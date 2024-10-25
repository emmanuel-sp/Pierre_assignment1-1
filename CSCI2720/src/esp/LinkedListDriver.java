package esp;

import esp.control.SortedLinkedList;
import esp.types.ItemType;
import esp.types.NodeType;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LinkedListDriver {
    public static void main(String[] args) {

        File file = new File(args[0]);
        Scanner input = new Scanner(System.in);
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println(e);
            System.exit(0);
        }

        SortedLinkedList list = new SortedLinkedList();
        while (input.hasNextInt()) {
            int vay = input.nextInt();
            list.insertItem(new ItemType(vay));
        }
        input = new Scanner(System.in);

        boolean using = true;
        char command;
        boolean ta = false;
        int val;
        int lenN;

        while (using) {
            if (!ta) {
                System.out.print("Enter a command: ");
            }
            ta = false;
            command = input.next().charAt(0);

            switch (command) {
            case 'i':
                System.out.print("Enter a number to insert: ");
                val = input.nextInt();
                System.out.println("Original list : " + printList(list));
                list.insertItem(new ItemType(val));
                System.out.println("New list : " + printList(list));
                break;
            case 'd':
                System.out.print("Enter a number to delete: ");
                val = input.nextInt();
                if (!list.isEmpty()) {
                    System.out.println("Original List : " + printList(list));
                    list.deleteItem(new ItemType(val));
                    System.out.println("New list : " + printList(list));
                } else {
                    System.out.println("You cannot delete from an empty list!");
                }
                break;
            case 's':
                System.out.println("Enter a number to search: ");
                val = input.nextInt();
                System.out.println("Original list : " + printList(list));
                int dex = list.searchItem(new ItemType(val));
                if (dex > -1) {
                    System.out.println("The item is present at index " + dex);
                }
                break;
            case 'n':
                ItemType ref = list.getNextItem();
                if (ref != null) {
                    System.out.println(ref.getValue());
                }
                break;
            case 'r':
                list.resetList();
                System.out.println("Iterator is reset");
                break;
            case 'a':
                System.out.println("Original list : " + printList(list));
                list.delAlt();
                System.out.println("New list : " + printList(list));
                break;
            case 'm':
                SortedLinkedList merged = new SortedLinkedList();
                System.out.print("Enter the length of the new list: ");
                lenN = input.nextInt();
                System.out.print("Enter the numbers: ");
                for (int i = 0; i < lenN; i++) {
                    merged.insertUtil(new ItemType(input.nextInt()));
                }
                System.out.println("list 1: " + printList(list));
                System.out.println("list 2: " + printList(merged));
                list.mergeList(merged);
                System.out.println("Merged list: " + printList(list));
                break;
            case 't':
                SortedLinkedList ls2 = new SortedLinkedList();
                System.out.print("Enter the length of the new list: ");
                lenN = input.nextInt();
                System.out.print("Enter the numbers: ");
                for (int i = 0; i < lenN; i++) {
                    ls2.insertItem(new ItemType(input.nextInt()));
                }
                System.out.println("list 1: " + printList(list));
                System.out.println("list 2: " + printList(ls2));
                System.out.println("Intersection of lists: " + printList(list.intersection(ls2)));
                break;
            case 'p':
                System.out.println("The list is: " + printList(list));
                break;
            case 'l':
                System.out.println("The length of the list is " + list.getLength());
            case 'q':
                System.out.println("Exiting the program...");
                using = false;
                break;
            default:
                ta = true;
                System.out.println("Invalid command try again: ");
                break;
            }
        }
    }
    public static String printList(SortedLinkedList s1) {
        NodeType temp = s1.getHead();
        String out = "";
        while (temp != null) {
            out = out + temp.info.getValue() + " ";
            temp = temp.next;
        }
        return out;
    }

}
