
function [HSI] = uRGB2HSI(uRGB)
uR = uRGB(:,:,1);
uG = uRGB(:,:,2);
uB = uRGB(:,:,3);
x = uR - 1/2*(uG + uB);
y = sqrt(3)/2*(uG-uB);
H = atan2(y,x);
%S = sqrt(x.*x+y.*y);
S = sqrt(x.^2+y.^2);
I =(uR+uB+uG)/3;

HSI(: , : , 1) = H;
HSI(: , : , 2)= S;
HSI(: , : , 3) = I;
%imshow(HSI);
end