/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.terra.terramarket.db.controllers;

import ru.terra.server.db.controllers.AbstractJpaController;
import ru.terra.terramarket.db.controllers.exceptions.IllegalOrphanException;
import ru.terra.terramarket.db.controllers.exceptions.NonexistentEntityException;
import ru.terra.terramarket.db.entity.Sells;
import ru.terra.terramarket.db.entity.SellsItem;
import ru.terra.terramarket.db.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author terranz
 */
public class SellsJpaController extends AbstractJpaController<Sells> implements Serializable {

    public SellsJpaController() {
        super(Sells.class);
    }

    @Override
    public void create(Sells sells) {
        if (sells.getSellsItemList() == null) {
            sells.setSellsItemList(new ArrayList<SellsItem>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            User user = sells.getUser();
            if (user != null) {
                user = em.getReference(user.getClass(), user.getId());
                sells.setUser(user);
            }
            List<SellsItem> attachedSellsItemList = new ArrayList<SellsItem>();
            for (SellsItem sellsItemListSellsItemToAttach : sells.getSellsItemList()) {
                sellsItemListSellsItemToAttach = em.getReference(sellsItemListSellsItemToAttach.getClass(), sellsItemListSellsItemToAttach.getId());
                attachedSellsItemList.add(sellsItemListSellsItemToAttach);
            }
            sells.setSellsItemList(attachedSellsItemList);
            em.persist(sells);
            if (user != null) {
                user.getSellsList().add(sells);
                user = em.merge(user);
            }
            for (SellsItem sellsItemListSellsItem : sells.getSellsItemList()) {
                Sells oldSellIdOfSellsItemListSellsItem = sellsItemListSellsItem.getSellId();
                sellsItemListSellsItem.setSellId(sells);
                sellsItemListSellsItem = em.merge(sellsItemListSellsItem);
                if (oldSellIdOfSellsItemListSellsItem != null) {
                    oldSellIdOfSellsItemListSellsItem.getSellsItemList().remove(sellsItemListSellsItem);
                    oldSellIdOfSellsItemListSellsItem = em.merge(oldSellIdOfSellsItemListSellsItem);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void update(Sells sells) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sells persistentSells = em.find(Sells.class, sells.getId());

            User userOld = persistentSells.getUser();
            User userNew = sells.getUser();

            List<SellsItem> sellsItemListOld = persistentSells.getSellsItemList();
            List<SellsItem> sellsItemListNew = sells.getSellsItemList();
            List<String> illegalOrphanMessages = null;
            for (SellsItem sellsItemListOldSellsItem : sellsItemListOld) {
                if (!sellsItemListNew.contains(sellsItemListOldSellsItem)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain SellsItem " + sellsItemListOldSellsItem + " since its sellId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<SellsItem> attachedSellsItemListNew = new ArrayList<SellsItem>();
            for (SellsItem sellsItemListNewSellsItemToAttach : sellsItemListNew) {
                sellsItemListNewSellsItemToAttach = em.getReference(sellsItemListNewSellsItemToAttach.getClass(), sellsItemListNewSellsItemToAttach.getId());
                attachedSellsItemListNew.add(sellsItemListNewSellsItemToAttach);
            }
            sellsItemListNew = attachedSellsItemListNew;
            sells.setSellsItemList(sellsItemListNew);
            sells = em.merge(sells);
            if (userOld != null && !userOld.equals(userNew)) {
                userOld.getSellsList().remove(sells);
                userOld = em.merge(userOld);
            }
            if (userNew != null && !userNew.equals(userOld)) {
                userNew.getSellsList().add(sells);
                userNew = em.merge(userNew);
            }
            for (SellsItem sellsItemListNewSellsItem : sellsItemListNew) {
                if (!sellsItemListOld.contains(sellsItemListNewSellsItem)) {
                    Sells oldSellIdOfSellsItemListNewSellsItem = sellsItemListNewSellsItem.getSellId();
                    sellsItemListNewSellsItem.setSellId(sells);
                    sellsItemListNewSellsItem = em.merge(sellsItemListNewSellsItem);
                    if (oldSellIdOfSellsItemListNewSellsItem != null && !oldSellIdOfSellsItemListNewSellsItem.equals(sells)) {
                        oldSellIdOfSellsItemListNewSellsItem.getSellsItemList().remove(sellsItemListNewSellsItem);
                        oldSellIdOfSellsItemListNewSellsItem = em.merge(oldSellIdOfSellsItemListNewSellsItem);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = sells.getId();
                if (get(id) == null) {
                    throw new NonexistentEntityException("The sells with id " + id + " no longer exists.");
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
    public void delete(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sells sells;
            try {
                sells = em.getReference(Sells.class, id);
                sells.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sells with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<SellsItem> sellsItemListOrphanCheck = sells.getSellsItemList();
            for (SellsItem sellsItemListOrphanCheckSellsItem : sellsItemListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Sells (" + sells + ") cannot be destroyed since the SellsItem " + sellsItemListOrphanCheckSellsItem + " in its sellsItemList field has a non-nullable sellId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(sells);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }


    public List<Sells> findLastSells(int count) {
        // TODO Auto-generated method stub
        return null;
    }

}
