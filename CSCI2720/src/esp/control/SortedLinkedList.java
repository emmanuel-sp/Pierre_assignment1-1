package esp.control;

import esp.types.ItemType;
import esp.types.NodeType;

public class SortedLinkedList {

    private NodeType head;
    private NodeType currentPos;

    public SortedLinkedList() {
        this.head = null;
        this.currentPos = null;
    }

    public int getLength() {
        NodeType temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        return len;
    }

    public void insertItem(ItemType item) {
        NodeType add = new NodeType(item);
        if (this.isEmpty()) {
            head = add;
            return;
        }
        if (this.getLength() == 1) {
            if (this.head.info.compareTo(item) < 0) {
                head.next = add;
            } else if (this.head.info.compareTo(item) > 0) {
                add.next = head;
                head = add;
            } else {
                System.out.println("Sorry. You cannot insert the duplicate item");
            }
            return;
        }
        if (head.info.compareTo(item) > 0) {
            add.next = head;
            head = add;
            return;
        }
        NodeType temp = head;
        while (temp.next != null && temp.next.info.compareTo(item) < 0) {
            temp = temp.next;
        }
        add.next = temp.next;
        temp.next = add;
    }

    public void deleteItem(ItemType item) {
        if (this.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        if (head.info.compareTo(item) == 0) {
            head = head.next;
            return;
        }
        NodeType temp = head;

        while (temp.next != null && temp.next.info.compareTo(item) != 0) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
    }

    public int searchItem(ItemType item) {
        NodeType temp = head;
        int count = 0;
        while (temp != null) {
            if (temp.info.compareTo(item) == 0) {
                return count;
            }
            temp = temp.next;
            count++;
        }
        System.out.println("Item not found!");
        return -1;
    }

    public ItemType getNextItem() {
        if (currentPos == null) {
            currentPos = head;
            if (head == null) {
                System.out.println("The list is empty");
                return null;
            }
        } else if (!(currentPos.next == null)) {
            currentPos = currentPos.next;
        } else {
            currentPos = head;
        }
        return currentPos.info;

    }

    public void resetList() {
        this.currentPos = null;
    }

    public void mergeList(SortedLinkedList sT) {
        NodeType temp = sT.head;
        while (temp != null) {
            this.insertUtil(temp.info);
            temp = temp.next;
        }
    }
    public void delAlt() {
        NodeType temp = head;
        if (this.isEmpty()) {
            return;
        }
        while (temp.next != null) {
            temp.next = temp.next.next;
            temp = temp.next;
        }
    }
    public SortedLinkedList intersection(SortedLinkedList s2) {
        SortedLinkedList out = new SortedLinkedList();
        int length1 = this.getLength();
        int length2 = s2.getLength();
        NodeType temp = head;
        NodeType temp2 = s2.getHead();

        if (length1 > length2) {
            while (temp != null) {
                if (s2.searchUtil(temp.info) > -1) {
                    out.insertItem(temp.info);
                }
                temp = temp.next;
            }
        } else {
            while (temp2 != null) {
                if (this.searchUtil(temp2.info) > -1) {
                    out.insertItem(temp2.info);
                }
                temp2 = temp2.next;
            }
        }
        return out;
    }

    public void insertUtil(ItemType item) {
        NodeType add = new NodeType(item);
        if (this.isEmpty()) {
            head = add;
            return;
        }
        if (this.getLength() == 1) {
            if (this.head.info.compareTo(item) < 0) {
                head.next = add;
            } else if (this.head.info.compareTo(item) > 0) {
                add.next = head;
                head = add;
            } else {
                return;
            }
            return;
        }
        if (head.info.compareTo(item) > 0) {
            add.next = head;
            head = add;
            return;
        }
        NodeType temp = head;
        while (temp.next != null && temp.next.info.compareTo(item) < 0) {
            temp = temp.next;
        }
        add.next = temp.next;
        temp.next = add;
    }
    public int searchUtil(ItemType item) {
        NodeType temp = head;
        int count = 0;
        while (temp != null) {
            if (temp.info.compareTo(item) == 0) {
                return count;
            }
            temp = temp.next;
            count++;
        }
        return -1;
    }

    public boolean isEmpty() {
        return (this.getLength() == 0);
    }

    public NodeType getHead() {
        return this.head;
    }
}
