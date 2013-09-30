package ru.terra.terramarket.network;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientFactory;
import javax.ws.rs.client.WebTarget;

import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import ru.terra.terramarket.constants.URLConstants;
import ru.terra.terramarket.core.SessionHolder;
import ru.terra.terramarket.dto.ListDTO;
import ru.terra.terramarket.dto.LoginDTO;
import ru.terra.terramarket.dto.group.GroupDTO;
import ru.terra.terramarket.dto.product.ProductDTO;
import ru.terra.terramarket.dto.sell.SellDTO;
import ru.terra.terramarket.dto.store.StoreDTO;
import ru.terra.terramarket.dto.waybill.WayBillDTO;
import ru.terra.terramarket.gui.swt.waybills.EditWayBillDialog.WayBillBean;

public class RestClient {
	private TMClient createRequest() {
		Client client = ClientFactory.newClient();
		WebTarget target = client.target(URLConstants.SERVER_URL);
		ResteasyWebTarget rtarget = (ResteasyWebTarget) target;
		return rtarget.proxy(TMClient.class);
	}

	public ListDTO<ProductDTO> loadProducts() {
		return createRequest().loadProducts(SessionHolder.sessionId, true, -1, -1);
	}

	public ListDTO<GroupDTO> loadGroups() {
		return createRequest().loadGroups(SessionHolder.sessionId, true, -1, -1);
	}

	public ListDTO<WayBillDTO> loadWBs() {
		return createRequest().loadWBs(SessionHolder.sessionId, true, -1, -1);
	}

	public ListDTO<StoreDTO> loadStore() {
		return createRequest().loadStore(SessionHolder.sessionId, true, -1, -1);
	}

	public ListDTO<SellDTO> loadSells() {
		return createRequest().loadSells(SessionHolder.sessionId, true, -1, -1);
	}

	public LoginDTO login(String user, String pass) {
		return createRequest().login(SessionHolder.sessionId, user, pass);
	}

	public WayBillDTO createWB(WayBillBean bean) {
		String products = "";
		for (Integer product : bean.products)
			products += product + ",";
		products = products.substring(0, products.length() - 1);

		String counts = "";
		for (Integer count : bean.counts)
			counts += count + ",";
		counts = counts.substring(0, counts.length() - 1);
		return createRequest().createWB(SessionHolder.sessionId, bean.date.getTime(), 1, products, counts, bean.title, bean.supplier);
	}

	public ProductDTO createProduct(ProductDTO prod) {
		return createRequest().createProduct(SessionHolder.sessionId, prod.name, prod.mincount, prod.barcode, prod.qtype, prod.priceIn,
				prod.priceOut, prod.group.id);
	}

	public Boolean updateProduct(ProductDTO prod) {
		return createRequest().updateProduct(SessionHolder.sessionId, prod.name, prod.mincount, prod.barcode, prod.qtype, prod.priceIn,
				prod.priceOut, prod.group.id).data;
	}

	public Boolean updateWayBill(WayBillBean wayBill, WayBillBean oldWb) {
		if (!wayBill.date.equals(oldWb.date))
			return createRequest().updateWayBill(SessionHolder.sessionId, "selldate", String.valueOf(wayBill.date.getTime()), wayBill.id).data;
		if (!wayBill.title.equals(oldWb.title))
			return createRequest().updateWayBill(SessionHolder.sessionId, "title", wayBill.title, wayBill.id).data;
		if (!wayBill.supplier.equals(oldWb.supplier))
			return createRequest().updateWayBill(SessionHolder.sessionId, "supplier", wayBill.supplier, wayBill.id).data;
		return false;
	}

	public Integer doSell(Integer[] products, Integer[] counts) {
		String aproducts = "";
		for (Integer product : products)
			aproducts += product + ",";
		aproducts = aproducts.substring(0, aproducts.length() - 1);

		String acounts = "";
		for (Integer count : counts)
			acounts += count + ",";
		acounts = acounts.substring(0, acounts.length() - 1);
		return createRequest().doSell(SessionHolder.sessionId, aproducts, acounts).data;
	}

	public Boolean storeAdd(Integer product, Integer count) {
		return createRequest().addToStore(SessionHolder.sessionId, product, count).data;

	}
}
