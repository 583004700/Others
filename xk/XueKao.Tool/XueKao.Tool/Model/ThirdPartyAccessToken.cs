using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ProtoBuf;
using XueKao.Tool.Model.Enum;
using XueKao.Tool.Model.Interface;

namespace XueKao.Tool.Model
{
    /// <summary>
    /// accesstoken
    /// </summary>
    [ProtoContract]
    public class ThirdPartyAccessToken : ICouchBaseStoredObject
    {
        /// <summary>
        /// 基础AccessToken
        /// </summary>
        private const string _key = "ThirdPartyAccessToken_{0}";

        /// <summary>
        /// 缓存Bucket
        /// </summary>
        private const CouchBaseSectionType _couchBaseSectionType = CouchBaseSectionType.Main;

        /// <summary>
        ///  KeyFormat 格式
        /// </summary>
        public string KeyFormat
        {
            get { return _key; }
        }

        /// <summary>
        ///  在Couchbase中的Key值
        /// </summary>
        public string Key
        {
            get { return string.Format(KeyFormat, ParnterId); }
        }

        /// <summary>
        ///  获得CouchBase的Key
        /// </summary>
        /// <returns></returns>
        public static string GetKey(int parnterId)
        {
            return string.Format(_key, parnterId);
        }

        /// <summary>
        /// 获取对应的CouchBase信息
        /// </summary>
        /// <returns></returns>
        public static CouchBaseSectionType GetCouchBaseSection()
        {
            return _couchBaseSectionType;
        }

        /// <summary>
        /// CouchBaseSectionTypeEnum
        /// </summary>
        public CouchBaseSectionType CouchBaseSection
        {
            get { return _couchBaseSectionType; }
        }

        [ProtoMember(1)]
        public int ParnterId { set; get; }

        /// <summary>
        /// 授权令牌
        /// </summary>
        [ProtoMember(2)]
        public string AccessToken { get; set; }

        /// <summary>
        /// 过期时间
        /// </summary>
        [ProtoMember(3)]
        public int ExpiresIn { get; set; }

        /// <summary>
        /// 更新时间（毫秒）
        /// </summary>
        [ProtoMember(4)]
        public long RefreshTicks { get; set; }

        /// <summary>
        /// 获取实例
        /// </summary>
        /// <param name="accessToken"></param>
        /// <param name="expiresIn"></param>
        /// <param name="refreshTickes"></param>
        /// <returns>需要创建的实例</returns>
        public static ThirdPartyAccessToken GetThirdPartyAccessToken(string accessToken, int expiresIn,
            long refreshTickes)
        {
            return new ThirdPartyAccessToken
            {
                AccessToken = accessToken,
                ExpiresIn = expiresIn,
                RefreshTicks = refreshTickes
            };
        }
    }
}
