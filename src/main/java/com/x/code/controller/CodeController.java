package com.x.code.controller;

import com.x.code.entity.dto.ReturnJson;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;


@RestController("codeController")
@RequestMapping(value = "/code")
public class CodeController extends BaseController{

    private static Logger logger = Logger.getLogger(CodeController.class);

    @RequestMapping("/detail")
    public ReturnJson detail(){
        return ReturnJson.success("获取数据成功");
    }
}
