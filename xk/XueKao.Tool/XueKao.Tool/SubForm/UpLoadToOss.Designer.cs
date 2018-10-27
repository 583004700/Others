namespace XueKao.Tool.SubForm
{
    partial class UpLoadToOss
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

        #region Windows 窗体设计器生成的代码

        /// <summary>
        /// 设计器支持所需的方法 - 不要
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            this.upload = new System.Windows.Forms.Button();
            this.textPanel = new System.Windows.Forms.TextBox();
            this.directories = new System.Windows.Forms.ComboBox();
            this.openFileDialog1 = new System.Windows.Forms.OpenFileDialog();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.buckets = new System.Windows.Forms.ComboBox();
            this.label3 = new System.Windows.Forms.Label();
            this.chkBoxIsConver = new System.Windows.Forms.CheckBox();
            this.SuspendLayout();
            // 
            // upload
            // 
            this.upload.Location = new System.Drawing.Point(211, 12);
            this.upload.Name = "upload";
            this.upload.Size = new System.Drawing.Size(61, 45);
            this.upload.TabIndex = 0;
            this.upload.Text = "上传文件";
            this.upload.UseVisualStyleBackColor = true;
            this.upload.Click += new System.EventHandler(this.upload_Click);
            // 
            // textPanel
            // 
            this.textPanel.Location = new System.Drawing.Point(12, 81);
            this.textPanel.Multiline = true;
            this.textPanel.Name = "textPanel";
            this.textPanel.ReadOnly = true;
            this.textPanel.Size = new System.Drawing.Size(260, 168);
            this.textPanel.TabIndex = 1;
            // 
            // directories
            // 
            this.directories.FormattingEnabled = true;
            this.directories.Location = new System.Drawing.Point(53, 14);
            this.directories.Name = "directories";
            this.directories.Size = new System.Drawing.Size(138, 20);
            this.directories.TabIndex = 2;
            // 
            // openFileDialog1
            // 
            this.openFileDialog1.FileName = "openFileDialog1";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 17);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(35, 12);
            this.label1.TabIndex = 3;
            this.label1.Text = "目录:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(12, 40);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(47, 12);
            this.label2.TabIndex = 5;
            this.label2.Text = "Bucket:";
            // 
            // buckets
            // 
            this.buckets.FormattingEnabled = true;
            this.buckets.Location = new System.Drawing.Point(65, 37);
            this.buckets.Name = "buckets";
            this.buckets.Size = new System.Drawing.Size(126, 20);
            this.buckets.TabIndex = 4;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(10, 62);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(107, 12);
            this.label3.TabIndex = 6;
            this.label3.Text = "是否覆盖原有文件:";
            // 
            // chkBoxIsConver
            // 
            this.chkBoxIsConver.AutoSize = true;
            this.chkBoxIsConver.Location = new System.Drawing.Point(124, 62);
            this.chkBoxIsConver.Name = "chkBoxIsConver";
            this.chkBoxIsConver.Size = new System.Drawing.Size(48, 16);
            this.chkBoxIsConver.TabIndex = 7;
            this.chkBoxIsConver.Text = "覆盖";
            this.chkBoxIsConver.UseVisualStyleBackColor = true;
            // 
            // UpLoadToOss
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(284, 261);
            this.Controls.Add(this.chkBoxIsConver);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.buckets);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.directories);
            this.Controls.Add(this.textPanel);
            this.Controls.Add(this.upload);
            this.Name = "UpLoadToOss";
            this.Text = "Oss文件上传小工具";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button upload;
        private System.Windows.Forms.TextBox textPanel;
        private System.Windows.Forms.ComboBox directories;
        private System.Windows.Forms.OpenFileDialog openFileDialog1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.ComboBox buckets;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.CheckBox chkBoxIsConver;
    }
}