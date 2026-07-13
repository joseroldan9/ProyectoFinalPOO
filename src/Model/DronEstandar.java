package Model;

public class DronEstandar extends Dron {
    private Sede sede; 

    public DronEstandar(String codigo, String modelo, double nivelBateria, String estado, String tipo, Sede sede) {
        super(codigo, modelo, nivelBateria, estado, tipo);
        this.sede = sede;
    }

    public Sede getSede() { return sede; }
    public void setSede(Sede sede) { this.sede = sede; }

    @Override
    public void mostrarInformacionEspecifica() {
        System.out.println("Dron Estandar en sede: " + sede.getNombre());
    }
    @Override
public String generarReporte() {
    return "===== DRON ESTÁNDAR =====\n"
            + "Código: " + codigo + "\n"
            + "Modelo: " + modelo + "\n"
            + "Batería: " + nivelBateria + "%\n"
            + "Estado: " + estado + "\n"
            + "Sede: " + sede.getNombre();
}
}

