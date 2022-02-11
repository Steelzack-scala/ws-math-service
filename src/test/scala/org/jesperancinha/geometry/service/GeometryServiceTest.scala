package org.jesperancinha.geometry.service

import akka.event.{Logging, LoggingAdapter}
import akka.http.scaladsl.testkit.ScalatestRouteTest
import com.typesafe.config.Config
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ServiceSpec extends AnyFlatSpec with Matchers with ScalatestRouteTest with Service {
  def config: Config = {
    ???
  }
  val logger: LoggingAdapter = Logging(system, getClass)


}
