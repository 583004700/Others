namespace XueKao.Tool.SubForm
{
    partial class CreateWeChatQrCodeFrm
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
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.keyTextBox = new System.Windows.Forms.TextBox();
            this.secretTextBox = new System.Windows.Forms.TextBox();
            this.createBtn = new System.Windows.Forms.Button();
            this.label3 = new System.Windows.Forms.Label();
            this.selPicBtn = new System.Windows.Forms.Button();
            this.logoLabel = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 35);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(47, 12);
            this.label1.TabIndex = 0;
            this.label1.Text = "AppKey:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(12, 87);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(65, 12);
            this.label2.TabIndex = 1;
            this.label2.Text = "AppSecret:";
            // 
            // keyTextBox
            // 
            this.keyTextBox.Location = new System.Drawing.Point(74, 32);
            this.keyTextBox.Name = "keyTextBox";
            this.keyTextBox.Size = new System.Drawing.Size(238, 21);
            this.keyTextBox.TabIndex = 2;
            // 
            // secretTextBox
            // 
            this.secretTextBox.Location = new System.Drawing.Point(74, 84);
            this.secretTextBox.Name = "secretTextBox";
            this.secretTextBox.Size = new System.Drawing.Size(238, 21);
            this.secretTextBox.TabIndex = 3;
            // 
            // createBtn
            // 
            this.createBtn.Location = new System.Drawing.Point(237, 186);
            this.createBtn.Name = "createBtn";
            this.createBtn.Size = new System.Drawing.Size(75, 23);
            this.createBtn.TabIndex = 4;
            this.createBtn.Text = "生 成";
            this.createBtn.UseVisualStyleBackColor = true;
            this.createBtn.Click += new System.EventHandler(this.createBtn_Click);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(12, 139);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(35, 12);
            this.label3.TabIndex = 5;
            this.label3.Text = "Logo:";
            // 
            // selPicBtn
            // 
            this.selPicBtn.Location = new System.Drawing.Point(74, 134);
            this.selPicBtn.Name = "selPicBtn";
            this.selPicBtn.Size = new System.Drawing.Size(75, 23);
            this.selPicBtn.TabIndex = 7;
            this.selPicBtn.Text = "选择图片";
            this.selPicBtn.UseVisualStyleBackColor = true;
            this.selPicBtn.Click += new System.EventHandler(this.selPicBtn_Click);
            // 
            // logoLabel
            // 
            this.logoLabel.AutoSize = true;
            this.logoLabel.Location = new System.Drawing.Point(155, 139);
            this.logoLabel.Name = "logoLabel";
            this.logoLabel.Size = new System.Drawing.Size(65, 12);
            this.logoLabel.TabIndex = 8;
            this.logoLabel.Text = "未选择LOGO";
            // 
            // CreateWeChatQrCodeFrm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(344, 221);
            this.Controls.Add(this.logoLabel);
            this.Controls.Add(this.selPicBtn);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.createBtn);
            this.Controls.Add(this.secretTextBox);
            this.Controls.Add(this.keyTextBox);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Name = "CreateWeChatQrCodeFrm";
            this.Text = "生成微信二维码";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox keyTextBox;
        private System.Windows.Forms.TextBox secretTextBox;
        private System.Windows.Forms.Button createBtn;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button selPicBtn;
        private System.Windows.Forms.Label logoLabel;
    }
}