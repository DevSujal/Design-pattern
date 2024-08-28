import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Employee {
    int id, sal;
    String pos, name;

    Employee left, right;

    Employee(int id, String name, int sal, String pos) {
        this.id = id;
        this.sal = sal;
        this.pos = pos;
        this.name = name;
    }

    @Override
    public String toString() {

        return pos;
    }
}

class Organization {
    Employee head = null;
    static int id = 1;
    Scanner sc = new Scanner(System.in);

    public Employee createEmployees() {
        Employee root = new Employee(id++, "vansh", 1000, "ceo");
        root.left = new Employee(id++, "sujal", 999, "sales manager");
        root.right = new Employee(id++, "shivansh", 999, "marketing manager");
        head = root;
        root.left.left = new Employee(id++, "prasad", 99, "sales person1");
        root.left.right = new Employee(id++, "akshat", 99, "sales person2");

        root.right.left = new Employee(id++, "rishi", 99, "marketing person1");
        root.right.right = new Employee(id++, "vidit", 99, "marketing person2");

        return head;
    }

    public int findLevel(Employee root, int key, int level) {
        if (root == null) {
            return -1;
        }

        if (root.id == key) {
            return level;
        }

        return Math.max(findLevel(root.left, key, level + 1), findLevel(root.right, key, level + 1));

    }

    public void levelOrder(Employee root) {
        Queue<Employee> q = new LinkedList<>();
        q.add(null);
        q.add(root);
        boolean isNullCame = false;
        while (!q.isEmpty()) {
            Employee curr = q.poll();
            if (curr == null) {
                if (q.isEmpty()) {
                    return;
                }
                q.add(null);
                System.out.println();
                isNullCame = true;
                continue;
            }

            int level = findLevel(root, curr.id, 0);
            if (isNullCame) {

                for (int i = 0; i < 2 - level; i++) {
                    System.out.print(" ");
                }
                isNullCame = false;
            }

            System.out.print(curr);
            for (int i = 0; i < 3 - level; i++) {
                System.out.print(" ");
            }

            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
    }

    public int sumSal(Employee root) {

        if (root == null)
            return 0;
        return root.sal + sumSal(root.left) + sumSal(root.right);
    }
}

class Test {
    public static void main(String[] args) {
        Organization o = new Organization();

        Employee root = o.createEmployees();
        o.levelOrder(root);
        System.out.println();
        System.out.println("sum for : " + root.left.pos);
        System.out.println(o.sumSal(root.left));
    }
}
