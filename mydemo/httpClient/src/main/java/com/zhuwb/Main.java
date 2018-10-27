package com.zhuwb;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.Map;


public class Main implements Runnable{
    private String examPaperId = "";
    private String questionId = "";
    private String questionOptionGroupId = "";

    public Main(){}
    public Main(String examPaperId,String questionId,String questionOptionGroupId){
        this.examPaperId = examPaperId;
        this.questionId = questionId;
        this.questionOptionGroupId = questionOptionGroupId;
    }

    public static void main(String[] args) throws Exception {
        Map<String,String> params = new HashMap<String, String>();
        /*params.put("passengerTicketStr","1,0,1,朱未斌,1,362422199502161619,15170669774,N");
        params.put("oldPassengerStr","朱未斌,1,362422199502161619,1_");
        params.put("randCode","");
        params.put("purpose_codes","00");
        params.put("key_check_isChange","6D33F5D9C0797B04747EA4CEC9063D86E9E057A1044AF1C5F7D95535");
        params.put("leftTicketStr","lrF4kEkVo1gNd%2FvZgdl6wToqRrG9Wm%2FEoB2Fzu5VXKGlm66zWi7p65fVC8c%3D");
        params.put("train_location","B2");
        params.put("choose_seats","");
        params.put("seatDetailType","000");
        params.put("whatsSelect","1");
        params.put("roomType","00");
        params.put("dwAll","N");
        params.put("_json_att","");
        //MtAG6sRok8g%3D
        params.put("REPEAT_SUBMIT_TOKEN","414a57b4f21deacb5b865a3984b09a0d");
        String cookie = "JSESSIONID=44477A7FCDDE4DC1C28203CD7B54543A; tk=mVQFqMXq_uVSqDUgRwB183qlXwd_ku1AMq_n-ctSbDRWf5eclm5150; route=6f50b51faa11b987e576cdb301e545c4; RAIL_EXPIRATION=1538337625920; RAIL_DEVICEID=PewZgqM5H0XgmBiKYctimxzMg_Fu7npQwn84xSTmsZEWJSFiF9WCm59aRAf3N9ITZAPa1TvhDjUS7NngtWFe-98E2k7nD1uDo8oTjhZNRhP8FQsMOKImBIIEPSvBGFOPRjOw5nJurZ6LL3V11C0iiKG7068_B8S8; _jc_save_toDate=2018-09-27; _jc_save_wfdc_flag=dc; BIGipServerpassport=904397066.50215.0000; current_captcha_type=Z; _jc_save_fromStation=%u5357%u660C%2CNCG; _jc_save_toStation=%u5409%u5B89%2CVAG; _jc_save_showIns=true; BIGipServerpool_passport=401408522.50215.0000; BIGipServerotn=568852746.64545.0000; _jc_save_fromDate=2018-10-01";
        String body = httpPost("https://kyfw.12306.cn/otn/confirmPassenger/confirmSingleForQueue",params,cookie);*/

//        Main m = new Main("RKfplxGHbVI%3D","13083399","13083399");
//        Thread t1 = new Thread(m,"t1");
//        t1.start();

//        Main m2 = new Main("pOXHW79ZABE%3D","13112025","13112025");
//        Thread t2 = new Thread(m2,"t2");
//        t2.start();

//        Main m3 = new Main("z3Nl88ni5C4%3D","13060371","13060371");
//        Thread t3 = new Thread(m3,"t3");
//        t3.start();

//        Main m4 = new Main("wqFP7bWs%2Fj8%3D","13002505","13002505");
//        Thread t4 = new Thread(m4,"t4");
//        t4.start();

//        Main m5 = new Main("Vtcb7Zk6PxI%3D","19027836","19027836");
//        Thread t5 = new Thread(m5,"t5");
//        t5.start();

//        Main m6 = new Main("KZHv0a44kL4%3D","76127945","76127945");
//        Thread t6 = new Thread(m6,"t6");
//        t6.start();

//        Main m7 = new Main("l4Z95At%2BFtc%3D","76047629","76047629");
//        Thread t7 = new Thread(m7,"t7");
//        t7.start();

        Main m8 = new Main("xMlbvPWRHTw%3D","19230647","19230647");
        Thread t8 = new Thread(m8,"t8");
        t8.start();

//        Main m9 = new Main("5jetBIxnihk%3D","75302679","75302679");
//        Thread t9 = new Thread(m9,"t9");
//        t9.start();
    }

