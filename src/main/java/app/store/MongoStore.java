package app.store;
import com.mongodb.client.*; import org.bson.Document;
import app.model.Student; import java.util.Random;
public class MongoStore{
 static MongoClient c=MongoClients.create("mongodb://localhost:27017");
 static MongoCollection<Document> col=c.getDatabase("nosql_lab").getCollection("students");
 public static void init(){col.drop(); for(int i=1;i<=10000;i++){col.insertOne(
 new Document("student_no","202500"+i).append("name","Student-"+i).append("department",dep()));}}
 public static String get(String n){Document d=col.find(new Document("student_no",n)).first();
 return d!=null?d.toJson():null;} 
 static String dep(){String[] d={"Classical Turkish Music","Turkish Folk Music","Computer Engineering"};
 return d[new Random().nextInt(d.length)];}
}
