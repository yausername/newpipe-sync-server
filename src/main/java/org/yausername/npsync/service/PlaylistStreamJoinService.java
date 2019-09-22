package org.yausername.npsync.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yausername.npsync.entity.PlaylistStreamJoin;
import org.yausername.npsync.payload.PlaylistStreamJoinRequest;
import org.yausername.npsync.payload.PlaylistStreamJoinResponse;
import org.yausername.npsync.repository.PlaylistStreamJoinRepository;

@Service
public class PlaylistStreamJoinService extends BaseService<PlaylistStreamJoin, PlaylistStreamJoinResponse>{

    @Autowired
    private PlaylistStreamJoinRepository playlistStreamJoinRepository;
    
    public PlaylistStreamJoinResponse create(PlaylistStreamJoinRequest playlistStreamJoin, Long userId) {
        PlaylistStreamJoin entity = playlistStreamJoin.toEntity(userId);
        Integer joinIndex = playlistStreamJoinRepository.getMaximumIndexOf(playlistStreamJoin.getPlaylistId());
        entity.setJoinIndex(joinIndex + 1);
        return playlistStreamJoinRepository.save(entity).toView();
    }
    
}
