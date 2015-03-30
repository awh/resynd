import akka.actor.{Props, ActorSystem}
import scala.concurrent.duration._

object TimerMain extends App {

  val system = ActorSystem("myactorsystem")

  val timerSink = system.actorOf(Props[TimerSink])

  import system.dispatcher // for implicit ExecutionContext

  system.scheduler.schedule(1 seconds, 1 seconds, timerSink, "boing")

  Console.println("Starting...");
}