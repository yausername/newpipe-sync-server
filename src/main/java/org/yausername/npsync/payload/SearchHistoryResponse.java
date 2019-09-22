package org.yausername.npsync.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchHistoryResponse extends SearchHistoryPayload implements Response {
    private Long uid;
}
