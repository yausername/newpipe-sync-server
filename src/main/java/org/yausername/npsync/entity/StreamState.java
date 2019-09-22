package org.yausername.npsync.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.yausername.npsync.payload.StreamStateResponse;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "stream_state")
@Getter
@Setter
public class StreamState extends BaseEntity<StreamStateResponse> {

    @NotNull
    private Long streamId;

    @NotBlank
    @Size(max = 512)
    private String progressTime;
    
    public StreamStateResponse toView() {
        StreamStateResponse response = new StreamStateResponse();
        response.setUid(uid);
        response.setStreamId(streamId);
        response.setProgressTime(progressTime);
        return response;
    }

}
