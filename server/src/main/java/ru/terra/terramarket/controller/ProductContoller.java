package ru.terra.terramarket.controller;

import com.sun.jersey.api.core.HttpContext;
import org.apache.commons.lang.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.terra.server.constants.ErrorConstants;
import ru.terra.server.controller.AbstractController;
import ru.terra.server.dto.SimpleDataDTO;
import ru.terra.server.security.SecurityLevel;
import ru.terra.terramarket.constants.URLConstants;
import ru.terra.terramarket.db.entity.Product;
import ru.terra.terramarket.dto.product.ProductDTO;
import ru.terra.terramarket.engine.GroupEngine;
import ru.terra.terramarket.engine.ProductEngine;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

@Path(URLConstants.DoJson.Product.PRODUCT)
public class ProductContoller extends AbstractController<Product, ProductDTO, ProductEngine> {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private GroupEngine groupEngine = new GroupEngine();

    public ProductContoller() {
        super(ProductEngine.class);
    }

    @POST
    @Path(URLConstants.DoJson.DO_CREATE)
    public ProductDTO create(@Context HttpContext hc,
                             @QueryParam("name") String name,
                             @QueryParam("mincount") Integer mincount,
                             @QueryParam("barcode") String barcode,
                             @QueryParam("qtype") Integer qtype,
                             @QueryParam("pricein") Integer priceIn,
                             @QueryParam("priceout") Integer priceOut,
                             @QueryParam("groupid") Integer group,
                             @QueryParam("comment") String comment
    ) {
        if (engine == null)
            throw new NotImplementedException();
        if (!checkUserCanAccess(hc, SecurityLevel.MANAGER)) {
            ProductDTO ret = new ProductDTO(null);
            ret.errorCode = ErrorConstants.ERR_NOT_AUTHORIZED_ID;
            ret.errorMessage = ErrorConstants.ERR_NOT_AUTHORIZED_MSG;
            return ret;
        }
        return engine.entityToDto(
                engine.createBean(
                        new Product(null, name, mincount, qtype, priceIn, priceOut, 0, barcode, groupEngine.getBean(group), comment)));

    }

    @POST
    @Path(URLConstants.DoJson.DO_UPDATE)
    public SimpleDataDTO<Boolean> update(@Context HttpContext hc,
                                         @QueryParam("name") String name,
                                         @QueryParam("mincount") Integer mincount,
                                         @QueryParam("barcode") String barcode,
                                         @QueryParam("qtype") Integer qtype,
                                         @QueryParam("pricein") Integer priceIn,
                                         @QueryParam("priceout") Integer priceOut,
                                         @QueryParam("groupid") Integer group,
                                         @QueryParam("comment") String comment) {
        if (engine == null)
            throw new NotImplementedException();
        if (!checkUserCanAccess(hc, SecurityLevel.MANAGER)) {
            SimpleDataDTO<Boolean> ret = new SimpleDataDTO<Boolean>(false);
            ret.errorCode = ErrorConstants.ERR_NOT_AUTHORIZED_ID;
            ret.errorMessage = ErrorConstants.ERR_NOT_AUTHORIZED_MSG;
            return ret;
        }
        return new SimpleDataDTO<>(engine.updateDTO(
                new ProductDTO(name, mincount, barcode, qtype, priceIn, priceOut, groupEngine.getDto(group), comment)));
    }
}
