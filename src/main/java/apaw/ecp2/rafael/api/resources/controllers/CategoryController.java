package apaw.ecp2.rafael.api.resources.controllers;

import java.util.Optional;

import apaw.ecp2.rafael.api.resources.daos.DaoFactory;
import apaw.ecp2.rafael.api.resources.dtos.CategoryDto;
import apaw.ecp2.rafael.api.resources.entities.Category;

public class CategoryController {
    
        private boolean existCategoryId(long categoryId) {
            return DaoFactory.getFactory().getCategoryDao().read(categoryId)!=null;
        }

        public Optional<CategoryDto> readCategory(long categoryId){
            if(existCategoryId(categoryId)) {
                return Optional.of(new CategoryDto(DaoFactory.getFactory().getCategoryDao().read(categoryId)));
            }else {
                return Optional.empty();
            }
            
        }
        public void createCategory(long categoryId,int categoryRank,String categoryTitle) {
            DaoFactory.getFactory().getCategoryDao().create(new Category(categoryId, categoryRank, categoryTitle));
        }
}
