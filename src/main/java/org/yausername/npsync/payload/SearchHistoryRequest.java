package org.yausername.npsync.payload;

import org.yausername.npsync.entity.SearchHistory;

public class SearchHistoryRequest extends SearchHistoryPayload implements Request<SearchHistory>{
    
    public SearchHistory toEntity(Long uid, Long userId) {
        SearchHistory response = new SearchHistory();
        response.setUid(uid);
        response.setUserId(userId);
        response.setCreationDate(creationDate);
        response.setServiceId(serviceId);
        response.setSearch(search);
        return response;
    }
    
    public SearchHistory toEntity(Long userId) {
        return toEntity(null, userId);
    }

}
