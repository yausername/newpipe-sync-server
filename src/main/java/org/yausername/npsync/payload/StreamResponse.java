package org.yausername.npsync.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StreamResponse extends StreamPayload implements Response {
    private Long uid;
}
