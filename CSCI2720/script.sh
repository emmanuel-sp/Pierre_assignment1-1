#!/usr/bin/bash -ex

javac -d bin src/esp/types/ItemType.java
javac -cp bin -d bin src/esp/types/NodeType.java
javac -cp bin -d bin src/esp/control/SortedLinkedList.java
javac -cp bin -d bin src/esp/LinkedListDriver.java
java -cp bin esp.LinkedListDriver 'src/esp/input.txt'
