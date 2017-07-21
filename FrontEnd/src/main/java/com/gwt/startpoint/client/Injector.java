package com.gwt.startpoint.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

//  С injector ом я еще не до конца разобрался, но как я понимаю он заменяет собой EventBus

@GinModules(InjectorModule.class)
public interface Injector extends Ginjector {
    public static final Injector INSTANCE = GWT.create(Injector.class);

    public EventBus getEventBus();
}