package apaw.ecp2.rafael.api.resources.exception;

public class UserFieldInvalidException extends Exception {
    private static final long serialVersionUID = -5287908729516560873L;

    public static final String DESCRIPTION = "nombre del usuario no encontrado";

    public UserFieldInvalidException(String detail) {
        super(DESCRIPTION + "." + detail);

    }

    public UserFieldInvalidException() {
        this("");
    }
}
