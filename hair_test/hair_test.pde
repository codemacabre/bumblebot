color color0 = 0;
color color1 = 0;
color color2 = 0;
color color3 = 0;

void setup() {
  size(512, 512);
  background(255);
  colorMode(HSB, 360, 100, 100, 100);
  color0 = color(0, 0, 0);
  color1 = color(floor(random(360)), floor(random(100)), floor(random(50, 100)));
  color2 = color(floor(random(360)), floor(random(100)), floor(random(50, 100)));
  color3 = color(floor(random(360)), floor(random(100)), floor(random(50, 100)));
}

void draw() {
  int centerX = floor(width * 0.5);
  int centerY = floor(height * 0.5);
  
  noStroke();
  fill(#101013);
  java.awt.Polygon p = new java.awt.Polygon();
  p.addPoint(200, 100);
  p.addPoint(312, 100);
  p.addPoint(412, 412);
  p.addPoint(412, 100);
  p.addPoint(200, 100);
  beginShape();
  for(int i = 0; i < p.npoints; i++) {
    vertex(p.xpoints[i], p.ypoints[i]);
  }
  endShape();
   
  stroke(color1, 50);
  for(int iX = 0; iX < width; iX++) {
    for (int iY = 0; iY < height; iY++) {
      if(p.contains(iX, iY)) {
        if(iX % 2 == 0 && iY % 2 == 0) {
          int randomiser = floor(random(10));
          int hairLength = floor(random(9, 13));
          int hairDirectionL = floor(random(-5, 0));
          int hairDirectionC = floor(random(-5, 5));
          int hairDirectionR = floor(random(0, 5));
          if(randomiser > 2) {
            if(iX < (centerX - 20)) {
              line(iX, iY, iX + hairDirectionL, iY + hairLength);
            } else if (iX > (centerX - 25) && iX < (centerX + 25)) {
              line(iX, iY, iX + hairDirectionC, iY + hairLength);
            } else if(iX > (centerX + 20)) {
              line(iX, iY, iX + hairDirectionR, iY + hairLength);
            }
          }
        }
      }
    }
  }
 
  noLoop();
  save("output.png");
}