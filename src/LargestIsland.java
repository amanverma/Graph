import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.IntStream;

public class LargestIsland {
    //At each point where we encounter 0, make it 1 and compute size of largest island so far.
    public static int largestIsland(int[][] grid) {
        Union3 u3 = new Union3(grid.length);
        int max_so_far = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = 1;
                    //fire the algo for UDJS to compute largest island
                    for (int k = 0; k < grid.length; k++) {
                        int[] rel = grid[k];
                        if (rel[0] != rel[1]) {
                            u3.union(rel[0], rel[1]);
                        }
                    }
                    grid[i][j] = 0;
                    u3.buildMapForCurrentGrid(map);
                    for(int v: map.values()){
                        max_so_far = Math.max(max_so_far,v);
                    }
                    map.clear();
                }
            }
        }
        for(int v: map.values()){
            max_so_far = Math.max(max_so_far,v);
        }
        return max_so_far;
    }

    public static void main(String[] args) {
        int[][] grid = new int[2][2];
        int[] one = new int[]{0,1};
        int[] two = new int[]{1,0};
        grid[0] = one;
        grid[1] = two;
        System.out.println(largestIsland(grid));

    }
}

class Union3 {
    int[] root;
    int[] rank;

    int count;

    public Union3(int n) {
        root = new int[n];
        rank = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 1;

        }
    }

    public int find(int x) {
        if (root[x] == x) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX!=rootY){
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            }
            if (rank[rootX] == rank[rootY]) {
                rank[rootX] += 1;
                root[rootY] = rootX;
            }
            count-=1;
        }
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public void buildMapForCurrentGrid(Map<Integer, Integer> map) {
        for(int i = 0 ; i <root.length; i++) {
            int key = find(i);
            if (map.get(key) == null) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }
    }

    public void getMaxArea(HashMap<Integer, Integer> map) {
        for(int i = 0 ; i <root.length; i++){
            int key = find(i);
            if(map.get(key)==null){
                map.put(key, 1);
            }else{
                map.put(key, map.get(key)+1);
            }
        }
    }
}
