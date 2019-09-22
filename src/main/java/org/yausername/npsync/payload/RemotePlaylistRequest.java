package org.yausername.npsync.payload;

import org.yausername.npsync.entity.RemotePlaylist;

public class RemotePlaylistRequest extends RemotePlaylistPayload implements Request<RemotePlaylist>{
    
    public RemotePlaylist toEntity(Long uid, Long userId) {
        RemotePlaylist response = new RemotePlaylist();
        response.setUid(uid);
        response.setUserId(userId);
        response.setServiceId(serviceId);
        response.setName(name);
        response.setUrl(url);
        response.setThumbnailUrl(thumbnailUrl);
        response.setUploader(uploader);
        response.setStreamCount(streamCount);
        return response;
    }
    
    public RemotePlaylist toEntity(Long userId) {
        return toEntity(null, userId);
    }

}
