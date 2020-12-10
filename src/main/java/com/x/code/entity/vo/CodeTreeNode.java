package com.x.code.entity.vo;

import com.x.code.entity.po.Code;

import java.util.List;

public class CodeTreeNode extends Code {

    private List<CodeTreeNode> childList;

    public List<CodeTreeNode> getChildList() {
        return childList;
    }

    public void setChildList(List<CodeTreeNode> childList) {
        this.childList = childList;
    }
}
