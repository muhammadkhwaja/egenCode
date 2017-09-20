package com.egen.pwtsensor.repository.impl;

import com.mongodb.WriteResult;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class BaseRepository<T, ID extends Serializable> implements CrudRepository<T, ID> {
    @Autowired
    private Datastore datastore;
    private Class<T> t;

    public BaseRepository(Class<T> t) {
        this.t = t;
    }

    @Override
    public Key<T> create(T entity) {
        return datastore.save(entity);
    }

    @Override
    public T read(ID id) {
        return datastore.get(t, id);
    }

    @Override
    public UpdateResults update(T entity, UpdateOperations<T> operations) {
        return datastore.update(entity, operations);
    }

    @Override
    public WriteResult delete(T entity) {
        return datastore.delete(entity);
    }

    @Override
    public UpdateOperations<T> createOperations() {
        return datastore.createUpdateOperations(t);
    }

}
