package logmonitor.spout;

import backtype.storm.spout.Scheme;
import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;


/**
 *随机产生消息发送出去
 */
public class RandomSpout extends BaseRichSpout {
    private static final long serialVersionUID = 6586976247263576774L;
    public static final String ERROR_AT_COM_STARIT_GEJIE_UTIL_TRANS_BL_GET_SYS_NAMES_BY_TYPE_TRANS_JAVA_220 = "1||error at com.starit.gejie.Util.Trans.BL_getSysNamesByType(Trans.java:220)";
    private SpoutOutputCollector collector;
    private TopologyContext context;
    private List list ;
    private final Scheme scheme;

    public RandomSpout(final Scheme scheme) {
        super();
        this.scheme = scheme;
    }

    public void open(Map conf, TopologyContext context,
                     SpoutOutputCollector collector) {
        this.context = context;
        this.collector = collector;
        list = new ArrayList();
        list.add("aid:1||error: Caused by: java.lang.NoClassDefFoundError: com/starit/gejie/dao/SysNameDao");
        list.add("aid:2||java.sql.SQLException: You have an error in your SQL syntax;");
        list.add("aid:1||error Unable to connect to any of the specified MySQL hosts.");
        list.add("aid:1||error:Servlet.service() for servlet action threw exception java.lang.NullPointerException");
        list.add("aid:2||error:java.lang.NoClassDefFoundError: org/coffeesweet/test01/Test01");
    }

    /**
     * 发送消息
     */
    public void nextTuple() {
        final Random rand = new Random();
        String msg = list.get(rand.nextInt(5)).toString();
        this.collector.emit(this.scheme.deserialize(msg.getBytes()));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void declareOutputFields(final OutputFieldsDeclarer declarer) {
        declarer.declare(this.scheme.getOutputFields());
    }
}
