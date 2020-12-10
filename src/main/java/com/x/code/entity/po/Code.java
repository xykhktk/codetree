package com.x.code.entity.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Code {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String codeDefine;
    @Column(nullable = false)
    private String codeItem;
    @Column(nullable = false)
    private Long parentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeDefine() {
        return codeDefine;
    }

    public void setCodeDefine(String codeDefine) {
        this.codeDefine = codeDefine;
    }

    public String getCodeItem() {
        return codeItem;
    }

    public void setCodeItem(String codeItem) {
        this.codeItem = codeItem;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
