package apaw.ecp2.rafael.api.resources;

import apaw.ecp2.rafael.api.resources.exception.CategoryFieldInvalidException;

public class CategoryResource {
    public static final String CATEGORIES = "categories";

    public void createCategory(long id, int rank, String title) throws CategoryFieldInvalidException {
        this.validateField(title);

    }

    private void validateField(String field) throws CategoryFieldInvalidException {
        if (field == null || field.isEmpty()) {
            throw new CategoryFieldInvalidException(field);
        }
    }

}
