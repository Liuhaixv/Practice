package 通过单例线程池无限遍历环形链表;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 通过单例线程池无限遍历环形链表
 */
public class Node implements Runnable {
    public static ExecutorService executorService = Executors.newSingleThreadExecutor();
    public static ArrayList<Node> nodes = new ArrayList<>();
    public static int created = 0;
    int id;
    Node next = null;

    Node() {
        created++;
        id = created;
        nodes.add(this);
        if (created < 10) {
            next = new Node();
        } else if (created == 10) {
            next = nodes.get(0);
            created++;
        }
    }

    Node(String str) {
    }

    public void print() {
        run();
    }

    @Override
    public void run() {
        System.out.println(id);
        System.out.println("线程名:" + Thread.currentThread().getName());
        executorService.execute(next);
    }
}
