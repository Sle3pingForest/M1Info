function compshow(im)
figure;
subplot(1,3,1) ;
imshowrange(im(:,:,1));
subplot(1,3,2);
imshowrange(im(:,:,2));
subplot(1,3,3);
imshowrange(im(:,:,3));
drawnow();
end