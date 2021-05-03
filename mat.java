package numbers;

public class mat {
    
    double[][] data;
    int rows,cols;
    
    mat(int rows, int cols){
        data= new double[rows][cols];
        this.rows = rows;
        this.cols = cols;
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                data[i][j] = 0;
            }
        }
    }
}
