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
