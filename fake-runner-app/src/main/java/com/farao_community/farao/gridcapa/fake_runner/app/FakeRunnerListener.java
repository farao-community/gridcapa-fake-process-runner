/*
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.farao_community.farao.gridcapa.fake_runner.app;

import com.farao_community.farao.gridcapa.task_manager.api.TaskDto;
import com.farao_community.farao.gridcapa.task_manager.api.TaskStatus;
import com.farao_community.farao.gridcapa.task_manager.api.TaskStatusUpdate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * @author Joris Mancini {@literal <joris.mancini at rte-france.com>}
 */
@Component
public class FakeRunnerListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(FakeRunnerListener.class);
    private static final String TASK_STATUS_UPDATES_BINDING = "handleRun-out-0";

    private final StreamBridge streamBridge;

    public FakeRunnerListener(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @Bean
    public Function<TaskDto, TaskStatusUpdate> handleRun() {
        return taskDto -> {
            LOGGER.info(String.format("Handling run request %s on TS ", taskDto.getTimestamp()));
            streamBridge.send(TASK_STATUS_UPDATES_BINDING, new TaskStatusUpdate(taskDto.getTimestamp(), TaskStatus.RUNNING));
            try {
                wait(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            TaskStatus taskStatus;
            if (taskDto.getTimestamp().getHour() >= 9
                && taskDto.getTimestamp().getHour() < 18) {
                LOGGER.info("Ok I can work !");
                taskStatus = TaskStatus.SUCCESS;
            } else {
                LOGGER.info("Out of my working time sorry...");
                taskStatus = TaskStatus.ERROR;
            }
            return new TaskStatusUpdate(taskDto.getTimestamp(), taskStatus);
        };
    }
}
