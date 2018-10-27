package com.ry.xk.common.bo;

public class SystemConfig
{

    private String configKey;

    private String aliyunAccessKey;

    private String aliyunBaseUrl;

    private String aliyunAccessId;

    private String aliyunDownloadBaseUrl;

    private String printResultReportApiUrl;

    private String h5Host;

    private String examPaperCoverPath;

    // 结果通知模板
    private String payedNotifyTemplate;

    // 文件
    private String yjpFileHost;

    public String getConfigKey()
    {
        return configKey;
    }

    public void setConfigKey(String configKey)
    {
        this.configKey = configKey;
    }

    public String getAliyunAccessKey()
    {
        return aliyunAccessKey;
    }

    public void setAliyunAccessKey(String aliyunAccessKey)
    {
        this.aliyunAccessKey = aliyunAccessKey;
    }

    public String getAliyunBaseUrl()
    {
        return aliyunBaseUrl;
    }

    public void setAliyunBaseUrl(String aliyunBaseUrl)
    {
        this.aliyunBaseUrl = aliyunBaseUrl;
    }

    public String getAliyunDownloadBaseUrl()
    {
        return aliyunDownloadBaseUrl;
    }

    public void setAliyunDownloadBaseUrl(String aliyunDownloadBaseUrl)
    {
        this.aliyunDownloadBaseUrl = aliyunDownloadBaseUrl;
    }

    public String getPrintResultReportApiUrl()
    {
        return printResultReportApiUrl;
    }

    public void setPrintResultReportApiUrl(String printResultReportApiUrl)
    {
        this.printResultReportApiUrl = printResultReportApiUrl;
    }

    public String getH5Host()
    {
        return h5Host;
    }

    public void setH5Host(String h5Host)
    {
        this.h5Host = h5Host;
    }

    public String getExamPaperCoverPath()
    {
        return examPaperCoverPath;
    }

    public void setExamPaperCoverPath(String examPaperCoverPath)
    {
        this.examPaperCoverPath = examPaperCoverPath;
    }

    public String getAliyunAccessId()
    {
        return aliyunAccessId;
    }

    public void setAliyunAccessId(String aliyunAccessId)
    {
        this.aliyunAccessId = aliyunAccessId;
    }

    public String getPayedNotifyTemplate()
    {
        return payedNotifyTemplate;
    }

    public void setPayedNotifyTemplate(String payedNotifyTemplate)
    {
        this.payedNotifyTemplate = payedNotifyTemplate;
    }

    public String getYjpFileHost()
    {
        return yjpFileHost;
    }

    public void setYjpFileHost(String yjpFileHost)
    {
        this.yjpFileHost = yjpFileHost;
    }
}
