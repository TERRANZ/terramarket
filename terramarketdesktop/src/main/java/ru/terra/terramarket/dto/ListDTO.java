package ru.terra.terramarket.dto;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

public class ListDTO<T> extends CommonDTO {
	public List<T> data = new ArrayList<>();
	@JsonIgnore
	private Integer size;

	public Integer getSize() {
		size = data.size();
		return size;
	}

	public void setData(List<T> d) {
		this.data = d;
	}

}
