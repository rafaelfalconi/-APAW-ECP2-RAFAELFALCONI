package apaw.ecp2.rafael.api.resources;

import java.util.Optional;

import apaw.ecp2.rafael.api.controllers.EmployeeController;
import apaw.ecp2.rafael.api.dtos.EmployeeDto;
import apaw.ecp2.rafael.api.resources.exception.CategoryIdNotFoundException;
import apaw.ecp2.rafael.api.resources.exception.EmployeeFieldInvalidException;
import apaw.ecp2.rafael.api.resources.exception.EmployeeIdNotFoundException;

public class EmployeeResource {
    public static final String Employee = "employees";

    public static final String ID = "/{id}";

    public EmployeeDto readEmployee(long employeeid) throws EmployeeIdNotFoundException{
        Optional<EmployeeDto> optional=new EmployeeController().readEmployee(employeeid);
        return optional.orElseThrow(()->new EmployeeIdNotFoundException(Long.toHexString(employeeid)));
        
    }

    public void createUsuario(long id, String name, long category) throws EmployeeFieldInvalidException, CategoryIdNotFoundException {
        this.validateField(name);
        if (!new EmployeeController().createEmployee(id, name, category)) {
            throw new CategoryIdNotFoundException(Long.toString(category));

        }

    }

    private void validateField(String field) throws EmployeeFieldInvalidException {
        if (field == null || field.isEmpty()) {
            throw new EmployeeFieldInvalidException(field);
        }
    }

}
