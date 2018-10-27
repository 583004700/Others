using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace XueKao.Tool.Model
{
    /// <summary>
    /// 保存accesstoken请求参数
    /// </summary>
    public class UpdateThirdPartyAccessTokenRequest 
    {
        /// <summary>
        /// 授权令牌
        /// </summary>
        public string AccessToken { get; set; }

        /// <summary>
        /// 过期时间
        /// </summary>
        public int ExpiresIn { get; set; }

        /// <summary>
        /// 更新时间（毫秒）
        /// </summary>
        public long RefreshTicks { get; set; }
    }
}
