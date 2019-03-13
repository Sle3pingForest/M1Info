function [uRGB] = sRGB2uRBG(chemin)
im = imread(chemin);
uRGB = double(im)/255;
%imshow(uRGB);
end