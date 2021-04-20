package server.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import proto.TestMessage;
import proto.TestMessage.Response;

@Component
public class HttpProtoClient {
	@Autowired
	private RestTemplate restTemplate;

	@Value("${server.port}")
	private String serverPort;

	public void sendHttpProtoMessage() throws URISyntaxException {
		System.out.println("Try to call Rest with protobuf");
		final String url = "http://127.0.0.1:" + serverPort + "/";
		TestMessage.Request request = TestMessage.Request.newBuilder().setQuery("This is a test proto Request").build();
		RequestEntity<TestMessage.Request> entity = RequestEntity.post(new URI(url)).body(request);

		ResponseEntity<Response> response = restTemplate.exchange(entity, TestMessage.Response.class);
		System.out.println("Response reseved");
		System.out.println(response.getStatusCodeValue());

		if (response.hasBody()) {
			System.out.println(response.getBody().getQuery());
		}

	}

}
