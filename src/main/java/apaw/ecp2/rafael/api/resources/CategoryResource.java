package apaw.ecp2.rafael.api.resources;

import apaw.ecp2.rafael.api.resources.controllers.CategoryController;
import apaw.ecp2.rafael.api.resources.exception.CategoryFieldInvalidException;

public class CategoryResource {
    
    public static final String CATEGORIES = "categories";
    public static final String ID= "/{id}";

    public void createCategory(long id, int rank, String title) throws CategoryFieldInvalidException {
        this.validateField(title);
        new CategoryController().createCategory(id, rank, title);

    }

    private void validateField(String field) throws CategoryFieldInvalidException {
        if (field == null || field.isEmpty()) {
            throw new CategoryFieldInvalidException(field);
        }
    }

}
