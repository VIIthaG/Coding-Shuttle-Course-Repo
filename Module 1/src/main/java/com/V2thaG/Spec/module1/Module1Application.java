package com.V2thaG.Spec.module1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Module1Application implements CommandLineRunner {
	///  so Basically you wanna go with @Override and @Autowired & create the object and then the IoC injects the bean wherever you specify
	/// fyi, here you have created the class PaymentService in another file and you are making a bean of that class's object
	@Autowired
	PaymentService paymentServiceObj;

	public static void main(String[] args) {
		SpringApplication.run(Module1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/// If you ever end up creating more than 1 object for a singleton scope bean and then you want to check if they are equal( which they will be anyway ) then
		/// compare their hashcodes using 'objectname'.hashcode() inside a sys.out.prtln()

		paymentServiceObj.pay();
		paymentServiceObj.pay();
	}
}
