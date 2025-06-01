![Run build and tests workflow](https://github.com/islomar/java-kata-template/actions/workflows/gradle.yml/badge.svg)

# Corporate Hotel Booking kata

- Template repository for Java katas
- The repository is created as a **GitHub repository template**, so that you can easily create your own GitHub
  repository from this one.
    - [Here](https://docs.github.com/en/repositories/creating-and-managing-repositories/creating-a-repository-from-a-template#creating-a-repository-from-a-template)
      you can find the instructions: easy peasy!
    - There is a **GH project** associated with this repo, with some pending improvements.
- If you run `make` from the root folder of the project, you can see all the actions that you can execute (e.g. running
  the tests, static analysis, code coverage, etc.)

## HOW to use it

1. Generate a repo using this one as a template,
   following [these instructions](https://docs.github.com/en/repositories/creating-and-managing-repositories/creating-a-repository-from-a-template#creating-a-repository-from-a-template)
2. Replace the `java-kata-name` placeholder that appears in several files with your own name (e.g. `java-fizzbuzz`).
    - For example, you can easily do it running `make rename-project new-name=java-fizzbuzz`

## Prerequisites

- **IMPORTANT**: just the first time, run `make local-setup`.
    - This will set up things like configuring Git hooks. The `pre-commit` hook will automatically run the linters and
      tests, rejecting the commit in case any of them fail.

## Functionalities included

- There is pipeline configured as a GitHub Action which runs all the linters, the tests and both the coverage and
  mutation testing.
    - The artifacts with the HTML reports generated can be downloaded from the GitHub project tab "Actions" --> "
      Summary" --> "Artifacts".
- [**Dependabot
  **](https://docs.github.com/code-security/dependabot/dependabot-version-updates/configuration-options-for-the-dependabot.yml-file)
  is configured at GitHub repository level, in order to automatically update the dependencies weekly.
- A **badge** on top of this README file shows the status of the GH Action (passing or failing).
- **Testing**
    - `make test`
    - Libraries used:
        - JUnit5
        - Hamcrest
    - Mutation testing with [PiTest](https://pitest.org/)
        - `make test-mutation`
- **Spotless** for checking the format and automatically fixing it
    - `make format`

## More info

- https://docs.github.com/en/actions/automating-builds-and-tests/building-and-testing-java-with-gradle
- https://www.baeldung.com/junit-5-gradle
- https://www.vogella.com/tutorials/Hamcrest/article.html
- https://www.petrikainulainen.net/programming/testing/junit-5-tutorial-writing-assertions-with-hamcrest/

## Pending

- Configure test coverage in the pipeline
- Mutation testing
- https://blog.gradle.org/gh-actions