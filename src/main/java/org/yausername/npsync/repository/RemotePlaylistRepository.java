package org.yausername.npsync.repository;

import org.springframework.stereotype.Repository;
import org.yausername.npsync.entity.RemotePlaylist;

@Repository
public interface RemotePlaylistRepository extends NewPipeRepository<RemotePlaylist, Long> {
}