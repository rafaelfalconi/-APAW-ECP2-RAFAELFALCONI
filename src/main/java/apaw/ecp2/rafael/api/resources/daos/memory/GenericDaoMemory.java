package apaw.ecp2.rafael.api.resources.daos.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import apaw.ecp2.rafael.api.resources.daos.GenericDao;

public abstract class GenericDaoMemory<T> implements GenericDao<T, Long> {

    private Map<Long, T> map;

    private Long id;

    protected void setMap(Map<Long, T> map) {
        this.map = map;
    }

    public GenericDaoMemory() {
        id = (long) 1;
    }

    @Override
    public void create(T entity) {
        map.put(id, entity);
        this.setId(entity, id);
        id++;
    }

    @Override
    public T read(Long id) {
        return map.get(id);
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(map.values());
    }

    protected abstract Integer getId(T entity);

    protected abstract void setId(T entity, Long id2);
}
