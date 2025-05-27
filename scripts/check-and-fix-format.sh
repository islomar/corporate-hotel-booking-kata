#!/bin/sh

./gradlew spotlessCheck
hasWrongFormat=$?

if [ $hasWrongFormat -ne 0 ]; then
  echo "The format is wrong, let's fix it!"
  ./gradlew spotlessApply
  exit 1
fi