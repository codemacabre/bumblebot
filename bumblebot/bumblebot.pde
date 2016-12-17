int beeGender = floor(random(5));
int pattern = floor(random(7));
color headCol =    0;
color thorax1Col = 0;
color thorax2Col = 0;
color thorax3Col = 0;
color topCol =  0;
color mid1Col = 0;
color mid2Col = 0;
color tailCol = 0;
color color0 = 0;
color color1 = 0;
color color2 = 0;
color color3 = 0;

void setup() {
  size(512, 512);
  background(255);
  setGender();
  colorMode(HSB, 360, 100, 100);
  color0 = color(0, 0, 0);
  color1 = color(floor(random(360)), floor(random(100)), floor(random(50, 100)));
  color2 = color(floor(random(360)), floor(random(100)), floor(random(50, 100)));
  color3 = color(0, 0, 100);
  setColors();
  drawBee();
  smooth();
  save("output.png");
}

void drawBee() {
  
  /*************
   * VARIABLES *
   *************/
   
  int centerX = floor(width * 0.5);
  int centerY = floor(height * 0.5);
  
  // Fore legs
  int coxaForeX   = floor(random(25, 35));
  int femurForeX  = coxaForeX + 10;
  int tibiaForeX  = femurForeX + 0;
  int tarsusForeX = tibiaForeX + 10;
  int coxaForeY   = 20;
  int femurForeY  = coxaForeY + 20;
  int tibiaForeY  = femurForeY + 30;
  int tarsusForeY = tibiaForeY + 5;
  
  // Mid legs
  int coxaMidX    = coxaForeX;
  int femurMidX   = coxaMidX + 20;
  int tibiaMidX   = femurMidX + 20;
  int tarsusMidX  = tibiaMidX + 13;
  int coxaMidY    = 0;
  int femurMidY   = coxaMidY + 5;
  int tibiaMidY   = femurMidY + 20;
  int tarsusMidY  = tibiaMidY + 3;
  
  // Hind legs
  int coxaHindX   = floor(random(15, 30));
  int femurHindX  = coxaHindX + 20;
  int tibiaHindX  = femurHindX + 25;
  int tarsusHindX = tibiaHindX + 15;
  int coxaHindY   = 15;
  int femurHindY  = coxaHindY + 5;
  int tibiaHindY  = femurHindY + 50;
  int tarsusHindY = tibiaHindY + 10;
  
  // Antennae
  int antennae1X = floor(random(15, 35));
  int antennae1Y = floor(random(50, 65));
  int antennae2X = antennae1X + floor(random(10, 25));
  int antennae2Y = antennae1Y + floor(random(25));
  
  // Head
  int headOriginX = floor(random(10, 20));
  int headOriginY = floor(random(45, 50));
  
  // Thorax
  int thoraxOriginX = coxaHindX;
  int thoraxOriginY = 35;
  int thoraxMidX = floor(random(coxaForeX, coxaForeX + 5));
  int thoraxMidY = floor((coxaForeY + coxaMidY) * 0.5);
  
  // Abdomen
  int abdomen1X = thoraxOriginX;
  int abdomen2X = floor(random(abdomen1X + 20, abdomen1X + 30));
  int abdomen3X = floor(random(abdomen2X + 5, abdomen2X + 15));
  int abdomen4X = floor(random(abdomen3X, abdomen3X + 5));
  int abdomen5X = floor(random(abdomen4X - 10, abdomen4X - 5));
  int abdomen6X = floor(random(abdomen1X - 5, abdomen1X));
  int abdomen1Y = 15; // constant to align with thorax
  int abdomen2Y = floor(random(20, 25));
  int abdomen3Y = floor(random(30, 35));
  int abdomen4Y = floor(random(30, 35));
  int abdomen5Y = floor(random(20, 25));
  int abdomen6Y = floor(random(abdomen5Y - 2, abdomen5Y + 2));
  int abdomen7Y = floor(random(5, 10)); // males only
  
  // Wings
  int wingOriginX = floor(random(coxaForeX - 10, coxaForeX - 5));
  int wingOriginY = thoraxMidY;
  
  int wingFore1X = floor(random(wingOriginX + 80, wingOriginX + 150));
  int wingFore2X = floor(random(wingFore1X + 30, wingFore1X + 50));
  int wingFore3X = floor(random(wingFore2X - 30, wingFore1X + 30));
  int wingFore4X = floor(random(wingFore1X - 20, wingFore1X - 10));
  
  int wingFore1Y = floor(random(wingOriginY + 10, wingOriginY + 50));
  int wingFore2Y = floor(random(wingFore1Y - 30, wingFore1Y - 20));
  int wingFore3Y = floor(random(wingFore2Y - 30, wingFore2Y - 20));
  int wingFore4Y = floor(random(wingFore3Y - 20, wingFore3Y - 5));
  
  int wingHind1X = wingFore4X;
  int wingHind2X = floor(random(wingHind1X + 5,  wingHind1X + 10));
  int wingHind3X = floor(random(wingHind2X - 30, wingHind1X - 20));
  
  int wingHind1Y = wingFore4Y;
  int wingHind2Y = floor(random(wingHind1Y - 20, wingHind1Y - 10));
  int wingHind3Y = floor(random(wingHind2Y - 20, wingHind2Y - 10));
  
  /***********
   * DRAWING *
   ***********/
   
  // Fore legs
  fill(0, 20, 15);
  stroke(0, 0, 0);
  triangle(centerX - coxaForeX,        centerY - coxaForeY,
           centerX - femurForeX,       centerY - femurForeY,
           centerX - (femurForeX + 2), centerY - femurForeY);
  quad(    centerX - femurForeX,       centerY - femurForeY,
           centerX - (femurForeX + 2), centerY - femurForeY,
           centerX - (tibiaForeX + 2), centerY - tibiaForeY,
           centerX - (tibiaForeX - 2), centerY - tibiaForeY);
  line(    centerX - tibiaForeX,       centerY - tibiaForeY,
           centerX - tarsusForeX,      centerY - tarsusForeY);

  triangle(centerX + coxaForeX,        centerY - coxaForeY,
           centerX + femurForeX,       centerY - femurForeY,
           centerX + (femurForeX + 2), centerY - femurForeY);
  quad(    centerX + femurForeX,       centerY - femurForeY,
           centerX + (femurForeX + 2), centerY - femurForeY,
           centerX + (tibiaForeX + 2), centerY - tibiaForeY,
           centerX + (tibiaForeX - 2), centerY - tibiaForeY);
  line(    centerX + tibiaForeX,       centerY - tibiaForeY,
           centerX + tarsusForeX,      centerY - tarsusForeY);
           
  // Mid legs
  fill(0, 20, 15);
  stroke(0, 0, 0);
  triangle(centerX - coxaMidX,         centerY + coxaMidY,
           centerX - femurMidX,        centerY + femurMidY,
           centerX - (femurMidX + 2),  centerY + (femurMidY - 3));
  quad(    centerX - femurMidX,        centerY + femurMidY,
           centerX - (femurMidX + 2),  centerY + (femurMidY - 3),
           centerX - (tibiaMidX + 3),  centerY + (tibiaMidY - 1),
           centerX - (tibiaMidX - 3),  centerY + (tibiaMidY + 1));
  line(    centerX - tibiaMidX,        centerY + tibiaMidY,
           centerX - tarsusMidX,       centerY + tarsusMidY);
           
  triangle(centerX + coxaMidX,         centerY + coxaMidY,
           centerX + femurMidX,        centerY + femurMidY,
           centerX + (femurMidX + 2),  centerY + (femurMidY - 3));
  quad(    centerX + femurMidX,        centerY + femurMidY,
           centerX + (femurMidX + 2),  centerY + (femurMidY - 3),
           centerX + (tibiaMidX + 3),  centerY + (tibiaMidY - 1),
           centerX + (tibiaMidX - 3),  centerY + (tibiaMidY + 1));
  line(    centerX + tibiaMidX,        centerY + tibiaMidY,
           centerX + tarsusMidX,       centerY + tarsusMidY);
           
  // Hind legs
  fill(0, 20, 15);
  stroke(0, 0, 0);
  if (beeGender <= 1) {
    // queen or worker
    triangle(centerX - coxaHindX,        centerY + coxaHindY,
             centerX - femurHindX,       centerY + femurHindY,
             centerX - (femurHindX + 3), centerY + (femurHindY - 4));
    quad(    centerX - femurHindX,       centerY + femurHindY,
             centerX - (femurHindX + 3), centerY + (femurHindY - 4),
             centerX - (tibiaHindX + 8), centerY + (tibiaHindY - 2),
             centerX - (tibiaHindX - 8), centerY + (tibiaHindY + 2));
    line(    centerX - tibiaHindX,       centerY + tibiaHindY,
             centerX - tarsusHindX,      centerY + tarsusHindY);
  
    triangle(centerX + coxaHindX,        centerY + coxaHindY,
             centerX + femurHindX,       centerY + femurHindY,
             centerX + (femurHindX + 3), centerY + (femurHindY - 4));
    quad(    centerX + femurHindX,       centerY + femurHindY,
             centerX + (femurHindX + 3), centerY + (femurHindY - 4),
             centerX + (tibiaHindX + 8), centerY + (tibiaHindY - 2),
             centerX + (tibiaHindX - 8), centerY + (tibiaHindY + 2));
    line(    centerX + tibiaHindX,       centerY + tibiaHindY,
             centerX + tarsusHindX,      centerY + tarsusHindY);
  }
  else if (beeGender > 1) {
    // male or cuckoo m or f
    triangle(centerX - coxaHindX,        centerY + coxaHindY,
             centerX - femurHindX,       centerY + femurHindY,
             centerX - (femurHindX + 2), centerY + (femurHindY - 3));
    quad(    centerX - femurHindX,       centerY + femurHindY,
             centerX - (femurHindX + 2), centerY + (femurHindY - 3),
             centerX - (tibiaHindX + 5), centerY + (tibiaHindY - 1),
             centerX - (tibiaHindX - 5), centerY + (tibiaHindY + 1));
    line(    centerX - tibiaHindX,       centerY + tibiaHindY,
             centerX - tarsusHindX,      centerY + tarsusHindY);
  
    triangle(centerX + coxaHindX,        centerY + coxaHindY,
             centerX + femurHindX,       centerY + femurHindY,
             centerX + (femurHindX + 2), centerY + (femurHindY - 3));
    quad(    centerX + femurHindX,       centerY + femurHindY,
             centerX + (femurHindX + 2), centerY + (femurHindY - 3),
             centerX + (tibiaHindX + 5), centerY + (tibiaHindY - 1),
             centerX + (tibiaHindX - 5), centerY + (tibiaHindY + 1));
    line(    centerX + tibiaHindX,       centerY + tibiaHindY,
             centerX + tarsusHindX,      centerY + tarsusHindY);
  }

  // Anennae
  noFill();
  stroke(0, 0, 0);
  if (beeGender <= 2) {
    // Females
    beginShape();
    vertex(centerX - headOriginX, centerY - headOriginY);
    vertex(centerX - antennae2X,  centerY - antennae2Y);
    endShape();
    beginShape();
    vertex(centerX + headOriginX, centerY - headOriginY);
    vertex(centerX + antennae2X,  centerY - antennae2Y);
    endShape();
  } else {
    // Males
    beginShape();
    vertex(centerX - headOriginX, centerY - headOriginY);
    vertex(centerX - antennae1X,  centerY - antennae1Y);
    vertex(centerX - antennae2X,  centerY - antennae2Y);
    endShape();
    beginShape();
    vertex(centerX + headOriginX, centerY - headOriginY);
    vertex(centerX + antennae1X,  centerY - antennae1Y);
    vertex(centerX + antennae2X,  centerY - antennae2Y);
    endShape();
  }
  
  // Eyes
  fill(0, 20, 15);
  stroke(0, 0, 0);
  beginShape();
  vertex(centerX - headOriginX, centerY - thoraxOriginY);
  vertex(centerX - ((headOriginX + thoraxOriginX) * 0.5), centerY - thoraxOriginY);
  vertex(centerX - ((headOriginX + thoraxOriginX) * 0.5), centerY - ((headOriginY + thoraxOriginY) * 0.5));
  vertex(centerX - headOriginX, centerY - headOriginY);
  vertex(centerX - headOriginX, centerY - thoraxOriginY);
  endShape();
  beginShape();
  vertex(centerX + headOriginX, centerY - thoraxOriginY);
  vertex(centerX + ((headOriginX + thoraxOriginX) * 0.5), centerY - thoraxOriginY);
  vertex(centerX + ((headOriginX + thoraxOriginX) * 0.5), centerY - ((headOriginY + thoraxOriginY) * 0.5));
  vertex(centerX + headOriginX, centerY - headOriginY);
  vertex(centerX + headOriginX, centerY - thoraxOriginY);
  endShape();

  // Head
  fill(headCol);
  stroke(headCol);
  beginShape();
  vertex(centerX - headOriginX, centerY - headOriginY);
  vertex(centerX + headOriginX, centerY - headOriginY);
  vertex(centerX + headOriginX, centerY - thoraxOriginY);
  vertex(centerX - headOriginX, centerY - thoraxOriginY);
  vertex(centerX - headOriginX, centerY - headOriginY);
  endShape();

  // Thorax
  fill(thorax1Col);
  stroke(thorax1Col);
  beginShape();
  vertex(centerX - thoraxOriginX, centerY - thoraxOriginY);
  vertex(centerX + thoraxOriginX, centerY - thoraxOriginY);
  vertex(centerX + coxaForeX,     centerY - coxaForeY);
  vertex(centerX - coxaForeX,     centerY - coxaForeY);
  vertex(centerX - thoraxOriginX, centerY - thoraxOriginY);
  endShape();
  
  fill(thorax2Col);
  stroke(thorax2Col);
  beginShape();
  vertex(centerX - coxaForeX,     centerY - coxaForeY);
  vertex(centerX + coxaForeX,     centerY - coxaForeY);
  vertex(centerX + thoraxMidX,    centerY - thoraxMidY);
  vertex(centerX + coxaMidX,      centerY - coxaMidY);
  vertex(centerX - coxaMidX,      centerY - coxaMidY);
  vertex(centerX - thoraxMidX,    centerY - thoraxMidY);
  vertex(centerX - coxaForeX,     centerY - coxaForeY);
  endShape();
  beginShape();
  
  fill(thorax3Col);
  stroke(thorax3Col);
  vertex(centerX - coxaMidX,      centerY - coxaMidY);
  vertex(centerX + coxaMidX,      centerY - coxaMidY);
  vertex(centerX + coxaHindX,     centerY + coxaHindY);
  vertex(centerX - coxaHindX,     centerY + coxaHindY);
  vertex(centerX - coxaMidX,      centerY - coxaMidY);
  endShape();

  // Abdomen
  fill(topCol);
  stroke(topCol);
  beginShape();
  vertex(centerX - abdomen1X, centerY + abdomen1Y);
  vertex(centerX + abdomen1X, centerY + abdomen1Y);
  vertex(centerX + abdomen2X, centerY + abdomen1Y + abdomen2Y);
  vertex(centerX - abdomen2X, centerY + abdomen1Y + abdomen2Y);
  vertex(centerX - abdomen1X, centerY + abdomen1Y);
  endShape();
  
  fill(mid1Col);
  stroke(mid1Col);
  beginShape();
  vertex(centerX - abdomen2X, centerY + abdomen1Y + abdomen2Y);
  vertex(centerX + abdomen2X, centerY + abdomen1Y + abdomen2Y);
  vertex(centerX + abdomen3X, centerY + abdomen1Y + abdomen2Y + abdomen3Y);
  vertex(centerX - abdomen3X, centerY + abdomen1Y + abdomen2Y + abdomen3Y);
  vertex(centerX - abdomen2X, centerY + abdomen1Y + abdomen2Y);
  endShape();
  
  fill(mid2Col);
  stroke(mid2Col);
  beginShape();
  vertex(centerX - abdomen3X, centerY + abdomen1Y + abdomen2Y + abdomen3Y);
  vertex(centerX + abdomen3X, centerY + abdomen1Y + abdomen2Y + abdomen3Y);
  vertex(centerX + abdomen4X, centerY + abdomen1Y + abdomen2Y + abdomen3Y + abdomen4Y);
  vertex(centerX - abdomen4X, centerY + abdomen1Y + abdomen2Y + abdomen3Y + abdomen4Y);
  vertex(centerX - abdomen3X, centerY + abdomen1Y + abdomen2Y + abdomen3Y);
  endShape();
  
  fill(tailCol);
  stroke(tailCol);
  beginShape();
  vertex(centerX - abdomen4X, centerY + abdomen1Y + abdomen2Y + abdomen3Y + abdomen4Y);
  vertex(centerX + abdomen4X, centerY + abdomen1Y + abdomen2Y + abdomen3Y + abdomen4Y);
  vertex(centerX + abdomen5X, centerY + abdomen1Y + abdomen2Y + abdomen3Y + abdomen4Y + abdomen5Y);
  vertex(centerX + abdomen6X, centerY + abdomen1Y + abdomen2Y + abdomen3Y + abdomen4Y + abdomen5Y + abdomen6Y);
  vertex(centerX - abdomen6X, centerY + abdomen1Y + abdomen2Y + abdomen3Y + abdomen4Y + abdomen5Y + abdomen6Y);
  vertex(centerX - abdomen5X, centerY + abdomen1Y + abdomen2Y + abdomen3Y + abdomen4Y + abdomen5Y);
  vertex(centerX - abdomen4X, centerY + abdomen1Y + abdomen2Y + abdomen3Y + abdomen4Y);
  endShape();
  
  if (beeGender > 2) {
  fill(tailCol);
  stroke(tailCol);
  beginShape();
  vertex(centerX - abdomen6X, centerY + abdomen1Y + abdomen2Y + abdomen3Y + abdomen4Y + abdomen5Y + abdomen6Y);
  vertex(centerX + abdomen6X, centerY + abdomen1Y + abdomen2Y + abdomen3Y + abdomen4Y + abdomen5Y + abdomen6Y);
  vertex(centerX, centerY + abdomen1Y + abdomen2Y + abdomen3Y + abdomen4Y + abdomen5Y + abdomen6Y + abdomen7Y);
  vertex(centerX, centerY + abdomen1Y + abdomen2Y + abdomen3Y + abdomen4Y + abdomen5Y + abdomen6Y + abdomen7Y);
  vertex(centerX - abdomen6X, centerY + abdomen1Y + abdomen2Y + abdomen3Y + abdomen4Y + abdomen5Y + abdomen6Y);
  endShape();
  }

  // Fore Wings
  fill(100, 50, 25, 50);
  noStroke();
  beginShape();
  vertex(centerX - wingOriginX, centerY - wingOriginY);
  vertex(centerX - wingFore1X, centerY - wingFore1Y);
  vertex(centerX - wingFore2X, centerY - wingFore2Y);
  vertex(centerX - wingFore3X, centerY - wingFore3Y);
  vertex(centerX - wingFore4X, centerY - wingFore4Y);
  vertex(centerX - wingOriginX, centerY - wingOriginY);
  endShape();
  
  beginShape();
  vertex(centerX + wingOriginX, centerY - wingOriginY);
  vertex(centerX + wingFore1X, centerY - wingFore1Y);
  vertex(centerX + wingFore2X, centerY - wingFore2Y);
  vertex(centerX + wingFore3X, centerY - wingFore3Y);
  vertex(centerX + wingFore4X, centerY - wingFore4Y);
  vertex(centerX + wingOriginX, centerY - wingOriginY);
  endShape();
  
  // Hind Wings
  beginShape();
  vertex(centerX - wingOriginX, centerY - wingOriginY);
  vertex(centerX - wingHind1X, centerY - wingHind1Y);
  vertex(centerX - wingHind2X, centerY - wingHind2Y);
  vertex(centerX - wingHind3X, centerY - wingHind3Y);
  vertex(centerX - wingOriginX, centerY - wingOriginY);
  endShape();
  
  beginShape();
  vertex(centerX + wingOriginX, centerY - wingOriginY);
  vertex(centerX + wingHind1X, centerY - wingHind1Y);
  vertex(centerX + wingHind2X, centerY - wingHind2Y);
  vertex(centerX + wingHind3X, centerY - wingHind3Y);
  vertex(centerX + wingOriginX, centerY - wingOriginY);
  endShape();
}

