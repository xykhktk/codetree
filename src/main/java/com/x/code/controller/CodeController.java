package com.x.code.controller;

import com.x.code.entity.dto.ReturnJson;
import com.x.code.entity.po.Code;
import com.x.code.entity.vo.CodeTreeNode;
import com.x.code.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Optional;


@RestController("codeController")
@RequestMapping(value = "/code")
public class CodeController{

    private static Logger logger = Logger.getLogger(CodeController.class);

    @Autowired
    private CodeService codeService;

    @RequestMapping("/list")
    public ReturnJson list(@RequestParam(value = "parentId",required = true) Long id){
        List<Code> list = codeService.getListByParentId(id);
        return ReturnJson.success("获取数据成功").putData("list",list);
    }

    /**
     * 获取所有数据
     * @return
     */
    @RequestMapping("/tree")
    public ReturnJson tree(){
        List<CodeTreeNode> tree = codeService.codeTree();
        return ReturnJson.success("获取数据成功").putData("tree",tree);
    }

    @RequestMapping("/detail")
    public ReturnJson detail(@RequestParam(value = "id",required = true) Long id){
        Optional<Code> result = codeService.findById(id);
        if(!result.isPresent()){
            return ReturnJson.error("获取数据失败");
        }
        if(result.get().getIsDel() != 0){
            return ReturnJson.error("数据已被删除");
        }
        return ReturnJson.success("获取数据成功").putData("detail",result.get());
    }

    @RequestMapping("/add")
    public ReturnJson add(
            @RequestParam(value = "codeDefine",required = true) String codeDefine,
            @RequestParam(value = "codeItem",required = true) String codeItem,
            @RequestParam(value = "parentId",required = true) Long parentId){
        codeService.add(codeDefine,codeItem,parentId);
        return ReturnJson.success("添加数据成功");
    }

    @RequestMapping("/update")
    public ReturnJson update(@RequestParam(value = "id",required = true) Long id,
                             @RequestParam(value = "codeDefine",required = true) String codeDefine,
                             @RequestParam(value = "codeItem",required = true) String codeItem){
        codeService.update(id,codeDefine,codeItem);
        return ReturnJson.success("修改数据成功");
    }

     @RequestMapping("/delete")
    public ReturnJson delete(@RequestParam(value = "id",required = true) Long id){
        codeService.delete(id);
        return ReturnJson.success("删除成功");
    }

}
