/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.terra.terramarket.db.controllers;

import ru.terra.server.db.controllers.AbstractJpaController;
import ru.terra.terramarket.db.controllers.exceptions.IllegalOrphanException;
import ru.terra.terramarket.db.controllers.exceptions.NonexistentEntityException;
import ru.terra.terramarket.db.entity.User;
import ru.terra.terramarket.db.entity.Waybill;
import ru.terra.terramarket.db.entity.WaybillItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author terranz
 */
public class WaybillJpaController extends AbstractJpaController<Waybill> implements Serializable {

    public WaybillJpaController() {
        super(Waybill.class);
    }

    @Override
    public void create(Waybill waybill) {
        if (waybill.getWaybillItemList() == null) {
            waybill.setWaybillItemList(new ArrayList<WaybillItem>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            User user = waybill.getUser();
            if (user != null) {
                user = em.getReference(user.getClass(), user.getId());
                waybill.setUser(user);
            }
            List<WaybillItem> attachedWaybillItemList = new ArrayList<WaybillItem>();
            for (WaybillItem waybillItemListWaybillItemToAttach : waybill.getWaybillItemList()) {
                waybillItemListWaybillItemToAttach = em.getReference(waybillItemListWaybillItemToAttach.getClass(), waybillItemListWaybillItemToAttach.getId());
                attachedWaybillItemList.add(waybillItemListWaybillItemToAttach);
            }
            waybill.setWaybillItemList(attachedWaybillItemList);
            em.persist(waybill);
            if (user != null) {
                user.getWaybillList().add(waybill);
                user = em.merge(user);
            }
            for (WaybillItem waybillItemListWaybillItem : waybill.getWaybillItemList()) {
                Waybill oldWaybillIdOfWaybillItemListWaybillItem = waybillItemListWaybillItem.getWaybill();
                waybillItemListWaybillItem.setWaybill(waybill);
                waybillItemListWaybillItem = em.merge(waybillItemListWaybillItem);
                if (oldWaybillIdOfWaybillItemListWaybillItem != null) {
                    oldWaybillIdOfWaybillItemListWaybillItem.getWaybillItemList().remove(waybillItemListWaybillItem);
                    oldWaybillIdOfWaybillItemListWaybillItem = em.merge(oldWaybillIdOfWaybillItemListWaybillItem);
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
    public void update(Waybill waybill) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Waybill persistentWaybill = em.find(Waybill.class, waybill.getId());
            User userOld = persistentWaybill.getUser();
            User userNew = waybill.getUser();
            List<WaybillItem> waybillItemListOld = persistentWaybill.getWaybillItemList();
            List<WaybillItem> waybillItemListNew = waybill.getWaybillItemList();
            List<String> illegalOrphanMessages = null;
            for (WaybillItem waybillItemListOldWaybillItem : waybillItemListOld) {
                if (!waybillItemListNew.contains(waybillItemListOldWaybillItem)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain WaybillItem " + waybillItemListOldWaybillItem + " since its waybillId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (userNew != null) {
                userNew = em.getReference(userNew.getClass(), userNew.getId());
                waybill.setUser(userNew);
            }
            List<WaybillItem> attachedWaybillItemListNew = new ArrayList<WaybillItem>();
            for (WaybillItem waybillItemListNewWaybillItemToAttach : waybillItemListNew) {
                waybillItemListNewWaybillItemToAttach = em.getReference(waybillItemListNewWaybillItemToAttach.getClass(), waybillItemListNewWaybillItemToAttach.getId());
                attachedWaybillItemListNew.add(waybillItemListNewWaybillItemToAttach);
            }
            waybillItemListNew = attachedWaybillItemListNew;
            waybill.setWaybillItemList(waybillItemListNew);
            waybill = em.merge(waybill);
            if (userOld != null && !userOld.equals(userNew)) {
                userOld.getWaybillList().remove(waybill);
                userOld = em.merge(userOld);
            }
            if (userNew != null && !userNew.equals(userOld)) {
                userNew.getWaybillList().add(waybill);
                userNew = em.merge(userNew);
            }
            for (WaybillItem waybillItemListNewWaybillItem : waybillItemListNew) {
                if (!waybillItemListOld.contains(waybillItemListNewWaybillItem)) {
                    Waybill oldWaybillIdOfWaybillItemListNewWaybillItem = waybillItemListNewWaybillItem.getWaybill();
                    waybillItemListNewWaybillItem.setWaybill(waybill);
                    waybillItemListNewWaybillItem = em.merge(waybillItemListNewWaybillItem);
                    if (oldWaybillIdOfWaybillItemListNewWaybillItem != null && !oldWaybillIdOfWaybillItemListNewWaybillItem.equals(waybill)) {
                        oldWaybillIdOfWaybillItemListNewWaybillItem.getWaybillItemList().remove(waybillItemListNewWaybillItem);
                        oldWaybillIdOfWaybillItemListNewWaybillItem = em.merge(oldWaybillIdOfWaybillItemListNewWaybillItem);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = waybill.getId();
                if (get(id) == null) {
                    throw new NonexistentEntityException("The waybill with id " + id + " no longer exists.");
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
            Waybill waybill;
            try {
                waybill = em.getReference(Waybill.class, id);
                waybill.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The waybill with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<WaybillItem> waybillItemListOrphanCheck = waybill.getWaybillItemList();
            for (WaybillItem waybillItemListOrphanCheckWaybillItem : waybillItemListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Waybill (" + waybill + ") cannot be destroyed since the WaybillItem " + waybillItemListOrphanCheckWaybillItem + " in its waybillItemList field has a non-nullable waybillId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            User user = waybill.getUser();
            if (user != null) {
                user.getWaybillList().remove(waybill);
                user = em.merge(user);
            }
            em.remove(waybill);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
