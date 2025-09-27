import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class GestorSustituciones {
    private ArrayList<Profesor> profesores;
    private File ficheroControl;

    public GestorSustituciones(File ficheroControl, ArrayList<Profesor> profesores) throws IOException {
        this.ficheroControl = ficheroControl;
        this.profesores = profesores;
        cargarHorarios(ficheroHorarios);
        cargarSustitucionesPrevias();
    }

    public void cargarHorarios(String ficheroHorarios, String ficheroControlSust) throws IOException {
        this.profesores = new ArrayList<>();
        this.ficheroControl = new File(ficheroControlSust);
        cargarHorarios(ficheroHorarios);
        cargarSustitucionesPrevias();
    }

    private Profesor buscarOcrearProfesor(String nombre) {
        return profesores.stream()
                .filter(p -> p.getNombre().equals(nombre))
                .findFirst()
                .orElseGet(() -> {
                    Profesor nuevo = new Profesor(nombre);
                    profesores.add(nuevo);
                    return nuevo;
                });
    }

    private void cargarSustitucionesPrevias() throws IOException {
        if (!ficheroControl.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(ficheroControl))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombre = datos[0];
                int total = Integer.parseInt(datos[3]);
                Profesor prof = buscarOcrearProfesor(nombre);
                while (prof.getSustitucionesRealizas() < total) {
                    prof.incrementarSustituciones();
                }
            }
        }
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
