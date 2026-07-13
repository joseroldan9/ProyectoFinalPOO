package Model;

public class Mision {
    private Sede sede;
    private Dron dron;
    private String fecha;
    private String hora;
    private String tipoMision;
    private String estado;

    public Mision(Sede sede, Dron dron, String fecha, String hora, String tipoMision) {
        this.sede = sede;
        this.dron = dron;
        this.fecha = fecha;
        this.hora = hora;
        this.tipoMision = tipoMision;
        this.estado = "Iniciada";
    }

    public Sede getSede() { return sede; }
    public void setSede(Sede sede) { this.sede = sede; }
    public Dron getDron() { return dron; }
    public void setDron(Dron dron) { this.dron = dron; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public String getHora() { return hora; }
    public void setHora(String hora) { this.hora = hora; }
    public String getTipoMision() { return tipoMision; }
    public void setTipoMision(String tipoMision) { this.tipoMision = tipoMision; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}


