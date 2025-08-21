import java.awt.*;
import javax.swing.*;

public class EdificioGUI extends JFrame {
    private JTextField txtNombreOrfanato, txtUbicacionOrfanato, txtNumeroNinos, txtPisos;
    private JTextField txtNombreInventario, txtCantidadInventario;
    private JTextField txtNumCuarto, txtPersonasHabitacion, txtCamas;
    private JTextArea areaResultados;
    private JButton btnExistencia, btnDonaciones, btnCamas, btnPersonas, btnDatosEdificio, btnNumeroNinos, btnPisos, btnNumCuarto, btnRopa, btnSalir;

    private Inventario inventario;
    private Habitaciones habitaciones;
    private Edificio edificio;

    public EdificioGUI() {
        setTitle("Gestión de Orfanato");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelDatos = new JPanel(new GridLayout(10, 2, 5, 5));
        panelDatos.setBorder(BorderFactory.createTitledBorder("Datos Iniciales"));

        panelDatos.add(new JLabel("Nombre del orfanato:"));
        txtNombreOrfanato = new JTextField();
        panelDatos.add(txtNombreOrfanato);

        panelDatos.add(new JLabel("Ubicación del orfanato:"));
        txtUbicacionOrfanato = new JTextField();
        panelDatos.add(txtUbicacionOrfanato);

        panelDatos.add(new JLabel("Número de niños:"));
        txtNumeroNinos = new JTextField();
        panelDatos.add(txtNumeroNinos);

        panelDatos.add(new JLabel("Número de pisos:"));
        txtPisos = new JTextField();
        panelDatos.add(txtPisos);

        panelDatos.add(new JLabel("Nombre de inventario:"));
        txtNombreInventario = new JTextField();
        panelDatos.add(txtNombreInventario);

        panelDatos.add(new JLabel("Cantidad de inventario:"));
        txtCantidadInventario = new JTextField();
        panelDatos.add(txtCantidadInventario);

        panelDatos.add(new JLabel("Número de cuarto:"));
        txtNumCuarto = new JTextField();
        panelDatos.add(txtNumCuarto);

        panelDatos.add(new JLabel("Personas en habitación:"));
        txtPersonasHabitacion = new JTextField();
        panelDatos.add(txtPersonasHabitacion);

        panelDatos.add(new JLabel("Número de camas:"));
        txtCamas = new JTextField();
        panelDatos.add(txtCamas);

        JButton btnGuardar = new JButton("Guardar Datos");
        panelDatos.add(btnGuardar);
        panelDatos.add(new JLabel());

        add(panelDatos, BorderLayout.NORTH);

        JPanel panelMenu = new JPanel(new GridLayout(5, 2, 5, 5));
        panelMenu.setBorder(BorderFactory.createTitledBorder("Menú"));

        btnExistencia = new JButton("Ver existencia de inventario");
        btnDonaciones = new JButton("Ver donaciones");
        btnCamas = new JButton("Ver camas en la habitación");
        btnPersonas = new JButton("Ver personas en la habitación");
        btnDatosEdificio = new JButton("Ver datos del edificio");
        btnNumeroNinos = new JButton("Ver número de niños");
        btnPisos = new JButton("Ver número de pisos");
        btnNumCuarto = new JButton("Ver número de cuarto");
        btnRopa = new JButton("Ver ropa en inventario");
        btnSalir = new JButton("Salir");

        panelMenu.add(btnExistencia);
        panelMenu.add(btnDonaciones);
        panelMenu.add(btnCamas);
        panelMenu.add(btnPersonas);
        panelMenu.add(btnDatosEdificio);
        panelMenu.add(btnNumeroNinos);
        panelMenu.add(btnPisos);
        panelMenu.add(btnNumCuarto);
        panelMenu.add(btnRopa);
        panelMenu.add(btnSalir);

        add(panelMenu, BorderLayout.CENTER);

        areaResultados = new JTextArea();
        areaResultados.setEditable(false);
        areaResultados.setBorder(BorderFactory.createTitledBorder("Resultados"));
        add(new JScrollPane(areaResultados), BorderLayout.SOUTH);

        btnGuardar.addActionListener(e -> guardarDatos());
        btnExistencia.addActionListener(e -> mostrarExistencia());
        btnDonaciones.addActionListener(e -> mostrarDonaciones());
        btnCamas.addActionListener(e -> mostrarCamas());
        btnPersonas.addActionListener(e -> mostrarPersonas());
        btnDatosEdificio.addActionListener(e -> mostrarDatosEdificio());
        btnNumeroNinos.addActionListener(e -> mostrarNumeroNinos());
        btnPisos.addActionListener(e -> mostrarPisos());
        btnNumCuarto.addActionListener(e -> mostrarNumCuarto());
        btnRopa.addActionListener(e -> mostrarRopa());
        btnSalir.addActionListener(e -> System.exit(0));
    }

