namespace XueKao.Tool.SubForm
{
    partial class CreateWehChatQrCodeFrm
    {
        /// <summary>
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 清理所有正在使用的资源。
        /// </summary>
        /// <param name="disposing">如果应释放托管资源，为 true；否则为 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows 窗体设计器生成的代码

        /// <summary>
        /// 设计器支持所需的方法 - 不要
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.orgList = new System.Windows.Forms.ComboBox();
            this.btn_GenerateMenu = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.logoLabel = new System.Windows.Forms.Label();
            this.selLogoBtn = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(21, 26);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(59, 12);
            this.label1.TabIndex = 0;
            this.label1.Text = "Partner：";
            // 
            // orgList
            // 
            this.orgList.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.orgList.FormattingEnabled = true;
            this.orgList.Location = new System.Drawing.Point(86, 23);
            this.orgList.Name = "orgList";
            this.orgList.Size = new System.Drawing.Size(360, 20);
            this.orgList.TabIndex = 1;
            // 
            // btn_GenerateMenu
            // 
            this.btn_GenerateMenu.Location = new System.Drawing.Point(179, 109);
            this.btn_GenerateMenu.Name = "btn_GenerateMenu";
            this.btn_GenerateMenu.Size = new System.Drawing.Size(94, 23);
            this.btn_GenerateMenu.TabIndex = 2;
            this.btn_GenerateMenu.Text = "生成";
            this.btn_GenerateMenu.UseVisualStyleBackColor = true;
            this.btn_GenerateMenu.Click += new System.EventHandler(this.btn_GenerateMenu_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(23, 70);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(41, 12);
            this.label2.TabIndex = 3;
            this.label2.Text = "Logo：";
            // 
            // logoLabel
            // 
            this.logoLabel.AutoSize = true;
            this.logoLabel.Location = new System.Drawing.Point(177, 70);
            this.logoLabel.Name = "logoLabel";
            this.logoLabel.Size = new System.Drawing.Size(65, 12);
            this.logoLabel.TabIndex = 4;
            this.logoLabel.Text = "未选择LOGO";
            // 
            // selLogoBtn
            // 
            this.selLogoBtn.Location = new System.Drawing.Point(86, 65);
            this.selLogoBtn.Name = "selLogoBtn";
            this.selLogoBtn.Size = new System.Drawing.Size(75, 23);
            this.selLogoBtn.TabIndex = 5;
            this.selLogoBtn.Text = "选择LOGO";
            this.selLogoBtn.UseVisualStyleBackColor = true;
            this.selLogoBtn.Click += new System.EventHandler(this.selLogoBtn_Click);
            // 
            // CreateWehChatQrCodeFrm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(491, 144);
            this.Controls.Add(this.selLogoBtn);
            this.Controls.Add(this.logoLabel);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.btn_GenerateMenu);
            this.Controls.Add(this.orgList);
            this.Controls.Add(this.label1);
            this.MaximizeBox = false;
            this.Name = "CreateWehChatQrCodeFrm";
            this.Text = "生成微信关注二维码";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.ComboBox orgList;
        private System.Windows.Forms.Button btn_GenerateMenu;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label logoLabel;
        private System.Windows.Forms.Button selLogoBtn;
    }
}

