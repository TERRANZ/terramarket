/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.terra.terramarket.db.controllers;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;

import ru.terra.server.db.controllers.AbstractJpaController;
import ru.terra.terramarket.db.controllers.exceptions.NonexistentEntityException;
import ru.terra.terramarket.db.entity.Photo;
import ru.terra.terramarket.db.entity.User;
import ru.terra.terramarket.db.entity.Product;

/**
 *
 * @author terranz
 */
public class PhotoJpaController extends AbstractJpaController<Photo> implements Serializable {

    public PhotoJpaController() {
        super(Photo.class);
    }

    @Override
    public void create(Photo photo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            User userId = photo.getUserId();
            if (userId != null) {
                userId = em.getReference(userId.getClass(), userId.getId());
                photo.setUserId(userId);
            }
            Product productId = photo.getProductId();
            if (productId != null) {
                productId = em.getReference(productId.getClass(), productId.getId());
                photo.setProductId(productId);
            }
            em.persist(photo);
            if (userId != null) {
                userId.getPhotoList().add(photo);
                userId = em.merge(userId);
            }
            if (productId != null) {
                productId.getPhotoList().add(photo);
                productId = em.merge(productId);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void update(Photo photo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Photo persistentPhoto = em.find(Photo.class, photo.getId());
            User userIdOld = persistentPhoto.getUserId();
            User userIdNew = photo.getUserId();
            Product productIdOld = persistentPhoto.getProductId();
            Product productIdNew = photo.getProductId();
            if (userIdNew != null) {
                userIdNew = em.getReference(userIdNew.getClass(), userIdNew.getId());
                photo.setUserId(userIdNew);
            }
            if (productIdNew != null) {
                productIdNew = em.getReference(productIdNew.getClass(), productIdNew.getId());
                photo.setProductId(productIdNew);
            }
            photo = em.merge(photo);
            if (userIdOld != null && !userIdOld.equals(userIdNew)) {
                userIdOld.getPhotoList().remove(photo);
                userIdOld = em.merge(userIdOld);
            }
            if (userIdNew != null && !userIdNew.equals(userIdOld)) {
                userIdNew.getPhotoList().add(photo);
                userIdNew = em.merge(userIdNew);
            }
            if (productIdOld != null && !productIdOld.equals(productIdNew)) {
                productIdOld.getPhotoList().remove(photo);
                productIdOld = em.merge(productIdOld);
            }
            if (productIdNew != null && !productIdNew.equals(productIdOld)) {
                productIdNew.getPhotoList().add(photo);
                productIdNew = em.merge(productIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = photo.getId();
                if (get(id) == null) {
                    throw new NonexistentEntityException("The photo with id " + id + " no longer exists.");
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
            Photo photo;
            try {
                photo = em.getReference(Photo.class, id);
                photo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The photo with id " + id + " no longer exists.", enfe);
            }
            User userId = photo.getUserId();
            if (userId != null) {
                userId.getPhotoList().remove(photo);
                userId = em.merge(userId);
            }
            Product productId = photo.getProductId();
            if (productId != null) {
                productId.getPhotoList().remove(photo);
                productId = em.merge(productId);
            }
            em.remove(photo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
