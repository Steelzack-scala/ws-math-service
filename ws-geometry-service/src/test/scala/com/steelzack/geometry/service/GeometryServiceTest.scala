package com.steelzack.geometry.service

import org.scalatest.Finders
import org.scalatest.FlatSpec
import org.scalatest.Matchers

import com.typesafe.config.Config

import akka.event.LoggingAdapter
import akka.http.scaladsl.testkit.ScalatestRouteTest

class ServiceSpec extends FlatSpec with Matchers with ScalatestRouteTest with Service {
  def config: Config = {
    ???
  }

  val logger: LoggingAdapter = ???;
}
