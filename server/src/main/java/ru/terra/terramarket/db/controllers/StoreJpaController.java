/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.terra.terramarket.db.controllers;

import ru.terra.server.db.controllers.AbstractJpaController;
import ru.terra.terramarket.db.controllers.exceptions.NonexistentEntityException;
import ru.terra.terramarket.db.entity.Product;
import ru.terra.terramarket.db.entity.Store;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.io.Serializable;

/**
 * @author terranz
 */
public class StoreJpaController extends AbstractJpaController<Store> implements Serializable {

    public StoreJpaController() {
        super(Store.class);
    }

    @Override
    public void create(Store store) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Product prodId = store.getProduct();
            if (prodId != null) {
                prodId = em.getReference(prodId.getClass(), prodId.getId());
                store.setProdId(prodId);
            }
            em.persist(store);
            if (prodId != null) {
                prodId.getStoreList().add(store);
                prodId = em.merge(prodId);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void update(Store store) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Store persistentStore = em.find(Store.class, store.getId());
            Product prodIdOld = persistentStore.getProduct();
            Product prodIdNew = store.getProduct();
            if (prodIdNew != null) {
                prodIdNew = em.getReference(prodIdNew.getClass(), prodIdNew.getId());
                store.setProdId(prodIdNew);
            }
            store = em.merge(store);
            if (prodIdOld != null && !prodIdOld.equals(prodIdNew)) {
                prodIdOld.getStoreList().remove(store);
                prodIdOld = em.merge(prodIdOld);
            }
            if (prodIdNew != null && !prodIdNew.equals(prodIdOld)) {
                prodIdNew.getStoreList().add(store);
                prodIdNew = em.merge(prodIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = store.getId();
                if (get(id) == null) {
                    throw new NonexistentEntityException("The store with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void delete(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Store store;
            try {
                store = em.getReference(Store.class, id);
                store.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The store with id " + id + " no longer exists.", enfe);
            }
            Product prodId = store.getProduct();
            if (prodId != null) {
                prodId.getStoreList().remove(store);
                prodId = em.merge(prodId);
            }
            em.remove(store);
            em.getTransaction().commit();
        } finally {
            if (em != null)
                em.close();
        }
    }

    public boolean isProductAvailable(Product product, Integer count) {
        Store store = findByProduct(product);
        if (store != null)
            return store.getCount() >= count;
        return false;
    }

    public Store findByProduct(Product product) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query q = em.createNamedQuery("Store.findByProduct").setParameter("prod", product);
            return (Store) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            if (em != null)
                em.close();
        }
    }

}
