import java.util.*;
public class matrixpeak{
    public static void main(String[] args){
        System.out.print("Matrix A:");
        int[][] matrix = dimensionInput();
        peakColfinder(matrix);
       
}


//function dimension input receives matrix dimension as wwell aas matrix elements
    public static int[][] dimensionInput(){
            int row=0;
            int column=0;
            Scanner input = new Scanner(System.in);
            while(true){
            String dimension = input.nextLine();
            int position = 0;
            int numberOfAppearances = 0;
            //checks if the matrix dimension is separated by a comma and if yes, how many commas..
            if(dimension.contains(",")==true){
                for(int i=0;i<dimension.length(); i++){
                    if(String.valueOf(dimension.charAt(i)).equals(",")){
                        position=i;
                        numberOfAppearances+=1;
                    }
                }
            }
            //if there are more than one commas, the user is prompted to re-enter dimensions
                if(numberOfAppearances>1){
                        System.out.print("Your format is incorrect");
                        break;
                    }
            //if there is no error from input, the dimensions are parsed into the row and column variables
                try{
                    row = Integer.parseInt(dimension.substring(0,position));
                    column = Integer.parseInt(dimension.substring((position+1), dimension.length()));
                    break;
                    }
                    //catch an error incase user mistakenly inputs any other character aside numbers for the matrix dimensions
                    catch(NumberFormatException e){
                        System.out.println("Your format is incorrect.");
                    }
                }
            //take input for the matrix elements
                Scanner ins = new Scanner(System.in);
                int[][] matrix = new int[row][column];
                for(int i=0; i< row; i++){
                for(int j=0; j < column; j++){
                    int right = 0; 
                while(right==0)//while loop will run as long as right is 0. 
                {
                try{
                //if element of matrix is succefully inputted, right increases to one and the while loop breaks
                matrix[i][j] = ins.nextInt();
                right+=1;}
                //catch error if user inputs any other character except an integer
                catch(InputMismatchException e){System.out.println("Invalid Matrix element. Enter Matrix values again");
                //when an error occurs, right remains 0 and the while loop runs again to retake input for the same row
                ins.next(); //this clears the error from scanner input
                }
                }
            }
        }
        return matrix; 
    }
        

//this function finds the peak column value
public static int[][] peakColfinder(int[][] checkMatrix){
       //for loop for iterating through the rows of the matrix 
       for (int row = 0;row < checkMatrix.length;row++){
       int maxValue = checkMatrix[0][0]; //the maximum value in a particular row
       int peakValue = 0; 
       //for loop iterates and finds the maximum value in a row
       for(int column= 0; column<checkMatrix[row].length; column++){
        if(checkMatrix[row][column]>maxValue){
            maxValue = checkMatrix[row][column];
        }
       }
       //the column of that maximum value is checked with the loop below and stored in the variable position
       int position = 0;
       for(int i=0; i<checkMatrix[row].length;i++){
        if(checkMatrix[row][i]==maxValue){
            position = i;
            break;
        }
       }
       //an iteration is performed through the column of the maximum value to get the minimum value
       int minValue = checkMatrix[row][position];
       for( int i=0; i<checkMatrix.length;i++){
        if( minValue > checkMatrix[i][position]){
            minValue = checkMatrix[i][position]; 
        }
       }
       //the minimum value is compared to the maximum value. if it's the same, then that maximum value is the peak value
       if (minValue == maxValue){
        System.out.println("( "+ (row+1) + ", "+ (position+1)+" )"+ " = " + maxValue);
        System.out.println();

       }



    }
    return checkMatrix;
}

}
