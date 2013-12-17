package ru.terra.terramarket.db.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ru.terra.terramarket.db.entity.Groups;
import ru.terra.terramarket.db.entity.Photo;
import ru.terra.terramarket.db.entity.SellsItem;
import ru.terra.terramarket.db.entity.Store;
import ru.terra.terramarket.db.entity.WaybillItem;

@Generated(value="EclipseLink-2.4.0.v20120608-rNA", date="2013-12-13T18:03:47")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, Integer> priceIn;
    public static volatile SingularAttribute<Product, String> barcode;
    public static volatile SingularAttribute<Product, Integer> qtype;
    public static volatile ListAttribute<Product, Photo> photoList;
    public static volatile SingularAttribute<Product, Integer> id;
    public static volatile ListAttribute<Product, WaybillItem> waybillItemList;
    public static volatile SingularAttribute<Product, Groups> groupId;
    public static volatile ListAttribute<Product, Store> storeList;
    public static volatile ListAttribute<Product, SellsItem> sellsItemList;
    public static volatile SingularAttribute<Product, String> name;
    public static volatile SingularAttribute<Product, Integer> rating;
    public static volatile SingularAttribute<Product, Integer> mincount;
    public static volatile SingularAttribute<Product, Integer> priceOut;

}