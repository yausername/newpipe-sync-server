package org.yausername.npsync.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

@NoRepositoryBean
public interface NewPipeRepository<T, ID> extends JpaRepository<T, ID> {
    
    Optional<T> findByUidAndUserId(Long uid, Long userId);

    boolean existsByUidAndUserId(Long uid, Long userId);

    @Transactional
    void deleteByUidAndUserId(Long uid, Long userId);
    
}
