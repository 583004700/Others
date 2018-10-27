using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;
using XueKao.Tool.Helper;
using System.IO;
using System.Web;
using Newtonsoft.Json;
using XueKao.Tool.Model;
using XueKao.Tool.WeChatAccessService;

namespace XueKao.Tool.SubForm
{
    public partial class CreateWehChatMenuFrm : Form
    {
        /// <summary>
        /// 合作伙伴信息
        /// </summary>
        private List<Partner> _partners;

        /// <summary>
        /// 全局密钥(64位)
        /// </summary>
        private static readonly string Key = "lQa9_&skzly%!9fs2@*UNA($ck_^:)'aI9e.^2Lbx9,5lf!j+~Hz@^hakuJ^crOb";

        /// <summary>
        /// 构造函数
        /// </summary>
        public CreateWehChatMenuFrm()
        {
            InitializeComponent();
            _partners = QueryHelper.GteAllPartners();
            BindOrgList();
        }
        
        /// <summary>
        /// 绑定机构列表
        /// </summary>
        private void BindOrgList()
        {
            if (_partners.Count == 0)
            {
                return;
            }
            var list = _partners.Select(p => p.PartnerId + "|" + p.PartnerName).ToList();
            orgList.DataSource = list;
        }

        /// <summary>
        /// 创建按钮
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void btn_GenerateMenu_Click(object sender, EventArgs e)
        {
            var text = orgList.Text;
            if (text == "")
            {
                MessageBox.Show(@"请先选择机构", @"提示");
                return;
            }
            var arr = text.Split('|');
            var partnerId = int.Parse(arr[0]);
            try
            {
                CreateMenu(partnerId);
            }
            catch (Exception exc)
            {
                MessageBox.Show(exc.ToString());
            }
        }

        /// <summary>
        /// 创建菜单
        /// </summary>
        /// <param name="partnerId"></param>
        private void CreateMenu(int partnerId)
        {
            var partner = _partners.FirstOrDefault(p => p.PartnerId == partnerId);
            var sysConfig = QueryHelper.GetSystemConfig();
            var appId = CryptogramHelper.Decrypt3DESWithTrueKey(partner.WeChatAppId, sysConfig.ConfigKey);
            var orgId = HttpUtility.UrlEncode(CryptogramHelper.Encrypt3DESWithTrueKey(partnerId.ToString(), Key));
            var weChatAccessService = new WeChatAccessServiceClient();
            var listUrl = weChatAccessService.GetAuthorizationUrl(
                new GetAuthorizeUrlRequest()
                {
                    AppId = appId,
                    RedirectUrl = string.Format("{0}examPaper?orgId={1}", sysConfig.H5Host, orgId),
                    RequestFromType = RequestFromTypeEnum.Java,
                    RequestTag = ServicesHelper.GetTimestamp()
                });

            var buyedUrl = weChatAccessService.GetAuthorizationUrl(
                new GetAuthorizeUrlRequest()
                {
                    AppId = appId,
                    RedirectUrl = string.Format("{0}examPaper/list?status=2&orgId={1}", sysConfig.H5Host, orgId),
                    RequestFromType = RequestFromTypeEnum.Java,
                    RequestTag = ServicesHelper.GetTimestamp()
                });

            var wrongBookUrl = weChatAccessService.GetAuthorizationUrl(
                new GetAuthorizeUrlRequest()
                {
                    AppId = appId,
                    RedirectUrl = string.Format("{0}wrongbook?orgId={1}", sysConfig.H5Host, orgId),
                    RequestFromType = RequestFromTypeEnum.Java,
                    RequestTag = ServicesHelper.GetTimestamp()
                });
            var extension = JsonConvert.DeserializeObject<PartnerExtension>(partner.PartnerExtension);
            if (extension == null || string.IsNullOrEmpty(extension.WeChatMenuButton))
            {
                MessageBox.Show(@"未配置公众号菜单按钮json", @"提示");
                return;
            }
            var accessToken = WeChatHelper.GetAcceccToken(partnerId);
            if (string.IsNullOrEmpty(accessToken))
            {
                MessageBox.Show(@"获取AccessToken失败", @"提示");
                return;
            }
            extension.WeChatMenuButton =
                extension.WeChatMenuButton.Replace("[list]", listUrl.Url)
                    .Replace("[buyed]", buyedUrl.Url)
                    .Replace("[wrongbook]", wrongBookUrl.Url);
            var wcfRequest = new CreateWeChatMenuRequest()
            {
                AccessToken = accessToken,
                Button = extension.WeChatMenuButton,
                RequestFromType = RequestFromTypeEnum.Java,
                RequestTag = ServicesHelper.GetTimestamp()
            };
            var ret = weChatAccessService.CreateMenu(wcfRequest);
            if (ret.errmsg != "")
            {
                MessageBox.Show(ret.errmsg, @"提示");
                return;
            }
            MessageBox.Show(@"生成成功", @"提示");
        }

