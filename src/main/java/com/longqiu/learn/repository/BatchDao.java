package com.longqiu.learn.repository;

import java.util.List;

/**
 * Created by QIUJ003 on 2017/12/26.
 */
public interface BatchDao<T> {
    public void batchInsert(List<T> list);
    public void batchUpdate(List<T> list);
}
