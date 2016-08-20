ws-geometry-service
-------------------

* Run this service using  sbtrun by following the following examples:

-------------------

Area and volume of a Cube:

```
$ curl -X POST -H 'Content-Type: application/json' http://localhost:8080/cube -d '{"side": 10}'

```
{

  "volume": 1000.0,

  "area": 600.0

}

-------------------

Area and volume of other polygons:

```
$ curl -X POST -H 'Content-Type: application/json' http://localhost:8080/recPal -d '{"base": 10, "height": 20, "length" : 5}'
```

{
  "volume": 1000.0,
  "area": 700.0
}

