package gvsucis;

import java.awt.Graphics;

public class TreeArtist implements FractalArtist {

  public void draw(Graphics g, int width, int height) {
   
    drawTree(g, width, height / 10, width / 2, 0, 10);
    
  }

  private void drawTree(Graphics g, int levelWidth, int levelHeight, int root_x, int root_y, int depth) {

      if (depth == 0) {
        return;
      }

      int quarterWidth = levelWidth / 4;
      g.drawLine(root_x, root_y, root_x - quarterWidth, root_y + levelHeight);
      g.drawLine(root_x, root_y, root_x + quarterWidth, root_y + levelHeight);
      drawTree(g, levelWidth / 2, levelHeight, root_x - quarterWidth, root_y + levelHeight, depth-1);
      drawTree(g, levelWidth / 2, levelHeight, root_x + quarterWidth, root_y + levelHeight, depth-1);
  }  
}