import java.util.ArrayList;

public class Profesor {
    private String nombre;
    private ArrayList<Hoario> hoarios;
    private int sustitucionesRealizas;

    public Profesor(String nombre, ArrayList<Hoario> hoarios, int sustitucionesRealizas) {
        this.nombre = nombre;
        this.hoarios = hoarios;
        this.sustitucionesRealizas = sustitucionesRealizas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Hoario> getHoarios() {
        return hoarios;
    }

    public void setHoarios(ArrayList<Hoario> hoarios) {
        this.hoarios = hoarios;
    }

    public int getSustitucionesRealizas() {
        return sustitucionesRealizas;
    }

    public void setSustitucionesRealizas(int sustitucionesRealizas) {
        this.sustitucionesRealizas = sustitucionesRealizas;
    }
}
