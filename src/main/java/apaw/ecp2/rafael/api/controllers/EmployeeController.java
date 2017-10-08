package apaw.ecp2.rafael.api.controllers;

import apaw.ecp2.rafael.api.daos.DaoFactory;
import apaw.ecp2.rafael.api.entities.Category;
import apaw.ecp2.rafael.api.entities.Employee;

public class EmployeeController {
    public boolean createEmployee(long id, String name,long categoryId) {
        Category category=DaoFactory.getFactory().getCategoryDao().read(categoryId);
        if(category !=null) {
            DaoFactory.getFactory().geEmployeeDao().create(new Employee(id, name, category));
            return true;
        }else {
            return false;
        }
    }
}
