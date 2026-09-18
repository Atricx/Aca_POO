import java.time.LocalDate;
import java.util.Scanner;

import modelo.Producto;
import modelo.Productoperecedero;
import modelo.ProductoImportado;
import modelo.Inventario;
import excepciones.ProductoNoEncontradoException;

///Inicio de la clase main////
public class Main {

    ///Esta clase comparte los datos registrados dentro de inventario
    private static Scanner scanner = new Scanner(System.in);
    private static Inventario Inventario = new Inventario();
    
    
    //////Menu////
    /// /////////
    public static void main(String[] args) {

        int opcion;
      
        do {
            mostrarMenu();

        
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número válido.\n");
                opcion = -1; 
            }

            switch (opcion) {
                case 1:
                    registrarProducto();
                    break;
                case 2:
                    Inventario.mostrarTodos();
                    break;
                case 3:
                    buscarProducto();
                    break;
                case 4: 
                    eliminarProducto();
                    break;
                case 5:
                    Inventario.calcularTotalPrecios();
                    break;
                case 6:
                    System.out.println("Gracias por usar el sistema. ¡Hasta pronto!");
                    break;
                default:
                    if (opcion != -1) {
                        System.out.println("Opción no válida.\n");
                    }
            }

        } while (opcion != 6);

        scanner.close();
    }

/////////////Mostrar Menu/////////////////////////////////////
    private static void mostrarMenu() {
        System.out.println("===== Inventario =====");
        System.out.println("1. Registrar producto");
        System.out.println("2. Mostrar todos los producto");
        System.out.println("3. Buscar producto por codigo");
        System.out.println("4. Eliminar producto");
        System.out.println("5. Valor Total de existencias");
        System.out.println("6. Salir");
        System.out.print("Elija una opción: ");
    }


    ///Funcion Registrar Producto////
    private static void registrarProducto() {
        Inventario.mostrarTiposDisponibles();
        System.out.print("Elija el tipo (1 o 2): ");
        String tipo = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Codigo: ");
        String codigo = scanner.nextLine();

        ///Manejo de errores y excepciones que permite registrar un producto y desplegar una alternativa en caso de no registarse con el
        /// el formato correcto///
        try {

            System.out.print("Cantidad: ");
            int cantidad1 = Integer.parseInt(scanner.nextLine());

            System.out.print("Precio: ");
            double precio = Double.parseDouble(scanner.nextLine());

            if (tipo.equals("1")) {
                System.out.print("Fecha de Vencimiento(YYYY-MM-DD): ");
                String fechaTexto = scanner.nextLine();
                LocalDate fecha = LocalDate.parse(fechaTexto);
                Productoperecedero perecedero = new Productoperecedero(nombre,cantidad1,codigo, precio, fecha);
                Inventario.registrar(perecedero);

            } else if (tipo.equals("2")) {
                System.out.print("Meses de Garantia: ");
                int meses = Integer.parseInt(scanner.nextLine());
                ProductoImportado producto = new ProductoImportado(nombre,cantidad1,codigo, precio, meses);
                Inventario.registrar(producto);

            } else {
                System.out.println("Tipo no válido. No se registró el producto.\n");
                return;
            }

            System.out.println("Producto registrado correctamente.\n");

        } catch (NumberFormatException e) {
            System.out.println("Error: Formato Incorrecto.");
            System.out.println("No se registró el Producto.\n");
        }
    }

    ////Funcion Buscar por codigo////
    private static void buscarProducto() {
        System.out.print("Ingrese el codigo a buscar: ");
        String codigo = scanner.nextLine();

        try {
            Producto encontrado = Inventario.buscarPorCodigo(codigo);
            System.out.println();
            encontrado.mostrarInformacion(); 
            System.out.println();
        } catch (ProductoNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }


    ////Funcion eliminar por codigo////
    private static void eliminarProducto() {
        System.out.print("Ingrese el codigo del producto: ");
        String codigo = scanner.nextLine();

        try {
            Producto encontrado = Inventario.eliminarporCodigo(codigo);
            System.out.println();
            encontrado.mostrarInformacion();
            System.out.println();
        } catch (ProductoNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage() + "\n");
        }
    }
}
