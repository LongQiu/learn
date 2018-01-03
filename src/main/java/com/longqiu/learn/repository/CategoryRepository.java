package com.longqiu.learn.repository;

import com.longqiu.learn.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by QIUJ003 on 2017/12/20.
 */
public interface CategoryRepository extends JpaRepository<Category, Long>, JpaSpecificationExecutor<Category> {
    Category findByName(String name);

    Category findByNameAndIsDeleted(String name, boolean isDeleted);

    Page<Category> findAll(Pageable pageable);

    Page<Category> findByName(String name, Pageable pageable);

    int countByName(String name);

    int deleteById(String id);

    int deleteByName(String name);
}
