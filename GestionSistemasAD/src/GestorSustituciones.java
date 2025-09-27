import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
}
