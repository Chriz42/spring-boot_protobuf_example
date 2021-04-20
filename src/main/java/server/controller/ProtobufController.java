package server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import proto.TestMessage;
import proto.TestMessage.Response;

@RestController
public class ProtobufController {

	@PostMapping(consumes = "application/x-protobuf", produces = "application/x-protobuf")
	public ResponseEntity<Response> handlePost(@RequestBody TestMessage.Request protobuf) {
		System.out.println("resived protohttp message");
		System.out.println(protobuf.getQuery());
		System.out.println("Send response");
		TestMessage.Response response = TestMessage.Response.newBuilder().setQuery("This is a protobuf server Response")
				.build();

		return ResponseEntity.ok(response);
	}

	@GetMapping(produces = "application/x-protobuf")
	public ResponseEntity<Response> handleGet() {

		TestMessage.Response response = TestMessage.Response.newBuilder().setQuery("This is a protobuf server Response")
				.build();

		return ResponseEntity.ok(response);
	}
}
