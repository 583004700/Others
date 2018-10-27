package flume;

import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

import java.util.ArrayList;
import java.util.List;

public class AppInterceptor implements Interceptor{

    private String appId;

    public void initialize() {

    }

    public Event intercept(Event event) {
        byte[] bytes = event.getBody();
        String message = new String(bytes);
        message ="appId:" + appId + "||" +message;
        event.setBody(message.getBytes());
        return event;
    }

    public List<Event> intercept(List<Event> list) {
        List<Event> results = new ArrayList<Event>();
        for(Event event : list){
            Event result = intercept(event);
            results.add(result);
        }
        return results;
    }

    public void close() {

    }


    public class AppInterceptorBuilder implements Builder{
        public Interceptor build() {
            return AppInterceptor.this;
        }

        public void configure(Context context) {
            appId = context.getString("appId");
        }
    }
}
