public class Horario {
    private String diaSemana;
    private String hora;
    private String grupo; //Libre o el grupo asignado

    public Horario(String grupo, String hora, String diaSemana) {
        this.grupo = grupo;
        this.hora = hora;
        this.diaSemana = diaSemana;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
}
