package com.multimodule.admin.repository;

import com.multimodule.core.entity.PostEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.beans.Transient;

public interface PostRepository extends JpaRepository<PostEntity, Long> {


    @Modifying
    @Transactional
    @Query("update PostEntity p set p.type = 'B' where p.id = :id")
    void banPostById(long id);
}
