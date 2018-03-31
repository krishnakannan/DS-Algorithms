class SnakeGame {

    int rows;
    int cols;
    LinkedList<int[]> snake;
    int[][] food;
    int foodCounter;
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        
        this.rows = height;
        this.cols = width;        
        snake = new LinkedList<int[]>();
        snake.addFirst(new int[]{0,0});
        this.food = food;
        this.foodCounter = 0;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {                
        int[] nextPos = getNextSafePos(direction.charAt(0), snake.peekFirst());                                
        if (nextPos.length == 0) {
            return -1;
        }        
        
        
        if (!isFoodPos(nextPos) && !snake.isEmpty()) {
            snake.pollLast();    
        }                        
        snake.addFirst(nextPos);                  
        //printSnake();
        return snake.size() - 1;
    }
    
    public boolean isFoodPos(int[] pos) {    
        if (foodCounter < food.length && pos[0] == food[foodCounter][0] && pos[1] == food[foodCounter][1]) {
            foodCounter++;
            return true;
        }
        return false;
    }    
    
    public int[] getNextSafePos(char direction, int[] coords) {                        
        int r = coords[0];
        int c = coords[1];
        int nr = -1;
        int nc = -1;
        if (direction == 'U' && r > 0) {
            nr = r - 1;
            nc = c;            
        } else if (direction == 'L' && c > 0) {
            nr = r;
            nc = c - 1;
        } else if (direction == 'D' && r < rows - 1) {
            nr = r + 1;
            nc = c;
        } else if (direction == 'R' && c < cols - 1) {
            nr = r;
            nc = c + 1;
        } else {
          return new int[]{};  
        }        
        int[] nextPos = new int[]{nr, nc};
        if (isSnakeBody(nextPos)) {
            return new int[]{};
        }
        return nextPos;
        
    }
    
    public boolean isSnakeBody(int[] coord) {
        //System.out.println("Checking " + coord[0] + "," + coord[1] + " SNAKE TAIL " + snake.peekLast()[0] + "," + snake.peekLast()[1]);
        boolean isBody = false;
        for (int[] sCoord : snake) {
            if (coord[0] == sCoord[0] && coord[1] == sCoord[1]) {                
                isBody = true;
                break;
            }
        }
        
        if (isBody) {
             if (snake.peekLast()[0] != coord[0] || snake.peekLast()[1] != coord[1]) {
                 return true;
             }
        }
        
        return false;
    }
    
    public void printSnake() {
        for (int[] sCoord : snake) {
            System.out.print(sCoord[0] +","+ sCoord[1] + " ");
        }
        System.out.println();
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */