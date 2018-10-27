using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace XueKao.Tool.Model
{
    public class Partner
    {
        /// <summary>
        /// PartnerId
        /// </summary>
        public int PartnerId { set; get; }

        /// <summary>
        /// 合作伙伴
        /// </summary>
        public string PartnerName { set; get; }

        /// <summary>
        /// appid
        /// </summary>
        public string WeChatAppId { set; get; }

        /// <summary>
        /// AppSecret
        /// </summary>
        public string WeChatAppSecret { set; get; }

        /// <summary>
        /// 扩展信息
        /// </summary>
        public string PartnerExtension { set; get; }
    }

    public class PartnerExtension
    {
        public string WeChatMenuButton { set; get; }
    }
}
