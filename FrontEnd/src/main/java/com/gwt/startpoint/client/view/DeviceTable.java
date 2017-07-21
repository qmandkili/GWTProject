package com.gwt.startpoint.client.view;

import java.util.List;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.startpoint.client.WorkerClient;
import com.gwt.startpoint.client.event.UpdateEvent;
import com.gwt.startpoint.client.event.UpdateEventHandler;
import com.model.shared.Device;

public class DeviceTable extends Composite {

	interface DeviceTableUiBinder extends UiBinder<Widget, DeviceTable> {
	}

	private static DeviceTableUiBinder uiBinder = GWT.create(DeviceTableUiBinder.class);

	@UiField(provided = true)
	FlexTable table;

	// Есть вопрос к тому как сделать так, чтобы не создавать это поле в каждом объекте UiBinder`a
	// Так как раньше это было в классе StartPoint, а сейчас получается везде
	private final WorkerClient client = GWT.create(WorkerClient.class);

	public DeviceTable(final EventBus bus) {
		bus.addHandler(UpdateEvent.TYPE, new UpdateEventHandler() {
			@Override
			public void update(UpdateEvent event) {
				client.getAll(new MethodCallback<List<Device>>() {

					@Override
					public void onSuccess(Method method, List<Device> response) {
						updateRows(response);
					}

					@Override
					public void onFailure(Method method, Throwable exception) {
						Window.alert(exception.toString());
					}
				});
			}
		});
		setupTable();
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setupTable() {
		table = new FlexTable();
		table.setText(0, 0, "id");
		table.setText(0, 1, "Name");
		table.setText(0, 2, "Description");
	}

	public void updateRows(List<Device> devices) {
		for (int i = 1; i < table.getRowCount(); i++) {
			table.removeRow(i);
		}
		for (int i = 0; i < devices.size(); i++) {
			table.setText(i + 1, 0, devices.get(i).getId().toString());
			table.setText(i + 1, 1, devices.get(i).getName());
			table.setText(i + 1, 2, devices.get(i).getDescription());
		}
	}

}
