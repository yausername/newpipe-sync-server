package org.yausername.npsync.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubscriptionPayload {
    
    @NotBlank
    @Size(max = 64)
    protected String serviceId;

    @NotBlank
    @Size(max = 512)
    protected String url;

    @NotBlank
    @Size(max = 512)
    protected String name;

    @NotBlank
    @Size(max = 512)
    protected String avatarUrl;

    @NotBlank
    @Size(max = 512)
    protected String subscriberCount;

    @Size(max = 512)
    protected String description;

}
