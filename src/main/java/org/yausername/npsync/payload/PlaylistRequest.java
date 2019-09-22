package org.yausername.npsync.payload;

import org.yausername.npsync.entity.Playlist;

public class PlaylistRequest extends PlaylistPayload implements Request<Playlist> {
    
    public Playlist toEntity(Long uid, Long userId) {
        Playlist response = new Playlist();
        response.setUid(uid);
        response.setUserId(userId);
        response.setName(name);
        response.setThumbnailUrl(thumbnailUrl);
        return response;
    }
    
    public Playlist toEntity(Long userId) {
        return toEntity(null, userId);
    }

}