    public void run() {
        try {
            submit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void submit() throws Exception{
        Map<String,String> params = new HashMap<String, String>();
        String body = "";
        String cookie = "authorization=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjEyLCJleHAiOjE1Njk1NTg4MzMsIm5iZiI6MTUzODAyMjgzM30.cMCBMsB_6K_PJwR1m6o94lvs7Ddfd4X8nBka0In08Zk";
        JSONObject jsonParam = new JSONObject();
        jsonParam.put("orgId", "l4Z95At%2bFtc%3d");
        jsonParam.put("examPaperId",examPaperId);
        for(int i=0;i<1000;i++) {
            System.out.println(Thread.currentThread().getName());
            body = httpPost("http://exam.motk.com/api/exam/generateExamData", params, cookie,jsonParam);
            JSONObject jsonObject = JSONObject.parseObject(body);
            String steId = jsonObject.getString("returnEntity");
            System.out.println(steId);
            JSONObject j = JSONObject.parseObject("{\"orgId\":\"l4Z95At%2bFtc%3d\",\"steId\":\""+steId+"\",\"questionId\":"+questionId+",\"userAnswers\":[{\"answer\":[\"\"],\"questionOptionGroupId\":"+questionOptionGroupId+"}],\"displayTypeId\":1,\"currentQuestionIndex\":0,\"doingType\":1}");
            body = httpPost("http://exam.motk.com/api/exam/saveExamItem", params, cookie,j);
            System.out.println(body);
            body = httpPost("http://exam.motk.com/api/exam/finishExam", params, cookie,j);
            System.out.println(body);
        }
    }

    /**
     * 绕过验证
     *
     * @return
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    public static SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sc = SSLContext.getInstance("SSLv3");

        // 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
        X509TrustManager trustManager = new X509TrustManager() {

            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) throws CertificateException {
            }

            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,
                    String paramString) throws CertificateException {
            }

            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };

        sc.init(null, new TrustManager[] { trustManager }, null);
        return sc;
    }


    public static String httpPost(String url, Map<String,String> map, String cookie,JSONObject jsonParam) throws Exception{
        String body = "";

        //采用绕过验证的方式处理https请求
        SSLContext sslcontext = createIgnoreVerifySSL();
        //设置协议http和https对应的处理socket链接工厂的对象
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.INSTANCE)
                .register("https", new SSLConnectionSocketFactory(sslcontext))
                .build();
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        HttpClients.custom().setConnectionManager(connManager);

        //创建自定义的httpclient对象
        CloseableHttpClient client = HttpClients.custom().setConnectionManager(connManager).build();
        //CloseableHttpClient client = HttpClients.createDefault();

        try {
            //创建post方式请求对象
            HttpPost httpPost = new HttpPost(url);
            //指定报文头Content-type、User-Agent
            httpPost.setHeader("Content-type", "application/json");
            httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");
            //执行请求操作，并拿到结果（同步阻塞）
            httpPost.addHeader("Cookie",cookie);
            httpPost.setHeader("Referer","http://exam.motk.com/answer?orgId=l4Z95At%2bFtc%3d&steId=oOiwn7Onjbw%3D");
//            List<NameValuePair> params = new ArrayList<NameValuePair>();
//            if(map!=null){
//                for (Map.Entry<String, String> entry : map.entrySet()) {
//                    //添加参数
//                    params.add( new BasicNameValuePair(entry.getKey(),entry.getValue()) );
//                }
//            }
//            //4、设置参数到请求对象中
//            try {
//                httpPost.setEntity(new UrlEncodedFormEntity(params, "utf-8"));
//            } catch (UnsupportedEncodingException e1) {
//                e1.printStackTrace();
//            }  //5、设置header信息
            StringEntity jentity = new StringEntity(jsonParam.toString(),"utf-8");//解决中文乱码问题
            httpPost.setEntity(jentity);
            CloseableHttpResponse response = client.execute(httpPost);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                body = EntityUtils.toString(entity, "UTF-8");
            }
            EntityUtils.consume(entity);
            response.close();
        } finally {
            client.close();
        }
        return body;
    }

}
