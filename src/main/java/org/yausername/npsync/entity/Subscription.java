package org.yausername.npsync.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.yausername.npsync.payload.SubscriptionResponse;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "subscriptions")
@Getter
@Setter
public class Subscription extends BaseEntity<SubscriptionResponse> {

    @NotBlank
    @Size(max = 64)
    private String serviceId;

    @NotBlank
    @Size(max = 512)
    private String url;

    @NotBlank
    @Size(max = 512)
    private String name;

    @NotBlank
    @Size(max = 512)
    private String avatarUrl;

    @NotBlank
    @Size(max = 512)
    private String subscriberCount;

    @Size(max = 512)
    private String description;
    
    public SubscriptionResponse toView() {
        SubscriptionResponse response = new SubscriptionResponse();
        response.setUid(uid);
        response.setServiceId(serviceId);
        response.setUrl(url);
        response.setName(name);
        response.setAvatarUrl(avatarUrl);
        response.setSubscriberCount(subscriberCount);
        response.setDescription(description);
        return response;
    }

}
