/*
    If a rabbit says 2 other rabbits are of same color.

    then there are 3 rabbits in same color.

    We can use this fact to group 3 rabbits. 

    If fourth rabbit says 2 other rabbits are of same color we know that it is different color

    and now we create different group consisting 3 rabbits.

    We use the following formula.


                                          
     Math.ceil  of  ((No of answers) / (Max number of rabbits that we can accomodate in that group)) * (Max number of rabbits that we can accomodate in that group)
                      
*/

class Solution {
    public int numRabbits(int[] answers) {
        int[] uniqAnswers = new int[1000];
        
        int rabbits = 0;
        
        for (int i = 0; i < answers.length; i++) {            
            uniqAnswers[answers[i]]++;                     
        }
        
        for (int i = 1; i < uniqAnswers.length; i++) {
            
            if (uniqAnswers[i] % (i + 1) == 0) {
                rabbits += uniqAnswers[i];
            } else {
                double val = Math.ceil((double)uniqAnswers[i] / (i  + 1));
                //System.out.println(uniqAnswers[i] + "/" + i + " = " + val);
                rabbits += (i  + 1) * (int)val;
            }
        }
        
        rabbits += uniqAnswers[0];
        
        return rabbits;
        
    }
}