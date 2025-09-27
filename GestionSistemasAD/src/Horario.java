public class Horario {
    private String diaSemana;
    private String hora;
    private String grupo; //Libre o el grupo asignado

    public Horario(String diaSemana, String hora, String grupo) {
        this.diaSemana = diaSemana;
        this.hora = hora;
        this.grupo = grupo;
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

    public boolean esLibre() {
        return grupo.equalsIgnoreCase("Libre");
    }
}
