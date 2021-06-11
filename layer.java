import java.util.Arrays;

public class layer {
    double[][] components;
    double[][] bias;
    double[][] weight;
    layer(int id){
        components = new double[id][1];
    }
    layer(int id, int width, int height){
        components = new double[id][1];
        weight = new double[id][height * width];
        for(int i = 0; i < (height * width); i++) {
            for(int j = 0; j < id; j++) {
            	weight[j][i] = rand();
            }
    	}
        bias = new double[id][1];
        for(int i = 0; i < (id); i++){
            bias[i][0] = 0;
        }
    }
    double rand() {
        double min = -100;
        double max = 100;
        double rand = (double)Math.floor(Math.random()*(max-min+1)+min);
        return rand / 100;
    }
    double[][] getData(){
    	return components;
    }
    void print2D(){
        for (double[] row : components){
            System.out.println(Arrays.toString(row));
        }
    }
}
