package com.jsptestwar.JspTestWar.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class NotificationServiceImpl implements NotificationService {

	public static final String NOTIFY_MSG_SESSION_KEY ="notificationMessage";
	
	@Autowired
	private HttpSession httpSession;
	
	
	@Override
	public void addInfoMessage(String msg) {

		addNotificationMessage(NotificationMessageType.INFO, msg);
	}

	@Override
	public void addErrorMessage(String msg) {
		addNotificationMessage(NotificationMessageType.ERROR, msg);
	}
	
	private void addNotificationMessage(NotificationMessageType type, String msg) {
		Object listMessage = 
				httpSession.getAttribute(NOTIFY_MSG_SESSION_KEY);
		List<NotificationMessage> notifyList = (List<NotificationMessage>) listMessage;
		if(notifyList==null) {
			notifyList = new ArrayList<NotificationMessage>();
		}
		notifyList.add(new NotificationMessage(type, msg));
		httpSession.setAttribute(NOTIFY_MSG_SESSION_KEY, notifyList);
	}
	
	
	public enum NotificationMessageType{
		INFO,
		ERROR
	}
	
	public class NotificationMessage{
		NotificationMessageType type;
		String msg;
		public NotificationMessage(NotificationMessageType type, String msg) {
			this.type = type;
			this.msg =msg;
		}
		public NotificationMessageType getType() {
			return type;
		}
		public void setType(NotificationMessageType type) {
			this.type = type;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		
	}
}
