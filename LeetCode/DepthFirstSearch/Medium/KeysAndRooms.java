import java.util.*;
import java.lang.*;
import java.io.*;

class KeysAndRooms {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		List<List<Integer>> rooms = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			List<Integer> roomKeys = new ArrayList<>();
			int key = in.nextInt();
			while (key != -1) {
				roomKeys.add(key);
				key = in.nextInt();
			}
			rooms.add(roomKeys);
		}
		KeysAndRooms kar = new KeysAndRooms();
		System.out.println(kar.canVisitAllRooms(rooms));

	}


	boolean[] visited;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];
        dfs(rooms, 0);        
        for (int i = 0; i < visited.length; i++) {
        	if (!visited[i]) {
        		return false;
        	}
        }
        
        return true;
    }

    public void dfs(List<List<Integer>> rooms, int currentRoom) {    
    	if (currentRoom < 0) {
    		return;
    	}
        visited[currentRoom] = true;
    	if (rooms.get(currentRoom).size() == 0) {
    		return;
    	}    	
    	List<Integer> currentKeys = rooms.get(currentRoom);
    	int size = currentKeys.size();
    	for (int i = 0; i < size; i++) {
    		int currentRoomkey = currentKeys.get(i);
    		if (currentRoomkey != -1) {
    			currentKeys.set(i, -1);
    			dfs(rooms, currentRoomkey);		
    		}    	
    	}    	
    }
}