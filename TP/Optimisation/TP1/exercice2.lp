/*xA xB Xc XD
 xA = 1 on prend
 xA = alpha on prend alpha projet A
 xA = 0 on prend pas */
 
max: 92xA + 40xB + 100xC + 35xD;
16xA + 25xB + 40xC +15xD <= 80;
22xA + 10xB + 25xC +15xD <= 65;
20xA + 5xB + 15xC +15xD <= 47;
15xA + 15xD <= 25;

0 <= xA <= 1;
0 <= xB <= 1;
0 <= xC <= 1;
0 <= xD <= 1;


xD >= xC;

int xA, xB, xC, xD;
