import java.io.*;
import java.lang.*;
import java.util.*;

public class GradingSystem{

public static void main(String[] args)
throws  IOException{
    //calling the takeinput function to prompt user for grade input...
    int[] num_scores = takeInput();
    //gradescores received scores array for grading and passes the stat array to graph generator 
    int[] stats = gradeScores(num_scores);
    //graph generator generates graph
    graphGenerator(stats);

}


public static int[] takeInput()
throws  IOException
{   
    //Taking set of grades from the user..
    BufferedReader ins = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter the scores: ");
    String inputted_grades = ins.readLine();

    //Using Split function to append the scores of string datatype into array, string_scores based on white spaces
    String[] string_scores = inputted_grades.split(" ");

    //Store the number of scores inputted by the user
    int number_of_scores = string_scores.length;

    //Initialise the num_scores array and Use the number_of_stores to set the size of the array 
    int[] num_scores = new int[number_of_scores];

    //defining and initializing iteration value
    int i = 0;

    //Pass scores as integers into the num_scores array
    while (i < number_of_scores){
        num_scores[i] = Integer.parseInt(string_scores[i]);
        i++;
    }
    return num_scores; //returns an array of the scores
}

public static int[] gradeScores(int[] num_scores){
    //Initializing minimum score, maximum score, sum of scores, average and stat array...
    int min_score = num_scores[0];
    int max_score = num_scores[0];
    int total = 0;
    double average = 0;
    int number_of_scores = num_scores.length;
    int i = (num_scores.length);
    int[] stat = new int[5];
    do { 
        i--;
        //checking for maximum and minimum score...
        if(min_score > num_scores[i]){
            min_score = num_scores[i];
        }
        if(max_score < num_scores[i]){
            max_score = num_scores[i];
        }
        total += num_scores[i];
        average = (double)total/number_of_scores;

        //Grading scores and appending grade occurrence to stat array
        if(num_scores[i]>=0 && num_scores[i]<=20){
            stat[0]+=1;

        }
        else if(num_scores[i]>=21 && num_scores[i]<=40){
            stat[1]+=1;
        }
        else if(num_scores[i]>=41 && num_scores[i]<=60){
            stat[2]+=1;
        }
        else if(num_scores[i]>=61 && num_scores[i]<=80){
            stat[3]+=1;   
        }
        else if(num_scores[i] > 80 && num_scores[i]<=100){
            stat[4]+=1;   
        }
        else{
            System.out.println("value " + num_scores[i]+ " is out of range hence will be left out of grading");
            continue;
        }

    } while (i>0); 

    //Printing max_value, min_value and average to console...
    System.out.print("Values: ");
    System.out.println("The maximum grade is " + max_score);
    System.out.println("The minimum grade is " + min_score);
    System.out.println("The average is " + average);

    return stat;
}

public static int graphGenerator(int[] stat){
    //Generating the Graph
    System.out.println("                            GRAPH                    ");

    //Setting the Upper boundary of the y axis..
    int upper_bound = Arrays.stream(stat).max().getAsInt();
    
    for( int k = upper_bound; k > 0 ; k--){
        System.out.println(k +"     >");
        for (int frequency:stat){
            if (frequency >= k ){
            System.out.print("            ####### ");}
            else{
            System.out.print("                    ");}
        }

        System.out.println();
    }

    //setting the x axis
    String[] x_label = {"0 - 20", "21 - 40", "41 - 60", "61 - 80", "81 - 100"};

    for(int j=0; j < x_label.length; j++){
        if(j == 0){
            System.out.print("      +___________________");}
        else{
            System.out.print("+___________________");
        }
        }
    System.out.print("+");
    System.out.println();

    for(int j=0; j < x_label.length; j++){
        if(j == 0){
            System.out.print("      I"+"       "+ x_label[j]);}
        else{
            System.out.print("      I"+"      "+x_label[j]);
        }
        }
    System.out.print("     I");
    return stat.length;

}
}