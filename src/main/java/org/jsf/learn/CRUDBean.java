package org.jsf.learn;

import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;

import org.jsf.learn.entities.Book;
import org.jsf.learn.utils.FacesUtils;

public class CRUDBean {

	private HtmlPanelGrid grid;

	@SuppressWarnings("unchecked")
	public CRUDBean() {
		if (grid == null) {
			Book book = new Book("Italo Calvino", "111111111",
					"Seis Propuestas para el proximo milenio");
			Application app = FacesContext.getCurrentInstance()
					.getApplication();
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("book", book);
			grid = (HtmlPanelGrid) app
					.createComponent(HtmlPanelGrid.COMPONENT_TYPE);
			grid.setColumns(2);

			HtmlOutputText isbn_label = (HtmlOutputText) app
					.createComponent(HtmlOutputText.COMPONENT_TYPE);
			isbn_label.setValue("ISBN :");
			grid.getChildren().add(isbn_label);

			ValueBinding vb = app.createValueBinding("#{book.isbn}");
			HtmlInputText isbn = (HtmlInputText) app
					.createComponent(HtmlInputText.COMPONENT_TYPE);
			isbn.setValueBinding("value", vb);
			vb.setValue(FacesContext.getCurrentInstance(), book.getIsbn());
			System.out.println(vb.getValue(FacesContext.getCurrentInstance()));
			isbn.setValueBinding("1", vb);
			grid.getChildren().add(isbn);

		}

	}

	public UIComponent getEditPanel() {
		return grid;
	}

	public void save() {
		System.out.println(FacesUtils.getParameter("book"));
		System.out.println("saving");
	}

	public String back() {
		System.out.println("returning");
		return "back";
	}
}
