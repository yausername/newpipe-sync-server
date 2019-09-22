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
import org.yausername.npsync.entity.SearchHistory;
import org.yausername.npsync.payload.SearchHistoryRequest;
import org.yausername.npsync.payload.SearchHistoryResponse;
import org.yausername.npsync.security.CurrentUser;
import org.yausername.npsync.security.UserPrincipal;
import org.yausername.npsync.service.SearchHistoryService;

@RestController
@RequestMapping("/api/searchhistory")
public class SearchHistoryController {
    
    @Autowired
    private SearchHistoryService searchHistoryService;
    
    @GetMapping
    public ResponseEntity<List<SearchHistoryResponse>> findAll(@CurrentUser UserPrincipal currentUser) {
        SearchHistory searchHistory = new SearchHistory();
        searchHistory.setUserId(currentUser.getId());
        return ResponseEntity.ok(searchHistoryService.findAll(Example.of(searchHistory)));
    }

    @PostMapping
    public ResponseEntity<SearchHistoryResponse> create(@CurrentUser UserPrincipal currentUser, @Valid @RequestBody SearchHistoryRequest searchHistory) {
        return ResponseEntity.ok(searchHistoryService.create(searchHistory, currentUser.getId()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SearchHistoryResponse> findById(@CurrentUser UserPrincipal currentUser, @PathVariable Long id) {
        return ResponseEntity.ok(searchHistoryService.findById(id, currentUser.getId()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SearchHistoryResponse> update(@CurrentUser UserPrincipal currentUser, @PathVariable Long id, @Valid @RequestBody SearchHistoryRequest searchHistory) {
        return ResponseEntity.ok(searchHistoryService.update(id, searchHistory, currentUser.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@CurrentUser UserPrincipal currentUser, @PathVariable Long id) {
        searchHistoryService.deleteById(id, currentUser.getId());
        return ResponseEntity.ok().build();
    }
    
}
