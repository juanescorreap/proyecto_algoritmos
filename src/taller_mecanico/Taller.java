package taller_mecanico;

import java.util.ArrayList;

public class Taller {
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Empleado> empleados;
    private ArrayList<Servicio> servicios;

    public Taller() {
        this.vehiculos = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.servicios = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }

    public void agregarEmpleado(Empleado empleado) {
        this.empleados.add(empleado);
    }

    public void agregarServicio(Servicio servicio) {
        this.servicios.add(servicio);
    }

    public void mostrarVehiculos() {
        System.out.println("Vehículos en el taller:");
        for (Vehiculo v : vehiculos) {
            v.mostrarInformacion();
        }
    }

    public void mostrarEmpleados() {
        System.out.println("Empleados del taller:");
        for (Empleado e : empleados) {
            e.mostrarEmpleado();
        }
    }

    public void mostrarServicios() {
        System.out.println("Servicios en curso en el taller:");
        for (Servicio s : servicios) {
            s.mostrarServicio();
        }
    }

    public void asignarServicioAvehiculo(Vehiculo vehiculo, Servicio servicio) {
        if (vehiculos.contains(vehiculo)) {
            vehiculo.agregarServicio(servicio);
            System.out.printf("Servicio '%s' asignado al vehículo %s%n", servicio.getNombreServicio(), vehiculo.getPlaca());
        } else {
            System.out.println("El vehículo no está registrado en el taller.");
        }
    }
}
