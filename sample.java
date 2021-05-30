package numbers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;

public class sample {
    
    double[][] data;
    int expectedOutput;
    int height;
    int width;
    String name;
    final int OFFSET = 2;
    //IMPORTANT: all samples should be the same size
    public sample(int w, int h, String n) throws IOException {
        data = new double[h * w][1];
        height = h;
        width = w;
        name = n;
        read();
    } 
    void read() throws IOException {
        int w = 32;
        int h = 30;
        //this will take an image and converts it into a double array with values for each pixel
        BufferedImage image = null;//image store../Users/shuuihisashi/Desktop
        //read
        try{
            File input = new File(name);
            image = new BufferedImage(w, h, BufferedImage.TYPE_BYTE_GRAY);
            image = ImageIO.read(input);
            int vectorDim = 0;
            for(int y = 0; y < height - OFFSET && vectorDim < (h * w); y++){
                for(int x = 0; x < width && vectorDim < (h * w); x++){
                    data[vectorDim][0] = (image.getRGB(x, y)/100000) * (-1);
                    vectorDim++;
                }
            }
            System.out.println("Read");
        }
        catch(IOException e){
            System.out.println("Error: "+e);
        }
    }
    void print2D(){
        for (double[] row : data){
            System.out.println(Arrays.toString(row));
        }
    }
}
