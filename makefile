test:
	./gradlew testMockDebugUnitTest

results:
	open ./app/build/reports/tests/testMockDebugUnitTest/index.html

test-result:
	$(MAKE) test
	open ./app/build/reports/tests/testMockDebugUnitTest/index.html

help:
	./gradlew tasks
