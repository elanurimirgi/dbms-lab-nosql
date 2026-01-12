package app.store;
import redis.clients.jedis.Jedis; import com.google.gson.Gson;
import app.model.Student; import java.util.Random;
public class RedisStore{
 static Jedis j=new Jedis("localhost",6379); static Gson g=new Gson();
 public static void init(){for(int i=1;i<=10000;i++){String n="202500"+i;
 j.set(n,g.toJson(new Student(n,"Student-"+i,dep())));}} 
 public static String get(String n){return j.get(n);} 
 static String dep(){String[] d={"Classical Turkish Music","Turkish Folk Music","Computer Engineering"};
 return d[new Random().nextInt(d.length)];}
}
