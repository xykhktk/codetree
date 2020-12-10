package com.x.code.controller;

import com.x.code.entity.dto.ReturnJson;
import com.x.code.entity.po.Code;
import com.x.code.repository.CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;

import java.util.List;


@RestController("codeController")
@RequestMapping(value = "/code")
public class CodeController extends BaseController{

    private static Logger logger = Logger.getLogger(CodeController.class);

    @Autowired
    private CodeRepository codeRepository;

    @RequestMapping("/detail")
    public ReturnJson detail(){
        List<Code> list= codeRepository.findAll();
        return ReturnJson.success("获取数据成功",list);
    }
}
