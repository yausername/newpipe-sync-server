package org.yausername.npsync.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.yausername.npsync.entity.BaseEntity;
import org.yausername.npsync.exception.NewPipeException;
import org.yausername.npsync.payload.Request;
import org.yausername.npsync.payload.Response;
import org.yausername.npsync.repository.NewPipeRepository;

public abstract class BaseService<T extends BaseEntity<U>, U extends Response> {

    @Autowired
    private NewPipeRepository<T, Long> repository;

    public List<U> findAll(Example<T> example) {
        if(null == example.getProbe().getUserId()) {
            throw new NewPipeException("search must contain userId", HttpStatus.FORBIDDEN);
        }
        return repository.findAll(example).stream().map(T::toView).collect(Collectors.toList());
    }

    public U findById(Long id, Long userId) {
        return repository.findByUidAndUserId(id, userId).map(T::toView).orElseThrow(() -> new NewPipeException("entity not found", HttpStatus.BAD_REQUEST));
    }

    public U create(Request<T> request, Long userId) {
        T entity = request.toEntity(userId);
        return repository.save(entity).toView();
    }
    
    public U update(Long id, Request<T> request, Long userId) {
        if(!repository.existsByUidAndUserId(id, userId)) {
            throw new NewPipeException("entity not found", HttpStatus.BAD_REQUEST);
        }
        T entity = request.toEntity(id, userId);
        return repository.save(entity).toView();
    }

    public void deleteById(Long id, Long userId) {
        repository.deleteByUidAndUserId(id, userId);
    }
    
}
