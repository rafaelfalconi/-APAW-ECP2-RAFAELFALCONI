package apaw.ecp2.rafael.api.resources.controllers;

import apaw.ecp2.rafael.api.resources.daos.DaoFactory;
import apaw.ecp2.rafael.api.resources.entities.Category;

public class CategoryController {

        public void createCategory(long categoryId,int categoryRank,String categoryTitle) {
            DaoFactory.getFactory().getCategoryDao().create(new Category(categoryId, categoryRank, categoryTitle));
        }
}
