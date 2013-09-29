package ru.terra.terramarket.dto;

public class SimpleDataDTO<T> extends CommonDTO {
	public T data;

	public SimpleDataDTO(T data) {
		this.data = data;
	}

	public SimpleDataDTO() {
		this.data = null;
	}
}
