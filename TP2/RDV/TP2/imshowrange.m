function imshowrange(im)
imshow(im,'DisplayRange',[min(min(im)) max(max(im))]);
end