.PHONY: all test

all: test

setup-devenv:
	./dev/setup-devenv.sh

test:
	mvn clean test