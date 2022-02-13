publish:
	sbt publishM2
test:
	sbt test
build:
	sbt compile
run: build
	sbt run
coverage:
	sbt jacoco