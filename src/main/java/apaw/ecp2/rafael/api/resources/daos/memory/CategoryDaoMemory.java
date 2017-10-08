package apaw.ecp2.rafael.api.resources.daos.memory;

import java.util.HashMap;
import java.util.List;
import java.util.function.ToIntFunction;

import apaw.ecp2.rafael.api.resources.daos.CategoryDao;
import apaw.ecp2.rafael.api.resources.entities.Category;

import static java.lang.Math.toIntExact;

public class CategoryDaoMemory extends GenericDaoMemory<Category> implements CategoryDao {

    public CategoryDaoMemory() {
        this.setMap(new HashMap<Long, Category>());
    }

    @Override
    protected Integer getId(Category entity) {
        return (int) entity.getId();
    }

    @Override
    protected void setId(Category entity, Long id2) {
       entity.setId(id2);

    }

}
