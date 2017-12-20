/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> empMap = new HashMap<>();
        for (Employee employee : employees) {
            empMap.put(employee.id , employee);
        }
        Integer eImportance = 0;
        Queue<Employee> eQueue = new LinkedList<>();
        eQueue.add(empMap.get(id));
        
        
        while(!eQueue.isEmpty()) {
            Employee polled = eQueue.poll();
            eImportance += polled.importance;    
            for (Integer subordinates : polled.subordinates) {
                eQueue.add(empMap.get(subordinates));
            }
        }
        return eImportance;
    }
}