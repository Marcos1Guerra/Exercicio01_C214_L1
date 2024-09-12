package br.inatel.cdg;

public class Atendimento {

    private String professor;
    private String horario;
    private String periodo;
    private int predio;
    private int sala;


    public Atendimento (String professor, String horario, String periodo, int predio, int sala){
        this.professor = professor;
        this.horario = horario;
        this.periodo = periodo;
        this.predio = predio;
        this.sala = sala;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor; }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public int getPredio() {
        return predio;
    }

    public void setPredio(int predio) {
        this.predio = predio;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }
}
