import java.util.*;
public class matrixmodular{
    public static void main(String[] arg){
        //for loop gives user 5 attempts in case of unmatching matrixes
        for(int i=0; i<5; i++){
        System.out.println("matrix A: ");
        int[][] matrixA = dimensionInput();
        System.out.println("matrix B: ");
        int[][] matrixB = dimensionInput();
        //checks if row of matrix A matches the column of matrix B
        if(matrixA.length==matrixB[0].length){
        product(matrixA, matrixB);
        break;}
        else{
            System.out.println("the row of matrix A must match with column of matrix B. You have " +(4-i)+" tries remaining");
        }
    }
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

    //function finds the product of the two matrixes
    public static int[][] product(int[][] matrixA, int[][] matrixB){
        int[][] resultant =new int[matrixA.length][matrixB[0].length];
        for(int i = 0; i<matrixA.length; i++){
            for(int b = 0; b<matrixB[0].length; b++){
                for(int c=0; c < matrixB.length; c++){
                    resultant[i][b] += matrixA[i][c]*matrixB[c][b];
                }

            }
        }
        for(int i=0; i < matrixA.length; i++){
            System.out.print("| ");
            for(int j=0; j<matrixB[0].length; j+=1){

                System.out.print(resultant[i][j] + " ");
            }
            System.out.print("| ");
            System.out.println();
        }
        return resultant;
    }
    
}
