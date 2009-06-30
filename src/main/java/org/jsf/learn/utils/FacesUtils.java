package org.jsf.learn.utils;

import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class FacesUtils {

	private static ExternalContext context = null;
	
	public static Locale getUserLocale() {
		return getExternalContext().getRequestLocale();
	}

	public static void createGlobalMessage(String mensaje, Severity severity,
			String detail) {
		createMessage(mensaje, severity, detail, null);
	}

	public static void createMessage(String mensaje, Severity severity,
			String detail, String component) {
		FacesMessage message = new FacesMessage(severity, mensaje, detail);
		FacesContext.getCurrentInstance().addMessage(component, message);
	}

	public static <T> T getParameter(String parameter) {
		T value = getRequestParameter(parameter);
		if (value == null) {
			value = getSessionParameter(parameter);
		}
		if (value == null) {
			value = getApplicationParameter(parameter);
		}
		return value;
	}

	public static <T> T getRequestParameter(String parameter) {
		@SuppressWarnings("unchecked")
		// Casted to the expected parameter
		T param = (T) getExternalContext().getRequestMap().get(parameter);
		return param;
	}

	public static <T> T getSessionParameter(String parameter) {
		@SuppressWarnings("unchecked")
		// Casted to the expected parameter
		T param = (T) getExternalContext().getSessionMap().get(parameter);
		return param;
	}

	public static <T> T getApplicationParameter(String parameter) {
		@SuppressWarnings("unchecked")
		// Casted to the expected parameter
		T param = (T) getExternalContext().getApplicationMap().get(parameter);
		return param;
	}

	private static ExternalContext getExternalContext() {
		return FacesContext.getCurrentInstance().getExternalContext();
	}
	
	/**
	 * Only for test purposes
	 * @param context
	 */
	protected static void setExternalContext(ExternalContext context){
		FacesUtils.context = context;
	}
	
}
