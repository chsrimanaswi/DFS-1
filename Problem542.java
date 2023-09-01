// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int[][] dirs = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        // temporary state change and adding 0's  to queue is done.
        for(int i=0;i<m;i++)
        {
            for(int j=0; j<n ;j++)
            {
                if(mat[i][j]==1) mat[i][j]=-1;
                else queue.add(new int[]{i,j});
            }
        }
       
        while(!queue.isEmpty())
        {

            int size = queue.size();
            for(int i=0;i<size;i++)
            {
                int[] curr = queue.poll();
                for(int[] dr : dirs){
                   int nr = dr[0]+curr[0];   // checking all 4 directions
                   int  nc = dr[1]+curr[1];
                    if(nr>=0&&nc>=0 && nr<m && nc<n && mat[nr][nc] == -1){ // if not processed
                        mat[nr][nc] = mat[curr[0]][curr[1]]+1;   // popped element is from previous level 
                        queue.add(new int[]{nr,nc});
                    }
                }
            }
        }
      return mat;

    }
}