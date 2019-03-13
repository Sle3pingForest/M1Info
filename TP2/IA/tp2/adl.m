function [w,b] = adl(X,Y)
    %Xplus = X(find(Y == 1),:)
    Xplus = X(Y == 1,:);
    Xmoins = X(Y == -1, :);
    
    
    meanXplus = mean(Xplus)'
    meanXmoins = mean(Xmoins)'
    
    [mplus,n] = size(Xplus);
    [mmoins,n] = size(Xmoins);
    
    Cplus = cov(Xplus)
    Cmoins = cov(Xmoins)
    
    C = ((mplus-1)*Cplus + (mmoins-1)*Cmoins)/((mplus-1)+(mmoins-1))

    w =  C\(meanXplus-meanXmoins)
    b = log(mplus/mmoins)+(1/2)*(meanXplus+meanXmoins)'*(-w)
end