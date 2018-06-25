#!/usr/bin/env bash
find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java tmekwa.Simulator.Simulator scenario.txt