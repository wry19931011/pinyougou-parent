package com.pinyougou.pojo;

import java.io.Serializable;

public class MsgResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6516053024587284944L;

	private Boolean success;

	private String message;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MsgResult() {
		super();
	}

	public MsgResult(Boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}

}
