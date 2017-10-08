package apaw.ecp2.rafael.api.entities;

import java.util.Calendar;

public class Employee {
    private long id;

    private String surname;

    private Calendar entry;

    private Boolean active;

    private Category category;

    public Employee(long id, String surname, Category category) {

        this.category = category;
        this.id = id;
        this.surname = surname;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Calendar getEntry() {
        return entry;
    }

    public void setEntry(Calendar entry) {
        this.entry = entry;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void getDate() {
        // this.getEntry().setTime(date);
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", surname=" + surname + ", entry=" + entry + ", active=" + active + ", category=" + category + "]";
    }
}
