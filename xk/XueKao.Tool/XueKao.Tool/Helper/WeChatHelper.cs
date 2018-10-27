using System;
using System.Globalization;
using System.Linq;
using XueKao.Tool.Couchbase;
using XueKao.Tool.ExternalMethod;
using XueKao.Tool.Model;
using XueKao.Tool.Model.Config;
using XueKao.Tool.WeChatAccessService;

namespace XueKao.Tool.Helper
{
    /// <summary>
    /// 微信帮助类
    /// </summary>
    public class WeChatHelper
    {
        /// <summary>
        /// 获取缓存时锁
        /// </summary>
        private static readonly object _lock = new object();

        /// <summary>
        /// Secret密钥
        /// </summary>
        private const string SecretKey = "RuanYun_Motk_SecretKey";

        /// <summary>
        /// 缓存时间
        /// </summary>
        private const int TimeOut = 110;

        /// <summary>
        /// 获取accesstoken
        /// </summary>
        /// <param name="parnterId"></param>
        /// <returns></returns>
        public static string GetAcceccToken(int parnterId)
        {
            var config = QueryHelper.GetSystemConfig();
            var token = GetValidToken(parnterId, config);
            return token.AccessToken;
        }

        public static string GetAccessToken(string appKey, string appSecret)
        {
            var token = GetValidToken(appKey, appSecret);
            return token;
        }

        private static string GetValidToken(string appKey, string appSecret)
        {
            using (var service = new WeChatAccessServiceClient())
            {
                var request = new GetWeChatAccessTokenRequest()
                {
                    AppKey = appKey,
                    AppSecret = appSecret,
                    RequestFromType = RequestFromTypeEnum.Pc,
                    RequestTag = DateTime.Now.ToString(CultureInfo.InvariantCulture).Encrypt3DesWithNet(SecretKey)
                };

                var weChatToken = service.GetAccessToken(request);

                return weChatToken.AccessToken;
            }
        }

        /// <summary>
        /// 获取有效的AccessToken并判断更新CouchBase
        /// 为避免因业务处理造成的时间差，AccessToken的CouchBase有效期提前10分钟失效
        /// </summary>
        /// <returns></returns>
        private static ThirdPartyAccessToken GetValidToken(int parnterId, SystemConfig systemConfig)
        {
            var parnter = QueryHelper.GteAllPartners().FirstOrDefault(p => p.PartnerId == parnterId);
            using (var service = new WeChatAccessServiceClient())
            {
                var accessTokenResultV1 = GetAccesstokenByParnterId(parnterId);
                if (accessTokenResultV1 != null && DateTime.Now < new DateTime(accessTokenResultV1.RefreshTicks).AddSeconds(accessTokenResultV1.ExpiresIn)) return accessTokenResultV1;
                lock (_lock)
                {
                    var accessTokenResultV2 = GetAccesstokenByParnterId(parnterId); ;
                    if (accessTokenResultV2 == null || (accessTokenResultV1 != null && accessTokenResultV1.AccessToken == accessTokenResultV2.AccessToken))
                    {
                        var request = new GetWeChatAccessTokenRequest()
                        {
                            AppKey = CryptogramHelper.Decrypt3DESWithTrueKey(parnter.WeChatAppId, systemConfig.ConfigKey),
                            AppSecret = CryptogramHelper.Decrypt3DESWithTrueKey(parnter.WeChatAppSecret, systemConfig.ConfigKey),
                            RequestFromType = RequestFromTypeEnum.Java,
                            RequestTag = DateTime.Now.ToString(CultureInfo.InvariantCulture).Encrypt3Des(SecretKey)
                        };
                        var weChatToken = service.GetAccessToken(request);
                        var updateThirdPartyAccessTokenRequest = weChatToken == null ? null : new UpdateThirdPartyAccessTokenRequest() { AccessToken = weChatToken.AccessToken, ExpiresIn = weChatToken.ExpiresIn - 10 * 60, RefreshTicks = weChatToken.RefreshTick };
                        accessTokenResultV2 = GetAccesstokenByParnterId(parnterId); ;
                        if (updateThirdPartyAccessTokenRequest != null && (accessTokenResultV2 == null || accessTokenResultV2.RefreshTicks < updateThirdPartyAccessTokenRequest.RefreshTicks))
                        {
                            SaveAccesstoken(parnterId, weChatToken.AccessToken, weChatToken.ExpiresIn - 10 * 60,
                                weChatToken.RefreshTick);
                            return new ThirdPartyAccessToken() { AccessToken = updateThirdPartyAccessTokenRequest.AccessToken, ExpiresIn = updateThirdPartyAccessTokenRequest.ExpiresIn, RefreshTicks = updateThirdPartyAccessTokenRequest.RefreshTicks };
                        }
                    }
                    return accessTokenResultV2;
                }
            }
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="parnterId"></param>
        /// <returns></returns>
        private static ThirdPartyAccessToken GetAccesstokenByParnterId(int parnterId)
        {
            return CouchBaseFactory.Get<ThirdPartyAccessToken>(parnterId);
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="parnterId"></param>
        /// <param name="accessToken"></param>
        /// <param name="expiresIn"></param>
        /// <param name="refreshTicks"></param>
        public static void SaveAccesstoken(int parnterId, string accessToken, int expiresIn, long refreshTicks)
        {
            var token = new ThirdPartyAccessToken()
            {
                ParnterId = parnterId,
                AccessToken = accessToken,
                ExpiresIn = expiresIn,
                RefreshTicks = refreshTicks
            };
            CouchBaseFactory.Update(token, (expiresIn / 60 > TimeOut ? TimeOut : expiresIn / 60));
        }
    }
}
