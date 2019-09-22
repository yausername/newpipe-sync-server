package org.yausername.npsync.payload;

import org.yausername.npsync.entity.StreamHistory;

public class StreamHistoryRequest extends StreamHistoryPayload implements Request<StreamHistory>{
    
    public StreamHistory toEntity(Long uid, Long userId) {
        StreamHistory response = new StreamHistory();
        response.setUid(uid);
        response.setUserId(userId);
        response.setStreamId(streamId);
        response.setAccessDate(accessDate);
        response.setRepeatCount(repeatCount);
        return response;
    }
    
    public StreamHistory toEntity(Long userId) {
        return toEntity(null, userId);
    }

}
