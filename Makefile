.DEFAULT_GOAL := help

help:  ## Show this help.
	@grep -E '^\S+:.*?## .*$$' $(firstword $(MAKEFILE_LIST)) | \
		awk 'BEGIN {FS = ":.*?## "}; {printf "%-30s %s\n", $$1, $$2}'

.PHONY: local-setup
local-setup: ## Set up the local environment (e.g. install git hooks)
	scripts/local-setup.sh

.PHONY: build
build: ## Build
	./gradlew build

.PHONY: format
format: ## Check and fix format using Spotless
	./scripts/check-and-fix-format.sh

.PHONY: test
test: ## Run all the tests
	./gradlew test

.PHONY: test-mutation
test-mutation: ## Run mutation testing
	./gradlew pitest
	@echo
	@echo "You can see the resulting test coverage report generated under ${PWD}/build/reports/pitest/index.html"

.PHONY: open-test-mutation-report
open-test-mutation-report: ## Open the existing mutation testing report
	@open build/reports/pitest/index.html

.PHONY: test-coverage
test-coverage: ## Run test coverage with JaCoCo
	./gradlew build jacocoTestReport
	@echo
	@echo "You can see the resulting test coverage report generated under ${PWD}/build/reports/jacoco/test/html/index.html"

.PHONY: open-test-coverage-report
open-test-coverage-report: ## Open the existing test coverage report
	@open build/reports/jacoco/test/html/index.html

.PHONY: lock-dependencies
lock-dependencies: ## Lock the dependencies
	./gradlew dependencies --write-locks

.PHONY: pre-commit
pre-commit: lock-dependencies format test

.PHONY: rename-project
rename-project: ## Rename project: 'make rename new-name=<new-name>'
	sed -i 's/java-kata-name/$(new-name)/' Makefile
	sed -i 's/java-kata-template/$(new-name)/' README.md
	sed -i 's/java-kata-template/$(new-name)/' Makefile