1. Disjoint set data structure = Union Find Data Structure => intersection of
        elements of two sets is null.
        2. Implementation of DS => Find and Union functions and their optimizations
        3. Optimisations
        - 1,2,3,4,5,6,
        - Quick Union and
        - Quick Find (O(1)) => Union function => O (N) => overall complexity for
        union of N nodes-> n^2
        - Path Compression -> optimization of Union
        - Union by Rank
        4. The main idea of a “disjoint set” is to have all connected vertices have
        the same parent node or root node, whether directly or indirectly connected.
        To check if two vertices are connected, we only need to check if they have
        the same root node.

        5.  I would highly recommend that you understand and memorize the
        implementation of “disjoint set with path compression and union by rank”.



        Union Class{
public int find(int x); -> Quick find (O(1)), Path compression optimisation for Quick Union
public void union(int x, int y);
public boolean connected(int x, int y);
public Union(int number_of_vertices); //public constructor -> root[i]=i;
        }

        3<-------0----->1---->2
        (0,1), (1,2), (1,3), (2,5)

        0 0 0 0 4 0

        0 1 2 3 4 5

        Quick Find Approach
        We always store the original root node rather than immediate parent nodes
        for each of the unions that are performed on vertices.

class Union{
    int[] root;

    public Union(int n){ //O(n)
        root = new int[n];
        for(int i = 0 ; i <n; i ++){
            root[i]=i;
        }
    }

    public int find(int x){
        return root[x]; //O(1)

    }
    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        for(int i=0 ; i <root.size();i ++){ //O(N)
            if(root[i]==rootY){
                root[i]=rootX;
            }
        }
    }

    public boolean connected(int x, int y){ //check if (1,5) //O(1)
        return find(x)==find(y);
    }


}
    Overall time complexity for single union -> O(n)
        Overall time complexity for all vertices -> O(n^2)
        Union Constructor - O (n)

        ==========================================================



        Quick Union Approach and why it is more efficient than Quick Find ?
        In Quick Union Approach, we are not storing original root node
        for all the elements (new elements of new tree) and hence to check if the
        components are connnected or not, in worst case this may take O(N) time
        complexity.

class Union{
    int[] root;

    public Union(int n){ //O(n)
        root = new int[n];
        for(int i = 0 ; i <n; i ++){
            root[i]=i;
        }
    }

(0,1), (1,2), (1,3), (4,5), (5,6), (2,5)
        0 0 0 0 0 4 4
        0 1 2 3 4 5 6

    public int find(int x){ // without path compression
        while(x!=root[x]){
            x = root[x];
        }
        return x;
    }

    // public int find(int x){ // avg  case <O(N)
    // 	//time complexity of find = O(height) => worst case height = N
    // 	if(root[x]==x){
    // 		return x;
    // 	}
    // 	return root[x] = find(root[x]); //path compression.

    // }
    public void union(int x, int y){ //O(n) due to find complexity.
        int rootX = find(x);//0,0
        int rootY = find(x);//1,2

        if(rootX!=rootY){
            root[rootY]=rootX;
        }
    }

    public boolean connected(int x, int y){ //check if (1,5) //O(1)
        //worst case complexity -> O(N)
        return find(x)==find(y);
    }


}
    Overall time complexity for single union -> less than O(n) in average case
        Overall time complexity for all vertices -> less than O(n^2)
        Union Constructor - O (n)
        However, time complexity in worst case is O(N) when Quick Union results
        in formation of skewed tree. (Line graph).

        Solution to this problem is Union by Rank. Such that maximum height of the
        tree formed by merging the two sub-trees will be at most log N +1.

        Time Complexity for this will be
        1. Find - O log n
        2. Union - O log n
        3. Connected - O log n
        4. Union Constructor - O (n)

        In the wors case scenario, in Find operation , when we repeatedly union
        components of equal rank, the tree height will be at most log(N) + 1, so the
        find operation requires O(logN) time.

        For the union and connected operations, we also need O(logN)
        time since these operations are dominated by the find operation.

        Code

class Union{
    int[] root;
    int[] rank;

    public Union(int n){
        for(int i = 0 ; i <n; i++){
            root[i]=i;
            rank[i]=1;
        }
    }

    public int find(int x){
        if(root[x]==x){
            return x;
        }
        return root[x]= find[root[x]];
    }

    public void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX!=rootY){
            if(rank[rootX]>rank[rootY]){
                root[rootY] = rootX;
            }else if(rank[rootX]<rank[rootY]){
                root[rootX] = rootY;
            }
            if(rank[rootX]==rank[rootY]){
                rank][rootX]+=1;
                root[rootY] = rootX;
            }
        }


    }

}

    The above Code is with
        1. Path Compression
        2. Union by Rank

        implementations and hence time complexity will be near to O(1) also alpha(N).
        Alpha = Inverse Ackerman Function. In practice, this is equal to Constant time
        complexity.



        ================================================================================

        MST

        Spanning Tree -
        - a fully connected graph with no cycles.
        - Number of spanning trees if there are N vertex = N^(N-2).
        - There are exactly N-1 edges in spanning tree.

        Minimum Spanning Tree
        - in a weighted graph, it will the Spanning tree with minimum overall cost.
        - there are two algorithms that we have to prepare
        - Prim's algorithm
        - Kruskal's algorithm.


        Topological Sort -
        - In any DAG, for any edge (U,V) -> U should always pre-date V.
        -
        A------>B
        A<------B

        Shortest Path between two nodes
        - Djikshtra algorithm


        Union Disjoint
        BFS
        DFS




