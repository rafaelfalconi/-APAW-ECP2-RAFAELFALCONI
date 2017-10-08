package apaw.ecp2.rafael.api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import apaw.ecp2.rafael.api.daos.DaoFactory;
import apaw.ecp2.rafael.api.dtos.EmployeeDto;
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
    private boolean existEmployee(long employeeId) {
        return DaoFactory.getFactory().geEmployeeDao().read(employeeId) !=null;
    }
    public Optional<EmployeeDto> readEmployee(long employeeId){
        if(existEmployee(employeeId)) {
            return Optional.of(new EmployeeDto(DaoFactory.getFactory().geEmployeeDao().read(employeeId)));
        }else {
            return Optional.empty();
        }
    }
    public List<EmployeeDto> employeeList(){
        List<EmployeeDto> employeeDtoList=new ArrayList<>();
        List<Employee> employees=DaoFactory.getFactory().geEmployeeDao().findAll();
        for(Employee employee: employees) {
            employeeDtoList.add(new EmployeeDto(employee));
        }
        return employeeDtoList;
    }
}
