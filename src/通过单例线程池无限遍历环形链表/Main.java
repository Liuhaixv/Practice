package 通过单例线程池无限遍历环形链表;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Node node = new Node();
        for (int i = 1; i < 100; i++) {
            new Node();
        }
        node.print();
    }
}