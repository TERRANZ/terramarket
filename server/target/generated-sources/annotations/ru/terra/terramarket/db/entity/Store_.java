package ru.terra.terramarket.db.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ru.terra.terramarket.db.entity.Product;

@Generated(value="EclipseLink-2.4.0.v20120608-rNA", date="2013-12-13T18:03:47")
@StaticMetamodel(Store.class)
public class Store_ { 

    public static volatile SingularAttribute<Store, Integer> id;
    public static volatile SingularAttribute<Store, Integer> count;
    public static volatile SingularAttribute<Store, Date> updated;
    public static volatile SingularAttribute<Store, Product> prodId;

}