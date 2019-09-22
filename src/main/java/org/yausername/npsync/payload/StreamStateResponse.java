package org.yausername.npsync.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StreamStateResponse extends StreamStatePayload implements Response {
    private Long uid;
}
