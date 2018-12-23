package com.byefan.xhoa.mapper.fee;

import com.byefan.core.mapper.BaseMapper;
import com.byefan.core.utils.ProviderUtil;
import com.byefan.xhoa.entity.fee.Account;
import com.byefan.xhoa.entity.sys.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface AccountMapper extends BaseMapper<Account,Integer> {
    @InsertProvider(type = ProviderUtil.class, method = "insert")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert2(Account t);

    @Select({"<script>",
            " SELECT a.id id,a.type type,a.company_id companyId,a.company_name companyName,a.name name,a.bank_no bankNo," +
                    " a.bank_name bankName, a.owner owner,a.phone phone,a.balance balance," +
                    " a.remark remark,a.state state," +
                    " a.creator creator,a.create_time createTime,a.update_user_id updateUserId,a.update_time updateTime" +
                    " FROM fee_account a" +
                    " WHERE a.state >-2 " +
//                        " <choose>",
//                        " <when test='roleType==\"LD\"'>",
//                        " and 1=1",
//                        " </when>",
//                        " <when test='roleType==\"CW\"'>",
//                        " and 1=1",
//                        " </when>",
//                        " <when test='roleType==\"YW\"'>",
//                            " <choose>",
//                            " <when test='roleCode==\"YG\"'>",
//                            " and #{user.deptId} in (select d.dept_id from fee_account_dept d where d.account_id=a.id)",
//                            " </when>",
//                            " <when test='roleCode==\"ZZ\"'>",
//                            " and #{user.deptId} in (select d.dept_id from fee_account_dept d where d.account_id=a.id)",
//                            " </when>",
//                            " <when test='roleCode==\"BZ\"'>",
//                            " and 1=1",
//                            " </when>",
//                            " <when test='roleCode==\"ZJ\"'>",
//                            " and 1=1",
//                            " </when>",
//                            " <otherwise>",
//                            " and 1=4",
//                            " </otherwise>",
//                            " </choose>",
//                        " </when>",
//                        " <when test='nameQc!=null and nameQc!=\"\"'>",
//                        " AND name like '%${nameQc}%'",
//                        " </when>",
//                        " <when test='yearQc!=null and yearQc!=\"\"'>",
//                        " AND year = #{yearQc}",
//                        " </when>",
//                        " <when test='monthQc!=null and monthQc!=\"\"'>",
//                        " AND month = #{monthQc}",
//                        " </when>",
//                        " </choose>",
            " <when test='typeQc!=null and typeQc!=\"\"'>",
            " AND type = #{typeQc}",
            " </when>",
            " <when test='companyId!=null and companyId!=\"\"'>",
            " AND a.company_id = #{companyId}",
            " </when>",
            " <when test='companyNameQc!=null and companyNameQc!=\"\"'>",
            " AND a.company_name like '%${companyNameQc}%'",
            " </when>",
            " <when test='nameQc!=null and nameQc!=\"\"'>",
            " AND a.name like '%${nameQc}%'",
            " </when>",
            " <when test='dockingIdQc!=null and dockingIdQc!=\"\"'>",
            " AND a.docking_id = #{dockingIdQc}",
            " </when>",
            " <when test='bankNoQc!=null and bankNoQc!=\"\"'>",
            " AND a.bank_no like '%${bankNoQc}%'",
            " </when>",
            " <when test='bankNameQc!=null and bankNameQc!=\"\"'>",
            " AND a.bank_name like '%${bankNameQc}%'",
            " </when>",
            " <when test='ownerQc!=null and ownerQc!=\"\"'>",
            " AND a.owner like '%${ownerQc}%'",
            " </when>",
            " order by id desc",
            "</script>"})
    List<Map> listPg(Map map);

    @Select("select * from fee_account where id=#{id} and state>-2")
    Account getById(Integer id);

    @UpdateProvider(type = ProviderUtil.class, method = "update")
    int update2(Account record);

    @Update("update fee_account set balance=#{balance} where state>-2 and id=#{id}")
    int updateBalance(@Param("balance") Double balance,@Param("id") Integer id) ;

    /**
     *
     * @param companyId 根据companyId和type判断类型，公司内部账户companyId=0，其他为供应商id或者客户公司id
     * @param type type=0未指定，type=1公司账户，type=2媒体供应商账户,type=3客户账户
     * @return
     */
    @Select({"<script>",
            " SELECT id id,type type,company_id companyId,company_name companyName," +
                    " name name,bank_no bankNo, bank_name bankName, owner owner,phone phone," +
                    " balance balance, remark remark,state state," +
                    " creator creator,create_time createTime,update_user_id updateUserId," +
                    "update_time updateTime,docking_id dockingId" +
                " FROM fee_account " +
                " where company_id=#{companyId} and type=#{type} and state > -2 " +
                    " <when test='dockingId!=null and dockingId!=\"\"'>",
                    " AND docking_id = #{dockingId} ",
                    " </when>",
                    " <when test='companyNameQc!=null and companyNameQc!=\"\"'>",
                    " AND company_name like '%${companyNameQc}%'",
                    " </when>",
                    " <when test='nameQc!=null and nameQc!=\"\"'>",
                    " AND name like '%${nameQc}%'",
                    " </when>",
                    " <when test='bankNoQc!=null and bankNoQc!=\"\"'>",
                    " AND bank_no like '%${bankNoQc}%'",
                    " </when>",
                    " <when test='bankNameQc!=null and bankNameQc!=\"\"'>",
                    " AND bank_name like '%${bankNameQc}%'",
                    " </when>",
                    " <when test='ownerQc!=null and ownerQc!=\"\"'>",
                    " AND owner like '%${ownerQc}%'",
                    " </when>",
                " order by id desc ",
            "</script>"})
    List<Map> listPgForSelectAccount(Map map);

    @Insert("insert into fee_account_dept (account_id,dept_id) values (#{accountId},#{deptId})")
    void insertAccountDept(@Param("accountId") Integer accountId,@Param("deptId") Integer deptId) ;

    @Insert("delete from fee_account_dept where account_id=#{accountId} and dept_id=#{deptId}")
    void deleteAccountDept(@Param("accountId") Integer accountId,@Param("deptId") Integer deptId) ;

    @Insert("delete from fee_account_dept where account_id=#{accountId}")
    void deleteAccountDeptByAccountId(@Param("accountId") Integer accountId) ;

    @Select("select c.* from fee_account a,fee_account_dept b,sys_dept c where a.id=b.account_id and b.dept_id=c.id and a.state>-2 and c.state>-2 and a.id=#{id} ")
    List<Dept> queryDeptByAccountId(Integer id);
}
