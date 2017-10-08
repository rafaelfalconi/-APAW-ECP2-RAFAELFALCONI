package apaw.ecp2.rafael.api.daos;

import java.util.List;

import apaw.ecp2.rafael.api.entities.Category;
import apaw.ecp2.rafael.api.entities.Employee;

public interface EmployeeDao extends GenericDao<Employee, Long> {
    List<Long> findValueByCategoryId(long categoryId);
}