void setGender() {
  if (beeGender == 0) {
    println("Queen bumblebee");
  } else if (beeGender == 1) {
    println("Worker bumblebee");
  } else if (beeGender == 2) {
    println("Female cuckoo bumblebee");
  } else if (beeGender == 3) {
    println("Male bumblebee");
  } else if (beeGender == 4) {
    println("Male cuckoo bumblebee");
  }
}

void setColors() {
  int yellower = floor(random(10));
  if (yellower <= 6) {
    println("bee colours made yellower");
    color1 = color(floor(random(30,60)), floor(random(75, 100)), floor(random(75, 100)));
    color2 = color(floor(random(30,60)), floor(random(75, 100)), floor(random(75, 100)));
  }
  switch (pattern) {
  case 0:
    println("black w/ colour1 tail");
    headCol = color0;
    thorax1Col = color0;
    thorax2Col = color0;
    thorax3Col = color0;
    topCol     = color0;
    mid1Col    = color0;
    mid2Col    = color0;
    tailCol    = color1;
    break;
  case 1:
    println("black w/ colour1 tail & colour2 thorax");
    headCol    = color0;
    thorax1Col = color2;
    thorax2Col = color2;
    thorax3Col = color2;
    topCol     = color0;
    mid1Col    = color0;
    mid2Col    = color0;
    tailCol    = color1;
    break;
  case 2:
    println("black w/ striped abdomen black, colour1");
    headCol    = color0;
    thorax1Col = color0;
    thorax2Col = color0;
    thorax3Col = color0;
    topCol     = color0;
    mid1Col    = color1;
    mid2Col    = color0;
    tailCol    = color1;
    break;
  case 3:
    println("striped w/ black, colour1");
    headCol    = color0;
    thorax1Col = color1;
    thorax2Col = color1;
    thorax3Col = color0;
    topCol     = color0;
    mid1Col    = color1;
    mid2Col    = color0;
    tailCol    = color1;
    break;
  case 4:
    println("striped w/ black, colour1, colour2");
    headCol    = color0;
    thorax1Col = color1;
    thorax2Col = color2;
    thorax3Col = color0;
    topCol     = color0;
    mid1Col    = color0;
    mid2Col    = color1;
    tailCol    = color2;
    break;
  case 5:
    println("colour1");
    headCol    = color1;
    thorax1Col = color1;
    thorax2Col = color1;
    thorax3Col = color1;
    topCol     = color1;
    mid1Col    = color1;
    mid2Col    = color1;
    tailCol    = color1;
    break;
  case 6:
    println("striped w/ colour1, colour2");
    headCol    = color1;
    thorax1Col = color2;
    thorax2Col = color1;
    thorax3Col = color2;
    topCol     = color1;
    mid1Col    = color2;
    mid2Col    = color1;
    tailCol    = color2;
    break;
  }
}