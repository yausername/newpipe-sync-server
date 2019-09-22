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
import org.springframework.web.bind.annotation.RestController;
import org.yausername.npsync.entity.StreamHistory;
import org.yausername.npsync.payload.StreamHistoryRequest;
import org.yausername.npsync.payload.StreamHistoryResponse;
import org.yausername.npsync.security.CurrentUser;
import org.yausername.npsync.security.UserPrincipal;
import org.yausername.npsync.service.StreamHistoryService;

@RestController
@RequestMapping("/api/streamhistory")
public class StreamHistoryController {
    
    @Autowired
    private StreamHistoryService streamHistoryService;
    
    @GetMapping
    public ResponseEntity<List<StreamHistoryResponse>> findAll(@CurrentUser UserPrincipal currentUser) {
        StreamHistory streamHistory = new StreamHistory();
        streamHistory.setUserId(currentUser.getId());
        return ResponseEntity.ok(streamHistoryService.findAll(Example.of(streamHistory)));
    }

    @PostMapping
    public ResponseEntity<StreamHistoryResponse> create(@CurrentUser UserPrincipal currentUser, @Valid @RequestBody StreamHistoryRequest streamHistory) {
        return ResponseEntity.ok(streamHistoryService.create(streamHistory, currentUser.getId()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamHistoryResponse> findById(@CurrentUser UserPrincipal currentUser, @PathVariable Long id) {
        return ResponseEntity.ok(streamHistoryService.findById(id, currentUser.getId()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StreamHistoryResponse> update(@CurrentUser UserPrincipal currentUser, @PathVariable Long id, @Valid @RequestBody StreamHistoryRequest streamHistory) {
        return ResponseEntity.ok(streamHistoryService.update(id, streamHistory, currentUser.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@CurrentUser UserPrincipal currentUser, @PathVariable Long id) {
        streamHistoryService.deleteById(id, currentUser.getId());
        return ResponseEntity.ok().build();
    }
    
}
