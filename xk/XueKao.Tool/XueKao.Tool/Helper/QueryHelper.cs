using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using RuanYun.Common;
using XueKao.Tool.Model;
using XueKao.Tool.Model.Config;

namespace XueKao.Tool.Helper
{
    public class QueryHelper
    {
        /// <summary>
        /// sysconfig
        /// </summary>
        private static SystemConfig _config;

        /// <summary>
        /// 锁
        /// </summary>
        private static object _lock = new object();

        /// <summary>
        /// 获取所有配置
        /// </summary>
        /// <returns></returns>
        public static SystemConfig GetSystemConfig()
        {
            lock (_lock)
            {
                if (_config != null)
                {
                    return _config;
                }
                 var dbContext = DataAccessBase.GetDbContext();
                 var config = dbContext.Sql("SELECT ConfigID,ConfigName,ConfigValue,Description FROM systemconfig").QueryMany<SystemConfigRaw>()
                     .BuildObjectFromRow<SystemConfig, SystemConfigRaw>("ConfigName", "ConfigValue");
                return config;
            }
        }

        public static List<CouchBaseConfig> GetAllCouchBaseConfig()
        {
            var dbContext = DataAccessBase.GetDbContext();
            return dbContext.Sql("SELECT CouchBaseConfigID,CouchBaseConfigName,CouchBaseConfigValue,Enabled FROM couchbaseconfig")
                .QueryMany<CouchBaseConfig>();
        }

        /// <summary>
        /// 获取所有合作伙伴
        /// </summary>
        /// <returns></returns>
        public static List<Partner> GteAllPartners()
        {
            var dbContext = DataAccessBase.GetDbContext();
            var sql = "SELECT * FROM partner ORDER BY PartnerID ";
            return  dbContext.Sql(sql).QueryMany<Partner>();
        }
    }
}
