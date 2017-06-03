#!/usr/bin/env bash

cd out/artifacts/GameOfLIfe_jar/
echo '1: Map size = 10'
echo '2: Map size = 20'
echo '3: Map size = 40'
echo '4: Map size = 80'
echo '5: Map size = 160'
java -cp GameOfLIfe.jar GameOfLife.Main $1