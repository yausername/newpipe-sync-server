package org.yausername.npsync.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaylistResponse extends PlaylistPayload implements Response {
    private Long uid;
}
