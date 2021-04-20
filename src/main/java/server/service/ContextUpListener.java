package server.service;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ContextUpListener {

	@Autowired
	HttpProtoClient client;

	@EventListener
	public void onApplicationEvent(ApplicationReadyEvent event) throws URISyntaxException {
		System.out.println("System is up ");
		client.sendHttpProtoMessage();
	}

}
