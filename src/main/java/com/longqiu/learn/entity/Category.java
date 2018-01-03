package com.longqiu.learn.entity;

import io.swagger.annotations.ApiModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by QIUJ003 on 2017/12/20.
 */
@ApiModel(description = "品类")
@Entity(name = "Category")
@Table(name = "Category")
public class Category implements Serializable {

    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "Code")
    private String code;

    @Column(name = "`Name`")
    private String name;

    @Column(name = "`order`")
    private Integer order;

    @Column(name = "`type`")
    private Integer type;

    @Column(name = "bewrite")
    private String bewrite;

    @Column(name = "createuser")
    private String createUser;

    @Column(name = "modifyUser")
    private String modifyUser;

    @Column(name = "createtime")
    private Date createTime;

    @Column(name = "modifytime")
    private Date modifyTime;

    @Column(name = "isdeleted")
    private Boolean isDeleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getBewrite() {
        return bewrite;
    }

    public void setBewrite(String bewrite) {
        this.bewrite = bewrite;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}

