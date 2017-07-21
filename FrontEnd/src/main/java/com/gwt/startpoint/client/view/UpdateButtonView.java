package com.gwt.startpoint.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.Button;
import com.gwt.startpoint.client.event.UpdateEvent;

public class UpdateButtonView extends Button {

	public UpdateButtonView(final SimpleEventBus eventBus) {
		setText("Update table");

		addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				eventBus.fireEvent(new UpdateEvent());
			}
		});
	}
}
