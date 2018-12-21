package com.byefan.core.controller;

import com.byefan.core.ResponseData;
import com.byefan.core.entity.Dict;
import com.byefan.core.serivce.IDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Map;

/**
 * 数据字典
 * @author GZW
 */
@Controller
@RequestMapping("/dict")
public class DictController {

    @Autowired
    IDictService dictService;

    @GetMapping
    @ResponseBody
    public Dict getByDict(Dict dict) {
        return dictService.getByTypeCodeAndCode(dict);
    }

    @GetMapping("list")
    @ResponseBody
    public List<Dict> list(Dict dict) {
        return dictService.list(dict);
    }

    @GetMapping("dicts")
    @ResponseBody
    public List<Map<String, Object>> list(@RequestParam Map<String, Object> param) {
        return dictService.list(param);
    }

    @GetMapping("listByTypeCode")
    @ResponseBody
    public List<Map<String, Object>> listByTypeCode(@RequestParam Map<String, Object> param) {
        return dictService.listByTypeCode(param);
    }

    @GetMapping("listByTypeCode2")
    @ResponseBody
    public List<Dict> listByTypeCode2(@RequestParam("typeCode") String typeCode) {
        List<Dict> list = dictService.listByTypeCode(typeCode) ;
        System.out.println(list);
        return list;
    }

    @RequestMapping("view")
    @ResponseBody
    public ResponseData view(@RequestParam("typeCode") String typeCode, @RequestParam("name") String name) {
        try{
            ResponseData data = ResponseData.ok() ;
            Dict entity = dictService.getByTypeCodeAndName(typeCode,name) ;
            data.putDataValue("entity",entity) ;
            data.putDataValue("message","操作成功");
            return data ;
        }catch (Exception e){
            e.printStackTrace();
            return ResponseData.customerError(1001,e.getMessage()) ;
        }
    }
}
