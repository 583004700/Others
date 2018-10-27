using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace XueKao.Tool.Model.Enum
{
    /// <summary>
    /// CouchBase的Bucket类别，一般以Bucket名称作为枚举值，前缀可以去掉，例如Motk-Common可用使用Common表示
    /// </summary>
    public enum CouchBaseSectionType
    {
        Main = 1,
        Examresult = 2,
    }
}
