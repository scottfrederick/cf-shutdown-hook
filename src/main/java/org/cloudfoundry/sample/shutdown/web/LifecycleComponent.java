package org.cloudfoundry.sample.shutdown.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifecycleComponent {

    private static Logger logger = LoggerFactory.getLogger(LifecycleComponent.class);

    @PostConstruct
    public void startup() {
        logger.info("Starting");
    }

    @PreDestroy
    public void shutdown() throws InterruptedException {
        logger.info("Initiating graceful shutdown");

        int countdown = 9;

        while (countdown > 0) {
            logger.info("Shutting down in " + countdown + " seconds");

            Thread.sleep(1000L);

            countdown--;
        }

        logger.info("Shutting down now");
    }
}
