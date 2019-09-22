package org.yausername.npsync.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.yausername.npsync.payload.StreamHistoryResponse;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "stream_history")
@Getter
@Setter
public class StreamHistory extends BaseEntity<StreamHistoryResponse> {

    @NotNull
    private Long streamId;

    @NotBlank
    @Size(max = 512)
    private String accessDate;
    
    @NotBlank
    @Size(max = 512)
    private String repeatCount;
    
    public StreamHistoryResponse toView() {
        StreamHistoryResponse response = new StreamHistoryResponse();
        response.setUid(uid);
        response.setStreamId(streamId);
        response.setAccessDate(accessDate);
        response.setRepeatCount(repeatCount);
        return response;
    }

}
