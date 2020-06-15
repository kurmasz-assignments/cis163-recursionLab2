package gvsucis;

import javax.swing.JPanel;
import java.awt.Graphics;

public class FractalPanel extends JPanel {

  private static final long serialVersionUID = 1L;
  private FractalArtist artist;

  public FractalPanel(FractalArtist artist) {
    super();
    this.artist = artist;
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    artist.draw(g, this.getWidth(), this.getHeight());
  }
}