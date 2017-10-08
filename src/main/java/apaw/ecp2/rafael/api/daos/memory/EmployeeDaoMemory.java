package apaw.ecp2.rafael.api.daos.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import apaw.ecp2.rafael.api.daos.EmployeeDao;
import apaw.ecp2.rafael.api.entities.Category;
import apaw.ecp2.rafael.api.entities.Employee;

public class EmployeeDaoMemory extends GenericDaoMemory<Employee> implements EmployeeDao {

    public EmployeeDaoMemory() {
        this.setMap(new HashMap<Long, Employee>());
    }

    @Override
    public List<Long> findValueByCategoryId(long categoryId) {
        List<Employee> employees = this.findAll();
        List<Long> employeesValue = new ArrayList<>();
        for (Employee employee : employees) {
            if(employee.getCategory().getId()==categoryId) {
                employeesValue.add(employee.getId());
            }

        }
        return employeesValue;
    }

    @Override
    protected Integer getId(Employee entity) {
        return (int) entity.getId();
    }

    @Override
    protected void setId(Employee entity, Long id2) {
        entity.setId(id2);
    }

}
