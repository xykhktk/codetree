package com.x.code.entity.po;

import javax.persistence.*;

@Entity
public class Code {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String codeDefine;
    @Column(nullable = false)
    private String codeItem;
    @Column(nullable = false)
    private Long parentId;
    @Column(nullable = false)
    private Byte isDel;

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

    public Byte getIsDel() {
        return isDel;
    }

    public void setIsDel(Byte isDel) {
        this.isDel = isDel;
    }
}
