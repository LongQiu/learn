package com.longqiu.learn.repository;

import com.longqiu.learn.entity.Platform;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by QIUJ003 on 2017/12/20.
 */
public interface PlatformRepository extends JpaRepository<Platform, Long>, JpaSpecificationExecutor<Platform> {
    Platform findByName(String platformName);

    Platform findByNameAndIsDeleted(String platformName,boolean isDeleted);

    @Query("select A from Platform A where A.useForBudget=true and A.name=:platformName")
    Platform findByNameForBudget(@Param("platformName")String platformName);

    Page<Platform> findAll(Pageable pageable);

    Page<Platform> findByName(String platformName, Pageable pageable);

    int countByName(String platformName);

    int deleteById(String id);

    int deleteByName(String platformName);
}
