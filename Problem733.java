//BFS
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length==0) return image;
        int[][] dirs = new int[][]{{0,-1},{-1,0},{1,0},{0,1}};
        int m = image.length;
        int n = image[0].length;
        int orig = image[sr][sc];
        if(orig == color) return image;   // no need to change anything so return the original array
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sr);
        queue.add(sc);

        image[sr][sc] = color;

        while(!queue.isEmpty()){

            int cr = queue.poll();
            int  cc = queue.poll();
            for(int[] dir :dirs){     // check four directions and change
               int  nr = cr+dir[0];
                int nc = cc+ dir[1];
                if(nr>=0&&nc>=0 && nr<m && nc<n && image[nr][nc] == orig){
                    image[nr][nc]=color;    //  change color and add it in queue to process its four directions
                    queue.add(nr);
                    queue.add(nc); 
                    
                }
            }
        }

        return image;
    }
}
//DFS
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length==0) return image;
        int[][] dirs = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        int m = image.length;
        int n = image[0].length;
        int orig = image[sr][sc];
        if(orig == color) return image;
        helper(image, sr, sc, dirs,color,m,n,orig);
        return image;
    }
     public void helper(int[][] image, int sr, int sc, int[][] dirs, int color, int m , int n, int orig){
         //base case
         if(sr<0||sc<0 || sr==m ||sc==n || image[sr][sc] != orig) return;     
         //logic
         image[sr][sc]=color;
         for(int[] dir : dirs){
             int nr = sr+dir[0];
             int nc = sc+dir[1];
             helper(image, nr, nc, dirs,color,m,n,orig);
         }
     }

    }