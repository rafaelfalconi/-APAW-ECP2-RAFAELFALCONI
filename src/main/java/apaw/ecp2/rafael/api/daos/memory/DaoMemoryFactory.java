package apaw.ecp2.rafael.api.daos.memory;

import apaw.ecp2.rafael.api.daos.CategoryDao;
import apaw.ecp2.rafael.api.daos.DaoFactory;
import apaw.ecp2.rafael.api.daos.EmployeeDao;

public class DaoMemoryFactory extends DaoFactory {

    private CategoryDao categoryDao;

    private EmployeeDao employeeDao;

    @Override
    public CategoryDao getCategoryDao() {
        if (categoryDao == null) {
            categoryDao = new CategoryDaoMemory();
        }
        return categoryDao;
    }

    @Override
    public EmployeeDao geEmployeeDao() {
        if (employeeDao == null) {
            employeeDao = new EmployeeDaoMemory();
        }
        return employeeDao;
    }

}
