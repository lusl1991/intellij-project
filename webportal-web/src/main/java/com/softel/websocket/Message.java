package com.softel.websocket;
import java.util.Date;
/**
 * 消息类
 * 
 * @author Goofy
 * @Date 2015年6月12日 下午7:32:39
 */
public class Message {
	/**
	 * 发送者
	 */
	public Long from;

	/**
	 * 发送者名称
	 */
	public String fromName;

	/**
	 * 接收者
	 */
	public Long to;

	/**
	 * 发送的文本
	 */
	public String text;

	/**
	 * 发送日期
	 */
	public Date date;

	/**
	 * 总数
	 */
	public Long total;

	/**
	 * 成功数
	 */
	public Long success;

	public Long getFrom() {
		return from;
	}

	public void setFrom(Long from) {
		this.from = from;
	}

	public Long getTo() {
		return to;
	}

	public void setTo(Long to) {
		this.to = to;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Long getSuccess() {
		return success;
	}

	public void setSuccess(Long success) {
		this.success = success;
	}
}
