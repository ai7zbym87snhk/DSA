import java.util.*;
public class Chocola{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in );
        int row = sc.nextInt();
        int col = sc.nextInt();
        Integer vercost [] = new Integer[col-1];
        Integer horcost [] = new Integer[row-1];

        for(int i =0; i<col-1;i++){
            vercost[i] = sc.nextInt();
        }
        for(int i =0; i<row-1;i++){
            horcost[i] = sc.nextInt();
        }

        // Pointers used to track cost in decensing order
        int h = 0;
        int v = 0;

        // Hp and Vp are same in the start as bar is full
        int hp =1;
        int vp = 1;

        // Sorting both arrays in reverse order
        java.util.Arrays.sort(vercost, Collections.reverseOrder());
        java.util.Arrays.sort(horcost, Collections.reverseOrder());

        int cost = 0;

        while(h<horcost.length && v<vercost.length){
            // Horizontal cut used
            if(vercost[v]<= horcost[h]){
                cost+= (horcost[h]*vp);
                hp++;
                h++;
            }
            // Verticle cut
            else{
                cost += (vercost[v]*hp);
                vp++;
                v++;
            }
        }

        // Ater loop still pieces will remain
        // Horizontal Pieces
        while(h<horcost.length){
                cost+= (horcost[h]*vp);
                hp++;
                h++;
        }

        // Verticle pieces
        while(v<vercost.length){
            cost += (vercost[v] * hp);
            vp++;
            v++;
        }

        System.out.println("The minimum cost for cutting the chocolate is : "+cost);
        sc.close();
    }
}