enum ItemType {
    ADD,
    SUB,
    MUL,
    DIV,
    VALUE,
    MOD10,
    SM   // Strange Mult

}
public class Item {
    private ItemType type;
    private int value = 0;

    public int GetValue()
    {
        return value;
    }

    public ItemType GetType()
    {
        return type;
    }

    public Item(int value) {
        this.type = ItemType.VALUE;
        this.value = value;
    }

    public Item(ItemType type) {
        this.type = type;
        this.value = 0;
    }
}
