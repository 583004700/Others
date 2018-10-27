package com.ry.xk.main.controller;


import com.ry.xk.common.CommonConst;
import com.ry.xk.common.CommonUtils;
import com.ry.xk.common.bo.ResponseBase;
import com.ry.xk.main.service.ICourseService;
import com.ry.xk.main.service.IPartnerService;
import com.ry.xk.request.bo.CoursesRequest;
import com.ry.xk.request.bo.WxAuthUrlRequest;
import com.ry.xk.response.bo.CourseType;
import com.ry.xk.response.bo.CourseWrongCountModule;
import com.ry.xk.response.bo.CoursesModule;
import com.ry.xk.studentexamresult.service.IWrongBookService;
import com.ry.xk.utils.UrlUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/course")
@Api("学科相关api")
public class CourseController
{
    @Autowired
    IPartnerService partnerService;

    @Autowired
    ICourseService courseService;

    @Autowired
    IWrongBookService wrongBookService;

    // 日志操作对象
    private static final Logger log = LoggerFactory.getLogger(CourseController.class);

    @ApiOperation("获取所有学科和对应错题数量")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "body", name = "coursesRequest", dataType = "CoursesRequest", required = true, value = "入参")})
    @RequestMapping(value = "/getCoursesAndWrongCount", method = RequestMethod.POST)
    public ResponseBase<List<CourseWrongCountModule>> getCoursesAndWrongCount(@RequestBody @Valid CoursesRequest coursesRequest, BindingResult result)
    {
        int resultType = CommonConst.resultTypeFail;
        List<CourseWrongCountModule> courseWrongCountModuleList = new ArrayList<CourseWrongCountModule>();
        try
        {
            if (result.hasErrors())
            {
                log.error("输入参数不正确", CommonUtils.getAllValidateError(result.getAllErrors()));
            }
            else
            {
                int courseTypeId = coursesRequest.getCourseTypeId();
                courseWrongCountModuleList = wrongBookService.getCourseWrongCounts(coursesRequest.getPartnerId(), coursesRequest.getUserId(), courseTypeId);
                resultType = CommonConst.resultTypeSuccess;
            }
        }
        catch (Exception e)
        {
            log.error("获取所有学科和对应错题数量失败", e);
        }
        ResponseBase<List<CourseWrongCountModule>> rb = new ResponseBase<List<CourseWrongCountModule>>(resultType, "", courseWrongCountModuleList);
        return rb;
    }

    @ApiOperation("获取所有学科")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "body", name = "coursesRequest", dataType = "CoursesRequest", required = true, value = "入参")})
    @RequestMapping(value = "/getCourses", method = RequestMethod.POST)
    public ResponseBase<List<CoursesModule>> getCourses(@RequestBody @Valid CoursesRequest coursesRequest, BindingResult result)
    {
        List<CoursesModule> courseListModules = new ArrayList<CoursesModule>();
        int resultType = CommonConst.resultTypeFail;
        try
        {
            if (result.hasErrors())
            {
                log.error("输入参数不正确", CommonUtils.getAllValidateError(result.getAllErrors()));
            }
            else
            {
                Integer courseTypeId = coursesRequest.getCourseTypeId();
                courseListModules = courseService.getByCourseType(coursesRequest.getPartnerId(), courseTypeId);
                resultType = CommonConst.resultTypeSuccess;
            }
        }
        catch (Exception e)
        {
            log.error("获取所有学科失败", e);
        }
        ResponseBase<List<CoursesModule>> rb = new ResponseBase<List<CoursesModule>>(resultType, "", courseListModules);
        return rb;
    }

    @ApiOperation("获取学段列表")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "body", name = "wxAuthUrlRequest", dataType = "WxAuthUrlRequest", required = true, value = "入参")})
    @RequestMapping(value = "/getCourseTypes", method = RequestMethod.POST)
    public ResponseBase<List<CourseType>> getCourseTypes(@RequestBody @Valid WxAuthUrlRequest wxAuthUrlRequest, BindingResult result)
    {
        int resultType = CommonConst.resultTypeFail;
        List<CourseType> courseTypes = new ArrayList<CourseType>();
        try
        {
            if (result.hasErrors())
            {
                log.error("输入参数不正确", CommonUtils.getAllValidateError(result.getAllErrors()));
            }
            else
            {
                courseTypes = partnerService.getCourseTypes(wxAuthUrlRequest.getPartnerId());
                resultType = CommonConst.resultTypeSuccess;
            }
        }
        catch (Exception e)
        {
            log.error("获取学段列表失败", e);
        }
        ResponseBase<List<CourseType>> rb = new ResponseBase<List<CourseType>>(resultType, "", courseTypes);
        return rb;
    }

}