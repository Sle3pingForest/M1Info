
function [uRGB2] = HSI2uRGB(HSI)

I = HSI(: , : , 3);
S = HSI(: , : , 2);
H = HSI(: , : , 1);

x = S.*cos(H);
y = S.*sin(H); 

uR = I + 2/3*x;
uG = I -1/3*x + 1/sqrt(3)*y;
uB = I -1/3*x-1/sqrt(3)*y;

uRGB2(:,:,1) = uR;
uRGB2(:,:,2) = uG;
uRGB2(:,:,3)= uB;
%imshow(uRGB2);
end