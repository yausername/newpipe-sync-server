package org.yausername.npsync.payload;

import org.yausername.npsync.entity.StreamState;

public class StreamStateRequest extends StreamStatePayload implements Request<StreamState>{
    
    public StreamState toEntity(Long uid, Long userId) {
        StreamState response = new StreamState();
        response.setUid(uid);
        response.setUserId(userId);
        response.setStreamId(streamId);
        response.setProgressTime(progressTime);
        return response;
    }
    
    public StreamState toEntity(Long userId) {
        return toEntity(null, userId);
    }

}
