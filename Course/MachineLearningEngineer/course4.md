**目录**

[toc]

# 误差
## 误差产生原因
实际情况中误差产生主要有两个来源：

1. 偏差（Bias）：因模型无法表示基本数据的复杂度。即过度简化了数据模型

	* 偏差形成的误差产生结果，低准确率和欠拟合。
	
		如果模型具有足够的数据，但因不够复杂而无法捕捉基本关系，则会出现偏差。这样一来，模型一直会系统地错误表示数据，从而导致准确率降低。这种现象叫做欠拟合（underfitting）。
	
		简单来说，如果模型不适当，就会出现偏差。举个例子：如果对象是按颜色和形状分类的，但模型只能按颜色来区分对象和将对象分类（模型过度简化），因而一直会错误地分类对象。

		或者，我们可能有本质上是多项式的连续数据，但模型只能表示线性关系。在此情况下，我们向模型提供多少数据并不重要，因为模型根本无法表示其中的基本关系，我们需要更复杂的模型。
	
2. 方差（Variance）：模型对训练它所用的有限数据过度敏感，即过度复杂化了数据模型
	
	* 方差造成的误差 - 低精度和过拟合
	
		在训练模型时，通常使用来自较大训练集的有限数量样本。如果利用随机选择的数据子集反复训练模型，可以预料它的预测结果会因提供给它的具体样本而异。在这里，方差（variance）用来测量预测结果对于任何给定的测试样本会出现多大的变化。

		出现方差是正常的，但方差过高表明模型无法将其预测结果泛化到更多的数据。对训练集高度敏感也称为过拟合（overfitting），而且通常出现在模型过于复杂或我们没有足够的数据支持它时。

		通常，可以利用更多数据进行训练，以降低模型预测结果的方差并提高精度。如果没有更多的数据可以用于训练，还可以通过限制模型的复杂度来降低方差。

## 模型表现判别
* 学习曲线

通过可视化图形从数据中学习的能力来探讨偏差与方差之间的关系。能根据一系列训练实例中的训练和测试数据比较模型的指标性能。

在查看数据与误差之间的关系时，我们通常会看到，随着训练点数量的增加，误差会趋于下降。由于我们尝试构建从经验中学习的模型，因此这很有意义。

我们将训练集和测试集分隔开，以便更好地了解能否将模型泛化到未见过的数据而不是拟合到刚见过的数据。

在学习曲线中，当训练曲线和测试曲线均达到稳定阶段，并且两者之间的差距不再变化时，则可以确认模型已尽其所能地了解数据。

* 理想学习曲线

模型的最终目标是，误差小并能很好地泛化到未见过的数据（测试数据）。如果测试曲线和训练曲线均收敛，并且误差极低，就能看到这种模型。这种模型能根据未见过的数据非常准确地进行预测。

* 模型复杂度

与学习曲线图形不同，模型复杂度图形呈现的是模型复杂度如何改变训练曲线和测试曲线，而不是呈现用来训练模型的数据点数量。一般趋势是，随着模型增大，模型对固定的一组数据表现出更高的变化性。

* 学习曲线和模型复杂度关系

如果我们获取具有同一组固定数据的相同机器学习算法的学习曲线，但为越来越高的模型复杂度创建几个图形，则所有学习曲线图形均代表模型复杂度图形。这就是说，如果我们获取了每个模型复杂度的最终测试误差和训练误差，并依据模型复杂度将它们可视化，则我们能够看到随着模型的增大模型的表现有多好。

* 模型复杂度应用

既然知道了能通过分析模型复杂度图形来识别偏差和方差的问题，现在可利用一个可视化工具来帮助找出优化模型的方法。在下一部分中，我们会探讨 gridsearch 和如何微调模型以获得更好的性能。

sklearn中的学习曲线函数可以帮到我们。它可以让我们通过数据点来了解模型表现的好坏。

可以先引入这个模块

```
from sklearn.learning_curve import learning_curve # sklearn 0.17
from sklearn.model_selection import learning_curve # sklearn 0.18
```

文档中一个合理的实现是：

```
 learning_curve(
        estimator, X, y, cv=cv, n_jobs=n_jobs, train_sizes=train_sizes)
```

这里estimator是我们正在用来预测的模型，例如它可以是 `GaussianNB()`，`X` 和 `y` 是特征和目标。`cv` 是交叉验证生成器，例如 `KFold()`，`'n_jobs'`是平行运算的参数，`train_sizes` 是多少数量的训练数据用来生成曲线。


实际案例中使用：

```
# In this exercise we'll examine a learner which has high variance, and tries to learn
# nonexistant patterns in the data.
# Use the learning curve function from sklearn.learning_curve to plot learning curves
# of both training and testing error.
# CODE YOU HAVE TO TYPE IN IS IN LINE 35

from sklearn.tree import DecisionTreeRegressor
import matplotlib.pyplot as plt
# PLEASE NOTE:
# In sklearn 0.18, the import would be from sklearn.model_selection import learning_curve
from sklearn.learning_curve import learning_curve # sklearn version 0.17
from sklearn.cross_validation import KFold
from sklearn.metrics import explained_variance_score, make_scorer
import numpy as np

# Set the learning curve parameters; you'll need this for learning_curves
size = 1000
cv = KFold(size,shuffle=True)
score = make_scorer(explained_variance_score)

# Create a series of data that forces a learner to have high variance
X = np.round(np.reshape(np.random.normal(scale=5,size=2*size),(-1,2)),2)
y = np.array([[np.sin(x[0]+np.sin(x[1]))] for x in X])


def plot_curve():
    # Defining our regression algorithm
    reg = DecisionTreeRegressor()
    # Fit our model using X and y
    reg.fit(X,y)
    print "Regressor score: {:.4f}".format(reg.score(X,y))

    # TODO: Use learning_curve imported above to create learning curves for both the
    #       training data and testing data. You'll need reg, X, y, cv and score from above.

    train_sizes, train_scores, test_scores = learning_curve(reg, X, y, cv=cv, scoring=score)

    # Taking the mean of the test and training scores
    train_scores_mean = np.mean(train_scores,axis=1)
    test_scores_mean = np.mean(test_scores,axis=1)

    # Plotting the training curves and the testing curves using train_scores_mean and test_scores_mean
    plt.plot(train_sizes ,train_scores_mean,'-o',color='b',label="train_scores_mean")
    plt.plot(train_sizes,test_scores_mean ,'-o',color='r',label="test_scores_mean")

    # Plot aesthetics
    plt.ylim(-0.1, 1.1)
    plt.ylabel("Curve Score")
    plt.xlabel("Training Points")
    plt.legend(bbox_to_anchor=(1.1, 1.1))
    plt.show()

plot_curve()
```

## 模型改进
针对上面的学习曲线，了解模型改进方法：我们可以看到，在给定一组固定数据时，模型不能过于简单或复杂。如果过于简单，模型无法了解数据并会错误地表示数据。但是，如果建立非常复杂的模型，则需要更多数据才能了解基本关系，否则十分常见的是，模型会推断出在数据中实际上并不存在的关系。

关键在于，通过找出正确的模型复杂度来找到最大限度降低偏差和方差的最有效点。当然，数据越多，模型随着时间推移会变得越好。
