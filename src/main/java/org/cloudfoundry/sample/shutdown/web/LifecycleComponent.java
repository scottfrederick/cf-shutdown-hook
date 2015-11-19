package org.cloudfoundry.sample.shutdown.web;

import org.cloudfoundry.sample.shutdown.QueueConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifecycleComponent {

    private static Logger logger = LoggerFactory.getLogger(LifecycleComponent.class);

    @Autowired
    RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void startup() {
        log("Starting");
    }

    @PreDestroy
    public void shutdown() throws InterruptedException {
        log("Initiating graceful shutdown");

        int countdown = 9;

        while (countdown > 0) {
            log("Shutting down in " + countdown + " seconds");

            Thread.sleep(1000L);

            countdown--;
        }

        log("Shutting down now");
    }

    private void log(String msg) {
        logger.info(msg);
        rabbitTemplate.convertAndSend(QueueConfig.QUEUE_NAME, msg);
    }
}
