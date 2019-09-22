package org.yausername.npsync.payload;

import org.yausername.npsync.entity.BaseEntity;

public interface Request<T extends BaseEntity> {
    
    T toEntity(Long uid, Long userId);
    
    T toEntity(Long userId);
    
}
