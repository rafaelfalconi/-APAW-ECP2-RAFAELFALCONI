package apaw.ecp2.rafael.api.resources.exception;

public class EmployeeFieldInvalidException extends Exception {
    private static final long serialVersionUID = -5287908729516560873L;

    public static final String DESCRIPTION = "nombre del usuario no encontrado";

    public EmployeeFieldInvalidException(String detail) {
        super(DESCRIPTION + "." + detail);

    }

    public EmployeeFieldInvalidException() {
        this("");
    }
}
