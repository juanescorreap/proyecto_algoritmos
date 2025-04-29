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

        JButton btnAgregarVehiculo = new JButton("Agregar Vehiculo");
        JButton btnAgregarEmpleado = new JButton("Agregar Empleado");
        JButton btnMostrarVehiculos = new JButton("Mostrar Vehiculos");
        JButton btnMostrarEmpleados = new JButton("Mostrar Empleados");

        panel.add(btnAgregarVehiculo);
        panel.add(btnAgregarEmpleado);
        panel.add(btnMostrarVehiculos);
        panel.add(btnMostrarEmpleados);

        btnAgregarVehiculo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarVehiculo();
            }
        });

        btnAgregarEmpleado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarEmpleado();
            }
        });

        btnMostrarVehiculos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarVehiculos();
            }
        });

        btnMostrarEmpleados.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                mostrarEmpleados();
            }
        });
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
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TallerGUI gui = new TallerGUI();
            gui.setVisible(true);
        });
    }
}
