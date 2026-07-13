package Model;

public class DronEntrega extends Dron {
    private double capacidadCargaKg;
    private int tiempoAutonomiaExtra;

    public DronEntrega(String codigo, String modelo, double nivelBateria, String estado, double capacidadCargaKg, int tiempoAutonomiaExtra) {
        super(codigo, modelo, nivelBateria, estado, "Entrega");
        this.capacidadCargaKg = capacidadCargaKg;
        this.tiempoAutonomiaExtra = tiempoAutonomiaExtra;
    }

    public double getCapacidadCargaKg() { return capacidadCargaKg; }
    public void setCapacidadCargaKg(double capacidadCargaKg) { this.capacidadCargaKg = capacidadCargaKg; }
    public int getTiempoAutonomiaExtra() { return tiempoAutonomiaExtra; }
    public void setTiempoAutonomiaExtra(int tiempoAutonomiaExtra) { this.tiempoAutonomiaExtra = tiempoAutonomiaExtra; }

    @Override
    public void mostrarInformacionEspecifica() {
        System.out.println("Carga Máx: " + capacidadCargaKg + "kg | Autonomía Extra: " + tiempoAutonomiaExtra + " min");
    }
    @Override
public String generarReporte() {
    return "===== DRON DE ENTREGA =====\n"
            + "Código: " + codigo + "\n"
            + "Modelo: " + modelo + "\n"
            + "Batería: " + nivelBateria + "%\n"
            + "Estado: " + estado + "\n"
            + "Capacidad de carga: " + capacidadCargaKg + " kg\n"
            + "Autonomía extra: " + tiempoAutonomiaExtra + " min";
}
}
