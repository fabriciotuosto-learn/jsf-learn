package org.jsf.learn;

import java.util.Map;
import java.util.Map.Entry;

import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.jsf.learn.entities.Book;
import org.jsf.learn.utils.FacesUtils;

public class CRUDBean {

	private HtmlPanelGrid grid;

	@SuppressWarnings("unchecked")
	public CRUDBean() throws Exception {
		if (grid == null) {
			Book book = new Book("Italo Calvino", "111111111",
					"Seis Propuestas para el proximo milenio");
			Application app = FacesContext.getCurrentInstance()
					.getApplication();
			FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap().put("bean", book);
			grid = (HtmlPanelGrid) app
					.createComponent(HtmlPanelGrid.COMPONENT_TYPE);
			grid.setColumns(2);
			Map<String, Object> beanDescription = BeanUtils.describe(book);
			beanDescription.remove("class");
			for (Entry<String, Object> entry : beanDescription.entrySet()) {
				HtmlOutputText label = (HtmlOutputText) app
						.createComponent(HtmlOutputText.COMPONENT_TYPE);
				label.setValue(StringUtils.capitalize(entry.getKey()));
				grid.getChildren().add(label);
				String _valueBinding = String.format("#{bean.%s}", entry
						.getKey());
				HtmlInputText input = (HtmlInputText) app
						.createComponent(HtmlInputText.COMPONENT_TYPE);
				input.setSize(entry.getValue().toString().length());
				input.setValueBinding("value", app
						.createValueBinding(_valueBinding));
				grid.getChildren().add(input);
			}

		}

	}

	public UIComponent getEditPanel() {
		return grid;
	}

	public void save() {
		System.out.println(FacesUtils.getParameter("bean"));
		System.out.println("saving");
	}

	public String back() {
		System.out.println("returning");
		return "back";
	}
}
