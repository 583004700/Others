using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace XueKao.Tool.Helper
{
    public class ServicesHelper
    {
        /// <summary>
        /// 获取第三方wcf调用时间戳
        /// </summary>
        /// <returns></returns>
        public static string GetTimestamp()
        {
            return CryptogramHelper.Encrypt3DESWithTrueKey(DateTime.Now.ToString(), "RuanYun_Motk_SecretKey");
        }

        /// <summary>
        /// 获取第三方wcf调用时间戳
        /// </summary>
        /// <returns></returns>
        public static string GetTimestampWithNet()
        {
            return CryptogramHelper.Encrypt3DES(DateTime.Now.ToString(), "RuanYun_Motk_SecretKey");
        }
    }
}
