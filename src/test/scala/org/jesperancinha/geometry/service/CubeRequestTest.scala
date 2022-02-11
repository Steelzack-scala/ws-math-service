package org.jesperancinha.geometry.service

import org.scalatest.funsuite.AnyFunSuite

class CubeRequestTest extends AnyFunSuite {

  test("should create a cube of the same size of 1") {
    val cubeRequest: CubeRequest = CubeRequest(1)
    assert(cubeRequest.side == 1)
  }

}
