package taller_mecanico;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Taller taller = new Taller();

        Vehiculo vehiculo1 = new Vehiculo("Auto", "Civic", "Honda", "ABC-123", 2020, "Juan Pérez", "En ingreso");
        Servicio servicio1 = new Servicio("Cambio de aceite", 50.00);

        taller.agregarVehiculo(vehiculo1);
        taller.asignarServicioAvehiculo(vehiculo1, servicio1);

        vehiculo1.mostrarInformacion();
        vehiculo1.mostrarServicios();
    }
}
