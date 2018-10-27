namespace XueKao.Tool
{
    partial class MainFrm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.微信相关操作ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.createWeChatMenu = new System.Windows.Forms.ToolStripMenuItem();
            this.createWeChatQrCode = new System.Windows.Forms.ToolStripMenuItem();
            this.阿里云相关操作ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.upFileToOss = new System.Windows.Forms.ToolStripMenuItem();
            this.createQrCode = new System.Windows.Forms.ToolStripMenuItem();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.微信相关操作ToolStripMenuItem,
            this.阿里云相关操作ToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(663, 25);
            this.menuStrip1.TabIndex = 0;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // 微信相关操作ToolStripMenuItem
            // 
            this.微信相关操作ToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.createWeChatMenu,
            this.createWeChatQrCode,
            this.createQrCode});
            this.微信相关操作ToolStripMenuItem.Name = "微信相关操作ToolStripMenuItem";
            this.微信相关操作ToolStripMenuItem.Size = new System.Drawing.Size(92, 21);
            this.微信相关操作ToolStripMenuItem.Text = "微信相关操作";
            // 
            // createWeChatMenu
            // 
            this.createWeChatMenu.Name = "createWeChatMenu";
            this.createWeChatMenu.Size = new System.Drawing.Size(184, 22);
            this.createWeChatMenu.Text = "生成公众号菜单";
            this.createWeChatMenu.Click += new System.EventHandler(this.createWeChatMenu_Click);
            // 
            // createWeChatQrCode
            // 
            this.createWeChatQrCode.Name = "createWeChatQrCode";
            this.createWeChatQrCode.Size = new System.Drawing.Size(184, 22);
            this.createWeChatQrCode.Text = "生成公众号二维码";
            this.createWeChatQrCode.Click += new System.EventHandler(this.createWeChatQrCode_Click);
            // 
            // 阿里云相关操作ToolStripMenuItem
            // 
            this.阿里云相关操作ToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.upFileToOss});
            this.阿里云相关操作ToolStripMenuItem.Name = "阿里云相关操作ToolStripMenuItem";
            this.阿里云相关操作ToolStripMenuItem.Size = new System.Drawing.Size(104, 21);
            this.阿里云相关操作ToolStripMenuItem.Text = "阿里云相关操作";
            // 
            // upFileToOss
            // 
            this.upFileToOss.Name = "upFileToOss";
            this.upFileToOss.Size = new System.Drawing.Size(124, 22);
            this.upFileToOss.Text = "上传文件";
            this.upFileToOss.Click += new System.EventHandler(this.upFileToOss_Click);
            // 
            // createQrCode
            // 
            this.createQrCode.Name = "createQrCode";
            this.createQrCode.Size = new System.Drawing.Size(184, 22);
            this.createQrCode.Text = "生成二维码（可填）";
            this.createQrCode.Click += new System.EventHandler(this.createQrCode_Click);
            // 
            // MainFrm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(663, 67);
            this.Controls.Add(this.menuStrip1);
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "MainFrm";
            this.Text = "MainFrm";
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem 微信相关操作ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem createWeChatMenu;
        private System.Windows.Forms.ToolStripMenuItem createWeChatQrCode;
        private System.Windows.Forms.ToolStripMenuItem 阿里云相关操作ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem upFileToOss;
        private System.Windows.Forms.ToolStripMenuItem createQrCode;
    }
}