package app.store;
import com.hazelcast.core.*; import com.hazelcast.config.Config;
import com.google.gson.Gson; import app.model.Student; import java.util.Random;
import com.hazelcast.map.IMap;
public class HazelcastStore{
 static HazelcastInstance hz=Hazelcast.newHazelcastInstance(new Config());
 static IMap<String,String> m=hz.getMap("students"); static Gson g=new Gson();
 public static void init(){for(int i=1;i<=10000;i++){String n="202500"+i;
 m.put(n,g.toJson(new Student(n,"Student-"+i,dep())));}} 
 public static String get(String n){return m.get(n);} 
 static String dep(){String[] d={"Classical Turkish Music","Turkish Folk Music","Computer Engineering"};
 return d[new Random().nextInt(d.length)];}
}


