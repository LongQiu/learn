package com.longqiu.learn.repository;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by QIUJ003 on 2017/12/26.
 */
public abstract class AbstractDao implements BatchDao {
    @PersistenceContext
    protected EntityManager em;

    @Transactional
    public void batchInsert(List list) {
        for (int i = 0; i < list.size(); i++) {
            em.persist(list.get(i));
            if (i % 30 == 0) {
                em.flush();
                em.clear();
            }
        }
    }

    @Transactional
    public void batchUpdate(List list) {
        for (int i = 0; i < list.size(); i++) {
            em.merge(list.get(i));
            if (i % 30 == 0) {
                em.flush();
                em.clear();
            }
        }
    }
}
