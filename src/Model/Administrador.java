package Model;

public class Administrador extends Usuario {
    public Administrador(String dni, String nombres, String apellidos, String usuario, String password) {
        super(dni, nombres, apellidos, usuario, password, "Administrador");
    }
}