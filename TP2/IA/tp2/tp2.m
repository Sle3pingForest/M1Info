
% Générer les données aléatoires dans le plan 


X1 = 5 + 2 * randn(100,2); 
X2 = -5 + 2 * randn(100,2); 
X = [X1;X2];
Y = [ones(100,1); -ones(100,1)];

figure;
hold on;
plot(X1(:,1), X1(:,2), 'ob');
plot(X2(:,1), X2(:,2), '*r');


Xvin = load ('vins.mat')

Xtest = Xvin.X;
Ytest = Xvin.Y;

[m,n] = size(Xtest);

% Apprentissage : 
[w,b] = adl(Xtest , Ytest); 

% Prédictions pour couvrir le plan et voir la frontière entre les classes : 
%Xtest = 20 * rand(1000,2) - 10;

Yhat = adlpred(Xtest, w, b);


errorTest = sum(mean(Yhat ~= Ytest))/m



plot(Xtest(Yhat==1,1), Xtest(Yhat==1,2), '.b');
plot(Xtest(Yhat==-1,1), Xtest(Yhat==-1,2), '.r');



