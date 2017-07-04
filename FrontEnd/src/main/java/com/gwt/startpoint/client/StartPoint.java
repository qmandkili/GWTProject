package com.gwt.startpoint.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.model.shared.Device;

import java.math.BigInteger;

import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class StartPoint implements EntryPoint {

	// private IdGenerator idGenerator = new IdGenerator();

	private final WorkerClient client = GWT.create(WorkerClient.class);

	private static final String HELLO_MESSAGE = "Hi, I'm your gwt application!";

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		// Это очень грязная фигня Она задает рутовую дирректорию для рест
		// запросов а у нас они лежат в другой папке
		// Нужно какнить распарсить первоначальный путь и уже к оригинальному
		// серваку добавлять это
		Defaults.setServiceRoot("http://localhost:8080/BackEnd/");
		
		

		/*
		 * final Label label = new Label(); client.get(new
		 * MethodCallback<String>() {
		 * 
		 * @Override public void onSuccess(Method method, String response) { //
		 * TODO Auto-generated method stub label.setText(response); }
		 * 
		 * @Override public void onFailure(Method method, Throwable exception) {
		 * // TODO Auto-generated method stub
		 * label.setText(exception.getMessage()); } });
		 */

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		
		Button addButton = new Button("Add");
		Button getButton = new Button("Get");
		Button updateButton = new Button("Update");
		Button deleteButton = new Button("Delete");
		
		horizontalPanel.add(addButton);
		horizontalPanel.add(getButton);
		horizontalPanel.add(updateButton);
		horizontalPanel.add(deleteButton);
		horizontalPanel.setVisible(true);
		
		TextBox idTextBox = new TextBox();
		TextBox nameTextBox = new TextBox();
		TextBox descriptionTextBox = new TextBox();
		Button addDeviceButton = new Button("Add");

		DialogBox addDialogBox = new DialogBox();
		addDialogBox.setTitle("Add new device");
		addDialogBox.setHeight("200");
		addDialogBox.setWidth("300");
		addDialogBox.setAnimationEnabled(true);
		addDialogBox.setGlassEnabled(true);
		addDialogBox.setVisible(true);
		
		VerticalPanel addTextPanel = new VerticalPanel();
		addTextPanel.add(idTextBox);
		addTextPanel.add(nameTextBox);
		addTextPanel.add(descriptionTextBox);
		addTextPanel.add(addDeviceButton);
		addTextPanel.setVisible(true);
		
		addDialogBox.setWidget(addTextPanel);
		
		addButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				addDialogBox.show();
			}
		});
		
		addDeviceButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				client.post(new Device(BigInteger.valueOf(Long.parseLong(idTextBox.getText())), 
						nameTextBox.getText(), descriptionTextBox.getText()),
						new MethodCallback<Device>() {
					@Override
					public void onFailure(Method method, Throwable exception) {
						// TODO Auto-generated method stub
						Window.alert(exception.toString() + "\n" + exception.getMessage());
						addDialogBox.hide();
					}

					@Override
					public void onSuccess(Method method, Device response) {
						// TODO Auto-generated method stub
						Window.alert(response.toString());
						addDialogBox.hide();
					}
				});
			}
		});		

		getButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				client.getById(BigInteger.valueOf(123), new MethodCallback<Device>() {
					@Override
					public void onFailure(Method method, Throwable exception) {
						// TODO Auto-generated method stub
						Window.alert(exception.toString() + "\n" + exception.getMessage());
					}

					@Override
					public void onSuccess(Method method, Device response) {
						// TODO Auto-generated method stub
						Window.alert(response.toString());
					}
				});
			}
		});		

		Device updateDevice = new Device(BigInteger.valueOf(123), "sendDevice", "");

		updateButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				client.update(updateDevice, new MethodCallback<Device>() {
					@Override
					public void onFailure(Method method, Throwable exception) {
						// TODO Auto-generated method stub
						Window.alert(exception.toString() + "\n" + exception.getMessage());
					}

					@Override
					public void onSuccess(Method method, Device response) {
						// TODO Auto-generated method stub
						Window.alert(response.toString());
					}
				});
			}
		});
		
		deleteButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				client.delete(BigInteger.valueOf(123), new MethodCallback<Device>() {
					@Override
					public void onFailure(Method method, Throwable exception) {
						// TODO Auto-generated method stub
						Window.alert(exception.toString() + "\n" + exception.getMessage());
					}

					@Override
					public void onSuccess(Method method, Device response) {
						// TODO Auto-generated method stub
						Window.alert(response.toString());
					}
				});
			}
		});

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
