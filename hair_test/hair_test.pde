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
  rect(centerX - 100, centerY - 100, 200, 200);
  
  stroke(color1, 50);
  for(int iX = centerX - 100; iX < centerX + 100; iX++) {
    for (int iY = centerY - 100; iY < centerY + 100; iY++) {
      if(iX % 2 == 0 && iY % 2 == 0) {
        int randomiser = floor(random(10));
        if(randomiser > 2) {
          if(iX < (centerX - 50)) {
            line(iX, iY, iX - 5, iY + 10);
          } else if (iX > (centerX - 54) && iX < (centerX - 30)) {
            line(iX, iY, iX - 4, iY + 10);
          } else if (iX > (centerX - 33) && iX < (centerX - 5)) {
            line(iX, iY, iX - 3, iY + 10);
          } else if (iX > (centerX - 7) && iX < (centerX + 7)) {
            int centerRandomiser = floor(random(10));
            if(centerRandomiser > 4) {
              line(iX, iY, iX - 2, iY + 10);
            } else {
              line(iX, iY, iX + 2, iY + 10);
            }
          } else if (iX > centerX && iX < (centerX + 7)) {
            line(iX, iY, iX + 2, iY + 10);
          } else if (iX > (centerX + 5) && iX < (centerX + 33)) {
            line(iX, iY, iX + 3, iY + 10);
          } else if (iX > (centerX + 30) && iX < (centerX + 54)) {
            line(iX, iY, iX + 4, iY + 10);
          } else if(iX > (centerX + 50)) {
            line(iX, iY, iX + 5, iY + 10);
          }
        }
      }
    }
  }
 
  noLoop();
  save("output.png");
}