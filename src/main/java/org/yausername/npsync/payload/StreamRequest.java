package org.yausername.npsync.payload;

import org.yausername.npsync.entity.Stream;

public class StreamRequest extends StreamPayload implements Request<Stream> {
    
    public Stream toEntity(Long uid, Long userId) {
        Stream response = new Stream();
        response.setUid(uid);
        response.setUserId(userId);
        response.setServiceId(serviceId);
        response.setUrl(url);
        response.setTitle(title);
        response.setStreamType(streamType);
        response.setDuration(duration);
        response.setUploader(uploader);
        response.setThumbnailUrl(thumbnailUrl);
        return response;
    }
    
    public Stream toEntity(Long userId) {
        return toEntity(null, userId);
    }

}
