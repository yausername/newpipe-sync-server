package org.yausername.npsync.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlaylistStreamJoinResponse extends PlaylistStreamJoinPayload implements Response {
    private Long uid;
}
