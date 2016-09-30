package com.vitrenko.spittr.model.repository;

import com.vitrenko.spittr.model.domain.Spitter;

import javax.annotation.Nullable;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;


public class JpaCrudRepository<T, PK extends Serializable> implements CrudRepository<T, PK> {

    private static String COUNT_QUERY = "SELECT count(e) FROM %s e";

    @PersistenceContext
    private EntityManager entityManager;

    private Class<T> entityClass;

    public JpaCrudRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T find(PK primaryKey) {
        return entityManager.find(entityClass, primaryKey);
    }

    @Override
    public List<T> find() {
        return getFindAllQuery().getResultList();
    }

    @Override
    public List<T> find(int from, int to) {
        return getFindAllQuery()
                .setFirstResult(from)
                .setMaxResults(to)
                .getResultList();
    }


    @Override
    public void create(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public T merge(T entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void delete(T entity) {
        if (entityManager.contains(entity)) {
            entityManager.remove(entity);
        } else {
            @SuppressWarnings("unchecked")
            PK primaryKey = (PK) entityManager.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(entity);
            delete(primaryKey);
        }
    }

    @Override
    public void delete(PK primaryKey) {
        entityManager.remove(entityManager.getReference(entityClass, primaryKey));
    }

    @Override
    public long size() {
        return getEntityManager()
                .createQuery(String.format(COUNT_QUERY, getEntityClass().getSimpleName()), Long.class)
                .getSingleResult();
    }

    protected TypedQuery<T> getFindAllQuery() {
        return getEntityManager()
                .createQuery("FROM " + getEntityClass().getSimpleName(), getEntityClass());
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }


    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

    @Nullable
    protected T getSingleResult(List<T> result) {
        return result.isEmpty() ? null : result.get(0);
    }

}
