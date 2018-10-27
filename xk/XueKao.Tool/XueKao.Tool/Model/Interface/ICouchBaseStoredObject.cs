using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using XueKao.Tool.Model.Enum;

namespace XueKao.Tool.Model.Interface
{
    /// <summary>
    ///  所有存放在CouchBase中的Object必须
    ///  继承的. 负责处理Key值
    /// </summary>
    public interface ICouchBaseStoredObject
    {
        /// <summary>
        ///  在CouchBase中的Key
        /// </summary>
        string Key { get; }

        /// <summary>
        ///  Key的格式
        /// </summary>
        string KeyFormat { get; }

        /// <summary>
        ///  将存储到哪个Bucket
        /// </summary>
        CouchBaseSectionType CouchBaseSection { get; }
    }
}
