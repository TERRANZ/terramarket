package ru.terra.terramarket.db.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ru.terra.terramarket.db.entity.Photo;
import ru.terra.terramarket.db.entity.Sells;
import ru.terra.terramarket.db.entity.Waybill;

@Generated(value="EclipseLink-2.4.0.v20120608-rNA", date="2013-12-13T18:03:47")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Integer> id;
    public static volatile ListAttribute<User, Sells> sellsList;
    public static volatile SingularAttribute<User, Integer> level;
    public static volatile SingularAttribute<User, String> name;
    public static volatile ListAttribute<User, Waybill> waybillList;
    public static volatile SingularAttribute<User, String> login;
    public static volatile ListAttribute<User, Photo> photoList;
    public static volatile SingularAttribute<User, String> pass;

}