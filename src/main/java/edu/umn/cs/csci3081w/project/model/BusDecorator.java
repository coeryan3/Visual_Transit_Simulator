package edu.umn.cs.csci3081w.project.model;

public class BusDecorator {
  private int red;
  private int blue;
  private int green;
  private int alpha;

  public BusDecorator(int color) {
    this.updateColor(color);
  }

  /**
   * Updates the color of the bus.
   *
   * @param color value to determine whether bus is gold or maroon.
   * @return updated decorated bus
   */
  public BusDecorator updateColor(int color) {
    //outgoing --> maroon
    if (color == 0) {
      this.red = 128;
      this.blue = 0;
      this.green = 0;
      this.alpha = 255;
    } else {  //incoming --> gold
      this.red = 255;
      this.blue = 0;
      this.green = 215;
      this.alpha = 255;
    }
    return this;
  }

  public int getRed() {
    return this.red;
  }

  public int getGreen() {
    return this.green;
  }

  public int getBlue() {
    return this.blue;
  }

  public int getAlpha() {
    return this.alpha;
  }
}
