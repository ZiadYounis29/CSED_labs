package Lab3;

public class SearchArrays implements ISearchArrays {
    @Override
    public int countIslands(int[][] grid){
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int count=0;
        for (int i = 0 ; i <rows ; i++){
            for(int j = 0 ; j < cols ; j++){
                if ( grid[i][j] == 1){
                    count++;
                    dfs(grid, i , j);
                }
            }
        }
        return count;
    }
    private void dfs(int[][] grid ,int row,int col){
        int rows = grid.length;
        int cols = grid[0].length;
        if(row>=rows || row<0 || col>=cols || col<0 || grid[row][col] ==0)
            return;
        grid[row][col]=0;
        dfs(grid,row ,col +1);
        dfs(grid,row +1 ,col);
        dfs(grid,row ,col -1);
        dfs(grid,row-1 ,col);
        return;
    }

    public boolean searchWord(char[][] grid, String word){
        if (grid == null || grid.length == 0 || word==null || grid[0].length == 0) return false;
        int wordLen = word.length();
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0 ;j<m;j++)
                for(int k=j ;(k-j<wordLen)&&(k<m);k++){
                    if(grid[i][k] != word.charAt(k-j))
                        break;
                    if(k-j==wordLen-1)
                        return true;
                }
        }
        for(int j=0;j<m;j++){
            for(int i=0 ;i<n;i++)
                for(int k=i ;(k-i<wordLen)&&(k<n);k++){
                    if(grid[k][j] != word.charAt(k-i))
                        break;
                    if(k-i==wordLen-1)
                        return true;
                }
        }
        return false;
    }


}
