package org.yausername.npsync.repository;

import org.springframework.stereotype.Repository;
import org.yausername.npsync.entity.Subscription;

@Repository
public interface SubscriptionRepository extends NewPipeRepository<Subscription, Long> {
}