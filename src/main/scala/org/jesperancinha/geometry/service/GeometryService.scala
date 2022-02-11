package org.jesperancinha.geometry.service

import akka.actor.ActorSystem
import akka.event.{ LoggingAdapter, Logging }
import akka.http.scaladsl.Http
import akka.http.scaladsl.client.RequestBuilding
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import akka.http.scaladsl.marshalling.ToResponseMarshallable
import akka.http.scaladsl.model.{ HttpResponse, HttpRequest }
import akka.http.scaladsl.model.StatusCodes._
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.unmarshalling.Unmarshal
import akka.stream.{ ActorMaterializer, Materializer }
import akka.stream.scaladsl.{ Flow, Sink, Source }
import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import java.io.IOException
import scala.concurrent.{ ExecutionContextExecutor, Future }
import scala.math._
import spray.json.DefaultJsonProtocol

//Requests
case class CubeRequest(side: Double)
case class RecPalRequest(base: Double, height: Double, length: Double)

//Results
case class CubeResult(volume: Double, area: Double)
case class RecPalResult(volume: Double, area: Double)

//Result JSON objects
object CubeResult {
  def apply(side: Double): CubeResult = CubeResult(getCubeVolume(side), getCubeArea(side))

  def getCubeVolume(side: Double): Double = {
    pow(side, 3)
  }

  def getCubeArea(side: Double): Double = {
    pow(side, 2) * 6
  }
}

object RecPalResult {
  def apply(base: Double, height: Double, length: Double): RecPalResult = RecPalResult(getRecPalVolume(base, height, length), getRecPalArea(base, height, length))

  def getRecPalVolume(base: Double, height: Double, length: Double) = {
    base * height * length
  }
  def getRecPalArea(base: Double, height: Double, length: Double) = {
    base * height * 2 + base * length * 2 + height * length * 2
  }

}

trait JSONProtocols extends DefaultJsonProtocol {
  implicit val cubeRequest = jsonFormat1(CubeRequest.apply)
  implicit val cubeResult = jsonFormat2(CubeResult.apply)
  implicit val recPalRequest = jsonFormat3(RecPalRequest.apply)
  implicit val recPalResult = jsonFormat2(RecPalResult.apply)
}

trait Service extends JSONProtocols {
  implicit val system: ActorSystem
  implicit def executor: ExecutionContextExecutor
  implicit val materializer: Materializer

  def config: Config
  val logger: LoggingAdapter

  val routeRecPal = {
    logRequestResult("math-service-scala") {
      pathPrefix("recPal") {
        (post & entity(as[RecPalRequest])) { recPalRequest =>
          complete {
            val base: Future[Either[String, Double]] = Future(Right(recPalRequest.base))
            val height: Future[Either[String, Double]] = Future(Right(recPalRequest.height))
            val length: Future[Either[String, Double]] = Future(Right(recPalRequest.length))
            base.zip(height.zip(length)).map[ToResponseMarshallable] {
              case (Right(base), (Right(height), Right(length))) => RecPalResult(base, height, length)
              case (Left(errorMessage), (_, _)) => BadRequest -> errorMessage
              case (Right(_), (_, _)) => BadRequest -> "Empty value for base!"
              case (_, (Right(_), _)) => BadRequest -> "Empty value for height!"
              case (_, (_, Right(_))) => BadRequest -> "Empty value for length!"
              case (_, (Left(errorMessage), _)) => BadRequest -> errorMessage
              case (Left(errorMessage), _) => BadRequest -> errorMessage
            }
          }
        }
      }
    }
  }

  val routesCube = {
    logRequestResult("math-service-scala") {
      pathPrefix("cube") {
        (post & entity(as[CubeRequest])) { cubeRequest =>
          complete {
            val side: Future[Either[String, Double]] = Future(Right(cubeRequest.side))
            side.map[ToResponseMarshallable] {
              case (Right(side)) => CubeResult(side)
              case (Left(errorMessage)) => BadRequest -> errorMessage
            }

          }
        }
      }
    }
  }
}

object GeometryService extends App with Service {
  override implicit val system = ActorSystem()
  override implicit val executor = system.dispatcher
  override implicit val materializer = ActorMaterializer()

  override val config = ConfigFactory.load()
  override val logger = Logging(system, getClass)

  Http().bindAndHandle(routeRecPal ~ routesCube, config.getString("http.interface"), config.getInt("http.port"))
}