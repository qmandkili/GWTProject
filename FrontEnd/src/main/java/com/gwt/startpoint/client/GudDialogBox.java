package com.gwt.startpoint.client;

import java.math.BigInteger;
import java.nio.file.WatchService;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.fasterxml.jackson.databind.introspect.WithMember;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.model.shared.Device;

public class GudDialogBox extends Composite {

	private static GudDialogBoxUiBinder uiBinder = GWT.create(GudDialogBoxUiBinder.class);

	interface GudDialogBoxUiBinder extends UiBinder<Widget, GudDialogBox> {
	}
	
	// Есть вопрос к тому как сделать так, чтобы не создавать это поле в каждом объекте UiBinder`a,
	// Так как раньше это было в классе StartPoint, а сейчас получается везде
	private final WorkerClient client = GWT.create(WorkerClient.class);

	public GudDialogBox() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiField
	TextBox idTextBox;
	
	@UiField
	TextBox nameTextBox;

	@UiField
	TextBox descriptionTextBox;
	
	@UiHandler("deleteButton")
	   void doClickDelete(ClickEvent event) {
		client.delete(BigInteger.valueOf(Long.parseLong(idTextBox.getText())), new MethodCallback<String>() {
			@Override
			public void onFailure(Method method, Throwable exception) {
				// TODO Auto-generated method stub
				Window.alert(exception.toString() + "\n" + exception.getMessage());
			}

			@Override
			public void onSuccess(Method method, String response) {
				// TODO Auto-generated method stub
				Window.alert(response + " OK. Device was successfully deleted");
			}
		});
	   }
	
	@UiHandler("getButton")
	   void doClickGet(ClickEvent event) {
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
	
	@UiHandler("updateButton")
	   void doClickUpdate(ClickEvent event) {
		client.update(new Device(BigInteger.valueOf(Long.parseLong(idTextBox.getText())),
				nameTextBox.getText(), descriptionTextBox.getText()), new MethodCallback<String>() {
			@Override
			public void onFailure(Method method, Throwable exception) {
				Window.alert(exception.toString() + "\n" + exception.getMessage());
			}

			@Override
			public void onSuccess(Method method, String response) {
				Window.alert(response + " OK. Device with new name: " + nameTextBox.getText() + " and description: "
				+ descriptionTextBox.getText() + " was successfully updated");
			}
		});
	   }

}