        #region Test
        private void SendMessage()
        {
            var uri = new Uri("http://10.0.3.41:8888/api/a/get");

            var template = File.ReadAllText(AppDomain.CurrentDomain.BaseDirectory + "Template/template.txt");
            var weChatAccessService = new WeChatAccessServiceClient();
            var list = new List<string>()
            {
                "oog24w04IUoudk80PkozlROB5RpA",
                "oog24wwpJWpa-l5UNrm1RyYRIoOQ",
                "oog24wyeGpmKsrFDZwGJE2KCQSL0",
                "oog24w3ON1kR-7x2R_UqJK-rUvTQ",
                "oog24w1RkNmE3cussYKS-Eeph1Is",
                "oog24w7ocDUsQF9z4DorIWXyfPyI",
                "oog24wxGz68s6Ucu_ukJ4q_bvytk",
                "oog24ww_xlWJonxRZr-xCDTe1-0M",
                "oog24w72N6oDKVTciz_R3xiefRH8",
                "oog24w8717VqzBmPpzeaJRVfnQbM",
                "oog24w0SD_MAJ0BQdu5c1_GYSY4E",
                "oog24w--CgxuULKJWX0ixAt4JspQ",
                "oog24w_JYGgqnMQjWtAPRvdym2Dk",
                "oog24w3K4Cx0PAPqNDtqM-EFmEgQ",
                "oog24w92BTWFCkcgWHGmW7fdHE_s",
                "oog24w8az1xYJgS97jWTkByYkeH8",
                "oog24w8bIhH-Fp5ZMGhL0KhUQLF8",
                "oog24w_2HjMwHstJFCogMWJcuDsI",
                "oog24w-ymWL5uWnc3ccOaqvyhLlg",
                "oog24wzDqXQ-hPJERLTufzj9Ohmk"
            };
            foreach (var openId in list)
            {
                var json = string.Format(template, openId, "", "您好，您已经支付成功", "#173177", "江西省普通高中学业水平考试复习模拟测试——语文（一）", "#173177", "", "#173177", "2元", "#173177", "付款时间：" + DateTime.Now.ToString("yyyy-MM-dd HH:mm"), "#173177");
                var wcfRequest = new TemplateMesageSendRequest()
                {
                    AccessToken = "10_Wqh-sAmvMy5J097NwqKvto_ZnwJ-WQd2fdUB60xpIuxP_uUoIqOVTWLUrPQx4arSciHs-QNW-a-adiv1oZrGeKTe_jH3mqTDZhcJJmQNrtyD6MHGteuqD1oiYLPERqiasXdfEAYozeFdqKPUDNUeAGAOYF",
                    Text = json,
                    RequestFromType = RequestFromTypeEnum.Java,
                    RequestTag = CryptogramHelper.Encrypt3DES(DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss"), "RuanYun_Motk_SecretKey")
                };
                weChatAccessService.TemplateMesageSend(wcfRequest);
            }
        }
        #endregion
    }
}
