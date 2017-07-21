package com.gwt.startpoint.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class UpdateEvent extends GwtEvent<UpdateEventHandler> {

	public static Type<UpdateEventHandler> TYPE = new Type<UpdateEventHandler>();
	
	@Override
	protected void dispatch(UpdateEventHandler handler) {
		handler.update(this);
	}

	@Override
	public Type<UpdateEventHandler> getAssociatedType() {
		return TYPE;
	}


}
