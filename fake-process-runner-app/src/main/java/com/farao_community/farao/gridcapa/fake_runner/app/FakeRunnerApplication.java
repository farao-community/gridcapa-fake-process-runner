package com.farao_community.farao.gridcapa.fake_runner.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Joris Mancini {@literal <joris.mancini at rte-france.com>}
 */
@SuppressWarnings("hideutilityclassconstructor")
@SpringBootApplication
public class FakeRunnerApplication {
    public static void main(String[] args) {
        SpringApplication.run(FakeRunnerApplication.class, args);
    }
}
