package algorithms;

import java.util.*;

public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> employeeById = new HashMap<>();
        for (Employee employee : employees) {
            employeeById.put(employee.id, employee);
        }

        return bfs(id, new LinkedList<>(), employeeById);
    }

    private int bfs(int startId, Queue<Integer> toVisit, Map<Integer, Employee> graph) {
        toVisit.offer(startId);
        int val = 0;

        while (!toVisit.isEmpty()) {
            int id = toVisit.poll();
            Employee emp = graph.get(id);
            val += emp.importance;

            List<Integer> subs = emp.subordinates;
            toVisit.addAll(subs);
        }
        return val;
    }

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    };
}
