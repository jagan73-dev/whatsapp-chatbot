package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class WebhookController {
	 @PostMapping("/webhook")
	    public MessageResponse handleMessage(@RequestBody MessageRequest request) {

	        String message = request.getMessage();
	        String reply;

	        if (message == null) {
	            reply = "Empty message";
	        } else if (message.equalsIgnoreCase("Hi")) {
	            reply = "Hello";
	        } else if (message.equalsIgnoreCase("Bye")) {
	            reply = "Goodbye";
	        } else {
	            reply = "I don't understand";
	        }

	        // Logging
	        System.out.println("Incoming message: " + message);

	        return new MessageResponse(reply);
	    }
}
