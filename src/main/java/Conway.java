import java.util.Arrays;

public class Conway {

    static int rows=10;
    static int columns =10;
    static String[][]grid={
            {"+","+","#","+","+","+","+","+","+","+"},
            {"+","+","#","#","#","+","+","+","+","+"},
            {"+","+","+","+","+","+","+","+","+","+"},
            {"+","+","+","+","+","+","+","+","+","+"},
            {"+","+","+","+","+","+","+","+","+","+"},
            {"+","+","+","+","+","+","+","+","+","+"},
            {"+","+","+","+","+","+","+","+","+","+"},
            {"+","+","+","+","+","+","+","+","+","+"},
            {"+","+","+","+","+","+","+","+","+","+"},
            {"+","+","+","+","+","+","+","+","+","+"},
    };

    static String[][]future_grid=new String[rows][columns];



    public static String ShowBoard(){
        System.out.println("Input");
        for (String[] arr:grid){
            System.out.println(Arrays.toString(arr));
        }
        int aliveNeighbors=0;

        for (int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                try {
                    if (grid[i][j + 1] == "#") {
                        aliveNeighbors+=1;
                        //Right Neighbor
                    }
                }catch (ArrayIndexOutOfBoundsException ignore){}
                try {
                    if (grid[i][j - 1] == "#") {
                        aliveNeighbors+=1;
                        //Left Neighbor
                    }
                }catch (ArrayIndexOutOfBoundsException ignore){

                }

                try {
                if(grid[i+1][j]=="#"){
                    aliveNeighbors+=1;
                    //Bottom Neigbor
                }
                }catch (ArrayIndexOutOfBoundsException ignore){

                }

                try {
                if(grid[i-1][j]=="#"){
                    aliveNeighbors+=1;
                    //Top Neighbor
                }
                }catch (ArrayIndexOutOfBoundsException ignore){

                }

                try{
                if(grid[i+1][j+1]=="#"){
                    aliveNeighbors+=1;
                    //aliveNeighbor in the bottom right
                }
                }catch (ArrayIndexOutOfBoundsException ignore){

                }
                try {
                if (grid[i-1][j-1]=="#"){
                    aliveNeighbors+=1;
                    //Top left Neighbor
                }
                }catch (ArrayIndexOutOfBoundsException ignore){

                }

                try {
                if (grid[i+1][j-1]=="#"){
                    aliveNeighbors+=1;
                    
                    //Bottom left Neighbor
                }
                }catch (ArrayIndexOutOfBoundsException ignore){

                }

                try {
                if (grid[i-1][j+1]=="#"){
                    aliveNeighbors+=1;
                    
                    //Top right Neighbor
                }
                }catch (ArrayIndexOutOfBoundsException ignore){

                }
                if(aliveNeighbors<2){
                    future_grid[i][j]="+";
                }else if(grid[i][j]=="#" && aliveNeighbors==2){
                    future_grid[i][j]="#";
                }else if(aliveNeighbors>3){
                    future_grid[i][j]="+";
                }else if(aliveNeighbors==3){
                    future_grid[i][j]="#";
                }else {
                    future_grid[i][j]="+";
                }
                aliveNeighbors=0;
            }
        }
        StringBuilder result = new StringBuilder();
        System.out.println("\n Next Generation");
        for (String[] arr : future_grid) {
            result.append(Arrays.toString(arr)).append("\n");
        }
        return result.toString();
    }
}



