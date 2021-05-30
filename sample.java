package numbers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;

public class sample {
    
    double[][] data;
    int expectedOutput;
    final int OFFSET = 2;
    public sample(int w, int h) {
        data = new double[w][h];
    } 
    void read() throws IOException {
        int w = 32;
        int h = 30;
        //this will take an image and converts it into a double array with values for each pixel
        BufferedImage image = null;//image store../Users/shuuihisashi/Desktop
        //read
        try{
            File input = new File("/Users/shuuihisashi/Desktop/JavaImage/4.png");
            image = new BufferedImage(w, h, BufferedImage.TYPE_BYTE_GRAY);
            image = ImageIO.read(input);
            for(int y = 0; y < data.length - OFFSET; y++){
                for(int x = 0; x < data[0].length; x++){
                    data[x][y] = image.getRGB(x, y)/100000;
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
