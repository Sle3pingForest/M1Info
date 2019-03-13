%
% Fonction d'apprentissage sur la base (X,Y)
%
%	w = polyreg(X, Y, degre)
%
%	w 	: paramètres du modèle polynomial f 
%	degre : degre du polynome f
%	X 	= [x1; x2; x3; ... ; xm]
%	Y 	= [y1; y2; y3; ... ; ym]
%
function w = polyreg(X, Y, degre)
    n = size(X,1);
    
    phi = zeros(n, degre +1);
    
    for k =  1 : degre + 1
        phi(:, k) = X.^(k-1);
    end
    w =  phi\Y
end
