package org.yausername.npsync.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StreamHistoryResponse extends StreamHistoryPayload implements Response {
    private Long uid;
}
