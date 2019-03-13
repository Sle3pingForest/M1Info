
%EXO1%
%une matrice A%
A = [[2,5,6,8,7,3];
    [7,8,7,9,3,1];
    [1,4,6,2,0,0];
    [6,6,5,3,2,4];
    [0,8,0,6,5,9]]

%A2 =  [[2.2,5,6,8,7,3];[7,8.5,7,9,3,1];[1,4,6,2,0,0];[6,6,5,3,2,4];[0,8,0,6,5,9]]
%round(A2) %arrondi la matrice

ssX = 3*A(2:4,2:5)

A(2:4,2:5) = 3*A(2:4,2:5) %ou ssX , on remplace une partie de la matrice gauche par la ma trice droit

%EXO2%
Mnulle = zeros(5,5)

Munaire = ones(5,5)

Mrand = rand(5,5)

Meye = eye(5,5)

%EXO3%


X = [1:8]' * ones(1,12) % pour cela on fait une produit de la comatrice[1:8] a la matrice ones(1:12)

M = size(X,1)
N = size(X,2)

X(M/4+1: M/4 + M/2,N/4+1:N/4 + N/2) = 4* X(M/4+1: M/4 + M/2,N/4+1:N/4 + N/2)

%EXO4%


Matrice = ones(5,5)

Mtemp = 2 * eye(2,2) - ones(2,2)

M = kron(Matrice,Mtemp)



