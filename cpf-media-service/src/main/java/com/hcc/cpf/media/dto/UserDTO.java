package com.hcc.cpf.media.dto;

public class UserDTO extends AbstractDTO<UserDTO> {


	private static final long serialVersionUID = -7840898994069036011L;

	private String userName;
	private Integer status;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}


}
