package Model;

public abstract class Dron implements Reportable {
    protected String codigo;
    protected String modelo;
    protected double nivelBateria;
    protected String estado;
    protected String tipo;

    public Dron(String codigo, String modelo, double nivelBateria, String estado, String tipo) {
        this.codigo = codigo;
        this.modelo = modelo;
        this.nivelBateria = nivelBateria;
        this.estado = estado;
        this.tipo = tipo;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public double getNivelBateria() { return nivelBateria; }
    public void setNivelBateria(double nivelBateria) { this.nivelBateria = nivelBateria; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public abstract void mostrarInformacionEspecifica();
}
