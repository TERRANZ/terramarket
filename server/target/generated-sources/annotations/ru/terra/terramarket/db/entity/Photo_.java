package ru.terra.terramarket.db.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ru.terra.terramarket.db.entity.Product;
import ru.terra.terramarket.db.entity.User;

@Generated(value="EclipseLink-2.4.0.v20120608-rNA", date="2013-12-13T18:03:47")
@StaticMetamodel(Photo.class)
public class Photo_ { 

    public static volatile SingularAttribute<Photo, Integer> id;
    public static volatile SingularAttribute<Photo, String> name;
    public static volatile SingularAttribute<Photo, User> userId;
    public static volatile SingularAttribute<Photo, String> path;
    public static volatile SingularAttribute<Photo, Product> productId;

}