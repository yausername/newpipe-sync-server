package org.yausername.npsync.payload;

import org.yausername.npsync.entity.Subscription;

public class SubscriptionRequest extends SubscriptionPayload implements Request<Subscription> {
    
    public Subscription toEntity(Long uid, Long userId) {
        Subscription response = new Subscription();
        response.setUid(uid);
        response.setUserId(userId);
        response.setServiceId(serviceId);
        response.setUrl(url);
        response.setName(name);
        response.setAvatarUrl(avatarUrl);
        response.setSubscriberCount(subscriberCount);
        response.setDescription(description);
        return response;
    }
    
    public Subscription toEntity(Long userId) {
        return toEntity(null, userId);
    }

}
