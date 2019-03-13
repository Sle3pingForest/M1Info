%
% Fonction de prédiction Y = polypred(X, w)
%
%	w 	: paramètres du modèle polynomial f issus de polyreg
%	X 	: vecteur de taille N contenant les N valeurs de x où évaluer le polynome f(x)
%	Y 	: valeurs de polynome f(X) 
% 
function Y = polypred(X, w)

    n = size(X,1);
    
    degre = length(w);
    
    phi = zeros(n, degre -1);
    
    for k =  1 : degre
        phi(:, k) = X.^(k-1);
    end
    
	Y = phi*w;

end
