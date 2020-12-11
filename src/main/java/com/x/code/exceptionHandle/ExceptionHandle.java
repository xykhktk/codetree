package com.x.code.exceptionHandle;

import com.x.code.controller.CodeController;
import com.x.code.entity.dto.ReturnJson;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private static Logger logger = Logger.getLogger(CodeController.class);

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ReturnJson handle(Exception e){
            return ReturnJson.error(e.getMessage());
    }

}
