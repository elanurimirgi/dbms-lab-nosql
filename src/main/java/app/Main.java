package app;
import app.store.*;
import static spark.Spark.*;
public class Main {
 public static void main(String[] args){
  port(8080);
  RedisStore.init();
  HazelcastStore.init();
  MongoStore.init();
  get("/nosql-lab-rd",(q,r)->RedisStore.get(q.queryParams("student_no")));
  get("/nosql-lab-hz",(q,r)->HazelcastStore.get(q.queryParams("student_no")));
  get("/nosql-lab-mon",(q,r)->MongoStore.get(q.queryParams("student_no")));
 }
}
