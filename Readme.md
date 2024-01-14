# math-service-scala

---

[![Twitter URL](https://img.shields.io/twitter/url?logoColor=blue&style=social&url=https%3A%2F%2Fimg.shields.io%2Ftwitter%2Furl%3Fstyle%3Dsocial)](https://twitter.com/intent/tweet?text=%20Checkout%20this%20%40github%20repo%20by%20%40joaofse%20%F0%9F%91%A8%F0%9F%8F%BD%E2%80%8D%F0%9F%92%BB%3A%20https%3A//github.com/jesperancinha/math-service-scala)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=math-service-scala%20🧮&color=informational)](https://github.com/jesperancinha/math-service-scala)

[![GitHub License](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](https://www.apache.org/licenses/LICENSE-2.0)

[![math-service-scala](https://github.com/jesperancinha/math-service-scala/actions/workflows/math-service-scala.yml/badge.svg)](https://github.com/jesperancinha/math-service-scala/actions/workflows/math-service-scala.yml)

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/2ea8cff0e5be48e29e0b3b5da9e272c4)](https://www.codacy.com/gh/jesperancinha/math-service-scala/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=jesperancinha/math-service-scala&amp;utm_campaign=Badge_Grade)

[![Codacy Badge](https://app.codacy.com/project/badge/Coverage/2ea8cff0e5be48e29e0b3b5da9e272c4)](https://www.codacy.com/gh/jesperancinha/math-service-scala/dashboard?utm_source=github.com&utm_medium=referral&utm_content=jesperancinha/math-service-scala&utm_campaign=Badge_Coverage)
[![Coverage Status](https://coveralls.io/repos/github/jesperancinha/math-service-scala/badge.svg?branch=master)](https://coveralls.io/github/jesperancinha/math-service-scala?branch=master)
[![codecov](https://codecov.io/gh/jesperancinha/math-service-scala/branch/master/graph/badge.svg?token=OZQu7yApiW)](https://codecov.io/gh/jesperancinha/math-service-scala)

[![GitHub language count](https://img.shields.io/github/languages/count/jesperancinha/math-service-scala.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/top/jesperancinha/math-service-scala.svg)](#)
[![GitHub top language](https://img.shields.io/github/languages/code-size/jesperancinha/math-service-scala.svg)](#)

---

## How to run

```shell
sbt run
```
## How to coverage

```shell
sbt jacoco
```

## How to test

```shell
sbt test
```

## Testing the application

#### 1.  Area and volume of a Cube

```
curl -X POST -H 'Content-Type: application/json' http://localhost:8080/cube -d '{"side": 10}'
```

```json
{
  "volume": 1000.0,
  "area": 600.0

}
```

#### 2.  Area and volume of other polygons

```shell
curl -X POST -H 'Content-Type: application/json' http://localhost:8080/recPal -d '{"base": 10, "height": 20, "length" : 5}'
```

```json
{
  "volume": 1000.0,
  "area": 700.0
}
```

## About me

[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=Jesperancinha&style=for-the-badge&logo=github&color=grey "GitHub")](https://github.com/jesperancinha)
