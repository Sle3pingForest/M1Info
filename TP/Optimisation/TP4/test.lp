/*max:25 x1 + 26 x2 + 22 x3 + 34x4;
blanc:x1 + 1.1x2 + 1.2 x3 + x4<= 250;
noir:1.3x2 + 1.1x3 +x4 <= 200;
bleu:0.4x1 + 0.3x2 + 0.2x3 +0.5x4 <= 50;
x1 + x2 + x3  + x4<= 200;
int x1,x2,x3, x4;*/

max:25 x1 + 26 x2 + 22 x3;
blanc:x1 + 1.1x2 + 1.2 x3 <= x4;
noir:1.3x2 + 1.1x3 +x4 <= x5;
bleu:0.4x1 + 0.3x2 + 0.2x3 <= x6;
x1 + x2 + x3  + x4<= 200;
x4+x5+x6 <=500;
int x1,x2,x3, x4;