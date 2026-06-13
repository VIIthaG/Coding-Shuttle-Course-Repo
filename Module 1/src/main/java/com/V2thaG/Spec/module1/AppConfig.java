package com.V2thaG.Spec.module1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
      /// 99% OF THE TIME YOU WILL BE USING THE SINLGETON SCOPE ITSELF FOR BEANS
     /// '  @Scope("Prototype")  ' add this little bit to change the scope of our bean to make the scope of the bean to prototype. Bascially everytime a new object gets created everytime you inject this bean
     /// '  @Scope("request")    ' creates a new bean everytime the webserver gets hit with a request
    ///  similarly, application and session Scope modifiers are used in the same context as request
     PaymentService paymentService() {
        return new PaymentService();
    }
}
