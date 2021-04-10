import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int n,m;
    public static int[][] graph;
    public static boolean[][] check;

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    graph = new int[n][m];
    check = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j)-'0';
            }
        }
        bfs();
        System.out.println(graph[n-1][m-1]);
    }

    public static void bfs(){
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        Queue<Integer> queue_x = new LinkedList<Integer>();
        Queue<Integer> queue_y = new LinkedList<Integer>();

        queue_x.offer(0);
        queue_y.offer(0);

        check[0][0] = true;

        while(!queue_x.isEmpty()){
            int x = queue_x.poll();
            int y = queue_y.poll();

            for (int i = 0; i < 4; i++) {
                int temp_x = x + dx[i];
                int temp_y = y + dy[i];

                if (temp_x>=0 && temp_x < n && temp_y >= 0 && temp_y<m){
                    if(graph[temp_x][temp_y]==1 && !check[temp_x][temp_y]) {
                        queue_x.offer(temp_x);
                        queue_y.offer(temp_y);

                        check[temp_x][temp_y] = true;

                        graph[temp_x][temp_y] = graph[x][y] + 1;
                    }
                }
            }
        }

    }
}
