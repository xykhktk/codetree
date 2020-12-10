package com.x.code.service;

import com.x.code.entity.po.Code;
import com.x.code.repository.CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CodeService {


    @Autowired
    private CodeRepository codeRepository;

    public List<Code> allList(){
        return codeRepository.findByIsDel(Byte.valueOf("0"));
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
