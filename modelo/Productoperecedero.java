package modelo;
import java.time.LocalDate;


//Subclase que heredara los atributos de producto a excepcion de que esta añadira un nuevo valor que es la fecha de vencimiento 
/// esto se realiza ajustando el formato que recibe el codigo.
public class Productoperecedero extends Producto {

    private LocalDate Fv;

    public Productoperecedero(String nombre, int cantidad, String codigo, 
                      double precio, LocalDate Fv) {
        super(nombre,cantidad,codigo, precio);
        this.Fv = Fv;
    }

    //getter
    public LocalDate getFv() { return Fv; }

    //// Aca añadimos la fecha de vencimiento reajustando la funcion mostar info mediante la funcion override que permite
    /// traer la funcion desde la clase padre y añadir el valor de la fecha de vencimiento.
    @Override
    public void mostrarInformacion() {
        System.out.println("Tipo: Producto Perecedero");
        super.mostrarInformacion(); 
        System.out.println("Fecha de Vecimiento: " + Fv);
    }
}
