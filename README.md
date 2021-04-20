# spring-boot_protobuf_example

simple maven, protobuf, spring-boot app.

The .proto file  /src/main/resources/proto/TestMessage.proto is build by maven and the class ends up under target/generated-sources/proto/TestMessage.java

Build with mvn install


On startup the ContextUpListener sends a POST Request with the  HttpProtoClient to the ProtobufController.
Verify proto message sending and receiving.

ProtobufController has an GET endpoint for testing with simple curl

My pain points with protobuf and spring was the mapping of the protomessages.

For sending a request you need a RestTemplate with ProtobufHttpMessageConverter 
	look at WeConfig.java  RestTemplate Bean
	
And on the receiving part you have to add HttpMessageConverter to convert back from proto to java object. See Webconfig.java extendMessageConverters methode


The worst with protobuf is the lack of documentation and examples....
