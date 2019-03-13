function toGY(HSI)


    figure;
imshow('shadows.jpg');
drawnow();
n=1;
somme=0;
terme = 1/n;
erreur = 1e-9;
while(terme > erreur)
[x,y] = ginput(1);
hue = HSI(round(y) ,round(x), 1);
H = HSI(: , : , 1);
I = find(abs(H-hue)< pi/5);
H(I) = pi/2;
HSI(:,:,1) = H;
uRGB = uRGB2(HSI);
imshow(uRGB);
drawnow;
end
 
disp(somme)
disp(n)
end