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
import org.yausername.npsync.entity.Subscription;
import org.yausername.npsync.payload.SubscriptionRequest;
import org.yausername.npsync.payload.SubscriptionResponse;
import org.yausername.npsync.security.CurrentUser;
import org.yausername.npsync.security.UserPrincipal;
import org.yausername.npsync.service.SubscriptionService;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping
    public ResponseEntity<List<SubscriptionResponse>> findAll(@CurrentUser UserPrincipal currentUser,
            @RequestParam(required = false) String serviceId, @RequestParam(required = false) String url) {
        Subscription subscription = new Subscription();
        subscription.setUserId(currentUser.getId());
        subscription.setServiceId(serviceId);
        subscription.setUrl(url);
        return ResponseEntity.ok(subscriptionService.findAll(Example.of(subscription)));
    }

    @PostMapping
    public ResponseEntity<SubscriptionResponse> create(@CurrentUser UserPrincipal currentUser,
            @Valid @RequestBody SubscriptionRequest subscription) {
        return ResponseEntity.ok(subscriptionService.create(subscription, currentUser.getId()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionResponse> findById(@CurrentUser UserPrincipal currentUser,
            @PathVariable Long id) {
        return ResponseEntity.ok(subscriptionService.findById(id, currentUser.getId()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubscriptionResponse> update(@CurrentUser UserPrincipal currentUser, @PathVariable Long id,
            @Valid @RequestBody SubscriptionRequest subscription) {
        return ResponseEntity.ok(subscriptionService.update(id, subscription, currentUser.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@CurrentUser UserPrincipal currentUser, @PathVariable Long id) {
        subscriptionService.deleteById(id, currentUser.getId());
        return ResponseEntity.ok().build();
    }

}
