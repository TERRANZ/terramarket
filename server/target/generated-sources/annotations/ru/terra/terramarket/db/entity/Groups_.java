package ru.terra.terramarket.db.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ru.terra.terramarket.db.entity.Product;

@Generated(value="EclipseLink-2.4.0.v20120608-rNA", date="2013-12-13T18:03:47")
@StaticMetamodel(Groups.class)
public class Groups_ { 

    public static volatile SingularAttribute<Groups, Integer> id;
    public static volatile ListAttribute<Groups, Product> productList;
    public static volatile SingularAttribute<Groups, String> name;
    public static volatile SingularAttribute<Groups, Integer> parent;

}