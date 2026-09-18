package modelo;




/////Definimos la clase producto como publica ya que esta heredara sus atributos a las subclases
public class Producto {
    //// encapsula los datos para que solo puedan ser usados por la calase y la subclases
    protected String nombre;
    protected int cantidad;
    protected String codigo;
    protected double precio; 

    /// Creamos el constructor que permitira el ingreso de datos en el futuro
    public Producto(String nombre,int cantidad, String codigo ,double precio){
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.codigo = codigo;
        this.precio = precio;
    }

    // getters
    public String getNombre(){
        return nombre;
    }

    public int getCantidad() {
        return cantidad; 
    }

    public String getCodigo() {
        return codigo; 
    }

    public double getPrecio() { 
        return precio; 
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Codigo: " + codigo);
        System.out.println("Precio: " + precio);
    }



}