package com.x.code.entity.vo;

import com.x.code.entity.po.Code;

import java.util.List;

/**
 * 代码的树状结构的节点
 */
public class CodeTreeNode extends Code {

    /**
     * 子节点
     */
    private List<CodeTreeNode> childList;

    public List<CodeTreeNode> getChildList() {
        return childList;
    }

    public void setChildList(List<CodeTreeNode> childList) {
        this.childList = childList;
    }
}
