# Ejemplo de uso de Interfaces JAVA

## Programación Orientada a Objetos

### 06/06

En sl siguiente ejemplo se muestra el uso de interfaces en JAVA, aplicado en el contexto 
de operaciones CRUD (Create, Read, Update, Delete) sobre un archivo de tipo ```.json```.

```json
[
  {
    "apellido": "Perez",
    "matricula": "12345678922",
    "carrera": "Ingeniería Civil Informatica",
    "nombre": "Juan",
    "edad": 20
  }
]
```
El ejemplo contepla las operaciones 'create' y 'read' sobre un archivo de tipo ```.json```.
Los ```.json``` extraidos del archivo, son almacenados en un ArrayList de objetos de tipo
```JSSONObject``` durante la ejecucion del programa.

En los siguientes enlaces podra encontrar informacion relacionada a la libreria utilizada:  
1. org.json: https://www.baeldung.com/java-org-json  
2. BufferReader: https://codegym.cc/es/groups/posts/es.150.bufferedreader-y-bufferedwriter

## Actividad propuesta

Desarrolle los metodos 'update' y 'delete' sobre el archivo ```.json```, considerando la intefaz
propuesta, y de tal manera que el usuario puede realizar estas operaciones desde la consola.    

La **interfaz** planteada es la siguiente:

```java
public interface Crud {
    
    public void create(String ruta);
    public void read(String ruta);
    public void update(String ruta);
    public void delete(String ruta);

} 
```

La clase que **Implementa** la interfaz es la siguiente:

```java
public class GestorArchivos implements Crud{

    @Override
    public void update(String ruta) {
        // Implementar para la clase.
    }

    @Override
    public void delete(String ruta) {
        // Implementar para la clase.
    }
}
```



