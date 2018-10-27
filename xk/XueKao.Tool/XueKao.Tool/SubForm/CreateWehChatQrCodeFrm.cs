using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Configuration;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using XueKao.Tool.Helper;
using System.Configuration;
using System.IO;
using System.Web;
using Newtonsoft.Json;
using RuanYun.DBUtility;
using ThoughtWorks.QRCode.Codec;
using XueKao.Tool.Model;
using XueKao.Tool.WeChatAccessService;

namespace XueKao.Tool.SubForm
{
    public partial class CreateWehChatQrCodeFrm : Form
    {
        /// <summary>
        /// 合作伙伴信息
        /// </summary>
        private List<Partner> _partners;

        /// <summary>
        /// 构造函数
        /// </summary>
        public CreateWehChatQrCodeFrm()
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
                using (var weChatAccessService = new WeChatAccessServiceClient())
                {
                    var accessToken = WeChatHelper.GetAcceccToken(partnerId);
                    var wcfRequest = new CreateQrRequest()
                    {
                        AccessToken = accessToken,
                        ExpireSeconds = 0,
                        SceneId = 1,
                        RequestFromType = RequestFromTypeEnum.Java,
                        RequestTag = ServicesHelper.GetTimestamp()
                    };
                    var url = weChatAccessService.CreateQrUrl(wcfRequest);
                    /*
                    var shortUrlWcfRequest = new ShortUrlRequest()
                    {
                        AccessToken = accessToken,
                        Long_Url = weChatAccessService.CreateQrUrl(wcfRequest),
                        RequestFromType = RequestFromTypeEnum.Java,
                        RequestTag = GetTimestamp()
                    };
                    var url = weChatAccessService.ShortUrl(shortUrlWcfRequest);
                    */
                    if (string.IsNullOrEmpty(url))
                    {
                        MessageBox.Show(@"生成二维码失败", @"提示");
                        return;
                    }
                    var qrCode = QrCodeHelper.CreateQrCode(url);

                    if (logoLabel.Text != "未选择LOGO" && File.Exists(logoLabel.Text))
                    {
                        // 如果选择了logo，则在二维码中加入logo图片
                        qrCode = QrCodeHelper.MergeQrImg(qrCode, new Bitmap(logoLabel.Text));
                    }

                    var file = new SaveFileDialog { Filter = "|*.jpg" };
                    file.ShowDialog();
                    var path = file.FileName;
                    if (path != "")
                    {
                        qrCode.Save(path);
                    }
                }
            }
            catch (Exception exc)
            {
                MessageBox.Show(exc.ToString());
            }
        }

        private void selLogoBtn_Click(object sender, EventArgs e)
        {
            OpenFileDialog file = new OpenFileDialog();

            file.Multiselect = false;
            file.Title = "请选择图片";
            file.Filter = "|*.jpg;*.png";

            if (file.ShowDialog() == DialogResult.OK)
            {
                logoLabel.Text = file.FileName;
            }
        }
    }
}
