package Model;

public class Supervisor extends Usuario {
    public Supervisor(String dni, String nombres, String apellidos, String usuario, String password) {
        super(dni, nombres, apellidos, usuario, password, "Supervisor");
    }
}