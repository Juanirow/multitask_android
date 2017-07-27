test:
	./gradlew test

results:
	open ./app/build/reports/tests/testDebugUnitTest/index.html

test-result: test results
