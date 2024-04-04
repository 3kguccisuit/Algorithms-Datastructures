import java.util.Random;

class Main {

    public static void main(String[] args) {


        // Item[] expr2 = new Item[] {
        //         // 10 − ((y1 ∗´ 2 + y2 + m1 ∗´ 2 + m2...) mod10)
        //         new Item(10),

        //         // 000304467 => 7

        //         // 6 Y1
        //         new Item(0),
        //         new Item(2),
        //         new Item(ItemType.SM),

        //         // 3 Y2
        //         new Item(0),
        //         new Item(ItemType.ADD),

        //         // 0 M1
        //         new Item(0),
        //         new Item(2),
        //         new Item(ItemType.SM),

        //         // 7 M2
        //         new Item(3),
        //         new Item(ItemType.ADD),

        //         new Item(ItemType.ADD),

        //         // 2 D1
        //         new Item(0),
        //         new Item(2),
        //         new Item(ItemType.SM),

        //         // 3 D2
        //         new Item(4),
        //         new Item(ItemType.ADD),

        //         new Item(ItemType.ADD),

        //         // 3 K1
        //         new Item(4),
        //         new Item(2),
        //         new Item(ItemType.SM),

        //         // 1 K2
        //         new Item(6),
        //         new Item(ItemType.ADD),

        //         new Item(ItemType.ADD),

        //         // 3 K3
        //         new Item(7),
        //         new Item(2),
        //         new Item(ItemType.SM),

        //         new Item(ItemType.ADD),

        //         new Item(ItemType.MOD10),

        //         new Item(ItemType.SUB),
        // };

        // Item[] expr3 = new Item[] {
        //     new Item(1),
        //     new Item(2),
        //     new Item(3),
        //     new Item(4),
        //     new Item(5),
        //     new Item(6),
        //     new Item(ItemType.SUB),
        //     new Item(ItemType.SUB),
        // };

        Stack stacken = new Stack(5);
        stacken.push(1);
        stacken.pop();
        stacken.push(3);
        stacken.push(5);
        stacken.pop();
        stacken.push(2);
        stacken.push(3);
        stacken.push(5);
        stacken.push(1);
        stacken.push(2);
        stacken.push(3);
        stacken.push(5);
        stacken.pop();



        System.out.println(stacken.getSize());




        // Calculator test = new Calculator(expr3);
        // int r = test.run();
        // System.out.printf("Resultat: %d\n", r);

        // test = new Calculator(expr3);
        // r = test.run();
        // System.out.printf("Resultat: %d\n", r);

        // System.out.println(stack.size());

        // while(!stack.isEmpty()){
        // System.out.print(stack.pop() + " ");
        // }

    }
}

// Item[] expr1 = new Item[] {
// // 10 − ((y1 ∗´ 2 + y2 + m1 ∗´ 2 + m2...) mod10)
// new Item(10),

// // 630723313 => 7

// // 6 Y1
// new Item(6),
// new Item(2),
// new Item(ItemType.SM),

// // 3 Y2
// new Item(3),
// new Item(ItemType.ADD),

// // 0 M1
// new Item(0),
// new Item(2),
// new Item(ItemType.SM),

// // 7 M2
// new Item(7),
// new Item(ItemType.ADD),

// new Item(ItemType.ADD),

// // 2 D1
// new Item(2),
// new Item(2),
// new Item(ItemType.SM),

// // 3 D2
// new Item(3),
// new Item(ItemType.ADD),

// new Item(ItemType.ADD),

// // 3 K1
// new Item(3),
// new Item(2),
// new Item(ItemType.SM),

// // 1 K2
// new Item(1),
// new Item(ItemType.ADD),

// new Item(ItemType.ADD),

// // 3 K3
// new Item(3),
// new Item(2),
// new Item(ItemType.SM),

// new Item(ItemType.ADD),

// new Item(ItemType.MOD10),

// new Item(ItemType.SUB),
// };