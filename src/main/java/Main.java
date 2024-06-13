import java.io.File;
import java.util.Scanner;
import org.json.JSONObject;

//* comentario

public class Main {
    public static void main(String[] args) {
        GestorArchivos gestorArchivos = new GestorArchivos();
        String ruta = "Archivos/usuarios.json";

        if (!new File("Archivos").exists()) {
            gestorArchivos.createFolder("Archivos");
        } else {
            gestorArchivos.read(ruta);
            gestorArchivos.showUsers();
        }

        VentanaCrud ventanaCrud = new VentanaCrud(ruta, gestorArchivos);
        ventanaCrud.setVisible(true);

        gestorArchivos.showUsers();
    }
}