package com.gwt.startpoint.client;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

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

public class AddDialogBox extends Composite {

	private static AddDialogBoxUiBinder uiBinder = GWT.create(AddDialogBoxUiBinder.class);

	interface AddDialogBoxUiBinder extends UiBinder<Widget, AddDialogBox> {
	}
	
	// Есть вопрос к тому как сделать так, чтобы не создавать это поле в каждом объекте UiBinder`a 
	// Так как раньше это было в классе StartPoint, а сейчас получается везде
	private final WorkerClient client = GWT.create(WorkerClient.class);

	@UiField
	TextBox nameTextBox;

	@UiField
	TextBox descriptionTextBox;


	public AddDialogBox() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public Device createDevice() {
		return new Device(null, nameTextBox.getText(), descriptionTextBox.getText());
	}
	
	@UiHandler("addButton")
	   void doClickAdd(ClickEvent event) {
		client.post(new Device(null, nameTextBox.getText(), descriptionTextBox.getText()), new MethodCallback<String>() {			
			@Override
			public void onSuccess(Method method, String response) {
				// TODO Auto-generated method stub
				Window.alert(response + " Device with name: " + nameTextBox.getText() + " and description: "
						+ descriptionTextBox.getText() + " was added");
			}
			@Override
			public void onFailure(Method method, Throwable exception) {
				// TODO Auto-generated method stub
				Window.alert(exception.toString());
			}
		});
	   }

}
