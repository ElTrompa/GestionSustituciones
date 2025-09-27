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

    public void
}
