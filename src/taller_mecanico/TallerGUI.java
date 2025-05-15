package taller_mecanico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TallerGUI extends JFrame {
    private Taller taller;

    public TallerGUI() {
        taller = new Taller();
        configurarVentana();
        inicializarComponentes();
    }
    private void configurarVentana() {
        this.setTitle("Taller Mecánico");
        this.setSize(500, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
    
    private void inicializarComponentes() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; // columna 0
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 10, 5, 10); // margen entre botones

        int fila = 0;

        JButton btnAgregarVehiculo = new JButton("Agregar Vehiculo");
        gbc.gridy = fila++;
        panel.add(btnAgregarVehiculo, gbc);

        JButton btnAgregarEmpleado = new JButton("Agregar Empleado");
        gbc.gridy = fila++;
        panel.add(btnAgregarEmpleado, gbc);

        JButton btnAgregarServicio = new JButton("Agregar Servicio");
        gbc.gridy = fila++;
        panel.add(btnAgregarServicio, gbc);

        JButton btnMostrarVehiculos = new JButton("Mostrar Vehiculos");
        gbc.gridy = fila++;
        panel.add(btnMostrarVehiculos, gbc);

        JButton btnMostrarEmpleados = new JButton("Mostrar Empleados");
        gbc.gridy = fila++;
        panel.add(btnMostrarEmpleados, gbc);

        JButton btnMostrarServicios = new JButton("Mostrar Servicios");
        gbc.gridy = fila++;
        panel.add(btnMostrarServicios, gbc);

        JButton btnAsignarServicioAvehiculo = new JButton("Asignar Servicio a Vehiculo");
        gbc.gridy = fila++;
        panel.add(btnAsignarServicioAvehiculo, gbc);

        JButton btnGuardarVehiculos = new JButton("Guardar Vehículos");
        gbc.gridy = fila++;
        panel.add(btnGuardarVehiculos, gbc);

        JButton btnGuardarEmpleados = new JButton("Guardar Empleados");
        gbc.gridy = fila++;
        panel.add(btnGuardarEmpleados, gbc);

        JButton btnGuardarServicios = new JButton("Guardar Servicios");
        gbc.gridy = fila++;
        panel.add(btnGuardarServicios, gbc);

        JButton btnCargarVehiculos = new JButton("Cargar Vehículos");
        gbc.gridy = fila++;
        panel.add(btnCargarVehiculos, gbc);

        JButton btnCargarEmpleados = new JButton("Cargar Empleados");
        gbc.gridy = fila++;
        panel.add(btnCargarEmpleados, gbc);

        JButton btnCargarServicios = new JButton("Cargar Servicios");
        gbc.gridy = fila++;
        panel.add(btnCargarServicios, gbc);

        // Acción de botones (lo puedes dejar como está, o reutilizar)
        btnAgregarVehiculo.addActionListener(e -> agregarVehiculo());
        btnAgregarEmpleado.addActionListener(e -> agregarEmpleado());
        btnAgregarServicio.addActionListener(e -> agregarServicio());
        btnMostrarVehiculos.addActionListener(e -> mostrarVehiculos());
        btnMostrarEmpleados.addActionListener(e -> mostrarEmpleados());
        btnMostrarServicios.addActionListener(e -> mostrarServicios());
        btnAsignarServicioAvehiculo.addActionListener(e -> asignarServicioAvehiculo());

        btnGuardarVehiculos.addActionListener(e -> taller.guardarVehiculosEnArchivo("vehiculos.txt"));
        btnGuardarEmpleados.addActionListener(e -> taller.guardarEmpleadosEnArchivo("empleados.txt"));
        btnGuardarServicios.addActionListener(e -> taller.guardarServiciosEnArchivo("servicios.txt"));
        btnCargarVehiculos.addActionListener(e -> taller.cargarVehiculosDesdeArchivo("vehiculos.txt"));
        btnCargarEmpleados.addActionListener(e -> taller.cargarEmpleadosDesdeArchivo("empleados.txt"));
        btnCargarServicios.addActionListener(e -> taller.cargarServiciosDesdeArchivo("servicios.txt"));

        this.add(panel);
    }

    private void agregarVehiculo() {
        String tipoVehiculo = JOptionPane.showInputDialog(this, "Tipo de vehículo:");
        String modelo = JOptionPane.showInputDialog(this, "Modelo:");
        String marca = JOptionPane.showInputDialog(this, "Marca:");
        String placa = JOptionPane.showInputDialog(this, "Placa:");
        int anoFabricacion = Integer.parseInt(JOptionPane.showInputDialog(this, "Año de fabricación:"));
        String propietario = JOptionPane.showInputDialog(this, "Propietario:");
        String estado = JOptionPane.showInputDialog(this, "Estado:");

        Vehiculo vehiculo = new Vehiculo(tipoVehiculo, modelo, marca, placa, anoFabricacion, propietario, estado);
        taller.agregarVehiculo(vehiculo);

        JOptionPane.showMessageDialog(this, "Vehículo agregado exitosamente.");
    }
    private void agregarEmpleado() {
        String nombre = JOptionPane.showInputDialog(this, "Nombre del empleado:");
        String puesto = JOptionPane.showInputDialog(this, "Puesto:");
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "ID del empleado:"));

        Empleado empleado = new Empleado(nombre, puesto, id);
        taller.agregarEmpleado(empleado);

        JOptionPane.showMessageDialog(this, "Empleado agregado exitosamente.");
    }
    private void agregarServicio() {
        String nombreServicio = JOptionPane.showInputDialog(this, "Nombre del servicio");
        double costo = Double.parseDouble(JOptionPane.showInputDialog(this, "Costo del servicio"));

        Servicio servicio = new Servicio(nombreServicio, costo);
        taller.agregarServicio(servicio);

        JOptionPane.showMessageDialog(this,"Servicio agregado exitosamente");
    }

    private void mostrarVehiculos() {
        StringBuilder sb = new StringBuilder();
        for (Vehiculo v : taller.getVehiculos()) {
            sb.append(v.getPlaca()).append(" - ").append(v.getModelo()).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.length() > 0 ? sb.toString() : "No hay vehículos registrados.");
    }
    private void mostrarEmpleados() {
        StringBuilder sb = new StringBuilder();
        for (Empleado e : taller.getEmpleados()) {
            sb.append(e.getNombre()).append(" - ").append(e.getPuesto()).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.length() > 0 ? sb.toString() : "No hay empleados registrados.");
    }
    private void mostrarServicios(){
        StringBuilder sb = new StringBuilder();
        for (Servicio s : taller.getServicios()){
            sb.append(s.getNombreServicio()).append(" - ").append(s.getCosto()).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.length()> 0 ? sb.toString():"No hay servicios registrados");
    }

    private void asignarServicioAvehiculo(){
        if (taller.getVehiculos().isEmpty()){
            JOptionPane.showMessageDialog(this,"No hay vehiculos registrados");
            return;
        }
        String[] placas = taller.getVehiculos().stream()
                .map(Vehiculo::getPlaca)
                .toArray(String[]::new);
        String placaSeleccionada = (String) JOptionPane.showInputDialog(
            this,
            "Selecciona una placa:",
            "Asignar servicio",
            JOptionPane.QUESTION_MESSAGE,
            null,
            placas,
            placas[0]
        );
        if(placaSeleccionada == null) return;

        Vehiculo vehiculo = taller.getVehiculos().stream()
                .filter(v -> v.getPlaca().equals(placaSeleccionada))
                .findFirst()
                .orElse(null);

        if (vehiculo == null) {
            JOptionPane.showMessageDialog(this, "Vehiculo no encontrado");
            return;
        }
        String nombreServicio = JOptionPane.showInputDialog(this, "Nombre del servicio:");
        if (nombreServicio == null || nombreServicio.trim().isEmpty()) return;

        double costo;

        try {
            costo =Double.parseDouble(JOptionPane.showInputDialog(this, "Costo del servicio:"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Costo Inválido");
            return;
        }
        Servicio servicio = new Servicio(nombreServicio, costo);
        taller.asignarServicioAvehiculo(vehiculo, servicio);

        JOptionPane.showMessageDialog(this, "Servicio asignado correctamente");
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TallerGUI gui = new TallerGUI();
            gui.setVisible(true);
        });
    }

}
