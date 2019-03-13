N = 500;
t = linspace(0,2*pi,500);
v = cos(2*t);
%figure;
%plot(v);

vf = fft(v);
%figure; 
%plot(abs(vf).^2);


vf2 = fftshift(vf);
%figure; 
%plot(abs(vf2).^2);

im1 = ones(N,1)*v;
im1show = (im1-min(min(im1)))/(max(max(im1)-min(min(im1))));

%figure;
%imshow(im1show);

imbis  = im1show';
%figure;
%imshow(imbis);


for i = 1:N
    imdia(i,:) = cos(8*(t-i/500*2*pi));
end

%figure;
%imshow(imdia);


for i = 1:N
    im4(i,:) = cos(8*(t-i/500*2*pi));
end

im5 = im1.*im4;
%figure;
%imshow(im5);

%tranformer de Fourier
imf = fft2(im5);
imf = fftshift(imf);
%figure;
%imshow(abs(imf).^2/max(max(abs(imf).^2)))



im = imread('animal_tres_mechant.jpg');
%figure;imshow(im);
im = double(rgb2gray(im))/255;
figure;imshow(im);

N = size(im,1);
M = size(im,2);
theta = 0 : 0.001 : 2*pi;
radius = 100;
X = radius * cos(theta);
Y = radius * sin(theta) ;
BW = poly2mask(X + M/2, Y+N/2, N, M);
%imshow(BW);



imf = fft2(im);
imf = fftshift(imf);
imflf = imf.*(BW);

%imflf = imf.*(1-BW);
imflf = fftshift(imflf);
im = ifft2(imflf);

figure;
imshow(im);


