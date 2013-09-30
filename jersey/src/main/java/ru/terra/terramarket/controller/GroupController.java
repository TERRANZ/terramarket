package ru.terra.terramarket.controller;

import com.sun.jersey.api.core.HttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.terra.server.constants.ErrorConstants;
import ru.terra.server.controller.AbstractController;
import ru.terra.terramarket.constants.URLConstants;
import ru.terra.terramarket.db.entity.Groups;
import ru.terra.server.dto.CommonDTO;
import ru.terra.server.dto.SimpleDataDTO;
import ru.terra.terramarket.dto.group.GroupDTO;
import ru.terra.terramarket.engine.GroupEngine;
import ru.terra.server.security.SecurityLevel;
import org.apache.commons.lang.NotImplementedException;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path(URLConstants.DoJson.Group.GROUP)
public class GroupController extends AbstractController<Groups, GroupDTO, GroupEngine> {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public GroupController() {
        super(GroupEngine.class);
    }

    @POST
    @Path(URLConstants.DoJson.DO_CREATE)
    public GroupDTO create(@Context HttpContext hc, @QueryParam("dto") GroupDTO dto) {
        if (engine == null)
            throw new NotImplementedException();
        if (!checkUserCanAccess(hc, SecurityLevel.MANAGER)) {
            GroupDTO ret = new GroupDTO();
            ret.errorCode = ErrorConstants.ERR_NOT_AUTHORIZED_ID;
            ret.errorMessage = ErrorConstants.ERR_NOT_AUTHORIZED_MSG;
            return  ret;
        }
        return null;//engine.createDto(dto);
    }
    @POST
    @Path(URLConstants.DoJson.DO_UPDATE)
    public SimpleDataDTO<Boolean> update(@Context HttpContext hc, @QueryParam("dto") GroupDTO dto) {
        if (engine == null)
            throw new NotImplementedException();
        if (!checkUserCanAccess(hc, SecurityLevel.MANAGER)) {
            SimpleDataDTO<Boolean> ret = new SimpleDataDTO<Boolean>(false);
            ret.errorCode = ErrorConstants.ERR_NOT_AUTHORIZED_ID;
            ret.errorMessage = ErrorConstants.ERR_NOT_AUTHORIZED_MSG;
            return ret;
        }
        return new SimpleDataDTO<>(engine.updateDTO(dto));
    }
}
