package apaw.ecp2.rafael.api.dtos;

import apaw.ecp2.rafael.api.entities.Category;
import apaw.ecp2.rafael.api.entities.Employee;

public class EmployeeDto {
    private long id;
    private String name;
    private String category;
    
    public EmployeeDto() {
        
    }
    
    public EmployeeDto(Employee employee) {
        id=employee.getId();
        name=employee.getSurname();
        category=employee.getCategory().getTitle();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    @Override
    public String toString() {
        return "{\"id\":"+id+",\"surname\":\" "+name+" \",\"category\":\" "+category+"\"}";
    }
}
