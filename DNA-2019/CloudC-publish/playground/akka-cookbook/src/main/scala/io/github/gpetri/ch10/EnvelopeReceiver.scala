package io.github.gpetri.ch10

import akka.actor.{Actor, ActorLogging}

class EnvelopeReceiver extends Actor with ActorLogging {
  def receive = {
    case x => log.info(s"Received [$x]")
  }
}
