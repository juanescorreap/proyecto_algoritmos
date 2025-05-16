package taller_mecanico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TallerGUI extends JFrame {
    private Taller taller;
    private JPanel cards;
    private final static String MENU = "Menu";
    private final static String VEHICULOS = "Vehiculos";
    private final static String EMPLEADOS = "Empleados";
    private final static String SERVICIOS = "Servicios";

    public TallerGUI() {
        taller = new Taller();
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        this.setTitle("Taller Mecánico");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void inicializarComponentes() {
        cards = new JPanel(new CardLayout());

        JPanel menuPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        JButton btnVehiculo = new JButton("Vehículo");
        JButton btnEmpleado = new JButton("Empleado");
        JButton btnServicio = new JButton("Servicio");
        JButton btnSalir = new JButton("Salir");

        menuPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        menuPanel.add(btnVehiculo);
        menuPanel.add(btnEmpleado);
        menuPanel.add(btnServicio);
        menuPanel.add(btnSalir);

        // Crear paneles específicos
        JPanel vehiculoPanel = crearPanelVehiculo();
        JPanel empleadoPanel = crearPanelEmpleado();
        JPanel servicioPanel = crearPanelServicio();

        cards.add(menuPanel, MENU);
        cards.add(vehiculoPanel, VEHICULOS);
        cards.add(empleadoPanel, EMPLEADOS);
        cards.add(servicioPanel, SERVICIOS);

        btnVehiculo.addActionListener(e -> mostrarPanel(VEHICULOS));
        btnEmpleado.addActionListener(e -> mostrarPanel(EMPLEADOS));
        btnServicio.addActionListener(e -> mostrarPanel(SERVICIOS));
        btnSalir.addActionListener(e -> System.exit(0));

        this.add(cards);
    }

    private JPanel crearPanelVehiculo() {
        JPanel panel = crearPanelBase();

        JButton btnAgregar = new JButton("Agregar Vehículo");
        JButton btnMostrar = new JButton("Mostrar Vehículos");
        JButton btnGuardar = new JButton("Guardar Vehículos");
        JButton btnCargar = new JButton("Cargar Vehículos");
        JButton btnVolver = new JButton("Volver al Menú");

        agregarBoton(panel, btnAgregar);
        agregarBoton(panel, btnMostrar);
        agregarBoton(panel, btnGuardar);
        agregarBoton(panel, btnCargar);
        agregarBoton(panel, btnVolver);

        btnAgregar.addActionListener(e -> agregarVehiculo());
        btnMostrar.addActionListener(e -> mostrarVehiculos());
        btnGuardar.addActionListener(e -> taller.guardarVehiculosEnArchivo("vehiculos.txt"));
        btnCargar.addActionListener(e -> taller.cargarVehiculosDesdeArchivo("vehiculos.txt"));
        btnVolver.addActionListener(e -> mostrarPanel(MENU));

        return panel;
    }

    private JPanel crearPanelEmpleado() {
        JPanel panel = crearPanelBase();

        JButton btnAgregar = new JButton("Agregar Empleado");
        JButton btnMostrar = new JButton("Mostrar Empleados");
        JButton btnGuardar = new JButton("Guardar Empleados");
        JButton btnCargar = new JButton("Cargar Empleados");
        JButton btnVolver = new JButton("Volver al Menú");

        agregarBoton(panel, btnAgregar);
        agregarBoton(panel, btnMostrar);
        agregarBoton(panel, btnGuardar);
        agregarBoton(panel, btnCargar);
        agregarBoton(panel, btnVolver);

        btnAgregar.addActionListener(e -> agregarEmpleado());
        btnMostrar.addActionListener(e -> mostrarEmpleados());
        btnGuardar.addActionListener(e -> taller.guardarEmpleadosEnArchivo("empleados.txt"));
        btnCargar.addActionListener(e -> taller.cargarEmpleadosDesdeArchivo("empleados.txt"));
        btnVolver.addActionListener(e -> mostrarPanel(MENU));

        return panel;
    }

    private JPanel crearPanelServicio() {
        JPanel panel = crearPanelBase();

        JButton btnAgregar = new JButton("Agregar Servicio");
        JButton btnMostrar = new JButton("Mostrar Servicios");
        JButton btnGuardar = new JButton("Guardar Servicios");
        JButton btnCargar = new JButton("Cargar Servicios");
        JButton btnAsignar = new JButton("Asignar Servicio a Vehículo");
        JButton btnVolver = new JButton("Volver al Menú");

        agregarBoton(panel, btnAgregar);
        agregarBoton(panel, btnMostrar);
        agregarBoton(panel, btnGuardar);
        agregarBoton(panel, btnCargar);
        agregarBoton(panel, btnAsignar);
        agregarBoton(panel, btnVolver);

        btnAgregar.addActionListener(e -> agregarServicio());
        btnMostrar.addActionListener(e -> mostrarServicios());
        btnGuardar.addActionListener(e -> taller.guardarServiciosEnArchivo("servicios.txt"));
        btnCargar.addActionListener(e -> taller.cargarServiciosDesdeArchivo("servicios.txt"));
        btnAsignar.addActionListener(e -> asignarServicioAvehiculo());
        btnVolver.addActionListener(e -> mostrarPanel(MENU));

        return panel;
    }

    private JPanel crearPanelBase() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        return panel;
    }

    private void agregarBoton(JPanel panel, JButton boton) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = panel.getComponentCount(); // posición vertical automática
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 0, 5, 0);
        panel.add(boton, gbc);
    }

    private void mostrarPanel(String nombre) {
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.show(cards, nombre);
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
}
