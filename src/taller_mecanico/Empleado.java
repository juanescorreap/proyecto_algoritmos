package taller_mecanico;

public class Empleado {
    private String nombre;
    private String puesto;
    private int idEmpleado;

    public Empleado(String nombre, String puesto, int idEmpleado) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getPuesto() {
        return this.puesto;
    }
    public int getIdEmpleado() {
        return this.idEmpleado;
    }

    public void mostrarEmpleado() {
        System.out.printf("Nombre: %s%nPuesto: %s%nID: %d%n", this.nombre, this.puesto, this.idEmpleado);
    }
}
