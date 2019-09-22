package org.yausername.npsync.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yausername.npsync.entity.PlaylistStreamJoin;
import org.yausername.npsync.payload.PlaylistStreamJoinRequest;
import org.yausername.npsync.payload.PlaylistStreamJoinResponse;
import org.yausername.npsync.security.CurrentUser;
import org.yausername.npsync.security.UserPrincipal;
import org.yausername.npsync.service.PlaylistStreamJoinService;

@RestController
@RequestMapping("/api/playliststreamjoin")
public class PlaylistStreamJoinController {

    @Autowired
    private PlaylistStreamJoinService playlistStreamJoinService;

    @GetMapping
    public ResponseEntity<List<PlaylistStreamJoinResponse>> findAll(@CurrentUser UserPrincipal currentUser,
            @RequestParam(required = false) Long playlistId, @RequestParam(required = false) Long streamId) {
        PlaylistStreamJoin example = new PlaylistStreamJoin();
        example.setUserId(currentUser.getId());
        example.setPlaylistId(playlistId);
        example.setStreamId(streamId);
        return ResponseEntity.ok(playlistStreamJoinService.findAll(Example.of(example)));
    }

    @PostMapping
    public ResponseEntity<PlaylistStreamJoinResponse> create(@CurrentUser UserPrincipal currentUser,
            @Valid @RequestBody PlaylistStreamJoinRequest playlistStreamJoin) {
        return ResponseEntity.ok(playlistStreamJoinService.create(playlistStreamJoin, currentUser.getId()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaylistStreamJoinResponse> findById(@CurrentUser UserPrincipal currentUser,
            @PathVariable Long id) {
        return ResponseEntity.ok(playlistStreamJoinService.findById(id, currentUser.getId()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlaylistStreamJoinResponse> update(@CurrentUser UserPrincipal currentUser,
            @PathVariable Long id, @Valid @RequestBody PlaylistStreamJoinRequest playlistStreamJoin) {
        return ResponseEntity.ok(playlistStreamJoinService.update(id, playlistStreamJoin, currentUser.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@CurrentUser UserPrincipal currentUser, @PathVariable Long id) {
        playlistStreamJoinService.deleteById(id, currentUser.getId());
        return ResponseEntity.ok().build();
    }

}
