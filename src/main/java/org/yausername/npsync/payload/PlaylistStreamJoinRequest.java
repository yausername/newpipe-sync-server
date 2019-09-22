package org.yausername.npsync.payload;

import org.yausername.npsync.entity.PlaylistStreamJoin;

public class PlaylistStreamJoinRequest extends PlaylistStreamJoinPayload implements Request<PlaylistStreamJoin>{
    
    public PlaylistStreamJoin toEntity(Long uid, Long userId) {
        PlaylistStreamJoin response = new PlaylistStreamJoin();
        response.setUid(uid);
        response.setUserId(userId);
        response.setPlaylistId(playlistId);
        response.setStreamId(streamId);
        response.setJoinIndex(joinIndex);
        return response;
    }
    
    public PlaylistStreamJoin toEntity(Long userId) {
        return toEntity(null, userId);
    }

}
