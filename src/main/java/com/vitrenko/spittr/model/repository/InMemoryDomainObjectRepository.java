/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitrenko.spittr.model.repository;

import com.vitrenko.spittr.model.domain.DomainObject;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;
import org.springframework.dao.DataRetrievalFailureException;

/**
 *
 * @author Vitalii_Vitrenko
 * @param <T>
 */
public class InMemoryDomainObjectRepository<T extends DomainObject> implements CrudRepository<T, Long> {

    private final Map<Long, T> domainObjects = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();

    private void create(T entity) {
        entity.setId(counter.incrementAndGet());
        domainObjects.put(entity.getId(), entity);
    }

    @Override
    @Nullable
    public T read(Long pk) {
        return domainObjects.get(pk);
    }

    @Override
    public Collection<T> read() {
        return domainObjects.values();
    }

    @Override
    public void save(T entity) {
        if (entity.getId() == null) {
            create(entity);
        } else {
            update(entity);
        }
    }

    private void update(T entity) {
        if (!domainObjects.containsKey(entity.getId())) {
            throw new DataRetrievalFailureException("entity with id " + entity.getId() + " was not found to update");
        }
        domainObjects.put(entity.getId(), entity);
    }

    @Override
    public void delete(T entity) {
        domainObjects.remove(entity.getId());
    }
    
    protected Map<Long, T> getEntityMap() {
        return domainObjects;
    }

}
