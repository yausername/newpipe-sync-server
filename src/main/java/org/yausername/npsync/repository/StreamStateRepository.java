package org.yausername.npsync.repository;

import org.springframework.stereotype.Repository;
import org.yausername.npsync.entity.StreamState;

@Repository
public interface StreamStateRepository extends NewPipeRepository<StreamState, Long> {
}