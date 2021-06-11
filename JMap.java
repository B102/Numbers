import java.io.IOException;
import java.util.Arrays;

class JMap {
    sample[] sampleSet = new sample[16];
    layer[] layers;
    double[][] target;
    private int width;
    private int height;
    final int OUTPUT_DATA_SIZE = 10;
    final int LAYER_SIZE = 16;
    void updateInput(JMapCell[][] image, int h, int w){
        target = new double[h * w][1];
        int vectorDim = 0;
        for (int y = 0; y < h && vectorDim < (h * w); y++){
            for (int x = 0; x < w && vectorDim < (h * w); x++){
                target[vectorDim][0] = image[x][y].colorVal();
                vectorDim++;
            }
        }
        System.out.println("Input Updated");
    }
    void updateSample(double[][] image, int h, int w){
        target = new double[h * w][1];
        int vectorDim = 0;
        for (int y = 0; y < h && vectorDim < (h * w); y++){
            for (int x = 0; x < w && vectorDim < (h * w); x++){
                target[vectorDim][0] = image[x][y];
                vectorDim++;
            }
        }
        System.out.println("Sample Updated");
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
    
    void iterate(int w, int h, int numbersOfLayers) throws IOException {
        height = h;
        width = w;
        layers = new layer[numbersOfLayers];
        //create layers, assign 0 bias, create random weights
        layer inputL = new layer(h * w);
        layer outputL = new layer(OUTPUT_DATA_SIZE, 1, LAYER_SIZE);
        layer hiddenL1st = new layer(LAYER_SIZE, h, w);
        layer hiddenL2nd = new layer(LAYER_SIZE, 1, LAYER_SIZE);
        //System.out.println();
        layers[0] = inputL;layers[1] = hiddenL1st;layers[2] = hiddenL2nd;layers[3] = outputL;
        //import training data
        imp();
        train(1, 0.2f);
        
    }
    
    void imp() throws IOException{
        sample s41 = new sample(width, height, "/Users/shuuihisashi/Desktop/samples/41.png"); sampleSet[0] = s41;s41.expectedOutput = 4;
        sample s42 = new sample(width, height, "/Users/shuuihisashi/Desktop/samples/42.png"); sampleSet[1] = s42;s42.expectedOutput = 4;
        sample s43 = new sample(width, height, "/Users/shuuihisashi/Desktop/samples/43.png"); sampleSet[2] = s43;s43.expectedOutput = 4;
        sample s44 = new sample(width, height, "/Users/shuuihisashi/Desktop/samples/44.png"); sampleSet[3] = s44;s44.expectedOutput = 4;
        sample s45 = new sample(width, height, "/Users/shuuihisashi/Desktop/samples/45.png"); sampleSet[4] = s45;s45.expectedOutput = 4;
        sample s46 = new sample(width, height, "/Users/shuuihisashi/Desktop/samples/46.png"); sampleSet[5] = s46;s46.expectedOutput = 4;
        sample s47 = new sample(width, height, "/Users/shuuihisashi/Desktop/samples/47.png"); sampleSet[6] = s47;s47.expectedOutput = 4;
        sample s48 = new sample(width, height, "/Users/shuuihisashi/Desktop/samples/48.png"); sampleSet[7] = s48;s48.expectedOutput = 4;
        sample s49 = new sample(width, height, "/Users/shuuihisashi/Desktop/samples/49.png"); sampleSet[8] = s49;s49.expectedOutput = 4;
        sample s410 = new sample(width, height, "/Users/shuuihisashi/Desktop/samples/410.png"); sampleSet[9] = s410;s410.expectedOutput = 4;
        sample s411 = new sample(width, height, "/Users/shuuihisashi/Desktop/samples/411.png"); sampleSet[10] = s411;s411.expectedOutput = 4;
        sample s412 = new sample(width, height, "/Users/shuuihisashi/Desktop/samples/412.png"); sampleSet[11] = s412;s412.expectedOutput = 4;
        sample s413 = new sample(width, height, "/Users/shuuihisashi/Desktop/samples/413.png"); sampleSet[12] = s413;s413.expectedOutput = 4;
        sample s414 = new sample(width, height, "/Users/shuuihisashi/Desktop/samples/414.png"); sampleSet[13] = s414;s414.expectedOutput = 4;
        sample s415 = new sample(width, height, "/Users/shuuihisashi/Desktop/samples/415.png"); sampleSet[14] = s415;s415.expectedOutput = 4;
        sample s416 = new sample(width, height, "/Users/shuuihisashi/Desktop/samples/416.png"); sampleSet[15] = s416;s416.expectedOutput = 4;
    }
    void forward(sample input){
        //bring the inputs into the input layer layers[0]
    	lib cal = new lib();
    	layers[0].components = input.data;
    	for(int i = 0; i < layers.length - 1; i++) {
    		layers[i + 1].components = cal.matAdd(cal.dotMul(layers[i + 1].weight, layers[i].getData()), layers[i + 1].bias);
    	}
    	layers[3].print2D();
    	System.out.println(" ");
    }
    
    void backward(double r, sample s) {
        //calculate a gradient and store the updated weights in the neurons
        //(calculate the output layer weights, calculate the hidden layer weight then update all the weights)
    }
    
    void train(int iterations,float rate) {
    	for(int i = 0; i < iterations; i++) {
            for(int j = 0; j < sampleSet.length; j++) {
                forward(sampleSet[j]);
                backward(rate,sampleSet[j]);
            }
    	}
    }
}
