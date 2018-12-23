package com.byefan.xhoa.controller.biz;

import com.byefan.core.ResponseData;
import com.byefan.core.annotation.Verify;
import com.byefan.core.config.Config;
import com.byefan.core.entity.Dict;
import com.byefan.core.log.OperateType;
import com.byefan.core.log.annotation.Log;
import com.byefan.core.serivce.IDictService;
import com.byefan.core.utils.POIUtil;
import com.byefan.core.utils.UUIDUtil;
import com.byefan.xhoa.entity.biz.Article;
import com.byefan.xhoa.service.biz.IArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    IArticleService articleService;
    @Autowired
    Config config;
    @Autowired
    IDictService dictService;

    /**
     * 查询税种
     * @return
     */
    @RequestMapping("/tax")
    @ResponseBody
    public List<Dict> tax(){
        List<Dict> taxes = dictService.listByTypeCode("tax");
        return taxes;
    }

    @RequestMapping("/businessList")
    @ResponseBody
    public PageInfo<Map<String, Object>> businessList(@RequestParam Map param,@PageableDefault(size = 10) Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(),pageable.getPageSize());
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<Map<String, Object>>(articleService.businessList(param));
        return pageInfo;
    }

    @RequestMapping("/articleListManager")
    @ResponseBody
    public PageInfo<Map> articleListManager(@RequestParam Map param,@PageableDefault(size = 10) Pageable pageable) {
        PageHelper.startPage(pageable.getPageNumber(),pageable.getPageSize());
        PageInfo<Map> pageInfo = new PageInfo<Map>(articleService.articleListManager(param));
        return pageInfo;
    }

    @RequestMapping("/businessResult")
    @ResponseBody
    public Map businessResult(@RequestParam Map param){
        return articleService.businessResult(param);
    }

    @RequestMapping("/editArticle")
    @ResponseBody
    public Map editArticle(@RequestParam Map param) {
        Map map = articleService.editArticle(param);
        return map;
    }

    @RequestMapping("/updateArticle")
    @ResponseBody
    public ResponseData updateArticle(@RequestParam Map param){
        try {
            int row = articleService.updateArticle(param);
            ResponseData da = ResponseData.ok();
            return da;
        }catch (Exception e){
            log.error("更新稿件失败",e);
            ResponseData da = ResponseData.customerError(1001,e.getMessage());
            return da;
        }
    }

    @RequestMapping("/deleteArticle")
    @ResponseBody
    public ResponseData deleteArticle(@RequestParam("artId") Integer id){
        try {
            int row = articleService.deleteArticle(id);
            ResponseData da = ResponseData.ok();
            return da;
        }catch (Exception e){
            log.error("删除稿件失败",e);
            ResponseData da = ResponseData.customerError(1001,e.getMessage());
            return da;
        }
    }

    @RequestMapping("/batchDelete")
    @ResponseBody
    public ResponseData batchDelete(@RequestParam("datas") String datas){
        try {
            boolean b = articleService.batchDelete(datas);
            ResponseData da = ResponseData.ok();
            return da;
        }catch (Exception e){
            log.error("批量删除稿件失败",e);
            ResponseData da = ResponseData.customerError(1001,e.getMessage());
            return da;
        }
    }

    /**
     * 导出全部
     */
    @RequestMapping("/exportAll")
    @Verify(code = "/article/exportAll", module = "稿件管理/导出全部")
    @Log(opType = OperateType.QUERY, module = "稿件管理/导出全部", note = "导出全部")
    public void exportAll(HttpServletResponse response, @RequestParam Map map){
        try {
            response.setContentType("application/binary;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode("稿件信息.xls", "UTF-8"));
            OutputStream outputStream = response.getOutputStream();
            articleService.exportAll(map,outputStream);
        }catch (Exception e){
            log.error("导出稿件失败",e);
        }
    }

    @GetMapping("list/{orderId}")
    @ResponseBody
    public PageInfo<Article> businessList(@PathVariable("orderId") Integer orderId, Pageable pageable) {
        return articleService.listByOrderId(orderId, pageable);
    }

    @PostMapping("upload")
    @ResponseBody
    public ResponseData upload(@RequestParam("id") Integer id, @RequestParam("file") MultipartFile multipartFile) {
        String originalFileName = multipartFile.getOriginalFilename();
        String uploadDir = config.getUploadDir();
        String wordPath = "";
        String fileName = UUIDUtil.get32UUID();
        if (StringUtils.isNotEmpty(originalFileName)) {
            String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
//            fileName = fileName + ext;
            File file = new File(uploadDir + "/words", fileName + ext);
            wordPath = file.getAbsolutePath();
            if (!file.getParentFile().exists())
                file.getParentFile().mkdirs();
            try {
                multipartFile.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String path = config.getWebDir() + fileName + ext;
            articleService.updatePathById(id, path);
        }
        OutputStreamWriter writer = null;
        FileInputStream in = null;
        try {
            String htmlPath = POIUtil.wordToHtml(originalFileName, fileName, uploadDir, wordPath, config.getWebDir());
            byte[] bytes = FileCopyUtils.copyToByteArray(new File(htmlPath));
            ResponseData ok = ResponseData.ok();
            ok.putDataValue("stream", new String(bytes));
            return ok;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return ResponseData.customerError(1001, e.getMessage());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return ResponseData.customerError(1002, e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseData.customerError(1003, e.getMessage());
        } finally {
            try {
                if (in != null)
                    in.close();
                if (writer != null)
                    writer.close();
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseData.customerError(1004, e.getMessage());
            }

        }
    }

    @GetMapping("loadHtml")
    @ResponseBody
    public ResponseData loadHtml(@RequestParam("htmlPath") String htmlPath) {
        try {
            String uploadDir = config.getUploadDir();
            htmlPath = uploadDir + "htmls" + htmlPath.substring(htmlPath.lastIndexOf("/"), htmlPath.lastIndexOf(".")) + ".html";
            byte[] bytes = FileCopyUtils.copyToByteArray(new File(htmlPath));
            ResponseData ok = ResponseData.ok();
            ok.putDataValue("stream", new String(bytes));
            return ok;
        } catch (Exception e) {
            return ResponseData.customerError(1001, e.getMessage());
        }
    }

    @GetMapping("queryArticleBySupplierId")
    @ResponseBody
    public PageInfo<Map> queryArticleBySupplierId(@PageableDefault(size = 5) Pageable pageable,@RequestParam Map map) {
        PageHelper.startPage(pageable.getPageNumber(),pageable.getPageSize());
        PageInfo<Map> pages = null ;
        try{
            if(map.get("supplierId")!=null){
                pages = articleService.queryArticleBySupplierId(pageable,Integer.parseInt((String)map.get("supplierId")),map);
            }else{
                throw new Exception("获取选中的供应商id失败！") ;
            }
        }catch (Exception e){
            e.printStackTrace();

        }
        return pages;
    }

    @RequestMapping("queryArticleForComm")
    @ResponseBody
    public PageInfo<Map> queryArticleForComm(@PageableDefault(size = 5) Pageable pageable,@RequestParam Map map) {
        PageHelper.startPage(pageable.getPageNumber(),pageable.getPageSize());
        PageInfo<Map> pages = null ;
        try{
            if(map.get("userId")!=null&&map.get("year")!=null&&map.get("month")!=null){
                pages = articleService.queryArticleForComm(pageable,map);
            }else{
                throw new Exception("请求失败，没有获取到用户或年月信息") ;
            }
        }catch (Exception e){
            e.printStackTrace();

        }
        return pages;
    }
}
