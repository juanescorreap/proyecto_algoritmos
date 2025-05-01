package taller_mecanico;

public class App {
    public static void main(String[] args) {
        Taller taller = new Taller();

        Vehiculo vehiculo1 = new Vehiculo("Auto", "Civic", "Honda", "ABC-123", 2020, "Juan Pérez", "En ingreso");
        Empleado empleado1 = new Empleado("Jose Rodríguez","Mecánico",123456);
        Servicio servicio1 = new Servicio("Cambio de aceite", 50.00);

        taller.agregarVehiculo(vehiculo1);
        taller.agregarEmpleado(empleado1);
        taller.asignarServicioAvehiculo(vehiculo1, servicio1);

        vehiculo1.mostrarInformacion();
        vehiculo1.mostrarServicios();
        empleado1.mostrarEmpleado();
        servicio1.mostrarServicio();
    }
}
