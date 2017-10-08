package apaw.ecp2.rafael.api.resources;

import apaw.ecp2.rafael.api.resources.exception.UserFieldInvalidException;

public class UserResource {
    public static final String USERS = "users";

    public void createUsuario(long id, String name, boolean active, long category) throws UserFieldInvalidException {
        this.validateField(name);

    }

    private void validateField(String field) throws UserFieldInvalidException {
        if (field == null || field.isEmpty()) {
            throw new UserFieldInvalidException(field);
        }
    }

}
