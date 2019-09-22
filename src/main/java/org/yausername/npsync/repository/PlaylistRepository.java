package org.yausername.npsync.repository;

import org.springframework.stereotype.Repository;
import org.yausername.npsync.entity.Playlist;

@Repository
public interface PlaylistRepository extends NewPipeRepository<Playlist, Long> {
}