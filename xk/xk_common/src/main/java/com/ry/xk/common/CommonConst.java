package com.ry.xk.common;

/**
 * 公用常量类
 * 
 * @author 幸仁强
 */
public class CommonConst
{

    public static final String OSS_URL_SUFFIX = ".aliyuncs.com";

    public static final String OSS_INTERNAL_URL_SECTION = "-internal";

    // public static final String DESKEY = "RuanYun_XK_Key";

    // id秘钥
    public static final String IDDESKEY = "lQa9_&skzly%!9fs2@*UNA($ck_^:)'aI9e.^2Lbx9,5lf!j+~Hz@^hakuJ^crOb";

    // 试卷未购买状态
    public static final int WGM = 1;

    // 试卷已购买未测
    public static final int YGMWC = 2;

    // 试卷已购买已测
    public static final int YGMYC = 3;

    // 试卷已购买测试中
    public static final int YGMZZCSZ = 4;

    // 题目批改状态批改错误
    public static final int PGCY = 2;

    // 题目批改状态批改正确
    public static final int PGZQ = 1;

    // 题目批改状态未批改
    public static final int WPG = 3;

    //题目批改状态未做
    public static final int WZ = 0;

    // 返回结果成功
    public static final int resultTypeSuccess = 1;

    // 返回结果失败
    public static final int resultTypeFail = 2;

    // 分享图片类型发出去的
    public static final int SEND = 1;

    // 分享图片类型接收到的
    public static final int RECEIVE = 2;

    // 短文改错操作类型（插入=1、修改=2、删除=0）
    public static final int OPERATETYPE_DELETE = 0;

    public static final int OPERATETYPE_ADD = 1;

    public static final int OPERATETYPE_MODIFY = 2;

    // 判卷结果 0=未判卷，1=正确，2=半对，3=错误
    public static final int GRADINGRESULT_NOGRADING = 0;

    public static final int GRADINGRESULT_TRUE = 1;

    public static final int GRADINGRESULT_HAF_PARTLY = 2;

    public static final int GRADINGRESULT_WRONG = 3;

    // 判卷类型 0-未知，1-系统判卷，2-人工判卷
    public static final int GRADINGTYPE_UNKNOWN = 0;

    public static final int GRADINGTYPE_SYSTEM = 1;

    public static final int GRADINGTYPE_ARTIFICIAL = 2;

    // 做题状态 1-未做，2-已做，3-未交
    public static final int QUESTIONDOINGSTATUS_NOTDO = 1;

    public static final int QUESTIONDOINGSTATUS_DO = 2;

    public static final int QUESTIONDOINGSTATUS_NOTSUBMIT = 3;

    // 资源类型,1模拟卷
    public static final int RESOURCETYPE_EXAMEPAPER = 1;

    public static final int RT_SUC = 1;

    public static final int RT_FAIL = 2;

    public static final String RT_SUC_MSG = "执行成功";

    public static final String RT_FAIL_MSG = "执行失败";

    public static final String WCFDESKEY = "RuanYun_Motk_SecretKey";

    public static final int STATUS_FLAG_VALID = 1;// 有效

    public static final int STATUS_FLAG_INVALID = 0;// 失效

    public static final int EXAMPAPER_SUBMISSION = 2;// 已交

    public static final int EXAMPAPER_UNSUBMITTED = 1;// 未交
    // 用户资源类型为模拟测试卷

    public static final int EXAM_PAPER = 1;

    // 前端查询试卷查询全部
    public static final int ALL = 1;

    // 前端查询试卷查询已购买的
    public static final int BUYED = 2;

    // 试卷考试方式闭卷
    public static final int CLOSE_PAPER = 1;

    // 试卷考试方式开卷
    public static final int OPEN_PAPER = 2;

    // 题目做题方式类型，做题使用的题目展示方式,分为1客观题、2主观题和0
    public static final byte QUESTIONDOINGTYPE_DEFAULT = 0;

    public static final byte QUESTIONDOINGTYPE_OBJECTIVE = 1;

    public static final byte QUESTIONTYPE_SUBJECTIVE = 2;

    public static final int OPERATETYPE_INSERT = 1;

    public static final int FILLBLANKTYPEID_SINGLESPACE = 2;

    // 获取免费试卷失败
    public static final int FAIL = 0;

    // 获取免费试卷成功
    public static final int SUCCESS = 1;

    // 产品关联类型试卷
    public static final int PRODUCTSOURCETYPEID_EXAMPAPER = 1;

    public static final int MINUTE_110 = 110;
    //公共字典学段
    public static final int COMMONDICTIONARYTYPE_COUSETYPE = 1;
}