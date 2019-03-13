
% Fichier pour EXERCICE 2 
% (créez un nouveau fichier pour l'exercice 1)

close all

%% 1) générer une base de données de 1000 points X,Y

N = 1000;
X = 6*rand(N,1) - 3; 
Y = sinc(X) + 0.2*randn(N,1);


%% 2) Créer un base d'apprentissage (Xapp, Yapp) de 30 points parmi ceux de (X,Y) et une base de test(Xtest,Ytest) avec le reste des données

indexes = randperm(1000,30);	% extrait 30 nombres tirés aléatoirement entre 1 et 1000 sans remise
Xapp = X(indexes);
Yapp = Y(indexes);

ind_test = 1:1000;
ind_test(indexes) = [];	% supprime certains indices de la liste

Xtest = X(ind_test);
Ytest = Y(ind_test);

% ordronner les Xtest pour faciliter le tracé des courbes
[Xtest, idx] = sort(Xtest);
Ytest = Ytest(idx);


% tracer la figure
figure;
hold on;
plot(Xtest,Ytest,'.r')
plot(Xapp,Yapp,'*b');
plot (Xtest,sinc(Xtest) , 'g', 'LineWidth',3)
legend('base test', 'base app', 'f_{reg}(x)' );

%% 3) implémenter les fonctions polyreg.m et polypred.m pour la régression polynomiale unidimensionelle

    w = polyreg(Xapp, Yapp, 5);
    Ypred = polypred(Xtest, w);
    %plot(Xtest, Ypred)
	%axis = [-5,5,-5,5]
%% 4) Réaliser l'apprentissage d'un modèle de degré 5 et calculer les erreurs d'apprentissage et de test

    ei = (Ytest-Ypred).^2;
    ei = sum(ei);
    rempF  =  (1 / size(Ytest,1)) * ei;

%% 5) Idem pour tout degré entre 1 et 15 en affichant les courbes

    for i =  1 : 15    
        w = polyreg(Xapp, Yapp, i);
        Ypred = polypred(Xtest, w);
        ei = (Ytest-Ypred).^2;
        ei = sum(ei);
        rempF  =  (1 / size(Ytest,1)) * ei;
        plot(Xtest,Ypred)
        axis = [-3,3,-2,2]
    end

% déterminer le meilleur modèle

 
 
%% 7) Sélection de modèle et estimation du risque

 

%% 8) Sélection de modèle sans données supplémentaires 

