package archive.algorithms;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> taskCnts = new HashMap<>();
        for (char c : tasks) {
            int cnt = taskCnts.getOrDefault(c, 0);
            taskCnts.put(c, cnt+1);
        }

        List<Task> taskList = taskCnts.entrySet().stream().map(e -> new Task(e.getKey(), e.getValue(), 0)).collect(Collectors.toList());
        PriorityQueue<Task> taskQ = new PriorityQueue<>(taskList);

        int cnt = 0;
        while (!taskQ.isEmpty()) {
            Task top = taskQ.poll();
            if (top.rest != 0) {
                top.rest--;
                System.out.println("IDLE");
            } else {
                if (top.cnt == 1) {
                    System.out.println("DONE" + top);
                } else {
                    top.cnt--;
                    top.rest = 2;
                    taskQ.offer(top);
                }
            }
            cnt++;
        }
        return cnt;
    }

    @EqualsAndHashCode
    @ToString
    class Task implements Comparable<Task> {
        char name;
        int cnt;
        int rest;

        public Task(char name, int cnt, int rest) {
            this.name = name;
            this.cnt = cnt;
            this.rest = rest;
        }

        @Override
        public int compareTo(Task o) {
            if (o.rest != this.rest) {
                return this.rest - o.rest;
            } else  {
                return this.cnt - o.cnt;
            }
        }
    }

    public static void main(String[] args) {
        TaskScheduler ts = new TaskScheduler();
        char[] work = {'a', 'a', 'b', 'b', 'a'};
        int n = ts.leastInterval(work, 2);
        System.out.println(n);
    }
}
