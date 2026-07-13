import Model.*;
import Repository.Data;
import View.LoginView;

public class Main {
    public static void main(String[] args) {
     
        Data.usuarios.add(new Administrador("11111111", "Oscar", "Valencia", "admin", "1234"));
        Data.usuarios.add(new Supervisor("22222222", "Summy", "Castro", "super", "1234"));
        Data.usuarios.add(new Operador("33333333", "Jose", "Roldan", "oper", "1234"));

        Data.drones.add(new Model.DronEstandar("D-001", "Serie A-01", 100.0, "Disponible", "Estandar", null));
Data.drones.add(new Model.DronEstandar("D-002", "Serie A-02", 95.0, "Disponible", "Estandar", null));
Data.drones.add(new Model.DronEstandar("D-003", "Serie B-01", 80.0, "Disponible", "Estandar", null));
Data.drones.add(new Model.DronEstandar("D-004", "Serie B-02", 100.0, "Disponible", "Estandar", null));
Data.drones.add(new Model.DronEstandar("D-005", "Serie C-01", 10.0, "Disponible", "Estandar", null));
Data.drones.add(new Model.DronEstandar("D-006", "Serie C-02", 100.0, "Disponible", "Vigilancia", null));
Data.drones.add(new Model.DronEstandar("D-007", "Serie D-01", 75.0, "En Misión", "Estandar", null));
Data.drones.add(new Model.DronEstandar("D-008", "Serie D-02", 60.0, "Disponible", "Transmision", null)); 
Data.drones.add(new Model.DronEstandar("D-009", "Serie E-01", 95.0, "En Misión", "Estandar", null));
Data.drones.add(new Model.DronEstandar("D-010", "Serie E-02", 50.0, "Disponible", "Entrega", null));
        LoginView login = new LoginView();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }
}
