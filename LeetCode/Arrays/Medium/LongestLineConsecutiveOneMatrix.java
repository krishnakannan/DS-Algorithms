class Solution {
    public int longestLine(int[][] M) {
        
        if (M.length == 0) {
            return 0;
        } else if (M[0].length == 0) {
            return 0;
        }
        
 		int[][] aux = new int[M.length][M[0].length]; 		
        int[][] ldaux = new int[M.length][M[0].length]; 		
        int[][] rdaux = new int[M.length][M[0].length]; 		

 		for (int i = 0; i < M.length; i++) {
 			for (int j = 0; j < M[0].length; j++) {
 				aux[i][j] = M[i][j];
                ldaux[i][j] = M[i][j];
                rdaux[i][j] = M[i][j];
 			}
 		}

 		int max = 0;
       // print(aux);
        
        
 		//Diagonals

 		for (int i = 0; i < aux.length; i++) { 			
 			for (int j = 0; j < aux[0].length; j++) {
                if (M[i][j] == 0) {
                    continue;
                } 

 				if (i > 0 && j > 0 && M[i - 1][j - 1] == 1) { 					
                    ldaux[i][j] = ldaux[i][j] < ldaux[i - 1][j - 1] + 1 ? ldaux[i - 1][j - 1] + 1 : ldaux[i][j];
 				}

 				if (i > 0 && j < aux[0].length - 1 && M[i - 1][j + 1] == 1) {
                    rdaux[i][j] = rdaux[i][j] < rdaux[i - 1][j + 1] + 1 ? rdaux[i - 1][j + 1] + 1 : rdaux[i][j];
 				} 
                
                aux[i][j] = rdaux[i][j] > ldaux[i][j] ? rdaux[i][j] : ldaux[i][j];
 			}
 		}

 		for (int i = 0; i < aux.length; i++) {
 			
 			int count = 0; 			
 			//Left to Right
 			for (int j = 0; j < aux[0].length; j++) {
 				if (M[i][j] == 1) {
 					count++;
 				} else {
 					count = 0;
 				} 				
 				aux[i][j] = aux[i][j] < count ? count : aux[i][j];
 			}            
            count = 0;
 			//Right to Left
 			for (int j = aux[0].length - 1; j >= 0; j--) {
 				if (M[i][j] == 1) {
 					count++;
 				} else {
 					count = 0;
 				} 				
 				aux[i][j] = aux[i][j] < count ? count : aux[i][j];
 			}   
 		}

 		for (int j = 0; j < aux[0].length; j++) {
 			
 			int count = 0; 			
 			//Top to Bottom
 			for (int i = 0; i < aux.length; i++) {
 				if (M[i][j] == 1) {
 					count++;
 				} else {
 					count = 0;
 				} 				
 				aux[i][j] = aux[i][j] < count ? count : aux[i][j];
 			}            
            count = 0;

 			//Bottom to Top
 			for (int i = aux.length - 1; i >= 0; i--) {
 				if (M[i][j] == 1) {
 					count++;
 				} else {
 					count = 0;
 				} 				
 				aux[i][j] = aux[i][j] < count ? count : aux[i][j];
 				max = max < aux[i][j] ? aux[i][j] : max;
 			}   
 		} 	

 		

 		//print(aux);
 		return max;
    }
    
    public void print(int[][] aux) {
        for (int i = 0; i < aux.length; i++) {
 			for (int j = 0; j < aux[0].length; j++) {
 				System.out.print(aux[i][j] + " ");
 			}
 			System.out.println();
 		}
 		System.out.println();
    }
}