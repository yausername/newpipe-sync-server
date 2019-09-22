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
import org.yausername.npsync.entity.Stream;
import org.yausername.npsync.payload.StreamRequest;
import org.yausername.npsync.payload.StreamResponse;
import org.yausername.npsync.security.CurrentUser;
import org.yausername.npsync.security.UserPrincipal;
import org.yausername.npsync.service.StreamService;

@RestController
@RequestMapping("/api/streams")
public class StreamController {
    
    @Autowired
    private StreamService streamService;
    
    @GetMapping
    public ResponseEntity<List<StreamResponse>> findAll(@CurrentUser UserPrincipal currentUser,
            @RequestParam(required = false) String serviceId, @RequestParam(required = false) String url) {
        Stream stream = new Stream();
        stream.setUserId(currentUser.getId());
        stream.setServiceId(serviceId);
        stream.setUrl(url);
        return ResponseEntity.ok(streamService.findAll(Example.of(stream)));
    }

    @PostMapping
    public ResponseEntity<StreamResponse> create(@CurrentUser UserPrincipal currentUser, @Valid @RequestBody StreamRequest stream) {
        return ResponseEntity.ok(streamService.create(stream, currentUser.getId()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamResponse> findById(@CurrentUser UserPrincipal currentUser, @PathVariable Long id) {
        return ResponseEntity.ok(streamService.findById(id, currentUser.getId()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StreamResponse> update(@CurrentUser UserPrincipal currentUser, @PathVariable Long id, @Valid @RequestBody StreamRequest stream) {
        return ResponseEntity.ok(streamService.update(id, stream, currentUser.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@CurrentUser UserPrincipal currentUser, @PathVariable Long id) {
        streamService.deleteById(id, currentUser.getId());
        return ResponseEntity.ok().build();
    }
    
}
