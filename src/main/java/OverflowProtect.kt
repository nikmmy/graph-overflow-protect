import org.joda.time.Hours
import redis.clients.jedis.Jedis
import java.util.concurrent.TimeUnit

/**
 * Created by nikita.mundhada on 5/8/18.
 */

fun main(args:Array<String>) {

    val jedis = Jedis("localhost");
    jedis.set("foo", "bar");
    println(jedis.get("foo"));


}

fun recordPlayExecution(orgId: String, playId: String, timestamp: Long){
    val jedis = Jedis("localhost");
    val timestampMinutes = TimeUnit.MILLISECONDS.toMinutes(timestamp)
    val key = "$orgId:$playId:$timestampMinutes"
    jedis.incr(key)
    jedis.expire(key, 3600) //Expire cache key in 1 hr

    jedis.hse
}