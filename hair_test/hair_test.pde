color color0 = 0;
color color1 = 0;
color color2 = 0;
color color3 = 0;

void setup() {
  size(512, 512);
  background(255);
  colorMode(HSB, 360, 100, 100);
  color0 = color(0, 0, 0);
  color1 = color(floor(random(360)), floor(random(100)), floor(random(50, 100)));
  color2 = color(floor(random(360)), floor(random(100)), floor(random(50, 100)));
  color3 = color(0, 0, 100);
}

void draw() {
  
  noStroke();
  fill(#101013);
  rect(centerX - 100, centerY - 100, 200, 200);
  
  drawHair();
 
  noLoop();
  save("output.png");
}

void drawHair() {
  stroke(color1);
  for(int iX = centerX - 100; iX <= centerX + 100; iX++) {
    for (int iY = centerY - 100; iY <= centerY - 100; iY++) {
      if(iX < centerX) {
        line(iX, iY, iX - 5, iY + 10);
      } else if(iX < (centerX - 50)) {
        line(iX, iY, iX - 3, iY + 10);
      } else if(iX < (centerX - 25)) {
        line(iX, iY, iX - 1, iY + 10);
      } else if(iX > (centerX + 25)) {
        line(iX, iY, iX + 1, iY + 10);
      } else if(iX > (centerX + 50)) {
        line(iX, iY, iX + 3, iY + 10);
      } else {
        line(iX, iY, iX + 5, iY + 10);
      }
    }
  }
}