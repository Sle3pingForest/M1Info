/* x1 = produit A
  x2 = produit B
  x3 = produit C */
  
max: 6x1 + 2.6x2 + 4x3;
4x1 + 2x2 + x3 <= 6000;
2x1 + 0.5x2 + 3x3 <= 4000;
//x1 + x2 + x3 <= 2500;
x1 + x2 + x3 <= 2000;
x1 >= 0;
x2 >= 0;
x3 >= 0;
int x1 ,x2 x3;
/*
value of objective function: 10000

Actual values of the variables:
x1                           1400
x2                              0
x3                            400


Actual values of the constraints:
R1                           6000
R2                           4000
R3                           1800
*/