package prototype.FTest;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;

public class F {
    public String name = "fff";
    public String toJsonString(){
        String jsonString = JSONObject.toJSONString(this);
        System.out.println("this*****"+this.say()+"     this.name*****"+this.name);
        return jsonString;
    }

    public String say(){
        String str = "Fsay"+this.name;
        return str;
    }

    public String fs(){
        Class clazz = this.getClass();
        Field[] fs = clazz.getDeclaredFields ();
        for ( int i = 0 ; i < fs. length ; i++){
            Field f = fs[i];
            f.setAccessible( true ); // 设置些属性是可以访问的
            try {
                Object val = f.get(this); // 得到此属性的值
                System. out .println( "name:" +f.getName()+ "/t value = " +val);
                String type = f.getType().toString(); // 得到此属性的类型
            }catch (Exception e){

            }
        }
        return "";
    }
}
