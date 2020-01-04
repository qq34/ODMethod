package com.eagle.cloud.route.vo;

/**
 * 错误信息CODE
 * @author wzhz
 * @date 2016-09-29
 */
public enum ErrorCode {

	SUCCESS ("OK", 1, "操作成功"),
	FAIL ("ERR", 0, "操作失败"),
	PARAM_NOT_NULL ("ERR", 101, "传入参数错误"),
	INSERT_FAIL ("ERR", 301, "系统繁忙，请稍候再试"),
	REPEAT_FAIL ("OK", 302, "已有该场景，请重命名"),
	SYSTEM_ERROR("ERR", 999, "未知错误");

    /**
     * 返回状态构造
     * @param status	状态
     * @param code		错误码
     * @param message   给用户的提示语
     */
    ErrorCode(String status, Integer code, String message) {
    	this.status = status;
        this.code = code;
        this.message = message;
    }

    private String status;
    private Integer code;
    private String message;
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
