package numbers;

import java.awt.*;
import javax.swing.*;

class JMapCell extends JComponent{
    private static final Dimension CELL_SIZE = new Dimension(9, 9);
    private int Drawn = 0;
    int xCoord;
    int yCoord;
    JMapCell(int color){
        setPreferredSize(CELL_SIZE);
        setColor(color);
    }
    
    JMapCell(){
        setPreferredSize(CELL_SIZE);
        setColor(0);
    }
    
    void setColor(int color){
        Drawn = color;
        updateAppearance();
    }
    
    int colorVal(){
        return Drawn;
    }
    
    private void updateAppearance(){
        if (Drawn != 0){
            setBackground(new java.awt.Color(Drawn, Drawn, Drawn));
        }else{
            setBackground(Color.WHITE);
        }
    }
    
    @Override
    protected void paintComponent(Graphics g){
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
