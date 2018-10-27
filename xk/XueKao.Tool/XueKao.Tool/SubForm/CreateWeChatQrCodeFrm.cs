using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using XueKao.Tool.Helper;
using XueKao.Tool.WeChatAccessService;

namespace XueKao.Tool.SubForm
{
    public partial class CreateWeChatQrCodeFrm : Form
    {
        public CreateWeChatQrCodeFrm()
        {
            InitializeComponent();
        }

        private void createBtn_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrWhiteSpace(keyTextBox.Text) || string.IsNullOrWhiteSpace(secretTextBox.Text))
            {
                MessageBox.Show(@"appKey或appSecret为空", @"提示");
                return;
            }

            try
            {
                using (var weChatAccessService = new WeChatAccessServiceClient())
                {
                    var accessToken = WeChatHelper.GetAccessToken(keyTextBox.Text.Trim(), secretTextBox.Text.Trim());

                    var wcfRequest = new CreateQrRequest()
                    {
                        AccessToken = accessToken,
                        ExpireSeconds = 0,
                        SceneId = 1,
                        RequestFromType = RequestFromTypeEnum.Pc,
                        RequestTag = ServicesHelper.GetTimestampWithNet()
                    };

                    var url = weChatAccessService.CreateQrUrl(wcfRequest);

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
            catch (Exception ex)
            {
                MessageBox.Show(ex.ToString());
            }
        }

        private void selPicBtn_Click(object sender, EventArgs e)
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
