
public class Hanoi
{
    public static Tower left;
    public static Tower mid;
    public static Tower right;

    public static void main(String[] args) {
        int size = args.length > 0 ? Integer.parseInt(args[0]) : 3;
        left = new Tower(size);
        mid = new Tower();
        right = new Tower();
        printTower(size);
        move(size, left, mid, right);
    }

    public static void move(int count, Tower leftTower, Tower midTower, Tower rightTower)
    {
        if (count == 0) return;

        move(count - 1, leftTower, rightTower, midTower); //  Swap the "mid" with "right"

        // Move the actual disk
        midTower.size++;
        leftTower.size--;
        printTower(count);

        move(count - 1, rightTower, midTower, leftTower);
    }

    public static void printTower(int count)
    {
        System.out.println("\033[2J");

        int max = Math.max(left.size, Math.max(mid.size, right.size));
        for (int i = max; i >= 0; i--) {
            if (i == left.size) System.out.print(" _\t");
            else if (i < left.size) System.out.print("| |\t");
            else System.out.print("   \t");
            
            if (i == mid.size) System.out.print(" _\t");
            else if (i < mid.size) System.out.print("| |\t");
            else System.out.print("   \t");

            if (i == right.size) System.out.print(" _\t");
            else if (i < right.size) System.out.print("| |\t");
            else System.out.print("   \t");
            System.out.println();
        }
        System.out.println("ITERATION: " +  count);
        try {
            Thread.sleep(700);
        } catch (InterruptedException ignored) {};
    }

    public static class Tower {
        private int size;
        
        public Tower(int size) {
            this.size = size;
        }
    
        public Tower() {
            this(0);
        }
    }
}
