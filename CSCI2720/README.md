    Emmanuel Pierre esp48321@uga.edu

    CHANGE TO CSCI2720 DIRECTORY!
        Simply run the ./script.sh file from the parent "CSCI2720"
        If you can't do the following lines from the CSCI2720 directory:
  javac -d bin src/esp/types/ItemType.java
  javac -cp bin -d bin src/esp/types/NodeType.java
  javac -cp bin -d bin src/esp/control/SortedLinkedList.java
  javac -cp bin -d bin src/esp/LinkedListDriver.java
  java -cp bin esp.LinkedListDriver 'src/esp/input.txt'

    You can change the input.txt file if you need to test different input.

    Merge Method pseudo code:
    New variant of insert where when the repeated element comes up, no message is printed.
    With this, the code goes through the elements of the other list and adds to it to the main list.
    Time complexity: O(n^2)

    Intersection pseudo code:
    Iterate through the larger list and search the other list to see if it contains the same element,
    if so add to our new list. Returns new list.
    Time complexity: O(n^2)