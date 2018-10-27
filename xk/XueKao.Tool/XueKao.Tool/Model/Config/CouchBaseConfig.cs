using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace XueKao.Tool.Model.Config
{
    /// <summary>
    ///CouchBase配置 对应CouchBaseConfig表
    /// </summary>
    [Serializable]
    public class CouchBaseConfig
    {
        /// <summary>
        /// CouchBase配置ID
        /// </summary>
        public int CouchBaseConfigId { get; set; }

        /// <summary>
        /// CouchBase配置名称
        /// </summary>
        public string CouchBaseConfigName { get; set; }

        /// <summary>
        /// CouchBase配置
        /// </summary>
        public string CouchBaseConfigValue { get; set; }

        /// <summary>
        /// 该配置是否有效
        /// </summary>
        public bool Enabled { get; set; }
    }
}
