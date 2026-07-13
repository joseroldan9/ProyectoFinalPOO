package Model;

public class DronVigilancia extends Dron {
    private String tipoCamara;
    private int rangoVisionGrados;

    public DronVigilancia(String codigo, String modelo, double nivelBateria, String estado, String tipoCamara, int rangoVisionGrados) {
        super(codigo, modelo, nivelBateria, estado, "Vigilancia");
        this.tipoCamara = tipoCamara;
        this.rangoVisionGrados = rangoVisionGrados;
    }

    public String getTipoCamara() { return tipoCamara; }
    public void setTipoCamara(String tipoCamara) { this.tipoCamara = tipoCamara; }
    public int getRangoVisionGrados() { return rangoVisionGrados; }
    public void setRangoVisionGrados(int rangoVisionGrados) { this.rangoVisionGrados = rangoVisionGrados; }

    @Override
    public void mostrarInformacionEspecifica() {
        System.out.println("Cámara: " + tipoCamara + " | Rango: " + rangoVisionGrados + "°");
    }
    @Override
public String generarReporte() {
    return "===== DRON DE VIGILANCIA =====\n"
            + "Código: " + codigo + "\n"
            + "Modelo: " + modelo + "\n"
            + "Batería: " + nivelBateria + "%\n"
            + "Estado: " + estado + "\n"
            + "Tipo de cámara: " + tipoCamara + "\n"
            + "Rango de visión: " + rangoVisionGrados + "°";
}
    
}