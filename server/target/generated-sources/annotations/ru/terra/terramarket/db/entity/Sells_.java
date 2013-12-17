package ru.terra.terramarket.db.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ru.terra.terramarket.db.entity.SellsItem;
import ru.terra.terramarket.db.entity.User;

@Generated(value="EclipseLink-2.4.0.v20120608-rNA", date="2013-12-13T18:03:47")
@StaticMetamodel(Sells.class)
public class Sells_ { 

    public static volatile SingularAttribute<Sells, Integer> id;
    public static volatile ListAttribute<Sells, SellsItem> sellsItemList;
    public static volatile SingularAttribute<Sells, Date> selldate;
    public static volatile SingularAttribute<Sells, User> user;

}