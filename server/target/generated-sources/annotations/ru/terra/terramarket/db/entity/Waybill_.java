package ru.terra.terramarket.db.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ru.terra.terramarket.db.entity.User;
import ru.terra.terramarket.db.entity.WaybillItem;

@Generated(value="EclipseLink-2.4.0.v20120608-rNA", date="2013-12-13T18:03:47")
@StaticMetamodel(Waybill.class)
public class Waybill_ { 

    public static volatile SingularAttribute<Waybill, Integer> id;
    public static volatile ListAttribute<Waybill, WaybillItem> waybillItemList;
    public static volatile SingularAttribute<Waybill, String> title;
    public static volatile SingularAttribute<Waybill, Integer> count;
    public static volatile SingularAttribute<Waybill, Date> selldate;
    public static volatile SingularAttribute<Waybill, User> user;
    public static volatile SingularAttribute<Waybill, String> supplier;

}