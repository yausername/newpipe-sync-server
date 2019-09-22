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
import org.yausername.npsync.entity.RemotePlaylist;
import org.yausername.npsync.payload.RemotePlaylistRequest;
import org.yausername.npsync.payload.RemotePlaylistResponse;
import org.yausername.npsync.security.CurrentUser;
import org.yausername.npsync.security.UserPrincipal;
import org.yausername.npsync.service.RemotePlaylistService;

@RestController
@RequestMapping("/api/remoteplaylists")
public class RemotePlaylistController {
    
    @Autowired
    private RemotePlaylistService remotePlaylistService;
    
    @GetMapping
    public ResponseEntity<List<RemotePlaylistResponse>> findAll(@CurrentUser UserPrincipal currentUser,
            @RequestParam(required = false) String serviceId, @RequestParam(required= false) String url) {
        RemotePlaylist remotePlaylist = new RemotePlaylist();
        remotePlaylist.setUserId(currentUser.getId());
        remotePlaylist.setServiceId(serviceId);
        remotePlaylist.setUrl(url);
        return ResponseEntity.ok(remotePlaylistService.findAll(Example.of(remotePlaylist)));
    }

    @PostMapping
    public ResponseEntity<RemotePlaylistResponse> create(@CurrentUser UserPrincipal currentUser, @Valid @RequestBody RemotePlaylistRequest remotePlaylist) {
        return ResponseEntity.ok(remotePlaylistService.create(remotePlaylist, currentUser.getId()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RemotePlaylistResponse> findById(@CurrentUser UserPrincipal currentUser, @PathVariable Long id) {
        return ResponseEntity.ok(remotePlaylistService.findById(id, currentUser.getId()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RemotePlaylistResponse> update(@CurrentUser UserPrincipal currentUser, @PathVariable Long id, @Valid @RequestBody RemotePlaylistRequest remotePlaylist) {
        return ResponseEntity.ok(remotePlaylistService.update(id, remotePlaylist, currentUser.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@CurrentUser UserPrincipal currentUser, @PathVariable Long id) {
        remotePlaylistService.deleteById(id, currentUser.getId());
        return ResponseEntity.ok().build();
    }
    
}
