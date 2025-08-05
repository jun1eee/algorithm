import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int t = 0; t < n; t++) {
            String str = sc.next();

            switch (str) {
                case "push_back":
                    int num = sc.nextInt();
                    list.add(num);
                    break;

                case "pop_back":
                    if (!list.isEmpty()) {
                        list.remove(list.size() - 1);
                    }
                    break;

                case "size":
                    System.out.println(list.size());
                    break;

                case "get":
                    int idx = sc.nextInt();
                    if (idx >= 1 && idx <= list.size()) {
                        System.out.println(list.get(idx - 1));
                    }
                    break;
            }
        }
    }
}
