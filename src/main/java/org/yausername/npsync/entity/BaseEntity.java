package org.yausername.npsync.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.yausername.npsync.payload.Response;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity<U extends Response> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long uid;
    
    @NotNull
    protected Long userId;
    
    public abstract U toView();
    
}
