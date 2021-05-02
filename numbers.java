package numbers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class numbers {
    private JMapCell[][] Cells;
    private int width;
    private int height;
    public static void main(String[] args) {
        numbers NumberRecognition = new numbers(64, 64);
        NumberRecognition.initWorkPlace();
    }
    numbers(int w, int h) {
        if (w <= 0)
            throw new IllegalArgumentException("width must be > 0; got " + w);
        
        if (h <= 0)
            throw new IllegalArgumentException("height must be > 0; got " + h);
        
        width = w;
        height = h;
        
    }
    private void initWorkPlace(){
        JFrame frame = new JFrame("Drawing Board");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container contentPane = frame.getContentPane();                         
        contentPane.setLayout(new BorderLayout());                              
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints(); 
                                                                                
        constraints.insets.set(0, 0, 1, 1);
        
        JPanel mapPanel = new JPanel(layout);
        mapPanel.setBackground(Color.GRAY);
        Cells = new JMapCell[width][height];
        
        Pen pen = new Pen();
        
        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                Cells[x][y] = new JMapCell();

                constraints.gridx = x;
                constraints.gridy = y;

                layout.setConstraints(Cells[x][y], constraints);
                
                mapPanel.add(Cells[x][y]);
                Cells[x][y].addMouseListener(pen);
            }
        }
        contentPane.add(mapPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}

