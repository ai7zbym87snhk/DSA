import java.util.*;
public class JobSequencing{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int job [][] = new int[n][2];
        for(int i = 0; i<job.length;i++){
            for(int j = 0; j<job[0].length;j++){
                job[i][j] = sc.nextInt();
            }
        }
        int jobs [][] = new int[n][3];
        for(int i = 0; i<n;i++){
            jobs[i][0] =i;
            jobs[i][1] = job[i][0];
            jobs[i][2] = job[i][1];
        } 
        java.util.Arrays.sort(jobs, Comparator.comparingDouble(o -> o[2]));
        int time = 0;
        int prof = 0;
        ArrayList<Integer>ans = new ArrayList<>();
        for(int i = n-1; i>=0;i--){
            if(jobs[i][1]>time){
                time++;
                prof+= jobs[i][2];
                ans.add(jobs[i][0]);
            }
        }

        System.out.println("You can do maximum : "+time+ " jobs");
        System.out.println("You can get a maximum profit of  : "+prof);
        System.out.println("The jobs you can do are : "+ ans.toString());
        sc.close();
    }
}