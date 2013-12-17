package ru.terra.terramarket.db.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ru.terra.terramarket.db.entity.Product;
import ru.terra.terramarket.db.entity.Sells;

@Generated(value="EclipseLink-2.4.0.v20120608-rNA", date="2013-12-13T18:03:47")
@StaticMetamodel(SellsItem.class)
public class SellsItem_ { 

    public static volatile SingularAttribute<SellsItem, Integer> id;
    public static volatile SingularAttribute<SellsItem, Integer> count;
    public static volatile SingularAttribute<SellsItem, Product> prodId;
    public static volatile SingularAttribute<SellsItem, Sells> sellId;

}