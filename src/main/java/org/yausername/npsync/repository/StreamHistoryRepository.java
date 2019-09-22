package org.yausername.npsync.repository;

import org.springframework.stereotype.Repository;
import org.yausername.npsync.entity.StreamHistory;

@Repository
public interface StreamHistoryRepository extends NewPipeRepository<StreamHistory, Long> {
}