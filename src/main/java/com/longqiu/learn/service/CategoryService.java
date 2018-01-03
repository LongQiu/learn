package com.longqiu.learn.service;

import com.longqiu.learn.entity.Category;
import com.longqiu.learn.repository.AbstractDao;
import com.longqiu.learn.repository.CategoryRepository;
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
public class CategoryService extends AbstractDao {

    //持久层
    @Autowired
    private CategoryRepository categoryRepository;

    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }

    public Category findUsedByName(String name) {
        return categoryRepository.findByNameAndIsDeleted(name,false);
    }

    public Page<Category> findAll(int page,int size){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        return categoryRepository.findAll(pageable);
    }

    public Page<Category> findByNameForPage(String name, Pageable pageable){
        return categoryRepository.findByName(name,pageable);
    }

    @Transactional
    public int insert(String name){
        Category category = new Category();
        category.setId(UUID.randomUUID().toString());
        category.setCode(name);
        category.setName(name);
        category.setCreateTime(new Date());
        category.setModifyTime(new Date());
        category.setCreateUser("00000000-0000-0000-0000-000000000001");
        category.setModifyUser("00000000-0000-0000-0000-000000000001");
        category.setOrder(0);
        category.setType(0);
        category.setDeleted(false);

        if(categoryRepository.countByName(name) > 0){
            return -1;
        }
        categoryRepository.save(category);
        //throw new RuntimeException();
        return 1;
    }
}
