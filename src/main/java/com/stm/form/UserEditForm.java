package com.stm.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.stm.data.entity.User;
public class UserEditForm {
	
	@NotNull
	@Size(min=1, max=User.NAME_MAX, message="{nameSizeError}")
	private String name = "";
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
