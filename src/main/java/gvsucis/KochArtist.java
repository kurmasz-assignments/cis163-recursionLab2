package gvsucis;

import java.awt.geom.Point2D;
import java.awt.Graphics;

public class KochArtist implements FractalArtist {

  public void draw(Graphics g, int width, int height) {

    g.drawString("Your code goes here", 100, 100);

    // 
  }

  // 

  // Find the points of the "peak" along the line from start to end.
  private Point2D.Double[] peakedLine(Point2D.Double start, Point2D.Double end) {

    double diffx = (end.x - start.x); // change in x coordinates
    double diffy = (end.y - start.y); // change in y coordinates
    double length = Math.sqrt((start.x - end.x) * (start.x - end.x) + (start.y - end.y) * (start.y - end.y));

    // Find the location of the two intermediate points on the line that
    // form the base of the peak.
    Point2D.Double firstThird = new Point2D.Double(start.x + (diffx / 3.0), start.y + diffy / 3.0);
    Point2D.Double secondThird = new Point2D.Double(start.x + 2.0 * (diffx / 3.0), start.y + 2.0 * diffy / 3.0);

    // Find the angle of the line above the x axis.
    double current_theta = Math.asin(diffy / length);
    if (diffx < 0) {
      current_theta = Math.PI - current_theta;
    }

    // The line in the center of the peak is perpendicular to the line we're
    // drawing. Thus, it's angle above the x axis is arcsin(1/2) degrees
    // greater than current_theta. (To see why this is, you'll need a
    // picture with the lines, angles, and lengths labeled.)
    double new_theta = current_theta + Math.asin(.5);

    // Find the distance of the peak from the line.
    double peak_height = length / 3.0 * Math.sqrt(3);

    // Calculate the location of the peak
    Point2D.Double peak = new Point2D.Double(start.x + Math.cos(new_theta) * peak_height,
        start.y + Math.sin(new_theta) * peak_height);

    return new Point2D.Double[] { start, firstThird, peak, secondThird, end };
  }

}
