package org.yausername.npsync.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.yausername.npsync.payload.PlaylistStreamJoinResponse;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "playlist_stream_join")
@Getter
@Setter
public class PlaylistStreamJoin extends BaseEntity<PlaylistStreamJoinResponse> {

    @NotNull
    private Long playlistId;

    @NotNull
    private Long streamId;
    
    @NotNull
    private Integer joinIndex;
    
    public PlaylistStreamJoinResponse toView() {
        PlaylistStreamJoinResponse response = new PlaylistStreamJoinResponse();
        response.setUid(uid);
        response.setPlaylistId(playlistId);
        response.setStreamId(streamId);
        response.setJoinIndex(joinIndex);
        return response;
    }
}
