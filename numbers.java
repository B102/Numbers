package numbers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class numbers {
    
    JMapCell[][] Cells;
    private int width;
    private int height;
    
    public static void main(String[] args) {
        numbers NumberRecognition = new numbers(32, 32);
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
        
        Container contentPane = frame.getContentPane();                         //spits out the ContentPane for "frame"
        contentPane.setLayout(new BorderLayout());                              //ContentPane updates b/c cP=frame.cP
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints(); 
                                                                                //setup the constraints for components in this class
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
                Cells[x][y].xCoord = x;
                Cells[x][y].yCoord = y;
            }
        }
        contentPane.add(mapPanel, BorderLayout.CENTER);
        
        JButton findPathButton = new JButton("Compile Map");
        findPathButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { compileMap(); }

            private void compileMap() {
                JMap Map = new JMap();
                Map.load(Cells);
            }
        });
        
        contentPane.add(findPathButton, BorderLayout.SOUTH);
        
        frame.pack();
        frame.setVisible(true);
    }
    
    class Pen implements MouseListener{
        private int drawn;
        private int colored = 0;
        private double timeStart;
        private double timeExit;
        private boolean drawing;
        @Override
        public void mousePressed(MouseEvent e){
            drawing = true;
        }

        @Override
        public void mouseReleased(MouseEvent e){
            drawing = false;
        }

        @Override
        public void mouseEntered(MouseEvent e){
            if (drawing){
                timeStart = System.currentTimeMillis();
            }
        }

        @Override
        public void mouseExited(MouseEvent e){
            if (drawing){
                timeExit = System.currentTimeMillis();
                JMapCell cell = (JMapCell) e.getSource();
                colored = cell.colorVal();
                double center = timeExit - timeStart;
                //double ambient = center * 0.1;
                if(cell.xCoord != 0 && cell.xCoord != 63 && cell.yCoord != 0 && cell.yCoord != 63){
                    /*
                    Cells[cell.xCoord + 1][cell.yCoord].setColor(compileColor(ambient));
                    Cells[cell.xCoord][cell.yCoord - 1].setColor(compileColor(ambient));
                    Cells[cell.xCoord][cell.yCoord + 1].setColor(compileColor(ambient));
                    Cells[cell.xCoord - 1][cell.yCoord].setColor(compileColor(ambient));
                    */
                    cell.setColor(compileColor(center));
                }else{
                    cell.setColor(compileColor(center));
                }
            }
        }

        @Override
        public void mouseClicked(MouseEvent e){
            JMapCell cell = (JMapCell) e.getSource();
            cell.setColor(0);
        }

        int compileColor(double time){
            double grayScale = 185 - time;
            if(colored != 0) {
                grayScale -= (255 - colored);
            }
            if(grayScale < -100){
                grayScale = 0;
            }
            if(grayScale < 0){
                grayScale = 30;
            }
            drawn = (int)grayScale;
            return drawn;
        }
    }
}
