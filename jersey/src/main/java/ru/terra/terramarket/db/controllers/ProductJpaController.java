/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.terra.terramarket.db.controllers;

import ru.terra.server.db.controllers.AbstractJpaController;
import ru.terra.terramarket.db.controllers.exceptions.IllegalOrphanException;
import ru.terra.terramarket.db.controllers.exceptions.NonexistentEntityException;
import ru.terra.terramarket.db.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author terranz
 */
public class ProductJpaController extends AbstractJpaController<Product> implements Serializable {

    public ProductJpaController() {
        super(Product.class);
    }

    @Override
    public void create(Product product) {
        if (product.getStoreList() == null) {
            product.setStoreList(new ArrayList<Store>());
        }
        if (product.getSellsItemList() == null) {
            product.setSellsItemList(new ArrayList<SellsItem>());
        }
        if (product.getWaybillItemList() == null) {
            product.setWaybillItemList(new ArrayList<WaybillItem>());
        }
        if (product.getPhotoList() == null) {
            product.setPhotoList(new ArrayList<Photo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Groups groupId = product.getGroup();
            if (groupId != null) {
                groupId = em.getReference(groupId.getClass(), groupId.getId());
                product.setGroup(groupId);
            }
            List<Store> attachedStoreList = new ArrayList<Store>();
            for (Store storeListStoreToAttach : product.getStoreList()) {
                storeListStoreToAttach = em.getReference(storeListStoreToAttach.getClass(), storeListStoreToAttach.getId());
                attachedStoreList.add(storeListStoreToAttach);
            }
            product.setStoreList(attachedStoreList);
            List<SellsItem> attachedSellsItemList = new ArrayList<SellsItem>();
            for (SellsItem sellsItemListSellsItemToAttach : product.getSellsItemList()) {
                sellsItemListSellsItemToAttach = em.getReference(sellsItemListSellsItemToAttach.getClass(), sellsItemListSellsItemToAttach.getId());
                attachedSellsItemList.add(sellsItemListSellsItemToAttach);
            }
            product.setSellsItemList(attachedSellsItemList);
            List<WaybillItem> attachedWaybillItemList = new ArrayList<WaybillItem>();
            for (WaybillItem waybillItemListWaybillItemToAttach : product.getWaybillItemList()) {
                waybillItemListWaybillItemToAttach = em.getReference(waybillItemListWaybillItemToAttach.getClass(), waybillItemListWaybillItemToAttach.getId());
                attachedWaybillItemList.add(waybillItemListWaybillItemToAttach);
            }
            product.setWaybillItemList(attachedWaybillItemList);
            List<Photo> attachedPhotoList = new ArrayList<Photo>();
            for (Photo photoListPhotoToAttach : product.getPhotoList()) {
                photoListPhotoToAttach = em.getReference(photoListPhotoToAttach.getClass(), photoListPhotoToAttach.getId());
                attachedPhotoList.add(photoListPhotoToAttach);
            }
            product.setPhotoList(attachedPhotoList);
            em.persist(product);
            if (groupId != null) {
                groupId.getProductList().add(product);
                groupId = em.merge(groupId);
            }
            for (Store storeListStore : product.getStoreList()) {
                Product oldProdIdOfStoreListStore = storeListStore.getProduct();
                storeListStore.setProdId(product);
                storeListStore = em.merge(storeListStore);
                if (oldProdIdOfStoreListStore != null) {
                    oldProdIdOfStoreListStore.getStoreList().remove(storeListStore);
                    oldProdIdOfStoreListStore = em.merge(oldProdIdOfStoreListStore);
                }
            }
            for (SellsItem sellsItemListSellsItem : product.getSellsItemList()) {
                Product oldProdIdOfSellsItemListSellsItem = sellsItemListSellsItem.getProduct();
                sellsItemListSellsItem.setProdId(product);
                sellsItemListSellsItem = em.merge(sellsItemListSellsItem);
                if (oldProdIdOfSellsItemListSellsItem != null) {
                    oldProdIdOfSellsItemListSellsItem.getSellsItemList().remove(sellsItemListSellsItem);
                    oldProdIdOfSellsItemListSellsItem = em.merge(oldProdIdOfSellsItemListSellsItem);
                }
            }
            for (WaybillItem waybillItemListWaybillItem : product.getWaybillItemList()) {
                Product oldProdIdOfWaybillItemListWaybillItem = waybillItemListWaybillItem.getProduct();
                waybillItemListWaybillItem.setProduct(product);
                waybillItemListWaybillItem = em.merge(waybillItemListWaybillItem);
                if (oldProdIdOfWaybillItemListWaybillItem != null) {
                    oldProdIdOfWaybillItemListWaybillItem.getWaybillItemList().remove(waybillItemListWaybillItem);
                    oldProdIdOfWaybillItemListWaybillItem = em.merge(oldProdIdOfWaybillItemListWaybillItem);
                }
            }
            for (Photo photoListPhoto : product.getPhotoList()) {
                Product oldProductIdOfPhotoListPhoto = photoListPhoto.getProductId();
                photoListPhoto.setProductId(product);
                photoListPhoto = em.merge(photoListPhoto);
                if (oldProductIdOfPhotoListPhoto != null) {
                    oldProductIdOfPhotoListPhoto.getPhotoList().remove(photoListPhoto);
                    oldProductIdOfPhotoListPhoto = em.merge(oldProductIdOfPhotoListPhoto);
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
    public void update(Product product) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Product persistentProduct = em.find(Product.class, product.getId());
            Groups groupIdOld = persistentProduct.getGroup();
            Groups groupIdNew = product.getGroup();
            List<Store> storeListOld = persistentProduct.getStoreList();
            List<Store> storeListNew = product.getStoreList();
            List<SellsItem> sellsItemListOld = persistentProduct.getSellsItemList();
            List<SellsItem> sellsItemListNew = product.getSellsItemList();
            List<WaybillItem> waybillItemListOld = persistentProduct.getWaybillItemList();
            List<WaybillItem> waybillItemListNew = product.getWaybillItemList();
            List<Photo> photoListOld = persistentProduct.getPhotoList();
            List<Photo> photoListNew = product.getPhotoList();
            List<String> illegalOrphanMessages = null;
            for (Store storeListOldStore : storeListOld) {
                if (!storeListNew.contains(storeListOldStore)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Store " + storeListOldStore + " since its prodId field is not nullable.");
                }
            }
            for (SellsItem sellsItemListOldSellsItem : sellsItemListOld) {
                if (!sellsItemListNew.contains(sellsItemListOldSellsItem)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain SellsItem " + sellsItemListOldSellsItem + " since its prodId field is not nullable.");
                }
            }
            for (WaybillItem waybillItemListOldWaybillItem : waybillItemListOld) {
                if (!waybillItemListNew.contains(waybillItemListOldWaybillItem)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain WaybillItem " + waybillItemListOldWaybillItem + " since its prodId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (groupIdNew != null) {
                groupIdNew = em.getReference(groupIdNew.getClass(), groupIdNew.getId());
                product.setGroup(groupIdNew);
            }
            List<Store> attachedStoreListNew = new ArrayList<Store>();
            for (Store storeListNewStoreToAttach : storeListNew) {
                storeListNewStoreToAttach = em.getReference(storeListNewStoreToAttach.getClass(), storeListNewStoreToAttach.getId());
                attachedStoreListNew.add(storeListNewStoreToAttach);
            }
            storeListNew = attachedStoreListNew;
            product.setStoreList(storeListNew);
            List<SellsItem> attachedSellsItemListNew = new ArrayList<SellsItem>();
            for (SellsItem sellsItemListNewSellsItemToAttach : sellsItemListNew) {
                sellsItemListNewSellsItemToAttach = em.getReference(sellsItemListNewSellsItemToAttach.getClass(), sellsItemListNewSellsItemToAttach.getId());
                attachedSellsItemListNew.add(sellsItemListNewSellsItemToAttach);
            }
            sellsItemListNew = attachedSellsItemListNew;
            product.setSellsItemList(sellsItemListNew);
            List<WaybillItem> attachedWaybillItemListNew = new ArrayList<WaybillItem>();
            for (WaybillItem waybillItemListNewWaybillItemToAttach : waybillItemListNew) {
                waybillItemListNewWaybillItemToAttach = em.getReference(waybillItemListNewWaybillItemToAttach.getClass(), waybillItemListNewWaybillItemToAttach.getId());
                attachedWaybillItemListNew.add(waybillItemListNewWaybillItemToAttach);
            }
            waybillItemListNew = attachedWaybillItemListNew;
            product.setWaybillItemList(waybillItemListNew);
            List<Photo> attachedPhotoListNew = new ArrayList<Photo>();
            for (Photo photoListNewPhotoToAttach : photoListNew) {
                photoListNewPhotoToAttach = em.getReference(photoListNewPhotoToAttach.getClass(), photoListNewPhotoToAttach.getId());
                attachedPhotoListNew.add(photoListNewPhotoToAttach);
            }
            photoListNew = attachedPhotoListNew;
            product.setPhotoList(photoListNew);
            product = em.merge(product);
            if (groupIdOld != null && !groupIdOld.equals(groupIdNew)) {
                groupIdOld.getProductList().remove(product);
                groupIdOld = em.merge(groupIdOld);
            }
            if (groupIdNew != null && !groupIdNew.equals(groupIdOld)) {
                groupIdNew.getProductList().add(product);
                groupIdNew = em.merge(groupIdNew);
            }
            for (Store storeListNewStore : storeListNew) {
                if (!storeListOld.contains(storeListNewStore)) {
                    Product oldProdIdOfStoreListNewStore = storeListNewStore.getProduct();
                    storeListNewStore.setProdId(product);
                    storeListNewStore = em.merge(storeListNewStore);
                    if (oldProdIdOfStoreListNewStore != null && !oldProdIdOfStoreListNewStore.equals(product)) {
                        oldProdIdOfStoreListNewStore.getStoreList().remove(storeListNewStore);
                        oldProdIdOfStoreListNewStore = em.merge(oldProdIdOfStoreListNewStore);
                    }
                }
            }
            for (SellsItem sellsItemListNewSellsItem : sellsItemListNew) {
                if (!sellsItemListOld.contains(sellsItemListNewSellsItem)) {
                    Product oldProdIdOfSellsItemListNewSellsItem = sellsItemListNewSellsItem.getProduct();
                    sellsItemListNewSellsItem.setProdId(product);
                    sellsItemListNewSellsItem = em.merge(sellsItemListNewSellsItem);
                    if (oldProdIdOfSellsItemListNewSellsItem != null && !oldProdIdOfSellsItemListNewSellsItem.equals(product)) {
                        oldProdIdOfSellsItemListNewSellsItem.getSellsItemList().remove(sellsItemListNewSellsItem);
                        oldProdIdOfSellsItemListNewSellsItem = em.merge(oldProdIdOfSellsItemListNewSellsItem);
                    }
                }
            }
            for (WaybillItem waybillItemListNewWaybillItem : waybillItemListNew) {
                if (!waybillItemListOld.contains(waybillItemListNewWaybillItem)) {
                    Product oldProdIdOfWaybillItemListNewWaybillItem = waybillItemListNewWaybillItem.getProduct();
                    waybillItemListNewWaybillItem.setProduct(product);
                    waybillItemListNewWaybillItem = em.merge(waybillItemListNewWaybillItem);
                    if (oldProdIdOfWaybillItemListNewWaybillItem != null && !oldProdIdOfWaybillItemListNewWaybillItem.equals(product)) {
                        oldProdIdOfWaybillItemListNewWaybillItem.getWaybillItemList().remove(waybillItemListNewWaybillItem);
                        oldProdIdOfWaybillItemListNewWaybillItem = em.merge(oldProdIdOfWaybillItemListNewWaybillItem);
                    }
                }
            }
            for (Photo photoListOldPhoto : photoListOld) {
                if (!photoListNew.contains(photoListOldPhoto)) {
                    photoListOldPhoto.setProductId(null);
                    photoListOldPhoto = em.merge(photoListOldPhoto);
                }
            }
            for (Photo photoListNewPhoto : photoListNew) {
                if (!photoListOld.contains(photoListNewPhoto)) {
                    Product oldProductIdOfPhotoListNewPhoto = photoListNewPhoto.getProductId();
                    photoListNewPhoto.setProductId(product);
                    photoListNewPhoto = em.merge(photoListNewPhoto);
                    if (oldProductIdOfPhotoListNewPhoto != null && !oldProductIdOfPhotoListNewPhoto.equals(product)) {
                        oldProductIdOfPhotoListNewPhoto.getPhotoList().remove(photoListNewPhoto);
                        oldProductIdOfPhotoListNewPhoto = em.merge(oldProductIdOfPhotoListNewPhoto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = product.getId();
                if (get(id) == null) {
                    throw new NonexistentEntityException("The product with id " + id + " no longer exists.");
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
            Product product;
            try {
                product = em.getReference(Product.class, id);
                product.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The product with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Store> storeListOrphanCheck = product.getStoreList();
            for (Store storeListOrphanCheckStore : storeListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Product (" + product + ") cannot be destroyed since the Store " + storeListOrphanCheckStore + " in its storeList field has a non-nullable prodId field.");
            }
            List<SellsItem> sellsItemListOrphanCheck = product.getSellsItemList();
            for (SellsItem sellsItemListOrphanCheckSellsItem : sellsItemListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Product (" + product + ") cannot be destroyed since the SellsItem " + sellsItemListOrphanCheckSellsItem + " in its sellsItemList field has a non-nullable prodId field.");
            }
            List<WaybillItem> waybillItemListOrphanCheck = product.getWaybillItemList();
            for (WaybillItem waybillItemListOrphanCheckWaybillItem : waybillItemListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Product (" + product + ") cannot be destroyed since the WaybillItem " + waybillItemListOrphanCheckWaybillItem + " in its waybillItemList field has a non-nullable prodId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Groups groupId = product.getGroup();
            if (groupId != null) {
                groupId.getProductList().remove(product);
                groupId = em.merge(groupId);
            }
            List<Photo> photoList = product.getPhotoList();
            for (Photo photoListPhoto : photoList) {
                photoListPhoto.setProductId(null);
                photoListPhoto = em.merge(photoListPhoto);
            }
            em.remove(product);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
