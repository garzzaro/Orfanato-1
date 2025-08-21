import java.awt.*;
import javax.swing.*;

public class FormularioNinios extends JFrame {


    private JTextField txtNombre, txtEdad, txtNacionalidad;
    private JTextField txtNombreTrabajador, txtEdadTrabajador, txtCargoTrabajador, txtSalarioTrabajador;
    private JRadioButton rbRapido, rbLento;
    private JButton btnGuardarNino, btnGuardarTrabajador, btnMenu[];

    private Ninios nino;
    private Trabajadores trabajador;

    public FormularioNinios() {
        setTitle("Registro de Niños en el Orfanato");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        JPanel panelDatos = new JPanel(new GridLayout(8, 2, 5, 5));
        panelDatos.setBorder(BorderFactory.createTitledBorder("Datos Iniciales"));

        panelDatos.add(new JLabel("Nombre del niño:"));
        txtNombre = new JTextField();
        panelDatos.add(txtNombre);

        panelDatos.add(new JLabel("Edad del niño:"));
        txtEdad = new JTextField();
        panelDatos.add(txtEdad);

        panelDatos.add(new JLabel("Nacionalidad del niño:"));
        txtNacionalidad = new JTextField();
        panelDatos.add(txtNacionalidad);

        panelDatos.add(new JLabel("Nombre del trabajador:"));
        txtNombreTrabajador = new JTextField();
        panelDatos.add(txtNombreTrabajador);

        panelDatos.add(new JLabel("Edad del trabajador:"));
        txtEdadTrabajador = new JTextField();
        panelDatos.add(txtEdadTrabajador);

        panelDatos.add(new JLabel("Cargo del trabajador:"));
        txtCargoTrabajador = new JTextField();
        panelDatos.add(txtCargoTrabajador);

        panelDatos.add(new JLabel("Salario del trabajador:"));
        txtSalarioTrabajador = new JTextField();
        panelDatos.add(txtSalarioTrabajador);

        JPanel panelBotones = new JPanel(new FlowLayout());
        btnGuardarNino = new JButton("Guardar Niño");
        btnGuardarTrabajador = new JButton("Guardar Trabajador");
        panelBotones.add(btnGuardarNino);
        panelBotones.add(btnGuardarTrabajador);

        add(panelDatos, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);

        JPanel panelMenu = new JPanel(new GridLayout(5, 2, 5, 5));
        panelMenu.setBorder(BorderFactory.createTitledBorder("Menú"));
        String[] acciones = {
            "Ver ubicación del niño",
            "Niño camina rápido",
            "Niño camina lento",
            "Ver información del trabajador",
            "Ver salario del trabajador",
            "Ver edad del trabajador",
            "Niño se presenta",
            "Ver presupuesto del orfanato",
            "Trabajador habla con los niños",
            "Salir"
        };
        btnMenu = new JButton[acciones.length];
        for (int i = 0; i < acciones.length; i++) {
            btnMenu[i] = new JButton(acciones[i]);
            panelMenu.add(btnMenu[i]);
        }
        add(panelMenu, BorderLayout.SOUTH);

        btnGuardarNino.addActionListener(e -> guardarNinio());
        btnGuardarTrabajador.addActionListener(e -> guardarTrabajador());

        btnMenu[0].addActionListener(e -> mostrarMensaje(nino != null ? nino.getNombre() + " está en el patio del orfanato." : "Primero ingrese y guarde los datos del niño."));
        btnMenu[1].addActionListener(e -> mostrarMensaje(nino != null ? nino.getNombre() + " está caminando rápido." : "Primero ingrese y guarde los datos del niño."));
        btnMenu[2].addActionListener(e -> mostrarMensaje(nino != null ? nino.getNombre() + " está caminando lento." : "Primero ingrese y guarde los datos del niño."));
        btnMenu[3].addActionListener(e -> mostrarMensaje(trabajador != null ? "Nombre: " + trabajador.getNombre() + ", Puesto: " + trabajador.getPuesto() : "Primero ingrese y guarde los datos del trabajador."));
        btnMenu[4].addActionListener(e -> mostrarMensaje(trabajador != null ? "El salario de " + trabajador.getNombre() + " es: " + trabajador.getSalario() + "Q" : "Primero ingrese y guarde los datos del trabajador."));
        btnMenu[5].addActionListener(e -> mostrarMensaje(trabajador != null ? "La edad de " + trabajador.getNombre() + " es: " + trabajador.getEdad() : "Primero ingrese y guarde los datos del trabajador."));
        btnMenu[6].addActionListener(e -> mostrarMensaje(nino != null ? "Hola, mi nombre es " + nino.getNombre() + " y tengo " + nino.getEdad() + " años." : "Primero ingrese y guarde los datos del niño."));
        btnMenu[7].addActionListener(e -> mostrarMensaje("El presupuesto del orfanato es de 100,000 Q."));
        btnMenu[8].addActionListener(e -> mostrarMensaje(trabajador != null ? trabajador.getNombre() + " está hablando con los niños." : "Primero ingrese y guarde los datos del trabajador."));
        btnMenu[9].addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private void guardarNinio() {
        try {
            String nombre = txtNombre.getText();
            int edad = Integer.parseInt(txtEdad.getText());
            String nacionalidad = txtNacionalidad.getText();
            nino = new Ninios(nombre, edad, nacionalidad);
            JOptionPane.showMessageDialog(this, "Niño guardado correctamente.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Edad debe ser un número.");
        }
    }

    private void guardarTrabajador() {
        try {
            String nombre = txtNombreTrabajador.getText();
            String puesto = txtCargoTrabajador.getText();
            float salario = Float.parseFloat(txtSalarioTrabajador.getText());
            int edad = Integer.parseInt(txtEdadTrabajador.getText());
            trabajador = new Trabajadores(nombre, puesto, salario, edad);
            JOptionPane.showMessageDialog(this, "Trabajador guardado correctamente.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Edad y salario deben ser números.");
        }
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    // ...eliminado mostrarNinios, ahora el menú muestra la info relevante...

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormularioNinios());
    }
}
