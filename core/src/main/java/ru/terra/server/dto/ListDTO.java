package ru.terra.server.dto;

import java.util.ArrayList;
import java.util.List;

public class ListDTO<T> extends CommonDTO {
	public List<T> data = new ArrayList<>();
	private Integer size;

	public Integer getSize() {
		size = data.size();
		return size;
	}

	public void setData(List<T> d) {
		this.data = d;
	}

}
