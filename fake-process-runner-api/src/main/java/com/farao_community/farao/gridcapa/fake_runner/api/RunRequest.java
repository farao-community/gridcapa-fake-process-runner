/*
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.farao_community.farao.gridcapa.fake_runner.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

/**
 * @author Joris Mancini {@literal <joris.mancini at rte-france.com>}
 */
public class RunRequest {
    private final String id;
    private final LocalDateTime targetProcessDateTime;

    @JsonCreator
    public RunRequest(@JsonProperty("id") String id,
                      @JsonProperty("targetProcessDateTime") LocalDateTime targetProcessDateTime) {
        this.id = id;
        this.targetProcessDateTime = targetProcessDateTime;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getTargetProcessDateTime() {
        return targetProcessDateTime;
    }
}
