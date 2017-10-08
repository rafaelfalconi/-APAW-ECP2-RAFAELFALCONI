package apaw.ecp2.rafael.api.resources.exception;

public class CategoryFieldInvalidException extends Exception {

    private static final long serialVersionUID = -5287908729516560873L;

    public static final String DESCRIPTION = "titulo de la categoria no encontrado";

    public CategoryFieldInvalidException(String detail) {
        super(DESCRIPTION + "." + detail);
    }
    
    public CategoryFieldInvalidException(){
        this("");
    }
}
