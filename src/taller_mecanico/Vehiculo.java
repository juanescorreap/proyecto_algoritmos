package taller_mecanico;

import java.util.ArrayList;

public class Vehiculo {
    private String tipoVehiculo;
    private String modelo;
    private String marca;
    private String placa;
    private int anoFabricacion;
    private String propietario;
    private String estado;
    private ArrayList<Servicio> servicios; 

    public Vehiculo(String tipoVehiculo, String modelo, String marca, String placa, int anoFabricacion, String propietario, String estado) {
        this.tipoVehiculo = tipoVehiculo;
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
        this.anoFabricacion = anoFabricacion;
        this.propietario = propietario;
        this.estado = estado;
        this.servicios = new ArrayList<>();
    }

    public String getPlaca() {
        return this.placa;
    }

    public String getModelo() {
        return this.modelo;
    }

    public String getEstado() {
        return this.estado;
    }

    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public void agregarServicio(Servicio servicio) {
        this.servicios.add(servicio);
    }

    public void mostrarInformacion() {
        System.out.printf("Tipo de vehículo: %s%nModelo: %s%nMarca: %s%nPlaca: %s%nAño: %d%nPropietario: %s%nEstado: %s%n",
                this.tipoVehiculo, this.modelo, this.marca, this.placa, this.anoFabricacion, this.propietario, this.estado);
    }

    public void mostrarServicios() {
        System.out.println("Servicios asignados:");
        for (Servicio servicio : servicios) {
            System.out.println(" - " + servicio.getNombreServicio());
        }
    }
}
