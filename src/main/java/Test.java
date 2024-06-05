import org.json.*;
import java.io.*;

public class Test {

    GestorArchivos gestorArchivos;
    String ruta;

    public Test() {
        this.gestorArchivos = new GestorArchivos();
        this.ruta = "Archivos/usuarios.json";
    }

    public void createUser() {
        JSONObject usuario = new JSONObject();
        usuario.put("nombre", "Pilar");
        usuario.put("apellido", "Bueno");
        usuario.put("edad", 20);
        usuario.put("carrera", "Ing. Civil Informatica");
        usuario.put("matricula", "21464893822");
        this.gestorArchivos.getJsonList().add(usuario);
    }

    public void saveUsers() {
        if (!new File("Archivos").exists()) {
            this.gestorArchivos.createFolder("Archivos");
        } 
        this.gestorArchivos.create(this.ruta);
    }

    public void readUsers() {
        this.gestorArchivos.read(this.ruta);
    }

    public void showUsers() {
        if (this.gestorArchivos.getJsonList().isEmpty()) {
            System.out.println("No hay usuarios");
            return;
        }

        for (JSONObject json : this.gestorArchivos.getJsonList()) {
            System.out.println(json.toString());
        }
    }


}
