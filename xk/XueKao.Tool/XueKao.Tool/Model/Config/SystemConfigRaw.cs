using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace XueKao.Tool.Model.Config
{
    public class SystemConfigRaw
    {
        /// <summary>
        /// 配置项的ID
        /// </summary>
        public int ConfigId { get; set; }

        /// <summary>
        /// 配置项名称
        /// </summary>
        public string ConfigName { get; set; }

        /// <summary>
        /// 配置项的值
        /// </summary>
        public string ConfigValue { get; set; }

        /// <summary>
        /// 配置项的描述
        /// </summary>
        public string Description { get; set; }
    }
}