    private void guardarDatos() {
        try {
            String nombreOrfanato = txtNombreOrfanato.getText();
            String ubicacionOrfanato = txtUbicacionOrfanato.getText();
            int numeroNinos = Integer.parseInt(txtNumeroNinos.getText());
            int pisos = Integer.parseInt(txtPisos.getText());
            edificio = new Edificio(nombreOrfanato, ubicacionOrfanato, numeroNinos, pisos);

            String nombreInventario = txtNombreInventario.getText();
            int cantidadInventario = Integer.parseInt(txtCantidadInventario.getText());
            inventario = new Inventario(nombreInventario, cantidadInventario);

            int numCuarto = Integer.parseInt(txtNumCuarto.getText());
            int personasHabitacion = Integer.parseInt(txtPersonasHabitacion.getText());
            int camas = Integer.parseInt(txtCamas.getText());
            habitaciones = new Habitaciones(numCuarto, personasHabitacion, camas);

            areaResultados.setText("Datos guardados correctamente.\n");
        } catch (Exception ex) {
            areaResultados.setText("Error al guardar datos: " + ex.getMessage());
        }
    }

    private void mostrarExistencia() {
        if (inventario != null) {
            String mensaje = "Hay " + inventario.getCantidad() + " unidades de " + inventario.getNombre() + ".";
            JOptionPane.showMessageDialog(this, mensaje, "Existencia de Inventario", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Primero ingrese y guarde los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    private void mostrarDonaciones() {
        if (inventario != null) {
            JOptionPane.showMessageDialog(this, "No hay donaciones disponibles por el momento.", "Donaciones", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Primero ingrese y guarde los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    private void mostrarCamas() {
        if (habitaciones != null) {
            String mensaje = "El cuarto #" + habitaciones.getNumCuarto() + " tiene " + habitaciones.getCamas() + " camas.";
            JOptionPane.showMessageDialog(this, mensaje, "Camas en la Habitación", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Primero ingrese y guarde los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    private void mostrarPersonas() {
        if (habitaciones != null) {
            String mensaje = "Hay " + habitaciones.getPersonasHabitacion() + " personas en el cuarto #" + habitaciones.getNumCuarto() + ".";
            JOptionPane.showMessageDialog(this, mensaje, "Personas en la Habitación", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Primero ingrese y guarde los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    private void mostrarDatosEdificio() {
        if (edificio != null) {
            String mensaje = "Nombre del orfanato: " + edificio.getNombreOrfanato() + "\nUbicación: " + edificio.getUbicacionOrfanato();
            JOptionPane.showMessageDialog(this, mensaje, "Datos del Edificio", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Primero ingrese y guarde los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    private void mostrarNumeroNinos() {
        if (edificio != null) {
            String mensaje = "Número de niños en el orfanato: " + edificio.getNumeroNinos();
            JOptionPane.showMessageDialog(this, mensaje, "Número de Niños", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Primero ingrese y guarde los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    private void mostrarPisos() {
        if (edificio != null) {
            String mensaje = "El orfanato tiene: " + edificio.getPisos() + " pisos.";
            JOptionPane.showMessageDialog(this, mensaje, "Número de Pisos", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Primero ingrese y guarde los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    private void mostrarNumCuarto() {
        if (habitaciones != null) {
            String mensaje = "Número de cuarto: " + habitaciones.getNumCuarto();
            JOptionPane.showMessageDialog(this, mensaje, "Número de Cuarto", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Primero ingrese y guarde los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    private void mostrarRopa() {
        if (inventario != null) {
            JOptionPane.showMessageDialog(this, "El inventario contiene ropa.", "Ropa en Inventario", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Primero ingrese y guarde los datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EdificioGUI().setVisible(true));
    }
}
