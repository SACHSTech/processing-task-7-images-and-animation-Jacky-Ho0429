import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {

  // PImages
  PImage sprite1;
  PImage background1;

  // Floats
  float fltAngle = 0;
  float fltRadius = 100;
  float fltCircleX = 25;
  float fltCircleY = 25;
  float fltCircleSpeedX = 4;
  float fltCircleSpeedY = 2;
  float fltCircleSize = width / 16;

  // Integers
  int intGhostSize = 50;

  public void settings() {
    size(400, 400);
  }

  public void setup() {
    // Loads and resizes images
    sprite1 = loadImage("OIG-removebg-preview.png");
    background1 = loadImage("background.jpg");
    sprite1.resize(intGhostSize, intGhostSize);
    background1.resize(400, 400);
  }

  public void draw() {
    // Sets background to loaded image
    image(background1, 0, 0);

    // Makes a ghost go in circles
    float fltGhostX = width / 2 + cos(fltAngle) * fltRadius - 25;
    float fltGhostY = height / 2 + sin(fltAngle) * fltRadius - 25;

    image(sprite1, fltGhostX, fltGhostY);

    fltAngle += 0.05; 
    
    // Reset angles of circle
    if (fltAngle > TWO_PI) {
      fltAngle = 0;
    }

    // Creates a bouncing ball
    ellipse(fltCircleX, fltCircleY, width / 16, height / 16);

    fltCircleX += fltCircleSpeedX;
    fltCircleY += fltCircleSpeedY;

    // Check for collisions with the screen edges
    if (fltCircleX < 20 || fltCircleX > width - width / 20) {
      fltCircleSpeedX *= -1; 

    }
    
    if (fltCircleY < 25 || fltCircleY > height - width / 20) {
      fltCircleSpeedY *= -1; 
    }
  }
  
  // Define other methods down here.
}
