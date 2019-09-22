package org.yausername.npsync.repository;

import org.springframework.stereotype.Repository;
import org.yausername.npsync.entity.SearchHistory;

@Repository
public interface SearchHistoryRepository extends NewPipeRepository<SearchHistory, Long> {
}