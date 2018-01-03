package com.longqiu.learn.service;

import com.longqiu.learn.entity.Platform;
import com.longqiu.learn.repository.AbstractDao;
import com.longqiu.learn.repository.PlatformRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * Created by QIUJ003 on 2017/12/21.
 */
@Service
public class PlatformService extends AbstractDao {
    private static final Logger logger =  LoggerFactory.getLogger(PlatformService.class);

    //持久层
    @Autowired
    private PlatformRepository platformRepository;

    public Platform findByName(String platformName) {
        return platformRepository.findByName(platformName);
    }

    public Platform findUsedByName(String platformName) {
        return platformRepository.findByNameAndIsDeleted(platformName,false);
    }

    public Platform findByNameForBudget(String platformName) {
        return platformRepository.findByNameForBudget(platformName);
    }

    public Page<Platform> findAll(int page,int size){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        return platformRepository.findAll(pageable);
    }

    public Page<Platform> findByNameForPage(String platformName, Pageable pageable){
        return platformRepository.findByName(platformName,pageable);
    }

    @Transactional
    public int insert(String platformName){
        logger.info("insert-start:");

        Platform platform = new Platform();
        platform.setId(UUID.randomUUID().toString());
        platform.setCode(platformName);
        platform.setName(platformName);
        platform.setCreateTime(new Date());
        platform.setModifyTime(new Date());
        platform.setCreateUser("00000000-0000-0000-0000-000000000001");
        platform.setModifyUser("00000000-0000-0000-0000-000000000001");
        platform.setOrder(0);
        platform.setUseForBudget(false);
        platform.setDeleted(false);

        if(platformRepository.countByName(platformName) > 0){
            return -1;
        }
        platformRepository.save(platform);
        //throw new RuntimeException();
        return 1;
    }
}
