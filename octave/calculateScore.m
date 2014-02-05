function [score, stats] = calculateScore(pred, y)

%[pred y (y == 2) ((pred == y) .* (y == 2))]
matches = (pred == y);

home = (y == 1);
h1 = sum(matches .* home);
h2 = sum(home);

deuce = (y == 2);
d1 = sum(matches .* deuce);
d2 = sum(deuce);

away = (y == 3);
a1 = sum(matches .* away);
a2 = sum(away);

h = h1 / h2;
d = d1 / d2;
dx = (1 + d) / 2;
a = a1 / a2;

score = 3 * (h*dx*a) / (h+dx+a);

stats = zeros(3,1);

stats(1) = h * 100;
stats(2) = d * 100;
stats(3) = a * 100;

end
