/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.terra.terramarket.db.controllers;

import ru.terra.server.db.controllers.AbstractJpaController;
import ru.terra.terramarket.db.controllers.exceptions.IllegalOrphanException;
import ru.terra.terramarket.db.controllers.exceptions.NonexistentEntityException;
import ru.terra.terramarket.db.entity.Photo;
import ru.terra.terramarket.db.entity.User;
import ru.terra.terramarket.db.entity.Waybill;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author terranz
 */
public class UserJpaController extends AbstractJpaController<User> implements Serializable {

    public UserJpaController() {
        super(User.class);
    }

    @Override
    public void create(User users) {
        if (users.getPhotoList() == null) {
            users.setPhotoList(new ArrayList<Photo>());
        }
        if (users.getWaybillList() == null) {
            users.setWaybillList(new ArrayList<Waybill>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Photo> attachedPhotoList = new ArrayList<Photo>();
            for (Photo photoListPhotoToAttach : users.getPhotoList()) {
                photoListPhotoToAttach = em.getReference(photoListPhotoToAttach.getClass(), photoListPhotoToAttach.getId());
                attachedPhotoList.add(photoListPhotoToAttach);
            }
            users.setPhotoList(attachedPhotoList);
            List<Waybill> attachedWaybillList = new ArrayList<Waybill>();
            for (Waybill waybillListWaybillToAttach : users.getWaybillList()) {
                waybillListWaybillToAttach = em.getReference(waybillListWaybillToAttach.getClass(), waybillListWaybillToAttach.getId());
                attachedWaybillList.add(waybillListWaybillToAttach);
            }
            users.setWaybillList(attachedWaybillList);
            em.persist(users);
            for (Photo photoListPhoto : users.getPhotoList()) {
                User oldUserIdOfPhotoListPhoto = photoListPhoto.getUserId();
                photoListPhoto.setUserId(users);
                photoListPhoto = em.merge(photoListPhoto);
                if (oldUserIdOfPhotoListPhoto != null) {
                    oldUserIdOfPhotoListPhoto.getPhotoList().remove(photoListPhoto);
                    oldUserIdOfPhotoListPhoto = em.merge(oldUserIdOfPhotoListPhoto);
                }
            }
            for (Waybill waybillListWaybill : users.getWaybillList()) {
                User oldUserOfWaybillListWaybill = waybillListWaybill.getUser();
                waybillListWaybill.setUser(users);
                waybillListWaybill = em.merge(waybillListWaybill);
                if (oldUserOfWaybillListWaybill != null) {
                    oldUserOfWaybillListWaybill.getWaybillList().remove(waybillListWaybill);
                    oldUserOfWaybillListWaybill = em.merge(oldUserOfWaybillListWaybill);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void update(User users) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            User persistentUsers = em.find(User.class, users.getId());
            List<Photo> photoListOld = persistentUsers.getPhotoList();
            List<Photo> photoListNew = users.getPhotoList();
            List<Waybill> waybillListOld = persistentUsers.getWaybillList();
            List<Waybill> waybillListNew = users.getWaybillList();
            List<String> illegalOrphanMessages = null;
            for (Waybill waybillListOldWaybill : waybillListOld) {
                if (!waybillListNew.contains(waybillListOldWaybill)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Waybill " + waybillListOldWaybill + " since its user field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Photo> attachedPhotoListNew = new ArrayList<Photo>();
            for (Photo photoListNewPhotoToAttach : photoListNew) {
                photoListNewPhotoToAttach = em.getReference(photoListNewPhotoToAttach.getClass(), photoListNewPhotoToAttach.getId());
                attachedPhotoListNew.add(photoListNewPhotoToAttach);
            }
            photoListNew = attachedPhotoListNew;
            users.setPhotoList(photoListNew);
            List<Waybill> attachedWaybillListNew = new ArrayList<Waybill>();
            for (Waybill waybillListNewWaybillToAttach : waybillListNew) {
                waybillListNewWaybillToAttach = em.getReference(waybillListNewWaybillToAttach.getClass(), waybillListNewWaybillToAttach.getId());
                attachedWaybillListNew.add(waybillListNewWaybillToAttach);
            }
            waybillListNew = attachedWaybillListNew;
            users.setWaybillList(waybillListNew);
            users = em.merge(users);
            for (Photo photoListOldPhoto : photoListOld) {
                if (!photoListNew.contains(photoListOldPhoto)) {
                    photoListOldPhoto.setUserId(null);
                    photoListOldPhoto = em.merge(photoListOldPhoto);
                }
            }
            for (Photo photoListNewPhoto : photoListNew) {
                if (!photoListOld.contains(photoListNewPhoto)) {
                    User oldUserIdOfPhotoListNewPhoto = photoListNewPhoto.getUserId();
                    photoListNewPhoto.setUserId(users);
                    photoListNewPhoto = em.merge(photoListNewPhoto);
                    if (oldUserIdOfPhotoListNewPhoto != null && !oldUserIdOfPhotoListNewPhoto.equals(users)) {
                        oldUserIdOfPhotoListNewPhoto.getPhotoList().remove(photoListNewPhoto);
                        oldUserIdOfPhotoListNewPhoto = em.merge(oldUserIdOfPhotoListNewPhoto);
                    }
                }
            }
            for (Waybill waybillListNewWaybill : waybillListNew) {
                if (!waybillListOld.contains(waybillListNewWaybill)) {
                    User oldUserOfWaybillListNewWaybill = waybillListNewWaybill.getUser();
                    waybillListNewWaybill.setUser(users);
                    waybillListNewWaybill = em.merge(waybillListNewWaybill);
                    if (oldUserOfWaybillListNewWaybill != null && !oldUserOfWaybillListNewWaybill.equals(users)) {
                        oldUserOfWaybillListNewWaybill.getWaybillList().remove(waybillListNewWaybill);
                        oldUserOfWaybillListNewWaybill = em.merge(oldUserOfWaybillListNewWaybill);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = users.getId();
                if (get(id) == null) {
                    throw new NonexistentEntityException("The users with id " + id + " no longer exists.");
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
            User users;
            try {
                users = em.getReference(User.class, id);
                users.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The users with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Waybill> waybillListOrphanCheck = users.getWaybillList();
            for (Waybill waybillListOrphanCheckWaybill : waybillListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Users (" + users + ") cannot be destroyed since the Waybill " + waybillListOrphanCheckWaybill
                        + " in its waybillList field has a non-nullable user field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Photo> photoList = users.getPhotoList();
            for (Photo photoListPhoto : photoList) {
                photoListPhoto.setUserId(null);
                photoListPhoto = em.merge(photoListPhoto);
            }
            em.remove(users);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }


    public User findUser(String login) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("User.findByLogin").setParameter("login", login);
            return (User) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public User findUser(String login, String password) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createNamedQuery("User.findByLoginAndPass").setParameter("login", login).setParameter("pass", password);
            return (User) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
}
