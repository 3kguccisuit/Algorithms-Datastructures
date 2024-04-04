
public class Calculator {
    Item[] expr;
    int ip;
    Stack stack;

    public Calculator(Item[] expr) {
        this.expr = expr;
        this.ip = 0;
        this.stack = new Stack(5);
    }

    public int run() {
        while (ip < expr.length) {
            step();
        }
        return stack.pop();
    }

    public int StrangeMult(int x,int y)
    {
        int t = x*y;
        int r=t;
        if (t>=10)
        {
            r = (t % 10) + 1;
        }
        return r;
    }

    public void step() {
        Item nxt = expr[ip++];
        switch (nxt.GetType()) {
            case ADD: {
                int x = stack.pop();
                int y = stack.pop();
                stack.push(x + y);
                System.out.printf("%d %d %s\n", x, y, ItemType.ADD.toString());
            }
                break;

            case DIV: {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x / y);
                System.out.printf("%d %d %s\n", x, y, ItemType.DIV.toString());
            }
                break;
            case MUL: {
                int x = stack.pop();
                int y = stack.pop();
                stack.push(x * y);
                System.out.printf("%d %d %s\n", x, y, ItemType.MUL.toString());
            }
                break;
            case SUB: {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x - y);
                System.out.printf("%d %d %s\n", x, y, ItemType.SUB.toString());
            }
                break;
            case MOD10: {
                int x = stack.pop();
                stack.push(x % 10);
                System.out.printf("%d %s\n", x, ItemType.MOD10.toString());
            }
                break;
            case SM: {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(StrangeMult(x,y));
                System.out.printf("%d %d %s\n", x, y, ItemType.SM.toString());
            }
                break;
            case VALUE:
                stack.push(nxt.GetValue());
                System.out.printf("%d %s\n", nxt.GetValue(), ItemType.VALUE.toString());
                break;
            default:
                break;
        }

    }
}
