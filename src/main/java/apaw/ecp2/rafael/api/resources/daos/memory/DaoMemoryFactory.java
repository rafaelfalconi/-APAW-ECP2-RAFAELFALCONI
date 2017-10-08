package apaw.ecp2.rafael.api.resources.daos.memory;

import apaw.ecp2.rafael.api.resources.daos.CategoryDao;
import apaw.ecp2.rafael.api.resources.daos.DaoFactory;

public  class DaoMemoryFactory extends DaoFactory {

    private CategoryDao categoryDao;

    @Override
    public CategoryDao getCategoryDao() {
        if (categoryDao == null) {
            categoryDao = new CategoryDaoMemory();
        }
        return categoryDao;
    }

  

}
