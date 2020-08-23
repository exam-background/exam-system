package com.yyhn.exam.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.yyhn.exam.common.Dto;
import com.yyhn.exam.common.DtoUtil;
import com.yyhn.exam.common.Page;
import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.entity.Course;
import com.yyhn.exam.entity.SysDictionary;
import com.yyhn.exam.mapper.SysDictionaryMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api( value = "针对字典表进行维护",description = "字典表管理控制器类")
public class SysDictionaryController {
    @Resource
    private SysDictionaryMapper sysDictionaryMapper;

    @ApiOperation(value = "字典表的增加", httpMethod = "POST",
            protocols = "HTTP",
            response = Dto.class, notes = "字典表的增加" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>100101 : 查询失败 </p>" +
            "<p>0 : 查询成功 </p>" )
    @RequestMapping(value = "/insertSysDictionary",method = RequestMethod.POST)
    public ResultMsg insertSysDictionary(SysDictionary sysDictionary){
        try {
            if(sysDictionaryMapper.insert(sysDictionary)>0){
                return ResultMsg.BY_SUCCESS("添加成功", null);
            }else{
                return ResultMsg.BY_FAIL("添加失败");
            }
        }catch (Exception ex){
            ex.printStackTrace();;
            DtoUtil.returnFail("查询失败！","100101");
        }
        return null;
    }

    @ApiOperation(value = "字典表的删除", httpMethod = "GET",
            protocols = "HTTP",
            response = Dto.class, notes = "字典表的删除" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>100101 : 查询失败 </p>" +
            "<p>0 : 查询成功 </p>" )
    @RequestMapping(value = "/deleteDictionary",method = RequestMethod.GET)
    public ResultMsg deleteDictionary(Integer id){
        try {
            if(sysDictionaryMapper.deleteById(id)>0){
                return ResultMsg.BY_SUCCESS("删除成功", null);
            }else{
                return ResultMsg.BY_FAIL("删除失败");
            }
        }catch (Exception ex){
            ex.printStackTrace();;
            DtoUtil.returnFail("查询失败！","100101");
        }
        return null;
    }

    @ApiOperation(value = "字典表的删除", httpMethod = "GET",
            protocols = "HTTP",
            response = Dto.class, notes = "字典表的删除" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>100101 : 查询失败 </p>" +
            "<p>0 : 查询成功 </p>" )
    @RequestMapping(value = "/getDictionaryBytype",method = RequestMethod.GET)
    public ResultMsg getDictionaryBytype(){
        try {
            Wrapper<SysDictionary> wrapper = new EntityWrapper<SysDictionary>();
            wrapper.eq("dictionary_type", "题型");
            List<SysDictionary> list = sysDictionaryMapper.selectList(wrapper);
            if(list != null){
                return ResultMsg.BY_SUCCESS("查询成功", list);
            }else{
                return ResultMsg.BY_FAIL("询失败");
            }
        }catch (Exception ex){
            ex.printStackTrace();;
            DtoUtil.returnFail("查询失败！","100101");
        }
        return null;
    }
}
