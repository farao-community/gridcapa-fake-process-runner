/*
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.farao_community.farao.gridcapa.fake_runner.app;

import com.farao_community.farao.gridcapa.fake_runner.api.RunRequest;
import com.farao_community.farao.gridcapa.fake_runner.api.RunResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * @author Joris Mancini {@literal <joris.mancini at rte-france.com>}
 */
@Component
public class FakeRunnerListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(FakeRunnerListener.class);

    @Bean
    public Function<RunRequest, RunResponse> handleRun() {
        return runRequest -> {
            LOGGER.info(String.format("Handling run request %s", runRequest.getId()));
            if (runRequest.getTargetProcessDateTime().getHour() >= 9
                && runRequest.getTargetProcessDateTime().getHour() < 18) {
                LOGGER.info("Ok I can work !");
                return new RunResponse(runRequest.getId(), RunResponse.Status.OK);
            } else {
                LOGGER.info("Out of my working time sorry...");
                return new RunResponse(runRequest.getId(), RunResponse.Status.NOK);
            }
        };
    }
}
