package com.gwt.startpoint.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.gwt.startpoint.client.view.DeviceTable;
import com.gwt.startpoint.client.view.UpdateButtonView;
import com.model.shared.Device;

import java.util.List;

import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class StartPoint implements EntryPoint {

	private final WorkerClient client = GWT.create(WorkerClient.class);

	private static final String HELLO_MESSAGE = "Hi, I'm your gwt application!";

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		SimpleEventBus eventBus = new SimpleEventBus();


		// Это очень грязная фигня Она задает рутовую дирректорию для рест
		// запросов а у нас они лежат в другой папке
		// Нужно какнить распарсить первоначальный путь и уже к оригинальному
		// серваку добавлять это
		Defaults.setServiceRoot("http://localhost:8080/BackEnd/");		
		
		GudDialogBox gudDialogBox = new GudDialogBox();
		
		AddDialogBox addBox = new AddDialogBox();

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		
		Button addButton = new Button("Add");
		Button getButton = new Button("G+U+D");
		//Button updateTableButton = new Button("Update Table");
		
		horizontalPanel.add(addButton);
		horizontalPanel.add(getButton);
		horizontalPanel.add(new UpdateButtonView(eventBus));
		horizontalPanel.setVisible(true);
		
		Button closeGudButton = new Button("Close");
		Button closeAddButton = new Button("Close");
		

		DialogBox addDialogBox = new DialogBox();
		addDialogBox.setTitle("Add new device");
		addDialogBox.setHeight("200");
		addDialogBox.setWidth("300");
		addDialogBox.setAnimationEnabled(true);
		addDialogBox.setGlassEnabled(true);
		addDialogBox.setVisible(true);
		
		VerticalPanel addTextPanel = new VerticalPanel();
		addTextPanel.add(addBox);
		addTextPanel.add(closeAddButton);
		addTextPanel.setVisible(true);
		
		addDialogBox.add(addTextPanel);
		
		DialogBox getDialogBox = new DialogBox();
		getDialogBox.setTitle("Get device");
		getDialogBox.setHeight("200");
		getDialogBox.setWidth("300");
		getDialogBox.setAnimationEnabled(true);
		getDialogBox.setGlassEnabled(true);
		getDialogBox.setVisible(true);
		
		VerticalPanel getTextPanel = new VerticalPanel();
		getTextPanel.setVisible(true);
		getTextPanel.add(gudDialogBox);
		getTextPanel.add(closeGudButton);
		
		getDialogBox.add(getTextPanel);
		
		addButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				addDialogBox.show();
			}
		});
		
		closeAddButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				addDialogBox.hide();
			}
		});
		
		getButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				getDialogBox.show();
			}
		});
		
		closeGudButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				getDialogBox.hide();
			}
		});
		
		/*updateTableButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				client.getAll(new MethodCallback<List<Device>>() {
					@Override
					public void onFailure(Method method, Throwable exception) {
						// TODO Auto-generated method stub
						Window.alert(exception.toString() + "\n" + exception.getMessage());
					}
					@Override
					public void onSuccess(Method method, List<Device> response) {						
						deviceTable.updateRows(response);
					}
				});
			}
		});	*/	
		
		RootPanel.get().add(new DeviceTable(eventBus));
		
		//RootPanel.get().add(table);

		RootPanel.get().add(horizontalPanel);

		final Label label = new Label(HELLO_MESSAGE);
		RootPanel.get().add(label);

		final Button button = new Button("Click me");
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Window.alert("You press on me! Don't it anymore");
			}
		});
		RootPanel.get().add(button);	
		
	}
}
