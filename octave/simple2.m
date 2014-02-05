%% Machine Learning Online Class - Exercise 4 Neural Network Learning

%  Instructions
%  ------------
% 
%  This file contains code that helps you get started on the
%  linear exercise. You will need to complete the following functions 
%  in this exericse:
%
%     sigmoidGradient.m
%     randInitializeWeights.m
%     nnCostFunction.m
%
%  For this exercise, you will not need to change any code in this file,
%  or any other files other than those mentioned above.
%

%% Initialization
clear ; close all; clc

%% Setup the parameters you will use for this exercise
input_layer_size  = 3;  %3 features
hidden_layer1_size = 10;   % 10 hidden units
hidden_layer2_size = 8;   % 10 hidden units
num_labels = 3;          % 3 labels, from 1 to 3 ( Home, Deuce, Away)

learningThreshold=0.0005
maxIter = 10

%% =========== Part 1: Loading and Visualizing Data =============
%  We start the exercise by first loading and visualizing the dataset. 
%  You will be working with a dataset that contains handwritten digits.
%

% Load Training Data
fprintf('Loading ...\n')

fprintf('Configuration: %i - %i - %i - %i\n', input_layer_size, hidden_layer1_size, hidden_layer2_size, num_labels);
load('simple_x.dat');
load('simple_y.dat');

%%%%%%%%%%%%%%%% FAKE DATA %%%%%%%%%%%%%%%%%%%
load('fake_x.txt');
load('fake_y.txt');
%simple_x = fake_x;
%simple_y = fake_y;
%fake = 1
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

m_total = size(simple_x, 1);
fprintf('total: %i\n', m_total);

m_train = m_total / 10 * 6;
m_small = m_total / 10 * 2;

f1 = simple_x(:,1) * 2 - 1;
f2 = simple_x(:,2) * 2 - 1;
f3 = (simple_x(:,1) - simple_x(:,2)) / 2;

simple_x = [f1 f2 f3];

Xtrain_total =  simple_x(1:m_train,:);
Xveri  =  simple_x(m_train+1:m_train+m_small,:);
Xtest  =  simple_x(m_train+m_small+1:m_total,:);

ytrain_total =  simple_y(1:m_train,:);
yveri  =  simple_y(m_train+1:m_train+m_small,:);
ytest  =  simple_y(m_train+m_small+1:m_total,:);

%for trainSize = 100:200:m_train
%for trainSize = [100 1000 m_train]
for trainSize = m_train:m_train

Xtrain = Xtrain_total(1:trainSize,:);
ytrain = ytrain_total(1:trainSize,:);

m = size(Xtrain, 1);

printf('%i examples...',m);

fprintf('\nInitializing Neural Network Parameters ...\n')
%for lambda = 0.5:-0.1:0
for lambda = 0.5:0.5

%  You should also try different values of lambda
%  lambda = 1;
fprintf('\nUsing lambda: %.1f\n', lambda);


initial_Theta1 = randInitializeWeights(input_layer_size, hidden_layer1_size);
n1 = size(initial_Theta1,1) * size(initial_Theta1,2);

initial_Theta2 = randInitializeWeights(hidden_layer1_size, hidden_layer2_size);
n2 = size(initial_Theta2,1) * size(initial_Theta2,2);

initial_Theta3 = randInitializeWeights(hidden_layer2_size, num_labels);
n3 = size(initial_Theta3,1) * size(initial_Theta3,2);


% Unroll parameters
initial_nn_params = [initial_Theta1(:) ; initial_Theta2(:), ; initial_Theta3(:)];


%% =================== Part 8: Training NN ===================
%  You have now implemented all the code necessary to train a neural 
%  network. To train your neural network, we will now use "fmincg", which
%  is a function which works similarly to "fminunc". Recall that these
%  advanced optimizers are able to train our cost functions efficiently as
%  long as we provide them with the gradient computations.
%
fprintf('\nTraining Neural Network... \n')

%  After you have completed the assignment, change the MaxIter to a larger
%  value to see how more training helps.
options = optimset('MaxIter', maxIter);


% Create "short hand" for the cost function to be minimized
costFunction = @(p) nnCostFunction2(p, ...
                                    input_layer_size, ...
                                    hidden_layer1_size, ...
                                    hidden_layer2_size, ...
                                    num_labels, Xtrain, ytrain, lambda);

% Now, costFunction is a function that takes in only one argument (the
% neural network parameters)
%[nn_params, cost] = fmincg(costFunction, initial_nn_params, options);

%plotX = 1:maxIter;
%plotY = cost';

%diff = ((cost(1)-cost(maxIter))/cost(1));
%fprintf('-> improved %.1f%%\n', diff*100);

nn_params = initial_nn_params;
plotY = [];

for i = 1:25
   [nn_params, cost] = fmincg(costFunction, nn_params, options);
   plotY = [plotY cost'];

   diff = ((cost(1)-cost(maxIter))/cost(1));
   fprintf('-> improved %.1f%%\n', diff*100);
   if (diff<learningThreshold)
      break;
   end
end
          
plotX = 1:length(plotY);

% Obtain Theta1,Theta2,Theta3 back from nn_params
Theta1 = reshape(nn_params(1:n1), ...
                 hidden_layer1_size, (input_layer_size + 1));

Theta2 = reshape(nn_params((1 + n1):n1+n2), ...
                 hidden_layer2_size, (hidden_layer1_size + 1));

Theta3 = reshape(nn_params((1 + (n1+n2)):end), ...
                        num_labels, (hidden_layer2_size + 1));

fprintf('%i iterations of learning. Plot will follow...\n',length(plotY));
%pause;

%plot(plotX,plotY);

%% ================= Part 10: Implement Predict =================
%  After training the neural network, we would like to use it to predict
%  the labels. You will now implement the "predict" function to use the
%  neural network to predict the labels of the training set. This lets
%  you compute the training set accuracy.

pred = predict2(Theta1, Theta2, Theta3, Xtrain);
[score, stats] = calculateScore(pred, ytrain);
fprintf('\nTraining Set Accuracy: %.2f%% (%.1f%%/%.1f%%/%.1f%%) => %.2f\n', mean(double(pred == ytrain)) * 100,stats(1), stats(2), stats(3), score);

pred = predict2(Theta1, Theta2, Theta3, Xveri);
[score, stats] = calculateScore(pred, yveri);
fprintf('Verification Set Accuracy: %.2f%% (%.1f%%/%.1f%%/%.1f%%) => %.2f\n', mean(double(pred == yveri)) * 100,stats(1), stats(2), stats(3), score);

[pred, h3] = predict2(Theta1, Theta2, Theta3, Xtest);
[score, stats] = calculateScore(pred, ytest);
fprintf('Test Set Accuracy: %.2f%% (%.1f%%/%.1f%%/%.1f%%) => %.2f\n', mean(double(pred == ytest)) * 100,stats(1), stats(2), stats(3), score);

            %debug =[(pred == ytest) ytest h3];
            %debug(1:10,:);
            
end %lambda

            
end %trainSize
