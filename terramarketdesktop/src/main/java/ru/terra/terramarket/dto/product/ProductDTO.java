package ru.terra.terramarket.dto.product;

import java.util.ArrayList;
import java.util.List;

import ru.terra.terramarket.dto.CommonDTO;
import ru.terra.terramarket.dto.group.GroupDTO;

public class ProductDTO extends CommonDTO {
	public String name;
	public Integer mincount;
	public String barcode;
	public Integer qtype;
	public Integer priceIn, priceOut;
	public GroupDTO group;
	public Integer rating;
	public List<PhotoDTO> photos = new ArrayList<>();

	public ProductDTO(ProductDTO dto) {
		this.id = dto.id;
		this.name = dto.name;
		this.mincount = dto.mincount;
		this.barcode = dto.barcode;
		this.qtype = dto.qtype;
		this.priceIn = dto.priceIn;
		this.priceOut = dto.priceOut;
		this.group = dto.group;
	}

	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}

	public boolean filled() {
		return name != null && name.length() > 0 && group != null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMincount() {
		return mincount;
	}

	public void setMincount(Integer mincount) {
		this.mincount = mincount;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Integer getQtype() {
		return qtype;
	}

	public void setQtype(Integer qtype) {
		this.qtype = qtype;
	}

	public Integer getPriceIn() {
		return priceIn;
	}

	public void setPriceIn(Integer priceIn) {
		this.priceIn = priceIn;
	}

	public Integer getPriceOut() {
		return priceOut;
	}

	public void setPriceOut(Integer priceOut) {
		this.priceOut = priceOut;
	}

}
