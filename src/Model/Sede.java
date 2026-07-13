package Model;

public class Sede {
    private String codigo;
    private String nombre;
    private String ciudad;
    private int capacidadAproximada;

    public Sede(String codigo, String nombre, String ciudad, int capacidadAproximada) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.capacidadAproximada = capacidadAproximada;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public int getCapacidadAproximada() { return capacidadAproximada; }
    public void setCapacidadAproximada(int capacidadAproximada) { this.capacidadAproximada = capacidadAproximada; }
}
