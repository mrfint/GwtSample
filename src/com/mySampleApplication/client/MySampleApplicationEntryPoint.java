package com.mySampleApplication.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.mySampleApplication.shared.MySampleApplicationService;
import org.jboss.errai.common.client.api.RemoteCallback;
import org.jboss.errai.enterprise.client.jaxrs.api.RestClient;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class MySampleApplicationEntryPoint implements EntryPoint {

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		final Button button = new Button("Click me");
		final Label label = new Label();

		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (label.getText().equals("")) {
					RestClient.setJacksonMarshallingActive(true);
					RestClient.setApplicationRoot("rest/");
					RestClient.create(MySampleApplicationService.class, new RemoteCallback<String>() {
						@Override
						public void callback(String result) {
							label.getElement().setInnerHTML(result);
						}
					}).getMessage("Hello, World!");
				} else {
					label.setText("");
				}
			}
		});

		// Assume that the host HTML has elements defined whose
		// IDs are "slot1", "slot2".  In a real app, you probably would not want
		// to hard-code IDs.  Instead, you could, for example, search for all
		// elements with a particular CSS class and replace them with widgets.
		//
		RootPanel.get("slot1").add(button);
		RootPanel.get("slot2").add(label);
	}

}
