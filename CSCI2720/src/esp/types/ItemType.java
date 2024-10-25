package esp.types;

public class ItemType {
    private int value;

    public ItemType(int num) {
        this.value = num;
    }

    public int compareTo(ItemType item) {
        if (this.value < item.value) {
            return -1;
        } else if (this.value > item.value) {
            return 1;
        } else {
            return 0;
        }
    }

    public int getValue() {
        return this.value;
    }


}
