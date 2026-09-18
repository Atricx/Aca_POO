package modelo;

import java.util.ArrayList;
import excepciones.ProductoNoEncontradoException;

//Inventario
//Relacion entre las clase
//se Almacenan los tipos disponibles dentro de un array
public class Inventario {

    private ArrayList<Producto> Productos = new ArrayList<>();

    private String[] tiposDisponibles = {"Perecedero", "Importado"};

    public String[] getTiposDisponibles() {
        return tiposDisponibles;
    }

    public void mostrarTiposDisponibles() {
        System.out.println("Tipos disponibles:");
        for (int i = 0; i < tiposDisponibles.length; i++) {
            System.out.println((i + 1) + ". " + tiposDisponibles[i]);
        }
    }

    public void registrar(Producto producto) {
        Productos.add(producto);
    }

    // Funcion Mostrar todo
    //almacena la informacion de todos los productos registrados y permite mostrarlos en cualquier parte cuando sea llamado
    /// atravez de algun metodo
    public void mostrarTodos() {
        if (Productos.isEmpty()) {
            System.out.println("Todavía no hay productos registrados.");
            return;
        }
        System.out.println("\n----- PRODUCTOS REGISTRADOS -----");
        for (Producto p : Productos) {
            p.mostrarInformacion();
            System.out.println("-----------------------------");
        }
    }

    //Funcion buscar por codigo///
    public Producto buscarPorCodigo(String codigo) throws ProductoNoEncontradoException {
        for (Producto p : Productos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        throw new ProductoNoEncontradoException("No existe ningún producto con codigo " + codigo);
    }
}
