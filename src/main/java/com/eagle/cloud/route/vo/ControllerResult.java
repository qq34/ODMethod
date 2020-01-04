package com.eagle.cloud.route.vo;


/**
 * 统一的json返回格式
 * @author wzhz
 * @param <T>
 */
public class ControllerResult<T> {

	private String status;
	private T data;
	private String msg;
	private Integer code;// 错误码

	public ControllerResult(String status, T data) {
		this.status = status;
		this.data = data;
	}
	public ControllerResult(String status) {
		this.status = status;
	}

	public ControllerResult(String status, T data, String msg) {
		this.status = status;
		this.data = data;
		this.msg = msg;
	}

	/**
	 * 正确信息
	 * @param data
	 * @param msg
	 */
	public ControllerResult(T data, String msg) {
		this.status = "OK";
		this.data = data;
		this.msg = msg;
	}


	public ControllerResult(String status, String msg) {
		this.msg = msg;
		this.status = status;
	}

	public ControllerResult(String status, String msg, int code) {
		this.msg = msg;
		this.status = status;
		this.code = code;
	}
	/**
	 * 返回错误码
	 * @param errorCode
	 */
	public ControllerResult(ErrorCode errorCode) {
		this.status = errorCode.getStatus();
		this.code = errorCode.getCode();
		this.msg = errorCode.getMessage();
	}
	/**
	 * 返回封装data的数据json
	 * @param data
	 * @param errorCode
	 */
	public ControllerResult(T data, ErrorCode errorCode) {
		this.data = data;
		this.status = errorCode.getStatus();
		this.code = errorCode.getCode();
		this.msg = errorCode.getMessage();
	}
	/**
	 * 
	 */
	public ControllerResult() {
		super();
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "返回信息：[status=" + status + ", data=" + data + ", msg=" + msg + ", code=" + code + "]";
	}

}
