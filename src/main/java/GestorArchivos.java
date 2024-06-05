import java.io.*;
import java.util.ArrayList;

import org.json.*;

public class GestorArchivos implements Crud{

    private ArrayList<JSONObject> jsonList;

    public GestorArchivos() {
        this.jsonList = new ArrayList<JSONObject>();
    }

    public ArrayList<JSONObject> getJsonList() {
        return jsonList;
    }

    @Override
    public void createFolder(String nombre) {
        System.out.println("Creating Folder...");
        File Carpeta = new File(nombre);
        Carpeta.mkdir();
    }

    // --------------- Metodos CRUD ---------------

    @Override
    public void create(String ruta) {

        System.out.println("Creating JSON file...");
        
        try {
            FileWriter fileWriter = new FileWriter(ruta);
            fileWriter.write("[\n"); // Por el formato de archivos.json, parto con un [

            for(JSONObject json: this.jsonList) {
                fileWriter.write(json.toString());
                if (jsonList.indexOf(json) < jsonList.size() - 1) {
                    fileWriter.write(",\n");
                }
            }
            fileWriter.write("\n]"); // Por el formato de archivos.json, termino con un ]
            fileWriter.close();
            
        } catch (IOException ignore) {
            System.out.println("Error al crear el archivo");
        }
    }

    @Override
    public void read(String ruta) {

        System.out.println("Reading JSON file...");
        
        try {
            FileReader fileReader = new FileReader(ruta);
            BufferedReader lector = new BufferedReader(fileReader);
            String linea;

            while ((linea = lector.readLine()) != null) {

                try {
                    JSONObject json = new JSONObject(linea.toString());
                    jsonList.add(json);
                } catch (JSONException ignore) {}
            }

            fileReader.close();
            lector.close();

        } catch (IOException ignore) {}
    }

    @Override
    public void update(String ruta) {

        System.out.println("Updating JSON file...");
    }

    @Override
    public void delete(String ruta) {

        System.out.println("Deleting JSON file...");
    }

    // --------------- Metodos para interactuar con usuario ---------------
    public void showUsers() {
        if (this.jsonList.isEmpty()) {
            System.out.println("No hay usuarios");
            return;
        }

        for (JSONObject json : this.jsonList) {
            System.out.println(json.toString());
        }
    }

    public void addUser(JSONObject usuario) {
        this.jsonList.add(usuario);
    }

}
