package org.yausername.npsync.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubscriptionResponse extends SubscriptionPayload implements Response {
    private Long uid;
}
