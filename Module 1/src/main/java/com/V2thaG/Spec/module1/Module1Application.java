package com.V2thaG.Spec.module1;

import com.V2thaG.Spec.module1.impl.EmailNotificationService;
import com.V2thaG.Spec.module1.impl.SmsNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Module1Application implements CommandLineRunner {

	//@Autowired
	//final NotificationService notificationServiceObj; // DEPENDENCY INJECTION
														// also we create this here so that we can simply go with this.notifcationServiceObj = .... down below

	//@Autowired
	/// Here we dont need this Qualifier annotation anymore since we are now dealing with a key-value pair & or environment variable. doing it this way helps us loosely couple our objects so that we can use them in the best fasion in springboot
//	public Module1Application( @Qualifier("email")
//			NotificationService notificationServiceParam) {
//		this.notificationServiceObj = notificationServiceParam; //CONSTRUCTOR DEPENDENCY INJECTION,
//																// also the final keyword here makes it
//																// so that no matter what this thing must be initialized, in this case it must be within the constructor
//																// furthermore, since final makes something immutable, the object becomes immutable
//	}

	///if you would like to get all the bean instances (in this
	/// case that would be both the email and sms services all at once), you could create a hashmap and do what
	///  is done below in the run method (just the for loop bit is required nothing else )
	@Autowired
	Map< String, NotificationService> notificationServiceMap = new HashMap<>();

	public static void main(String[] args) {
		SpringApplication.run(Module1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//this.notificationServiceObj = null; if we tried to do this then this line would result in an error

		/// Here we create the Object 'notificationServiceObj based on the implementation class 'EmailNotificationService'
	    	//notificationServiceObj.send("Hello This is a notification");

		for( var notificationService : notificationServiceMap.entrySet() ){
			System.out.println(notificationService.getKey());
			notificationService.getValue().send("Hello");
		}



	}
}
