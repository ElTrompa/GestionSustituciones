import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class GestorSustituciones {
    private ArrayList<Profesor> profesores;
    private File ficheroControl;

    public GestorSustituciones(String ficheroHorarios, String ficheroControlSust) throws IOException {
        this.profesores = new ArrayList<>();
        this.ficheroControl = new File(ficheroControlSust);
        cargarHorarios(ficheroHorarios);
        cargarSustitucionesPrevias();
    }

    private void cargarHorarios(String ficheroHorarios) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(ficheroHorarios))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] datos = linea.split(",");
                if (datos.length < 4) continue;

                String nombre = datos[0];
                String dia = datos[1];
                String hora = datos[2];
                String grupo = datos[3];

                Profesor prof = buscarOcrearProfesor(nombre);
                prof.agregarHorario(new Horario(dia, hora, grupo));
            }
        }
    }

    private void cargarSustitucionesPrevias() throws IOException {
        if (!ficheroControl.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(ficheroControl))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String[] datos = linea.split(",");
                if (datos.length < 4) continue;

                String nombre = datos[0];
                int total = Integer.parseInt(datos[3]);
                Profesor prof = buscarOcrearProfesor(nombre);
                while (prof.getSustitucionesRealizas() < total) {
                    prof.incrementarSustituciones();
                }
            }
        }
    }

    private Profesor buscarOcrearProfesor(String nombre) {
        return profesores.stream()
                .filter(p -> p.getNombre().equals(nombre))
                .findFirst()
                .orElseGet(() -> {
                    Profesor nuevo = new Profesor(nombre, new ArrayList<>(), 0);
                    profesores.add(nuevo);
                    return nuevo;
                });
    }

    public ArrayList<Profesor> buscarSustitutos(String dia, String hora) {
        return (ArrayList<Profesor>) profesores.stream()
                .filter(p -> p.getHorarios().stream()
                        .anyMatch(h -> h.getDiaSemana().equalsIgnoreCase(dia)
                                && h.getHora().equalsIgnoreCase(hora)
                                && h.esLibre()))
                .sorted(Comparator.comparingInt(Profesor::getSustitucionesRealizas))
                .collect(Collectors.toList());
    }

    public void asignarSustituto(Profesor prof, String dia, String hora) throws IOException {
        prof.incrementarSustituciones();
        try (FileWriter fw = new FileWriter(ficheroControl, true)) {
            fw.write(prof.getNombre() + "," + dia + "," + hora + "," + prof.getSustitucionesRealizas() + "\n");
        }
    }

    public void mostrarRanking() {
        profesores.stream()
                .sorted((a, b) -> Integer.compare(b.getSustitucionesRealizas(), a.getSustitucionesRealizas()))
                .forEach(System.out::println);
    }
}
