class Solution {
    //Solution is based on arrival times
    
    class Car {
        int position;
        int speed;
        public Car(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
    }
    
    Stack<Double> arrivalTimes;
    public int carFleet(int target, int[] position, int[] speed) {
        arrivalTimes = new Stack<>();
        int fleets = 0;
        Car[] cars = new Car[position.length];
        for (int i = 0; i < position.length; i++) {
            cars[i] = new Car(position[i], speed[i]);            
        }
        Arrays.sort(cars, new Comparator<Car>(){
            public int compare(Car a, Car b) {
                return b.position - a.position;
            }
        });
        
        for (Car car : cars) {
            if (arrivalTimes.isEmpty()) {
                arrivalTimes.push(getArrivalTime(target, car));
            } else {
                double arrivalTime = getArrivalTime(target, car);
                if (arrivalTimes.peek() < arrivalTime) {
                    arrivalTimes.add(arrivalTime);
                }
            }            
        }
        return arrivalTimes.size();
    }
    
    public double getArrivalTime(int target, Car car) {
        return ((double)(target - car.position) / car.speed);
    }
}