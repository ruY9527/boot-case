package com.ruY9527.application;

import com.ruY9527.application.condition.ConditionBeanInImport;
import com.ruY9527.application.events.GavinYangSendMessageEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;


/***
 * @author GavinYang
 *
 *
 */

@SpringBootApplication
@Import(ConditionBeanInImport.class)
public class BootSourceReadApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BootSourceReadApplication.class, args);

        GavinYangSendMessageEvent messageEvent = new GavinYangSendMessageEvent(context);
        context.publishEvent(messageEvent);

    }

}
