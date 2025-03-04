package junia.projetJEE.core.service;


import junia.projetJEE.core.dao.GenericDAO;
import junia.projetJEE.core.entity.GenericEntity;

import java.util.List;


public abstract class GenericService<T extends GenericEntity> {

    private final GenericDAO<T> internalDAO;

    public GenericDAO<T> getInternalDAO() {
        return internalDAO;
    }

    protected GenericService(GenericDAO<T> internalDAO) {
        this.internalDAO = internalDAO;
    }

    public void deleteAll() {
        internalDAO.deleteAll();
    }

    public void save(final T objectToSave) {
        internalDAO.save(objectToSave);
    }

    public long countAll() {
        return internalDAO.count();
    }

    public List<T> findAll() {
        return internalDAO.findAll();
    }

    public void deleteById(long id) {
        internalDAO.deleteById(id);
    }

    public T findOne(long id){ return internalDAO.findById(id).get();}
}
