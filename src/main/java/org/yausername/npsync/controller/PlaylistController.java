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
import org.yausername.npsync.entity.Playlist;
import org.yausername.npsync.payload.PlaylistRequest;
import org.yausername.npsync.payload.PlaylistResponse;
import org.yausername.npsync.security.CurrentUser;
import org.yausername.npsync.security.UserPrincipal;
import org.yausername.npsync.service.PlaylistService;

@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @GetMapping
    public ResponseEntity<List<PlaylistResponse>> findAll(@CurrentUser UserPrincipal currentUser,
            @RequestParam(required = false) String name) {
        Playlist playlist = new Playlist();
        playlist.setUserId(currentUser.getId());
        playlist.setName(name);
        return ResponseEntity.ok(playlistService.findAll(Example.of(playlist)));
    }

    @PostMapping
    public ResponseEntity<PlaylistResponse> create(@CurrentUser UserPrincipal currentUser,
            @Valid @RequestBody PlaylistRequest playlist) {
        return ResponseEntity.ok(playlistService.create(playlist, currentUser.getId()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaylistResponse> findById(@CurrentUser UserPrincipal currentUser, @PathVariable Long id) {
        return ResponseEntity.ok(playlistService.findById(id, currentUser.getId()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlaylistResponse> update(@CurrentUser UserPrincipal currentUser, @PathVariable Long id,
            @Valid @RequestBody PlaylistRequest playlist) {
        return ResponseEntity.ok(playlistService.update(id, playlist, currentUser.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@CurrentUser UserPrincipal currentUser, @PathVariable Long id) {
        playlistService.deleteById(id, currentUser.getId());
        return ResponseEntity.ok().build();
    }

}
