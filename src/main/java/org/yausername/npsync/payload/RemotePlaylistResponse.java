package org.yausername.npsync.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RemotePlaylistResponse extends RemotePlaylistPayload implements Response {
    private Long uid;
}
