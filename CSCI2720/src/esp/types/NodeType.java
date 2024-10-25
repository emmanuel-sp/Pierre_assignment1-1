package esp.types;

import esp.types.ItemType;

public class NodeType {

    public ItemType info;
    public NodeType next;

    public NodeType(ItemType info, NodeType next) {
        this.info = info;
        this.next = next;
    }

    public NodeType(ItemType info) {
        this.info = info;
    }

} // NodeType
