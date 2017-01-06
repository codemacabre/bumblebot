import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class bumblebot extends PApplet {

int beeGender = floor(random(5));
int pattern = floor(random(7));
int headCol =    0;
int thorax1Col = 0;
int thorax2Col = 0;
int thorax3Col = 0;
int topCol =  0;
int mid1Col = 0;
int mid2Col = 0;
int tailCol = 0;
int color0 = 0;
int color1 = 0;
int color2 = 0;
int color3 = 0;

java.awt.Polygon beeHead = new java.awt.Polygon();
java.awt.Polygon beeThorax1 = new java.awt.Polygon();
java.awt.Polygon beeThorax2 = new java.awt.Polygon();
java.awt.Polygon beeThorax3 = new java.awt.Polygon();
java.awt.Polygon beeAbdTop = new java.awt.Polygon();
java.awt.Polygon beeAbdMid1 = new java.awt.Polygon();
java.awt.Polygon beeAbdMid2 = new java.awt.Polygon();
java.awt.Polygon beeTail1 = new java.awt.Polygon();
java.awt.Polygon beeTail2 = new java.awt.Polygon();

public void setup() {
  
  background(255);
  setGender();
  colorMode(HSB, 360, 100, 100);
  color0 = color(0, 0, 0);
  color1 = color(floor(random(360)), floor(random(100)), floor(random(50, 100)));
  color2 = color(floor(random(360)), floor(random(100)), floor(random(50, 100)));
  color3 = color(0, 0, 100);
  setColors();
  drawBee();
  drawHair(beeHead);
  drawHair(beeThorax1);
  drawHair(beeThorax2);
  drawHair(beeThorax3);
  drawHair(beeAbdTop);
  drawHair(beeAbdMid1);
  drawHair(beeAbdMid2);
  drawHair(beeTail1);
  drawHair(beeTail2);
  
  save("output.png");
  exit();
}

public void drawBee() {

  /*************
   * VARIABLES *
   *************/

  int centerX = floor(width * 0.5f);
  int centerY = floor(height * 0.5f);

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
  int antennae3X = antennae2X;
  int antennae3Y = antennae2Y + floor(random(50, 65));

  // Head
  int headOriginX = floor(random(10, 20));
  int headOriginY = floor(random(45, 50));

  // Thorax
  int thoraxOriginX = coxaHindX;
  int thoraxOriginY = 35;
  int thoraxMidX = floor(random(coxaForeX, coxaForeX + 5));
  int thoraxMidY = floor((coxaForeY + coxaMidY) * 0.5f);

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
  fill(239, 15, 7);
  stroke(239, 15, 7);
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
  fill(239, 15, 7);
  stroke(239, 15, 7);
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
  fill(239, 15, 7);
  stroke(239, 15, 7);
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
  stroke(239, 15, 7);
  if (beeGender <= 2) {
    // Females
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
  } else {
    // Males
    beginShape();
    curveVertex(centerX + headOriginX, centerY - headOriginY);
    curveVertex(centerX - headOriginX, centerY - headOriginY);
    curveVertex(centerX - antennae1X,  centerY - antennae1Y);
    curveVertex(centerX - antennae2X,  centerY - antennae2Y);
    curveVertex(centerX - antennae3X,  centerY - antennae3Y);
    endShape();
    beginShape();
    curveVertex(centerX + headOriginX, centerY - headOriginY);
    curveVertex(centerX + headOriginX, centerY - headOriginY);
    curveVertex(centerX + headOriginX, centerY - headOriginY);
    curveVertex(centerX + antennae1X,  centerY - antennae1Y);
    curveVertex(centerX + antennae2X,  centerY - antennae2Y);
    curveVertex(centerX + antennae3X,  centerY - antennae3Y);
    endShape();
  }

  // Eyes
  fill(239, 15, 7);
  stroke(239, 15, 7);
  beginShape();
  vertex(centerX - headOriginX, centerY - thoraxOriginY);
  vertex(centerX - ((headOriginX + thoraxOriginX) * 0.5f), centerY - thoraxOriginY);
  vertex(centerX - ((headOriginX + thoraxOriginX) * 0.5f), centerY - ((headOriginY + thoraxOriginY) * 0.5f));
  vertex(centerX - headOriginX, centerY - headOriginY);
  vertex(centerX - headOriginX, centerY - thoraxOriginY);
  endShape();
  beginShape();
  vertex(centerX + headOriginX, centerY - thoraxOriginY);
  vertex(centerX + ((headOriginX + thoraxOriginX) * 0.5f), centerY - thoraxOriginY);
  vertex(centerX + ((headOriginX + thoraxOriginX) * 0.5f), centerY - ((headOriginY + thoraxOriginY) * 0.5f));
  vertex(centerX + headOriginX, centerY - headOriginY);
  vertex(centerX + headOriginX, centerY - thoraxOriginY);
  endShape();

  // Head
  fill(239, 15, 7);
  stroke(239, 15, 7);
  beeHead.addPoint(centerX - headOriginX, centerY - headOriginY);
  beeHead.addPoint(centerX + headOriginX, centerY - headOriginY);
  beeHead.addPoint(centerX + headOriginX, centerY - thoraxOriginY);
  beeHead.addPoint(centerX - headOriginX, centerY - thoraxOriginY);
  beeHead.addPoint(centerX - headOriginX, centerY - headOriginY);
  beginShape();
  for(int i = 0; i < beeHead.npoints; i++) {
    vertex(beeHead.xpoints[i], beeHead.ypoints[i]);
  }
  endShape();

  // Thorax
  fill(239, 15, 7);
  stroke(239, 15, 7);
  beeThorax1.addPoint(centerX - thoraxOriginX, centerY - thoraxOriginY);
  beeThorax1.addPoint(centerX + thoraxOriginX, centerY - thoraxOriginY);
  beeThorax1.addPoint(centerX + coxaForeX,     centerY - coxaForeY);
  beeThorax1.addPoint(centerX - coxaForeX,     centerY - coxaForeY);
  beeThorax1.addPoint(centerX - thoraxOriginX, centerY - thoraxOriginY);
  beginShape();
  for(int i = 0; i < beeThorax1.npoints; i++) {
    vertex(beeThorax1.xpoints[i], beeThorax1.ypoints[i]);
  }
  endShape();

  fill(239, 15, 7);
  stroke(239, 15, 7);
  beeThorax2.addPoint(centerX - coxaForeX,     centerY - coxaForeY);
  beeThorax2.addPoint(centerX + coxaForeX,     centerY - coxaForeY);
  beeThorax2.addPoint(centerX + thoraxMidX,    centerY - thoraxMidY);
  beeThorax2.addPoint(centerX + coxaMidX,      centerY - coxaMidY);
  beeThorax2.addPoint(centerX - coxaMidX,      centerY - coxaMidY);
  beeThorax2.addPoint(centerX - thoraxMidX,    centerY - thoraxMidY);
  beeThorax2.addPoint(centerX - coxaForeX,     centerY - coxaForeY);
  beginShape();
  for(int i = 0; i < beeThorax2.npoints; i++) {
    vertex(beeThorax2.xpoints[i], beeThorax2.ypoints[i]);
  }
  endShape();

  fill(239, 15, 7);
  stroke(239, 15, 7);
  beeThorax3.addPoint(centerX - coxaMidX,      centerY - coxaMidY);
  beeThorax3.addPoint(centerX + coxaMidX,      centerY - coxaMidY);
  beeThorax3.addPoint(centerX + coxaHindX,     centerY + coxaHindY);
  beeThorax3.addPoint(centerX - coxaHindX,     centerY + coxaHindY);
  beeThorax3.addPoint(centerX - coxaMidX,      centerY - coxaMidY);
  beginShape();
  for(int i = 0; i < beeThorax3.npoints; i++) {
    vertex(beeThorax3.xpoints[i], beeThorax3.ypoints[i]);
  }
  endShape();

  // Abdomen
  fill(239, 15, 7);
  stroke(239, 15, 7);
  beeAbdTop.addPoint(centerX - abdomen1X, centerY + abdomen1Y);
  beeAbdTop.addPoint(centerX + abdomen1X, centerY + abdomen1Y);
  beeAbdTop.addPoint(centerX + abdomen2X, centerY + abdomen1Y + abdomen2Y);
  beeAbdTop.addPoint(centerX - abdomen2X, centerY + abdomen1Y + abdomen2Y);
  beeAbdTop.addPoint(centerX - abdomen1X, centerY + abdomen1Y);
  beginShape();
  for(int i = 0; i < beeAbdTop.npoints; i++) {
    vertex(beeAbdTop.xpoints[i], beeAbdTop.ypoints[i]);
  }
  endShape();

  fill(239, 15, 7);
  stroke(239, 15, 7);
  beeAbdMid1.addPoint(centerX - abdomen2X, centerY + abdomen1Y + abdomen2Y);
  beeAbdMid1.addPoint(centerX + abdomen2X, centerY + abdomen1Y + abdomen2Y);
  beeAbdMid1.addPoint(centerX + abdomen3X, centerY + abdomen1Y + abdomen2Y + abdomen3Y);
  beeAbdMid1.addPoint(centerX - abdomen3X, centerY + abdomen1Y + abdomen2Y + abdomen3Y);
  beeAbdMid1.addPoint(centerX - abdomen2X, centerY + abdomen1Y + abdomen2Y);
  beginShape();
  for(int i = 0; i < beeAbdMid1.npoints; i++) {
    vertex(beeAbdMid1.xpoints[i], beeAbdMid1.ypoints[i]);
  }
  endShape();

  fill(239, 15, 7);
  stroke(239, 15, 7);
  beeAbdMid2.addPoint(centerX - abdomen3X, centerY + abdomen1Y + abdomen2Y + abdomen3Y);
  beeAbdMid2.addPoint(centerX + abdomen3X, centerY + abdomen1Y + abdomen2Y + abdomen3Y);
  beeAbdMid2.addPoint(centerX + abdomen4X, centerY + abdomen1Y + abdomen2Y + abdomen3Y + abdomen4Y);
  beeAbdMid2.addPoint(centerX - abdomen4X, centerY + abdomen1Y + abdomen2Y + abdomen3Y + abdomen4Y);
  beeAbdMid2.addPoint(centerX - abdomen3X, centerY + abdomen1Y + abdomen2Y + abdomen3Y);
  beginShape();
  for(int i = 0; i < beeAbdMid2.npoints; i++) {
    vertex(beeAbdMid2.xpoints[i], beeAbdMid2.ypoints[i]);
  }
  endShape();

  fill(239, 15, 7);
  stroke(239, 15, 7);
  beeTail1.addPoint(centerX - abdomen4X, centerY + abdomen1Y + abdomen2Y + abdomen3Y + abdomen4Y);
  beeTail1.addPoint(centerX + abdomen4X, centerY + abdomen1Y + abdomen2Y + abdomen3Y + abdomen4Y);
  beeTail1.addPoint(centerX + abdomen5X, centerY + abdomen1Y + abdomen2Y + abdomen3Y + abdomen4Y + abdomen5Y);
  beeTail1.addPoint(centerX + abdomen6X, centerY + abdomen1Y + abdomen2Y + abdomen3Y + abdomen4Y + abdomen5Y + abdomen6Y);
  beeTail1.addPoint(centerX - abdomen6X, centerY + abdomen1Y + abdomen2Y + abdomen3Y + abdomen4Y + abdomen5Y + abdomen6Y);
  beeTail1.addPoint(centerX - abdomen5X, centerY + abdomen1Y + abdomen2Y + abdomen3Y + abdomen4Y + abdomen5Y);
  beeTail1.addPoint(centerX - abdomen4X, centerY + abdomen1Y + abdomen2Y + abdomen3Y + abdomen4Y);
  beginShape();
  for(int i = 0; i < beeTail1.npoints; i++) {
    vertex(beeTail1.xpoints[i], beeTail1.ypoints[i]);
  }
  endShape();

  if (beeGender > 2) {
  fill(239, 15, 7);
  stroke(239, 15, 7);
  beeTail2.addPoint(centerX - abdomen6X, centerY + abdomen1Y + abdomen2Y + abdomen3Y + abdomen4Y + abdomen5Y + abdomen6Y);
  beeTail2.addPoint(centerX + abdomen6X, centerY + abdomen1Y + abdomen2Y + abdomen3Y + abdomen4Y + abdomen5Y + abdomen6Y);
  beeTail2.addPoint(centerX, centerY + abdomen1Y + abdomen2Y + abdomen3Y + abdomen4Y + abdomen5Y + abdomen6Y + abdomen7Y);
  beeTail2.addPoint(centerX, centerY + abdomen1Y + abdomen2Y + abdomen3Y + abdomen4Y + abdomen5Y + abdomen6Y + abdomen7Y);
  beeTail2.addPoint(centerX - abdomen6X, centerY + abdomen1Y + abdomen2Y + abdomen3Y + abdomen4Y + abdomen5Y + abdomen6Y);
  beginShape();
  for(int i = 0; i < beeTail2.npoints; i++) {
    vertex(beeTail2.xpoints[i], beeTail2.ypoints[i]);
  }
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

public void setGender() {
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

public void setColors() {
  int yellower = floor(random(10));
  if (yellower <= 3) {
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

public void drawHair(java.awt.Polygon bodyPart) {
  int centerX = width / 2;

  // Get color
  if(bodyPart == beeHead) {
    stroke(headCol, 60);
  } else if(bodyPart == beeThorax1) {
    stroke(thorax1Col, 60);
  } else if(bodyPart == beeThorax2) {
    stroke(thorax2Col, 60);
  } else if(bodyPart == beeThorax3) {
    stroke(thorax3Col, 60);
  } else if(bodyPart == beeAbdTop) {
    stroke(topCol, 60);
  } else if(bodyPart == beeAbdMid1) {
    stroke(mid1Col, 60);
  } else if(bodyPart == beeAbdMid2) {
    stroke(mid2Col, 60);
  } else if(bodyPart == beeTail1 || bodyPart == beeTail2) {
    stroke(tailCol, 60);
  }

  for(int iX = 0; iX < width; iX++) {
    for (int iY = 0; iY < height; iY++) {
      if(bodyPart.contains(iX, iY)) {
        if(iX % 2 == 0 && iY % 2 == 0) {
          int randomiser = floor(random(10));
          int hairLength = floor(random(9, 13));
          int hairDirectionL = floor(random(-7, 0));
          int hairDirectionC = floor(random(-5, 5));
          int hairDirectionR = floor(random(0, 7));
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
  for(int iX = 0; iX < width; iX++) {
    for (int iY = 0; iY < height; iY++) {
      if(bodyPart.contains(iX, iY)) {
        if(iX % 3 == 0 && iY % 2 == 0) {
          int randomiser = floor(random(10));
          int hairLength = floor(random(9, 13));
          int hairDirectionL = floor(random(-7, 0));
          int hairDirectionC = floor(random(-5, 5));
          int hairDirectionR = floor(random(0, 7));
          if(randomiser > 2) {
            if(iX < (centerX - 30)) {
              line(iX, iY, iX + hairDirectionL, iY + hairLength);
            } else if (iX > (centerX - 35) && iX < (centerX + 35)) {
              line(iX, iY, iX + hairDirectionC, iY + hairLength);
            } else if(iX > (centerX + 30)) {
              line(iX, iY, iX + hairDirectionR, iY + hairLength);
            }
          }
        }
      }
    }
  }
}
  public void settings() {  size(512, 512);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "bumblebot" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
