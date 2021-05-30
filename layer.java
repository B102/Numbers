package numbers;

public class layer {
    double[] components;
    double bias;
    final int INPUT_DATA_SIZE = 1024;
    final int OUTPUT_DATA_SIZE = 10;
    final int LAYER_SIZE = 16;
    layer(String id){
        if (id == "inputL"){
            components = new double[INPUT_DATA_SIZE];
        }
        if (id == "outputL"){
            components = new double[OUTPUT_DATA_SIZE];
        }
        if (id == "hiddenL"){
            components = new double[LAYER_SIZE];
        }
    }
}
