package Model;

public class RutaVuelo {
    private String codigo;
    private String zonaAsignada;
    private int duracionMinutos;
    private String nivelPrioridad;

    public RutaVuelo(String codigo, String zonaAsignada, int duracionMinutos, String nivelPrioridad) {
        this.codigo = codigo;
        this.zonaAsignada = zonaAsignada;
        this.duracionMinutos = duracionMinutos;
        this.nivelPrioridad = nivelPrioridad;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getZonaAsignada() { return zonaAsignada; }
    public void setZonaAsignada(String zonaAsignada) { this.zonaAsignada = zonaAsignada; }
    public int getDuracionMinutos() { return duracionMinutos; }
    public void setDuracionMinutos(int duracionMinutos) { this.duracionMinutos = duracionMinutos; }
    public String getNivelPrioridad() { return nivelPrioridad; }
    public void setNivelPrioridad(String nivelPrioridad) { this.nivelPrioridad = nivelPrioridad; }
}