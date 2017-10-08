package apaw.ecp2.rafael.api.resources.exception;

public class CategoryIdNotFoundException extends Exception {
    private static final long serialVersionUID = -5287908729516560873L;

    public static final String DESCRIPTION = "El id de la categoria no existe";

    public CategoryIdNotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public CategoryIdNotFoundException() {
        this("");
    }
}
