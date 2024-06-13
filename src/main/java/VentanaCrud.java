import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCrud extends JFrame implements ActionListener {
    private JLabel nombreLabel;
    private JLabel apellidoLabel;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JLabel matriculaLabel;
    private JLabel edadLabel;
    private JTextField textFieldMatricula;
    private JTextField textFieldEdad;
    private JLabel carreraLabel;
    private JTextField textFieldCarrera;
    private JButton guardarButton;
    private JButton limpiarButton;
    private JPanel formularioPanel;
    private JLabel formularioLabel;

    //--------- Generados manualemnte ---------
    private String ruta;
    private GestorArchivos gestorArchivos;


    public VentanaCrud(String ruta, GestorArchivos gestorArchivos) {
        setUpGUI();
        this.ruta = ruta;
        this.gestorArchivos = gestorArchivos;
    }

    public void setUpGUI() {
        setTitle("Formulario");
        setLocationRelativeTo(null);
        setSize(500, 400);
        setContentPane(formularioPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        guardarButton.addActionListener(this);
        limpiarButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == guardarButton) {
            crearUsuario();
        } else if (e.getSource() == limpiarButton) {
            limpiarCampos();
        }
    }

    public void limpiarCampos() {
        textFieldApellido.setText("");
        textFieldNombre.setText("");
        textFieldMatricula.setText("");
        textFieldEdad.setText("");
        textFieldCarrera.setText("");
        System.out.println("Limpiando...");
    }

    public void crearUsuario() {
        String nombre = textFieldNombre.getText();
        String apellido = textFieldApellido.getText();
        String matricula = textFieldMatricula.getText();
        String edad = textFieldEdad.getText();
        String carrera = textFieldCarrera.getText();
        gestorArchivos.createUser(nombre, apellido, edad, carrera, matricula);
        gestorArchivos.create(ruta);
        System.out.println("Guardando...");
    }
}
