package br.com.vendas.utility;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

// classes que retornam mensagens personalizadas.
public class Message {

	public static void info(String msg) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public static void erro(String msg) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public static void warn(String msg) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, msg, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
