package com.byefan.xhoa.mapper.crm;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.core.utils.ProviderUtil;
import com.byefan.xhoa.entity.crm.DockingPeople;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface DockingPeopleMapper extends BaseMapper<DockingPeople, Integer> {
    /**
     * 添加一条客户对接人记录
     *
     * @param record
     * @return
     */
    @InsertProvider(type = ProviderUtil.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int add(DockingPeople record);

    /**
     * 通过公司ID查询对接人信息
     *
     * @param companyId
     * @return
     */
    @Select("SELECT * FROM t_crm_docking_people WHERE company_id = #{companyId} and delete_flag != 1")
    DockingPeople getDockingPeopleByCompanyId(@Param("companyId") Integer companyId);

    /**
     * 将对接人解绑或绑定
     *
     * @param peo
     * @return
     */
    @Update("update t_crm_docking_people set cust_property = #{custProperty}, worker = #{worker} where id = #{id}")
    int cancelOrBindDocking(DockingPeople peo);

    /**
     * 更新联系人信息
     *
     * @param peo
     * @return
     */
    @Update({
            "<script>",
            "update t_crm_docking_people set \n",
            "<when test='deleteFlag!=null and deleteFlag!=\"\" or deleteFlag==0'>",
            "delete_flag = #{deleteFlag}, \n",
            "</when>",
            "<when test='worker!=null and worker!=\"\"'>",
            "worker = #{worker} ,\n",
            "</when>",
            "update_time=now()",
            "where id = #{id}",
            "</script>"
    })
    int updateDocking(DockingPeople peo);

    /**
     * 查询对接人
     *
     * @param map
     * @return
     */
    @Select({
            "<script>",
            "select peo.*,a.id uid,a.name uname,a.dept_id  from t_crm_docking_people peo,sys_user a where peo.worker=a.id and cust_property=2",
            "<when test='worker!=null and worker!=\"\"'>",
            "and worker = #{worker}",
            "</when>",
            "<when test='custId!=null and custId!=\"\"'>",
            "and company_id = #{custId}",
            "</when>",
            "</script>"
    })
    @Results({
            @Result(property = "user.id", column = "uid"),
            @Result(property = "user.name", column = "uname"),
            @Result(property = "user.dept.id", column = "dept_id"),
    })
    List<DockingPeople> listDockingPeople(Map map);


    @Select("select * from t_crm_docking_people where company_id=#{custId}")
    List<DockingPeople> listByCustId(@Param("custId") Integer custId);

    @Select({
            "<script>",
            "select * from t_crm_docking_people peo where 1=1",
            "<when test='worker!=null and worker!=\"\"'>",
            "and worker = #{worker}\n",
            "</when>",
            "</script>"
    })
    List<DockingPeople> listByWorker(@Param("worker") Integer worker);

}
