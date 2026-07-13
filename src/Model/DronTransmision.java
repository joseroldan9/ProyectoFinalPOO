package Model;

public class DronTransmision extends Dron {
    private String frecuenciaTransmision;
    private String resolucionMax;

    public DronTransmision(String codigo, String modelo, double nivelBateria, String estado, String frecuenciaTransmision, String resolucionMax) {
        super(codigo, modelo, nivelBateria, estado, "Transmisión");
        this.frecuenciaTransmision = frecuenciaTransmision;
        this.resolucionMax = resolucionMax;
    }

    public String getFrecuenciaTransmision() { return frecuenciaTransmision; }
    public void setFrecuenciaTransmision(String frecuenciaTransmision) { this.frecuenciaTransmision = frecuenciaTransmision; }
    public String getResolucionMax() { return resolucionMax; }
    public void setResolucionMax(String resolucionMax) { this.resolucionMax = resolucionMax; }

    @Override
    public void mostrarInformacionEspecifica() {
        System.out.println("Frecuencia: " + frecuenciaTransmision + " | Resolución: " + resolucionMax);
    }
    @Override
public String generarReporte() {
    return "===== DRON DE TRANSMISIÓN =====\n"
            + "Código: " + codigo + "\n"
            + "Modelo: " + modelo + "\n"
            + "Batería: " + nivelBateria + "%\n"
            + "Estado: " + estado + "\n"
            + "Frecuencia: " + frecuenciaTransmision + "\n"
            + "Resolución: " + resolucionMax;
}
}