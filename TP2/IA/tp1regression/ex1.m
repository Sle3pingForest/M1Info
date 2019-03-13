
m = 1000;

X = 10 *rand(m,5) - 5

X(:,5) = 2*X(:,4);

Y = randn(m,1);

w = [1.2, -1.3, 0.5, 0.8, -2.3];

y =  X * w' + randn(m,1);

ww = inv(X'*X)*X'* y

error = X * ww;

ei = sum((y - X*w').^2);

rempF  =  (1 / size(X,1)) * ei;

% www = ww
www = X \ y %resoudre arg min || y - X ||²

%Q5 plus m est grand plus on approche de 1
