publish:
	sbt publishM2
test:
	sbt test
build:
	sbt compile
run: build
	sbt run
coverage:
	export OMNI_LOG=true
	sbt assembly package jacoco omniReport -v
