package apaw.ecp2.rafael.api.resources.dtos;

import apaw.ecp2.rafael.api.resources.entities.Category;

public class CategoryDto {
    private long id;

    private int rank;

    private String title;
    
    public CategoryDto() {
        
    }
    
    public CategoryDto(Category category) {
        id=category.getId();
        rank=category.getRank();
        title=category.getTitle();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "{\"id\":"+id+",\"rank\":"+rank+",\"title\":\""+title+"\"}";
    }
    
   
    
    
}
