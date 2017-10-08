package apaw.ecp2.rafael.api.resources.exception;

public class EmployeeIdNotFoundException extends Exception {
    private static final long serialVersionUID = -5287908729516560873L;

    public static final String DESCRIPTION = "El id de la categoria no existe";

    public EmployeeIdNotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public EmployeeIdNotFoundException() {
        this("");
    }
}
