using System.Configuration;
using RuanYun.DBUtility;

namespace XueKao.Tool.Helper
{
    /// <summary>
    /// 数据库访问层需要使用的基类，主要用来生成数据库连接环境
    /// </summary>
    public static class DataAccessBase
    {
        /// <summary>
        /// 连接字符串
        /// </summary>
        private static readonly string Conn;

        /// <summary>
        /// 构造函数
        /// </summary>
        static DataAccessBase()
        {
            Conn = ConfigurationManager.ConnectionStrings["MainDbPrefix"].ConnectionString;
        }

        /// <summary>
        /// 创建数据库连接对象
        /// </summary>
        /// <returns></returns>
        public static IDbContext GetDbContext()
        {
            return new DbContext().ConnectionString(Conn, new MySqlProvider());
        }
    }
}
