package ru.terra.terramarket.network;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import ru.terra.terramarket.constants.URLConstants;
import ru.terra.terramarket.dto.LoginDTO;
import ru.terra.terramarket.network.tmclients.Groups;
import ru.terra.terramarket.network.tmclients.Products;
import ru.terra.terramarket.network.tmclients.Sells;
import ru.terra.terramarket.network.tmclients.Store;
import ru.terra.terramarket.network.tmclients.WayBills;

public interface TMClient extends Products, Groups, WayBills, Sells, Store {

	@GET
	@Path(URLConstants.DoJson.Login.LOGIN + URLConstants.DoJson.Login.LOGIN_DO_LOGIN_JSON)
	LoginDTO login(@HeaderParam("Cookie") String session, @QueryParam("user") String user, @QueryParam("pass") String pass);

}
