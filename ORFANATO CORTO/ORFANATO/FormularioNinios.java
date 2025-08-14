import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormularioNinios extends JFrame {


    private JTextField txtNombre, txtEdad, txtNacionalidad;
    private JRadioButton rbRapido, rbLento;
    private JButton btnGuardar, btnMostrar;

    private Ninios[] listaNinios = new Ninios[3];
    private int indice = 0;

    public FormularioNinios() {
        setTitle("Registro de Niños en el Orfanato");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        JPanel panelDatos = new JPanel(new GridLayout(4, 2, 5, 5));
        panelDatos.setBorder(BorderFactory.createTitledBorder("Datos del Niño"));

        panelDatos.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelDatos.add(txtNombre);

        panelDatos.add(new JLabel("Edad:"));
        txtEdad = new JTextField();
        panelDatos.add(txtEdad);

        panelDatos.add(new JLabel("Nacionalidad:"));
        txtNacionalidad = new JTextField();
        panelDatos.add(txtNacionalidad);

        panelDatos.add(new JLabel("Velocidad al caminar:"));
        JPanel panelVelocidad = new JPanel();
        rbRapido = new JRadioButton("Rápido");
        rbLento = new JRadioButton("Lento");
        ButtonGroup grupoVelocidad = new ButtonGroup();
        grupoVelocidad.add(rbRapido);
        grupoVelocidad.add(rbLento);
        panelVelocidad.add(rbRapido);
        panelVelocidad.add(rbLento);
        panelDatos.add(panelVelocidad);

        JPanel panelBotones = new JPanel(new FlowLayout());
        btnGuardar = new JButton("Guardar Niño");
        btnMostrar = new JButton("Mostrar Niños");
        panelBotones.add(btnGuardar);
        panelBotones.add(btnMostrar);


        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarNinio();
            }
        });

        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarNinios();
            }
        });

        add(panelDatos, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
        setVisible(true);
    }

    private void guardarNinio() {
        if (indice < listaNinios.length) {
            try {
                String nombre = txtNombre.getText();
                int edad = Integer.parseInt(txtEdad.getText());
                String nacionalidad = txtNacionalidad.getText();

                Ninios nuevo = new Ninios(nombre, edad, nacionalidad);
                listaNinios[indice] = nuevo;
                indice++;

                JOptionPane.showMessageDialog(this, "Niño guardado correctamente.");
                txtNombre.setText("");
                txtEdad.setText("");
                txtNacionalidad.setText("");
                rbRapido.setSelected(false);
                rbLento.setSelected(false);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Edad debe ser un número.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "El arreglo de niños está lleno.");
        }
    }

    private void mostrarNinios() {
        StringBuilder sb = new StringBuilder();
        for (Ninios n : listaNinios) {
            if (n != null) {
                sb.append("Nombre: ").append(n.getNombre())
                  .append(", Edad: ").append(n.getEdad())
                  .append(", Nacionalidad: ").append(n.getNacionalidad())
                  .append("\n");
            }
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormularioNinios());
    }
}
