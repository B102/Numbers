void iterate(int w, int h, int numbersOfLayers) throws IOException {
        height = h;
        width = w;
        //create layers
        layers = new layer[numbersOfLayers];
        layer inputL = new layer(h * w);
        layer outputL = new layer(OUTPUT_DATA_SIZE);
        layer hiddenL1st = new layer(LAYER_SIZE);
        layer hiddenL2nd = new layer(LAYER_SIZE);
        layers[0] = inputL;layers[1] = hiddenL1st;layers[2] = hiddenL2nd;layers[3] = outputL;
        //create rand() weights
        weight1stand2nd = new double[LAYER_SIZE][h * w];
        for(int i = 0; i < (h * w); i++) {
            for(int j = 0; j < LAYER_SIZE; j++) {
                weight1stand2nd[j][i] = rand();
            }
    	}
        weight2ndand3rd = new double[LAYER_SIZE][LAYER_SIZE];
        for(int i = 0; i < (LAYER_SIZE); i++) {
            for(int j = 0; j < LAYER_SIZE; j++) {
                weight2ndand3rd[j][i] = rand();
            }
    	}
        weight3rdand4th = new double[OUTPUT_DATA_SIZE][LAYER_SIZE];
        for(int i = 0; i < (LAYER_SIZE); i++) {
            for(int j = 0; j < OUTPUT_DATA_SIZE; j++) {
                weight3rdand4th[j][i] = rand();
            }
    	}
        //assign 0 bias
        bias1stand2nd = new double[h * w][1];
        for(int i = 0; i < (h * w); i++){
            bias1stand2nd[i][0] = 0;
        }
        bias2ndand3rd = new double[LAYER_SIZE][1];
        for(int i = 0; i < (LAYER_SIZE); i++){
            bias2ndand3rd[i][0] = 0;
        }
        bias3rdand4th = new double[LAYER_SIZE][1];
        for(int i = 0; i < (LAYER_SIZE); i++){
            bias3rdand4th[i][0] = 0;
        }
        //import training data
        imp();
        //train
        
    }
