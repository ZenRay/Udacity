**目录**

[toc]

# 决策树
决策树的作用是通过将相关信息明确，以确定最后的结果。一般的步骤：

1. 选择最佳属性
2. 确定问题
3. 产生答案路径
4. 重复以上步骤，直到确认最后答案

## 布尔函数表述方式
决策树的几种表述意义：

1. `A and B`，即 A 和 B 均为真时得到的结果。决策树
2. `A or B`，即 A 或者 B 为真是得到的结果。决策树的结构表现为线性增长
3. `A xor B`，即 A 和 B 不能同时选择，两者中仅有一个为真时为真。在决策树表现中会存在差异（当 A 和 B 都为真时，结果为真），决策树的结构表现为指数级增长（${2^N}$），同时结果的的增长率更大（${2^{2^N}}$）

以上方式的意义，是可以表达了决策树的 `node` 和 `leaf` 的分布结构特点。

因为面对异或情况下决策树的结构指数级增长，这样说明备选函数的数量也是指数级增长。因此在实际情况下，需要采用合适的算法才能提高筛选效率。

## 决策树算法
1. ID3 —— Iterative Dichotomiser（迭代二分类器）
	
	[ID3 算法](https://storage.googleapis.com/supplemental_media/udacityu/5414400946/ID3%20Algorithm%20for%20Decision%20Trees.pdf)是通过自上向下，贪婪方法来构建决策树模型。总体来看它的步骤如下：
	
	* 存在一个有属性和分类值的数据集
	* 在数据集中，**选择最佳的属性**——在此时进行判断分类是否完成，用于检查最终是否训练数据是否完全匹配决策；当没有属性可以用于区分数据时，ID3 对数据以通过决策树路径上最多属性的方式进行区分数据。如果最终还是不能进行完全区分，ID3 将强制进行最后决策
	* 区分数据集，将符合选择属性的数据更新到对应的属性下
	* 生成包含了最佳属性的决策树 **节点（node）**
	* 通过递归进行第二步到第四步的过程，创建新的 node。需要注意发生分类终止的情况，属性不能被重复使用；如果在没有可以用于匹配的属性以及子数据集尚未分配完全的时候，这个时候只能选择一个最优匹配

	以下是针对离散属性且分类为二分类方式，创建的伪代码：
	
	```
	def id3(examples,classification_attribute,attributes):
		createarootnodeforthetree
		if all examples are positive/yes:
			return root node with positive/yes label
		else if all examples are negative/no:
			return root node with negative/no label
		else if there are no attributes left:
			return root node with most popular
			
		classification_attribute label
			else:
				best_attribute = attribute from attributes that best classifies examples
				assign best_attribute to root node
				
				for each value in best_attribute:
					add branch below root node for the value
				branch_examples=[examples that have that value for best_attribute]
	
				if branch_examples is empty:
					add leaf node with most popular classification_attribute label
				else
					add sub tree id3(branch_examples,
							classification_attribute,
							attributes-best_attribute)
	```
	
	
	**ID3 弊端**
	* 如果遇到一开始就不能进行决策，那么对整个数据集都是不适用。这种情况下，就是在刚开始数据就进行最终分类——即得到一个节点的情况
	* 同样的，对于一开始就是无属性的数据集，算法的结果同样是只有一个节点

	**算法中最佳属性评估——信息增益（information gain）**
	
	以数学的方式评估属性进行的分类数据表达效果，它确定了数据集上设置的标签随机性降低的效果。其数学表达式，用属性 A 对样本集 S 进行划分得到的信息增益： ${Gain(S, A)=Entropy(S)-\Sigma_{v}{\frac{S_v}{S}Entropy(S_v)}}$，其中 S 表示的是整体数据集（也可以用于表示父节点），v 表示各子节点数据，A 为属性
	
	熵（Entropy），它是测量随机性的一种方法（类比于物理学中表示系统稳定性），多辆样本集合纯度指标。其数学表达式为： ${Entropy=-\Sigma_{v}{P(v)logP(v)}}$

	**ID3 偏差**
	
	ID 3 的归纳偏差（inductive bias）主要针对两类偏差，限定偏差（表示针对特定算法的假设集合（Hypothesis Set），这样限定了算法的可选空间），即 `restriction bias`；优选偏差（表示了在假设集中首选的集，而此偏差是导致归纳偏差的主要原因），即 `reference bias`。
	
	优选偏差：说明了 ID3 算法是自定向下的构建算法模型，这也是说明了最佳属性都是靠近顶部；另一方面，ID3 的优选偏差偏向于能够产生良好分类结果数据的模型，而非较差分类数据结果模型——即 **以结果为导向** 偏向于适用能够创建正确决策树模型的数据；算法偏向于路径更短的树而非更长路径的树

	**连续类型属性数据的决策树应用**：可以通过数值范围来构建属性值；另一方面如果确认测试数据集中数据的范围，可以通过选择覆盖了测试集数据范围的数据进行训练（**注意⚠️**尽量不要使用该方法）。通常情况下，一般不会在特定的路径上进行重复调用属性；但是对于具有连续性属性数据，可以对属性进行分类进行重复调用，这种请款下是有意义的（例如年龄，先使用年龄大于 30 岁的进行分类产生节点，后续在该路径上继续分析年龄小于 14 岁的进行分类）
	
	**决策树算法停止时机：**1）所有内容个都已正确分类；2）属性使用完，或所有样本在所有的属性上取汁相同，无法划分；3）没有过拟合发生——剪枝，即当前节点包含的样本集合为空，不能划分。
	当时以上情况中，第二种是吧当前节点标记为叶节点，并将其类别设定为该节点所含样本的最多的类别。它是对当前节点的后验分布；而在第三种情况，同样是当前节点标记为叶节点，但是其类别设定为父节点包含样本最多的类别。其是把父节点的样本分布作为当前节点的先验分布。

2. C4.5

	该算法不是直接使用信息增益来选择最优划分属性，而是采用增益率来选择最优划分属性。其计算公式：${Gain\_ratio(S,A)=\frac{Gain(S, A)}{IV(A)}}$，其中 ${IV(A)=-\Sigma_{v}{\frac{S_v}{S}}log_2\frac{S_v}{S}}$，属性 A 可能取值数目越多（那么 v 也会越大），那么 IV(A) 的值也会越大。
	
	增益率准则优选偏差——对取值数目较少的属性有偏好，先从候选划分属性中找出信息增益高于平均水平的属性，在从找个选择增益率最高的（这是一种启发式算法）。
	
3. 基尼指数——Gini index

	一般可用于 CART 决策树（ Classification and Regression Tree）。其表达数据集 D 的纯度使用基尼值来度量，${Gini(D)=\Sigma_k^y\Sigma_{k'\neq{k}}p_kp_{k'}=1-\Sigma_{k=1}^yp_k^2}$。${Gini(D)}$ 反应来从数据集 D 中随机抽取两个样本，其类别标记不一致的概率，其值越小表示数据集 D 的纯度越高。属性 a 的基尼指数计算公式：${Gini\_index(D,a)=\Sigma^v_{v=1}\frac{D^v}{D}Gini(D^v)}$


4. 剪枝——pruning

	剪枝是为了对付过拟合的主要手段。因为在决策树中，为了尽可能的分类训练样本，节点划分过程将不断重复，有时会造成决策树分支过多。因此通过主动去掉一些分支来降低过拟合的风险。
	主要手段分为“预剪枝（prepruning）”和 “后剪枝（postpruning）”。**预剪枝**指在决策树生长过程中，对每个节点划分前先进行估计，若当前节点的划分不能带来决策树泛化性能提升，则停止划分并将当前节点标记为叶节点。**后剪枝**指先从训练集生成一颗完整的决策树，然后自底向上地对非叶节点进行考察，若将该节点对应的子树替换为叶节点能带来决策树泛化性能提升，则将该子树替换为叶节点
