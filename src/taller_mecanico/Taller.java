package taller_mecanico;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
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
    public ArrayList<Vehiculo> getVehiculos() {
        return this.vehiculos;
    }

    public ArrayList<Empleado> getEmpleados() {
        return this.empleados;
    }
    public ArrayList<Servicio> getServicios() {
        return this.servicios;
    }
    public void guardarVehiculosEnArchivo(String nombreArchivo) {
    try (PrintWriter writer = new PrintWriter(nombreArchivo)) {
        for (Vehiculo v : this.vehiculos) {
            writer.printf("%s;%s;%s;%s;%d;%s;%s%n",
                v.getTipoVehiculo(), v.getModelo(), v.getMarca(),
                v.getPlaca(), v.getAnoFabricacion(),
                v.getPropietario(), v.getEstado()
            );
        }
        System.out.println("Vehículos guardados correctamente en " + nombreArchivo);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
public void cargarVehiculosDesdeArchivo(String nombreArchivo) {
    this.vehiculos.clear();
    try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] datos = linea.split(";");
            if (datos.length == 7) {
                Vehiculo v = new Vehiculo(
                    datos[0], datos[1], datos[2], datos[3],
                    Integer.parseInt(datos[4]),
                    datos[5], datos[6]
                );
                this.vehiculos.add(v);
            }
        }
        System.out.println("Vehículos cargados correctamente desde " + nombreArchivo);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
public void guardarEmpleadosEnArchivo(String nombreArchivo) {
    try (PrintWriter writer = new PrintWriter(nombreArchivo)) {
        for (Empleado e : this.empleados) {
            writer.printf("%s;%s;%d%n", e.getNombre(), e.getPuesto(), e.getIdEmpleado());
        }
        System.out.println("Empleados guardados correctamente.");
    } catch (IOException e) {
        e.printStackTrace();
    }
}
public void cargarEmpleadosDesdeArchivo(String nombreArchivo) {
    this.empleados.clear();
    try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] datos = linea.split(";");
            if (datos.length == 3) {
                Empleado e = new Empleado(datos[0], datos[1], Integer.parseInt(datos[2]));
                this.empleados.add(e);
            }
        }
        System.out.println("Empleados cargados correctamente.");
    } catch (IOException e) {
        e.printStackTrace();
    }
}
public void guardarServiciosEnArchivo(String nombreArchivo) {
    try (PrintWriter writer = new PrintWriter(nombreArchivo)) {
        for (Servicio s : this.servicios) {
            writer.printf("%s;%.2f%n", s.getNombreServicio(), s.getCosto());
        }
        System.out.println("Servicios guardados correctamente.");
    } catch (IOException e) {
        e.printStackTrace();
    }
}
public void cargarServiciosDesdeArchivo(String nombreArchivo) {
    this.servicios.clear();
    try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] datos = linea.split(";");
            if (datos.length == 2) {
                Servicio s = new Servicio(datos[0], Double.parseDouble(datos[1]));
                this.servicios.add(s);
            }
        }
        System.out.println("Servicios cargados correctamente.");
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
