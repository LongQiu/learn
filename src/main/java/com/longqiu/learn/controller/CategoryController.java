package com.longqiu.learn.controller;

import com.longqiu.learn.entity.Category;
import com.longqiu.learn.service.CategoryService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by QIUJ003 on 2017/12/21.
 */
@RestController
@RequestMapping(value="/category")
public class CategoryController {
    private static final Logger logger =  LoggerFactory.getLogger(CategoryController.class);

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value="获取品类信息", notes="根据{categorymname}获取对应品类信息")
    @RequestMapping(value="/{categorymname}",method = RequestMethod.GET)
    public Category get(@PathVariable String categorymname){
        Category category = categoryService.findByName(categorymname);
        return category;
    }

    @ApiOperation(value="获取品类列表", notes="根据URL中的pageIndex、pageSize获取品类列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageIndex", value = "页码", required = true,paramType = "query", dataType = "int"),
                @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true,paramType = "query", dataType = "int")
    })
    @RequestMapping(value="/getList",method = RequestMethod.GET)
    public Page<Category> getList(@RequestParam int pageIndex, @RequestParam int pageSize){
        return categoryService.findAll(pageIndex,pageSize);
    }

    @ApiOperation(value="插入品类信息", notes="根据name插入品类信息")
    @ApiImplicitParam(name = "name", value = "品类名称", required = true,paramType = "query", dataType = "String")
    @RequestMapping(value="/insert",method = RequestMethod.GET)
    public int insert(@RequestParam String name){
        return categoryService.insert(name);
    }

    @ApiOperation(value="批量更新品类信息", notes="批量更新品类信息")
    @RequestMapping(value="/batchUpdate",method = RequestMethod.POST)
    public int batchUpdate(@RequestBody List<Category> list){
        logger.info("batchUpdate-start:");
        categoryService.batchUpdate(list);
        return 1;
    }
}
