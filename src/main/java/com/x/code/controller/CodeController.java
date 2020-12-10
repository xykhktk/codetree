package com.x.code.controller;

import com.x.code.entity.dto.ReturnJson;
import com.x.code.entity.po.Code;
import com.x.code.repository.CodeRepository;
import com.x.code.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;

import java.util.List;


@RestController("codeController")
@RequestMapping(value = "/code")
public class CodeController extends BaseController{

    private static Logger logger = Logger.getLogger(CodeController.class);

    @Autowired
    private CodeService codeService;

    @GetMapping("/list")
    public ReturnJson list(){
        return ReturnJson.success("获取数据成功").putData("list","");
    }

    @GetMapping("/allList")
    public ReturnJson allList(){
        List<Code> list = codeService.allList();
        return ReturnJson.success("获取数据成功").putData("list",list);
    }

    @RequestMapping("/info")
    public ReturnJson detail(){
        Code code = codeService.findById(Long.valueOf("1"));
        return ReturnJson.success("获取数据成功").putData("info",code);
    }

    @GetMapping("/add")
    public ReturnJson add(){
        codeService.add("1","2",Long.valueOf("0"));
        return ReturnJson.success("添加数据成功").putData("list","");
    }

    @GetMapping("/update")
    public ReturnJson update(){
        codeService.update(Long.valueOf("1"),"aa","AA");
        return ReturnJson.success("修改数据成功").putData("list","");
    }

     @RequestMapping("/delete")
    public ReturnJson delete(){
        Long id = Long.valueOf("1");
        codeService.delete(id);
        return ReturnJson.success("删除成功");
    }

}
