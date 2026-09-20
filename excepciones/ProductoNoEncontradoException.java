package excepciones;
//// permite dar una respuesta al programa cuando se presenten problemas como al leer y escribir archivos  
public class ProductoNoEncontradoException extends Exception {

    public ProductoNoEncontradoException(String mensaje) {
        super(mensaje); 
    }
}
///commit 3