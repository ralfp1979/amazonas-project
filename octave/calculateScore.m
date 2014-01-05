function [score, stats] = calculateScore(pred, y)


h1 = sum(pred == y == 1);
h2 = sum(y == 1);
d1 = sum(pred == y == 2);
d2 = sum(y == 2);
a1 = sum(pred == y == 3);
a2 = sum(y == 3);

h = h1 / h2;
d = d1 / d2;
a = a1 / a2;

score = 3 * (h*d*a) / (h+d+a);

stats = zeros(3,1);

stats(1) = h * 100;
stats(2) = d * 100;
stats(3) = a * 100;

end
