package hw_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        final RedBlackTree tree = new RedBlackTree();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                try {
                    int value = Integer.parseInt((reader.readLine()));
                    tree.add(value);
                    System.out.println("finish");
                } catch (Exception ignored) {

                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // HashMap map = new HashMap();
        // map.push(1, 2);
        // map.push(3, 4);
        //
        // System.out.println(map.find(3));
        // System.out.println(map.find(2));
        //
        // map.remove(3);
        // map.push(2, 5);
        // System.out.println(map.find(3));
        // System.out.println(map.find(2));

        // Tree tree = new Tree();

        // for(int i=1; i<=5; i++){
        // tree.insert(i);
        // }

    }

}