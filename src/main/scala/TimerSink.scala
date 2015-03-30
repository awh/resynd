import akka.actor.Actor
import akka.event.Logging

class TimerSink extends Actor {

  val log = Logging(context.system, this)

  def receive = {
    case m => Console.println(m.toString)
  }

}