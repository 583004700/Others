using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using XueKao.Tool.SubForm;

namespace XueKao.Tool
{
    public partial class MainFrm : Form
    {
        public MainFrm()
        {
            InitializeComponent();
        }

        /// <summary>
        /// 上传文件至oss
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void upFileToOss_Click(object sender, EventArgs e)
        {

        }

        /// <summary>
        /// 创建公众号菜单
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void createWeChatMenu_Click(object sender, EventArgs e)
        {
            var frm = new CreateWehChatMenuFrm();
            frm.Show();
        }

        /// <summary>
        /// 创建公众号二维码
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void createWeChatQrCode_Click(object sender, EventArgs e)
        {
            var frm = new CreateWehChatQrCodeFrm();
            frm.Show();
        }

        private void createQrCode_Click(object sender, EventArgs e)
        {
            var frm = new CreateWeChatQrCodeFrm();
            frm.Show();
        }
    }
}
