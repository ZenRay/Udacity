**目录**

[toc]

课程内容涉及评估和验证相关知识

# Lesson 1 Training Models
评估：使用相关指标对模型效果进行判断；同时需要基于相应的指标完成模型改善。

使用 `sklearn` 训练数据模型：

In the last section, we learned most of the most important classification algorithms in Machine Learning, including the following:

* Logistic Regression
* Neural Networks
* Decision Trees
* Support Vector Machines

Now, we'll have the chance to use them in real data! In sklearn, this is very easy, all we do is define our classifier, and then use the following line to fit the classifier to the data (which we call `X`, `y`):

```
classifier.fit(X,y)
```

Here are the main classifiers we define, together with the package we must import:

**Logistic Regression**

```
from sklearn.linear_model import LogisticRegression
classifier = LogisticRegression()
```

**Neural Networks**
(note: This is only available on versions 0.18 or higher of scikit-learn)

```
from sklearn.neural_network import MLPClassifier
classifier = MLPClassifier()
```

**Decision Trees**

```
from sklearn.tree import DecisionTreeClassifier
classifier = DecisionTreeClassifier()
```

**Support Vector Machines**

```
from sklearn.svm import SVC
classifier = SVC()
```

**Example: Logistic Regression**
Let's do an end-to-end example on how to read data and train our classifier. Let's say we carry our X and y from the previous section. Then, the following commands will train the Logistic Regression classifier:

```
from sklearn.linear_model import LogisticRegression
classifier = LogisticRegression()
classifier.fit(X,y)
```

## Lesson 2 Testing Models
利用测试数据集对模型检验，通常使用 `sklearn.model_selection` 中的 `train_test_split` 方法：

```
from sklearn.model_selection import train_test_split

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size)
```

`X` 为数据特征值， `y` 为标记值——label， `test_size` 为需要设定的区分作为测试数据的比例

