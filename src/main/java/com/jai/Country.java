package com.jai;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class Country {
	
	private int id;
	private String name;

    @ApiModelProperty(position = 1, required = true, value = "101")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@ApiModelProperty(position = 2, required = true, value = "India")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
