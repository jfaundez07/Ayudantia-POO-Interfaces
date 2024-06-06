import java.io.File;
import java.util.Scanner;
import org.json.JSONObject;

//* comentario

public class Main {
    public static void main(String[] args) {
        GestorArchivos gestorArchivos = new GestorArchivos();
        String ruta = "Archivos/usuarios.json";
        gestorArchivos.read(ruta);
        gestorArchivos.showUsers();

        JSONObject usuario = createUser();
        gestorArchivos.addUser(usuario);

        if (!new File("Archivos").exists()) {
            gestorArchivos.createFolder("Archivos");
        }

        gestorArchivos.create(ruta);
        gestorArchivos.showUsers();
    }

    public static JSONObject createUser() {
        Scanner scanner = new Scanner(System.in);
        JSONObject usuario = new JSONObject();

        System.out.println("Ingrese el nombre del usuario: ");
        String name = scanner.nextLine();
        usuario.put("nombre", name);

        System.out.println("Ingrese el apellido del usuario: ");
        String lastName = scanner.nextLine();
        usuario.put("apellido", lastName);

        System.out.println("Ingrese la edad del usuario: ");
        String age = scanner.nextLine();
        usuario.put("edad", age);

        System.out.println("Ingrese la carrera del usuario: ");
        String career = scanner.nextLine();
        usuario.put("carrera", career);

        System.out.println("Ingrese la matricula del usuario: ");
        String matricula = scanner.nextLine();
        usuario.put("matricula", matricula);

        scanner.close();

        return usuario;
    }
}