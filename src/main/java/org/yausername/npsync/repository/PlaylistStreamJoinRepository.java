package org.yausername.npsync.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.yausername.npsync.entity.PlaylistStreamJoin;

@Repository
public interface PlaylistStreamJoinRepository extends NewPipeRepository<PlaylistStreamJoin, Long> {
    
    @Query(value = "SELECT coalesce(max(join_index), -1) FROM playlist_stream_join where playlist_id = :playlistId", nativeQuery= true)
    Integer getMaximumIndexOf(final Long playlistId);
}