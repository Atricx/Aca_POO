package modelo;

//Subclase que añade los meses de garantia  /
public class ProductoImportado extends Producto {

    private int mesesGarantia;
    /////Constructor que permite asignar los valores a los objetos 
    public ProductoImportado(String nombre, int cantidad, String codigo,
                        double precio, int mesesGarantia) {
        super(nombre, cantidad, codigo, precio);
        this.mesesGarantia = mesesGarantia;
    }

    public int getmesesGarantia() { return mesesGarantia; }

   /// metodo overrride que permite sosbrescribir informacion dentro de la funcion mostrar info que se encuentra debtro de la clase padre
    @Override
    public void mostrarInformacion() {
        System.out.println("Tipo: Producto Importado");
        super.mostrarInformacion();
        System.out.println("Meses de Garantia: " + mesesGarantia + " Meses");
    }
}
