import java.util.*;
public class ActivitySelection{
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int starttime [] = new int [n];
    int endtime [] = new int [n];
    // Taking the input for Start time
    for (int i = 0; i<n;i++){
        starttime[i] = sc.nextInt();
    }
    // Input for endtime
    for (int i = 0; i<n;i++){
        endtime[i] = sc.nextInt();
    }

    // Making a 2-D matrix

    int activities [][] = new int[starttime.length][3];
    for(int i = 0; i<starttime.length;i++){
        activities[i][0] = i;   // Storing the indexes
        activities[i][1] = starttime[i];    // Storing its corresponding start time
        activities[i][2] = endtime[i];     // Storing its corresponding end time
    }

    // Sorting the 2-D Array
    java.util.Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

    int maxAct = 1;
    ArrayList <Integer> ans = new ArrayList<>();
    // Selecting A0
    ans.add(activities[0][0]);
    int lastt = activities[0][2];

    for (int i = 1; i<endtime.length;i++){
        // Selecting non overlapping tasks
        if(activities[i][1]>=lastt){
            maxAct++;
            ans.add(activities[i][0]);
            lastt = activities[i][2];
        }
    }

    // Printing the needed

    System.out.println("The max tasks done by one man at atime are : "+maxAct);
    for(int i = 0; i<ans.size();i++){
        System.out.print("A"+ans.get(i) +" ");
    }
    System.out.println();
    sc.close();

  }
}