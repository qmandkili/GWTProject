package com.gwt.startpoint.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.model.shared.Device;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

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
		
		FlexTable table = new FlexTable();
		table.setText(0, 0, "id");
		table.setText(0, 1, "Name");
		table.setText(0, 2, "Description");
		table.setVisible(true);

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		
		Button addButton = new Button("Add");
		Button getButton = new Button("G+U+D");
		Button updateTableButton = new Button("Update Table");
		
		horizontalPanel.add(addButton);
		horizontalPanel.add(getButton);
		horizontalPanel.add(updateTableButton);
		horizontalPanel.setVisible(true);
		
		TextBox idTextBox = new TextBox();
		TextBox nameTextBox = new TextBox();
		TextBox descriptionTextBox = new TextBox();
		Button addDeviceButton = new Button("Add");
		Button getDeviceButton = new Button("Get");
		Button updateDeviceButton = new Button("Update");
		Button deleteDeviceButton = new Button("Delete");
		Button closeButton = new Button("Close");
		

		DialogBox addDialogBox = new DialogBox();
		addDialogBox.setTitle("Add new device");
		addDialogBox.setHeight("200");
		addDialogBox.setWidth("300");
		addDialogBox.setAnimationEnabled(true);
		addDialogBox.setGlassEnabled(true);
		addDialogBox.setVisible(true);
		
		VerticalPanel addTextPanel = new VerticalPanel();
		addTextPanel.add(nameTextBox);
		addTextPanel.add(descriptionTextBox);
		addTextPanel.add(addDeviceButton);
		addTextPanel.setVisible(true);
		
		addDialogBox.setWidget(addTextPanel);
		
		DialogBox getDialogBox = new DialogBox();
		getDialogBox.setTitle("Get device");
		getDialogBox.setHeight("200");
		getDialogBox.setWidth("300");
		getDialogBox.setAnimationEnabled(true);
		getDialogBox.setGlassEnabled(true);
		getDialogBox.setVisible(true);
		
		VerticalPanel getTextPanel = new VerticalPanel();
		HorizontalPanel idInputPanel = new HorizontalPanel();
		Label idLabel = new Label("id:");
		idInputPanel.add(idLabel);
		idInputPanel.add(idTextBox);
		getTextPanel.add(idInputPanel);
		getTextPanel.add(getDeviceButton);
		HorizontalPanel nameInputPanel = new HorizontalPanel();
		Label nameLabel = new Label("Name:");
		nameInputPanel.add(nameLabel);
		nameInputPanel.add(nameTextBox);
		getTextPanel.add(nameInputPanel);
		HorizontalPanel descInputPanel = new HorizontalPanel();
		Label descLabel = new Label("Description:");
		descInputPanel.add(descLabel);
		descInputPanel.add(descriptionTextBox);
		getTextPanel.add(descInputPanel);
		HorizontalPanel buttonPanel = new HorizontalPanel();
		buttonPanel.add(updateDeviceButton);
		buttonPanel.add(deleteDeviceButton);
		buttonPanel.add(closeButton);
		getTextPanel.add(buttonPanel);
		getTextPanel.setVisible(true);
		
		getDialogBox.setWidget(getTextPanel);
		
		addButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				addDialogBox.show();
			}
		});
		
		addDeviceButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				client.post(new Device(
						null,
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
				getDialogBox.show();
			}
		});

		getDeviceButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				client.getById(BigInteger.valueOf(Long.parseLong(idTextBox.getText())), new MethodCallback<Device>() {
					@Override
					public void onFailure(Method method, Throwable exception) {
						// TODO Auto-generated method stub
						Window.alert(exception.toString() + "\n" + exception.getMessage());
					}

					@Override
					public void onSuccess(Method method, Device response) {
						// TODO Auto-generated method stub
						//Window.alert(response.toString());
						nameTextBox.setText(response.getName());
						descriptionTextBox.setText(response.getDescription());
					}
				});
			}
		});
		
		updateTableButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				client.getAll(new MethodCallback<List<Device>>() {
					@Override
					public void onFailure(Method method, Throwable exception) {
						// TODO Auto-generated method stub
						Window.alert(exception.toString() + "\n" + exception.getMessage());
					}

					@Override
					public void onSuccess(Method method, List<Device> response) {
						for(int i = 0; i < response.size(); i++) {							
							table.setText(i + 1, 0, response.get(i).getId().toString());
							table.setText(i + 1, 1, response.get(i).getName());
							table.setText(i + 1, 2, response.get(i).getDescription());
						}
					}
				});
			}
		});
		
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				getDialogBox.hide();
			}
		});

		updateDeviceButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				client.update(new Device(BigInteger.valueOf(Long.parseLong(idTextBox.getText())),
						nameTextBox.getText(), descriptionTextBox.getText()), new MethodCallback<Device>() {
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
		
		deleteDeviceButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				client.delete(BigInteger.valueOf(Long.parseLong(idTextBox.getText())), new MethodCallback<String>() {
					@Override
					public void onFailure(Method method, Throwable exception) {
						// TODO Auto-generated method stub
						Window.alert(exception.toString() + "\n" + exception.getMessage());
					}

					@Override
					public void onSuccess(Method method, String response) {
						// TODO Auto-generated method stub
						Window.alert(response);
					}
				});
			}
		});
		
		RootPanel.get().add(table);

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
