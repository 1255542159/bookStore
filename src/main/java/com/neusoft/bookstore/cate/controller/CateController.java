package com.neusoft.bookstore.cate.controller;

import com.neusoft.bookstore.cate.model.Cate;
import com.neusoft.bookstore.cate.service.CateService;
import com.neusoft.bookstore.menu.model.Menu;
import com.neusoft.bookstore.util.ErrorCode;
import com.neusoft.bookstore.util.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author joy
 * @version 1.0
 * @date 2020/4/30 9:43
 */
@RestController
@RequestMapping("cate")
@Api("cate")
public class CateController {

    @Autowired
    private CateService cateService;

    @PostMapping("addCate")
    @ApiOperation(value = "新增分类",notes = "新增分类")
    private ResponseVo addCate(@RequestBody Cate cate){
        ResponseVo responseVo = new ResponseVo();
        try{
            responseVo = cateService.addCate(cate);
        }catch (Exception e){
            responseVo.setCode(ErrorCode.SERVER_EXCEPTION_CODE);
            responseVo.setMsg("系统异常");
            responseVo.setSuccess(false);
            e.printStackTrace();
        }
        return responseVo;
    }

    @ApiOperation(value = "分类树查询",notes = "分类树查询")
    @GetMapping("listCateTree")
    public ResponseVo listCateTree(){
        ResponseVo responseVo = new ResponseVo();
        try{
            responseVo = cateService.listCateTree();
        }catch (Exception e){
            responseVo.setCode(ErrorCode.SERVER_EXCEPTION_CODE);
            responseVo.setMsg("系统异常");
            responseVo.setSuccess(false);
            e.printStackTrace();
        }
        return responseVo;
    }

    @ApiOperation(value = "分类树详情查询",notes = "分类树详情查询")
    @GetMapping("findCateByCode")
    public ResponseVo findCateByCode(String cateCode){
        ResponseVo responseVo = new ResponseVo();
        try{
            responseVo = cateService.findCateByCode(cateCode);
        }catch (Exception e){
            responseVo.setCode(ErrorCode.SERVER_EXCEPTION_CODE);
            responseVo.setMsg("系统异常");
            responseVo.setSuccess(false);
            e.printStackTrace();
        }
        return responseVo;
    }

    @ApiOperation(value = "修改分类信息",notes = "修改分类信息")
    @PostMapping("updateCateByCode")
    public ResponseVo updateCateByCode(@RequestBody Cate cate){
        ResponseVo responseVo = new ResponseVo();
        try{
            responseVo = cateService.updateCateByCode(cate);
        }catch (Exception e){
            responseVo.setCode(ErrorCode.SERVER_EXCEPTION_CODE);
            responseVo.setMsg("系统异常");
            responseVo.setSuccess(false);
            e.printStackTrace();
        }
        return responseVo;
    }

    @ApiOperation(value = "删除分类信息",notes = "删除分类信息")
    @GetMapping("deleteCateByCode")
    public ResponseVo deleteCateByCode(String cateCode){
        ResponseVo responseVo = new ResponseVo();
        try{
            responseVo = cateService.deleteCateByCode(cateCode);
        }catch (Exception e){
            responseVo.setCode(ErrorCode.SERVER_EXCEPTION_CODE);
            responseVo.setMsg("系统异常");
            responseVo.setSuccess(false);
            e.printStackTrace();
        }
        return responseVo;
    }

    @ApiOperation(value = "级联加载商品分类",notes = "级联加载商品分类")
    @GetMapping("findCateByCateCode")
    public ResponseVo findCateByCateCode(String cateCode){
        ResponseVo responseVo = new ResponseVo();
        try{
            responseVo = cateService.findCateByCateCode(cateCode);
        }catch (Exception e){
            responseVo.setCode(ErrorCode.SERVER_EXCEPTION_CODE);
            responseVo.setMsg("系统异常");
            responseVo.setSuccess(false);
            e.printStackTrace();
        }
        return responseVo;
    }


}
