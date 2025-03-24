package taller_mecanico;

public class Servicio {
    private String nombreServicio;
    private double costo;

    public Servicio(String nombreServicio, double costo) {
        this.nombreServicio = nombreServicio;
        this.costo = costo;
    }

    public String getNombreServicio() {
        return this.nombreServicio;
    }

    public double getCosto() {
        return this.costo;
    }

    public void mostrarServicio() {
        System.out.printf("Servicio: %s%nCosto: $%.2f%n", this.nombreServicio, this.costo);
    }
}
