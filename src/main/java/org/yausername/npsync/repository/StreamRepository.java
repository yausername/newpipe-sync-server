package org.yausername.npsync.repository;

import org.springframework.stereotype.Repository;
import org.yausername.npsync.entity.Stream;

@Repository
public interface StreamRepository extends NewPipeRepository<Stream, Long> {
}