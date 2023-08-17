package com.iyang.bootsourceconditional;

import com.iyang.bootsourceconditional.condition.ConditionBeanInImport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ConditionBeanInImport.class)
public class BootSourceConditionalApplication {

    public static void main(String[] args) {
        SpringApplication sa =new SpringApplication(BootSourceConditionalApplication.class);
        sa.run(args);

    }

}
