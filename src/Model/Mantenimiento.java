package Model;

public class Mantenimiento {
    private String codigoDron;
    private String fecha;
    private String descripcion;
    private double costo;
    private String responsable;

    public Mantenimiento(String codigoDron, String fecha, String descripcion, double costo, String responsable) {
        this.codigoDron = codigoDron;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.costo = costo;
        this.responsable = responsable;
    }

    public String getCodigoDron() { return codigoDron; }
    public void setCodigoDron(String codigoDron) { this.codigoDron = codigoDron; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public double getCosto() { return costo; }
    public void setCosto(double costo) { this.costo = costo; }
    public String getResponsable() { return responsable; }
    public void setResponsable(String responsable) { this.responsable = responsable; }
}


