package numbers;

import java.util.Arrays;

class JMap {
    
    layer[] layers;
    sample[] sampleSet;
    double[][] target;
    
    void update(JMapCell[][] image, int h, int w){
        target = new double[w][h];
        for (int y = 0; y < h; y++){
            for (int x = 0; x < w; x++){
                target[x][y] = image[x][y].colorVal();
            }
        }
    }
    
    void print2D(){
        for (double[] row : target){
            System.out.println(Arrays.toString(row));
        }
    }
    
    int predict(){
        //does one forward pass
        //return 0 for now
        return 0;
    }
    
    void iterate(){
        //set weight
        //create layers
        //import training data
        //train
    }
    
    void forward(double[][] inputs){
        //bring the inputs into the input layer layers[0]
        //add in the bias 
    }
    
    void backward(double r, sample s) {
        //calculate a gradient and store the updated weights in the neurons
        //(calculate the output layer weights, calculate the hidden layer weight then update all the weights)
    }
    
    void train(int iterations,float rate) {
    	for(int i = 0; i < iterations; i++) {
            for(int j = 0; j < sampleSet.length; j++) {
                forward(sampleSet[j].data);
                backward(rate,sampleSet[j]);
            }
    	}
    }
}
