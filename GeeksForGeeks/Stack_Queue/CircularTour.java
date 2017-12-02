/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


// In java function tour() takes two arguments array of petrol
// and array of distance
class GfG
{
	class PetrolPump {
		int currentCapacity;
		int distanceToNext;
		boolean exploredAsStart = false;
		public PetrolPump() {/*  */}
		public PetrolPump(int currentCapacity, int distanceToNext) {
			this.currentCapacity = currentCapacity;
			this.distanceToNext = distanceToNext;
		}
	}

    int tour(int petrol[], int distance[]) {
    	//List<PetrolPump> pumps = new ArrayList<>();
    	Queue<PetrolPump> circularQueue = new LinkedList<>();
    	int truckCapacity = 0;
    	int visited = 0;
    	int startPump = 0;
    	//Initialize PetrolPump & put it in Queue
		for (int i = 0; i < petrol.length; i++) {			
			circularQueue.add(new PetrolPump(petrol[i], distance[i]));
		}
		Queue<PetrolPump> currentTour = new LinkedList<>();
		currentTour.addAll(circularQueue);
		//First Store in Queue
		while(!circularQueue.peek().exploredAsStart) {
			
			int distanceToNext = currentTour.peek().distanceToNext;
			truckCapacity += currentTour.peek().currentCapacity;
			currentTour.add(currentTour.poll());
			visited++;
			//Not possible to proceed.
			if (truckCapacity < distanceToNext){
				visited = 0;
				startPump += 1;
				circularQueue.peek().exploredAsStart = true;
				circularQueue.add(circularQueue.poll());
				currentTour.clear();
				currentTour.addAll(circularQueue);
			} else {
				if (visited == petrol.length - 1){
					return startPump;
				}
			}
		}
		return -1;
    }
}