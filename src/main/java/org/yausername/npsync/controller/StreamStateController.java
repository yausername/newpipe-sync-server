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
import org.yausername.npsync.entity.StreamState;
import org.yausername.npsync.payload.StreamStateRequest;
import org.yausername.npsync.payload.StreamStateResponse;
import org.yausername.npsync.security.CurrentUser;
import org.yausername.npsync.security.UserPrincipal;
import org.yausername.npsync.service.StreamStateService;

@RestController
@RequestMapping("/api/streamstates")
public class StreamStateController {
    
    @Autowired
    private StreamStateService streamStateService;
    
    @GetMapping
    public ResponseEntity<List<StreamStateResponse>> findAll(@CurrentUser UserPrincipal currentUser,
            @RequestParam(required = false) Long streamId) {
        StreamState streamState = new StreamState();
        streamState.setUserId(currentUser.getId());
        streamState.setStreamId(streamId);
        return ResponseEntity.ok(streamStateService.findAll(Example.of(streamState)));
    }

    @PostMapping
    public ResponseEntity<StreamStateResponse> create(@CurrentUser UserPrincipal currentUser, @Valid @RequestBody StreamStateRequest streamState) {
        return ResponseEntity.ok(streamStateService.create(streamState, currentUser.getId()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamStateResponse> findById(@CurrentUser UserPrincipal currentUser, @PathVariable Long id) {
        return ResponseEntity.ok(streamStateService.findById(id, currentUser.getId()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StreamStateResponse> update(@CurrentUser UserPrincipal currentUser, @PathVariable Long id, @Valid @RequestBody StreamStateRequest streamState) {
        return ResponseEntity.ok(streamStateService.update(id, streamState, currentUser.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@CurrentUser UserPrincipal currentUser, @PathVariable Long id) {
        streamStateService.deleteById(id, currentUser.getId());
        return ResponseEntity.ok().build();
    }
    
}
