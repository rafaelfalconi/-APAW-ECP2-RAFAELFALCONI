package apaw.ecp2.rafael.api.resources;

import java.util.Optional;

import apaw.ecp2.rafael.api.controllers.CategoryController;
import apaw.ecp2.rafael.api.dtos.CategoryDto;
import apaw.ecp2.rafael.api.resources.exception.CategoryFieldInvalidException;
import apaw.ecp2.rafael.api.resources.exception.CategoryIdNotFoundException;

public class CategoryResource {

    public static final String CATEGORIES = "categories";

    public static final String ID = "/{id}";

    public CategoryDto readCategory(long id) throws CategoryIdNotFoundException {
        Optional<CategoryDto> optional=new CategoryController().readCategory(id);
        return optional.orElseThrow(()->new CategoryIdNotFoundException(Long.toString(id)));
        
    }
    public String categoryList() {
        return new CategoryController().categoryList().toString();
     
    }
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
