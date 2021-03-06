function [J grad] = nnCostFunction2(nn_params, ...
                                   input_layer_size, ...
                                   hidden_layer1_size, ...
                                   hidden_layer2_size, ...
                                   num_labels, ...
                                   X, y, lambda)
%NNCOSTFUNCTION Implements the neural network cost function for a two layer
%neural network which performs classification
%   [J grad] = NNCOSTFUNCTON(nn_params, hidden_layer_size, num_labels, ...
%   X, y, lambda) computes the cost and gradient of the neural network. The
%   parameters for the neural network are "unrolled" into the vector
%   nn_params and need to be converted back into the weight matrices. 
% 
%   The returned parameter grad should be a "unrolled" vector of the
%   partial derivatives of the neural network.
%

% Reshape nn_params back into the parameters Theta1 and Theta2, the weight matrices
% for our 2 layer neural network

n1 = (input_layer_size+1) *hidden_layer1_size;
n2 = (hidden_layer1_size+1) *hidden_layer2_size;
n3 = (hidden_layer2_size+1) *num_labels;

Theta1 = reshape(nn_params(1:n1), ...
                 hidden_layer1_size, (input_layer_size + 1));

Theta2 = reshape(nn_params((1 + n1):n1+n2), ...
                 hidden_layer2_size, (hidden_layer1_size + 1));

Theta3 = reshape(nn_params((1 + (n1+n2)):end), ...
                 num_labels, (hidden_layer2_size + 1));

% Setup some useful variables
m = size(X, 1);
         
m;
input_layer_size;
hidden_layer1_size;
hidden_layer2_size;
num_labels;
lambda;
size(y);
min(y);
max(y);
         
% You need to return the following variables correctly 
J = 0;
Theta1_grad = zeros(size(Theta1));
Theta2_grad = zeros(size(Theta2));
Theta3_grad = zeros(size(Theta3));

% ====================== YOUR CODE HERE ======================
% Instructions: You should complete the code by working through the
%               following parts.
%
% Part 1: Feedforward the neural network and return the cost in the
%         variable J. After implementing Part 1, you can verify that your
%         cost function computation is correct by verifying the cost
%         computed in ex4.m
%
% Part 2: Implement the backpropagation algorithm to compute the gradients
%         Theta1_grad and Theta2_grad. You should return the partial derivatives of
%         the cost function with respect to Theta1 and Theta2 in Theta1_grad and
%         Theta2_grad, respectively. After implementing Part 2, you can check
%         that your implementation is correct by running checkNNGradients
%
%         Note: The vector y passed into the function is a vector of labels
%               containing values from 1..K. You need to map this vector into a 
%               binary vector of 1's and 0's to be used with the neural network
%               cost function.
%
%         Hint: We recommend implementing backpropagation using a for-loop
%               over the training examples if you are implementing it for the 
%               first time.
%
% Part 3: Implement regularization with the cost function and gradients.
%
%         Hint: You can implement this around the code for
%               backpropagation. That is, you can compute the gradients for
%               the regularization separately and then add them to Theta1_grad
%               and Theta2_grad from Part 2.
%

X = [ones(m, 1) X];
a1 = zeros(m,hidden_layer1_size);
a2 = zeros(m,hidden_layer2_size);

z = 0;

%calculate hidden layer1
for ii = 1:m
  for jj = 1:hidden_layer1_size
   x = X(ii,:);
   x = x';
   t = Theta1(jj,:);
   mySum = t * x;
  
   a1(ii,jj) = sigmoid(mySum);
   z = z + 1;
  end
end

a1 = [ones(m, 1) a1];
%calculate hidden layer2
for ii = 1:m
  for jj = 1:hidden_layer2_size
  x = a1(ii,:);
  x = x';
  t = Theta2(jj,:);
  mySum = t * x;

  a2(ii,jj) = sigmoid(mySum);
  z = z + 1;
  end
end


a2 = [ones(m, 1) a2];
b = zeros(m,num_labels);
p = zeros(m,num_labels);

%calculate outout layer
for ii = 1:m
  for jj = 1:num_labels
   x = a2(ii,:);
   x = x';
   t = Theta3(jj,:);
   mySum = t * x;
  
   b(ii,jj) = sigmoid(mySum);
  end
end


for ii = 1:m
  [myMax, index] = max(b(ii,:));
  p(ii, index) = 1;
end

p;
y;

Delta1 = zeros(hidden_layer1_size, input_layer_size +1);
Delta2 = zeros(hidden_layer2_size, hidden_layer1_size + 1);
Delta3 = zeros(num_labels, hidden_layer2_size + 1);

for ii = 1:m
  myY = zeros(num_labels, 1);
  myY(y(ii)) = 1;
  delta3 = b(ii,:)' - myY;

  a2_1 = a2(ii,:)';
  delta2 = (Theta3' * delta3) .* (a2_1 .* (1 - a2_1));
  delta2x = delta2(2:end);
  
  a1_1 = a1(ii,:)';
  delta1 = (Theta2' * delta2x) .* (a1_1 .* (1 - a1_1));
  delta1x = delta1(2:end);

            
  for jj = 1:num_labels
    _h = b(ii,jj);
    _y = myY(jj);
    error = _y * log(_h) + (1 - _y) * log(1 - _h);
    J = J + error;
  end
  
  Delta3 = Delta3 + delta3 * a2(ii,:);
  Delta2 = Delta2 + delta2x * a1(ii,:);
  Delta1 = Delta1 + delta1x * X(ii,:);
end

weightSum = 0;
for ii = 1:hidden_layer1_size
  for jj = 1:(input_layer_size+1)
    if jj > 1
      Delta1(ii,jj) = Delta1(ii,jj) + lambda*Theta1(ii,jj);
      weightSum = weightSum + Theta1(ii,jj)^2;
    end
  end
end

for ii = 1:hidden_layer2_size
  for jj = 1:(hidden_layer1_size+1)
    if jj > 1
      Delta2(ii,jj) = Delta2(ii,jj) + lambda*Theta2(ii,jj);
      weightSum = weightSum + Theta2(ii,jj)^2;
    end
  end
end

for ii = 1:num_labels
  for jj = 1:(hidden_layer2_size+1)
    if jj > 1
      Delta3(ii,jj) = Delta3(ii,jj) + lambda*Theta3(ii,jj);
      weightSum = weightSum + Theta3(ii,jj)^2;
    end
  end
end

Delta1 = Delta1 ./ m;
Delta2 = Delta2 ./ m;
Delta3 = Delta3 ./ m;

Theta1_grad = Delta1;
Theta2_grad = Delta2;
Theta3_grad = Delta3;


J = (J / (-m)) + (lambda * weightSum / (2 * m));













% -------------------------------------------------------------

% =========================================================================

% Unroll gradients
grad = [Theta1_grad(:) ; Theta2_grad(:) ; Theta3_grad(:)];


end
