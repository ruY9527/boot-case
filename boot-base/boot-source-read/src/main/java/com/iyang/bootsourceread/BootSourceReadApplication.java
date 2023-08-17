package com.iyang.bootsourceread;

import com.iyang.bootsourceread.events.GavinYangSendMessageEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


/***
 * @author GavinYang
 *
 *
 */

@SpringBootApplication
public class BootSourceReadApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BootSourceReadApplication.class, args);

        GavinYangSendMessageEvent messageEvent = new GavinYangSendMessageEvent(context);
        context.publishEvent(messageEvent);

    }

}
