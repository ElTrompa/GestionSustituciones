import java.util.ArrayList;

public class Profesor {
    private String nombre;
    private ArrayList<Horario> horario;
    private int sustitucionesRealizas;

    public Profesor(String nombre, ArrayList<Horario> horario, int sustitucionesRealizas) {
        this.nombre = nombre;
        this.horario = horario;
        this.sustitucionesRealizas = sustitucionesRealizas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Horario> getHorarios() {
        return horario;
    }

    public void setHorario(ArrayList<Horario> horario) {
        this.horario = horario;
    }

    public int getSustitucionesRealizas() {
        return sustitucionesRealizas;
    }

    public void setSustitucionesRealizas(int sustitucionesRealizas) {
        this.sustitucionesRealizas = sustitucionesRealizas;
    }

    public void agregarHorario(Horario h) {
        horario.add(h);
    }

    public void incrementarSustituciones() {
        sustitucionesRealizas++;
    }

    @Override
    public String toString {
        return nombre + " (sustituciones: " + sustitucionesRealizas + ")";
    }
}
