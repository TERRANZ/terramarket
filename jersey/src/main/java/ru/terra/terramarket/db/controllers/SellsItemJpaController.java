/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.terra.terramarket.db.controllers;

import ru.terra.server.db.controllers.AbstractJpaController;
import ru.terra.terramarket.db.controllers.exceptions.NonexistentEntityException;
import ru.terra.terramarket.db.entity.Product;
import ru.terra.terramarket.db.entity.Sells;
import ru.terra.terramarket.db.entity.SellsItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.io.Serializable;

/**
 * @author terranz
 */
public class SellsItemJpaController extends AbstractJpaController<SellsItem> implements Serializable {
    public SellsItemJpaController() {
        super(SellsItem.class);
    }

    @Override
    public void create(SellsItem sellsItem) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sells sellId = sellsItem.getSellId();
            if (sellId != null) {
                sellId = em.getReference(sellId.getClass(), sellId.getId());
                sellsItem.setSellId(sellId);
            }
            Product prodId = sellsItem.getProduct();
            if (prodId != null) {
                prodId = em.getReference(prodId.getClass(), prodId.getId());
                sellsItem.setProdId(prodId);
            }
            em.persist(sellsItem);
            if (sellId != null) {
                sellId.getSellsItemList().add(sellsItem);
                sellId = em.merge(sellId);
            }
            if (prodId != null) {
                prodId.getSellsItemList().add(sellsItem);
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
    public void update(SellsItem sellsItem) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SellsItem persistentSellsItem = em.find(SellsItem.class, sellsItem.getId());
            Sells sellIdOld = persistentSellsItem.getSellId();
            Sells sellIdNew = sellsItem.getSellId();
            Product prodIdOld = persistentSellsItem.getProduct();
            Product prodIdNew = sellsItem.getProduct();
            if (sellIdNew != null) {
                sellIdNew = em.getReference(sellIdNew.getClass(), sellIdNew.getId());
                sellsItem.setSellId(sellIdNew);
            }
            if (prodIdNew != null) {
                prodIdNew = em.getReference(prodIdNew.getClass(), prodIdNew.getId());
                sellsItem.setProdId(prodIdNew);
            }
            sellsItem = em.merge(sellsItem);
            if (sellIdOld != null && !sellIdOld.equals(sellIdNew)) {
                sellIdOld.getSellsItemList().remove(sellsItem);
                sellIdOld = em.merge(sellIdOld);
            }
            if (sellIdNew != null && !sellIdNew.equals(sellIdOld)) {
                sellIdNew.getSellsItemList().add(sellsItem);
                sellIdNew = em.merge(sellIdNew);
            }
            if (prodIdOld != null && !prodIdOld.equals(prodIdNew)) {
                prodIdOld.getSellsItemList().remove(sellsItem);
                prodIdOld = em.merge(prodIdOld);
            }
            if (prodIdNew != null && !prodIdNew.equals(prodIdOld)) {
                prodIdNew.getSellsItemList().add(sellsItem);
                prodIdNew = em.merge(prodIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = sellsItem.getId();
                if (get(id) == null) {
                    throw new NonexistentEntityException("The sellsItem with id " + id + " no longer exists.");
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
            SellsItem sellsItem;
            try {
                sellsItem = em.getReference(SellsItem.class, id);
                sellsItem.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sellsItem with id " + id + " no longer exists.", enfe);
            }
            Sells sellId = sellsItem.getSellId();
            if (sellId != null) {
                sellId.getSellsItemList().remove(sellsItem);
                sellId = em.merge(sellId);
            }
            Product prodId = sellsItem.getProduct();
            if (prodId != null) {
                prodId.getSellsItemList().remove(sellsItem);
                prodId = em.merge(prodId);
            }
            em.remove(sellsItem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
