package com.farao_community.farao.gridcapa.fake_runner.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Joris Mancini {@literal <joris.mancini at rte-france.com>}
 */
public class RunResponse {

    public enum Status {
        OK,
        NOK
    }

    private final String id;
    private final Status status;

    @JsonCreator
    public RunResponse(@JsonProperty("id") String id,
                       @JsonProperty("status") Status status) {
        this.id = id;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }
}
