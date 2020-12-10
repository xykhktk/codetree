package com.x.code.service;

import com.x.code.entity.po.Code;
import com.x.code.entity.vo.CodeTreeNode;
import com.x.code.repository.CodeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CodeService {


    @Autowired
    private CodeRepository codeRepository;

    public List<CodeTreeNode> codeTree(){
        List<Code> list = getListByParentId(Long.valueOf("0"));
        ArrayList<CodeTreeNode> result_list = new ArrayList<>();
        for(Code code : list){
            CodeTreeNode codeTreeNode = new CodeTreeNode();
            BeanUtils.copyProperties(code,codeTreeNode);
            codeTreeNode.setChildList(getChildList(codeTreeNode));
            result_list.add(codeTreeNode);
        }

        return result_list;
    }

    /**
     * 递归获取子树
     * @param codeTreeNode
     * @return
     */
    private List<CodeTreeNode> getChildList(CodeTreeNode codeTreeNode){
        List<Code> childList = getListByParentId(codeTreeNode.getId());
        ArrayList<CodeTreeNode> childNodeList = new ArrayList<>();
        for(Code code : childList){
            CodeTreeNode childCodeTreeNode = new CodeTreeNode();
            BeanUtils.copyProperties(code,childCodeTreeNode);
            childCodeTreeNode.setChildList(getChildList(childCodeTreeNode)); //递归获取下一级
            childNodeList.add(childCodeTreeNode);
        }
        return childNodeList;
    }

    /**
     * 根据父id获取下一级节点
     * @param parentId
     * @return
     */
    public List<Code> getListByParentId(Long parentId){
        return codeRepository.findByIsDelAndParentId(Byte.valueOf("0"),parentId);
    }

    public Optional<Code> findById(Long id){
        Optional<Code> result = codeRepository.findById(id);
        return result;
    }

    @Transactional
    public void add(String codeDefine,String codeItem,Long parentId){
        Code code = new Code();
        code.setCodeDefine(codeDefine);
        code.setCodeItem(codeItem);
        code.setParentId(parentId);
        code.setIsDel(Byte.valueOf("0"));
        codeRepository.save(code);
    }

    @Transactional
    public void update(Long id,String codeDefine,String codeItem){
        codeRepository.update(id, codeDefine, codeItem);
    }

    @Transactional
    public void delete(Long id){
        codeRepository.softDel(id);
    }

}
