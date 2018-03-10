[toc]

# 文件说明
该内容主要是针对答疑问题过程中找到的比较实用性的关于 AB 测试的文档

# ${\alpha}$ 和 ${\beta}$ 统计学说明
1. [${\alpha}$ 和 ${\beta}$，古希腊字母与统计学](http://www.appadhoc.com/blog/alpha-beta-statics-ab-test/)
2. [如何理解统计学中的 Power | 宋春林](http://songchunlin.net/cn/2014/04/statistical-power/)
	
	解释了 ${\alpha}$ 和 ${\beta}$ 两者的统计学意义，

# Standard deviation & Standard error
`Standard deviation` is a calculation that can be made on any list of data. Most of the time, it is used on numerical data to get a measure of the spread of a data, essentially quantifying some of what you might see with a visualization such as a histogram.

`Standard error` is a type of standard deviation that is calculated specifically on sampling means. If you took infinite samples of size N, then the standard error for that N would be the standard deviation of the distribution made up of the means of all of the samples. Analytically, if this is a normal distribution, the standard error will approximately equal the standard deviation of all of the datapoints as a whole divided by the square root of N (thus the formula).

In this case, we are calculating the standard deviation of differences, which isn't a standard error. However, it can be used in the same way as a standard error in terms of creating a confidence interval for the differences.

# 统计显著性和实际显著性

首先统计显著性和实际显著性是不同的概念——**统计显著性**是检查试验组和对照组之间是否存在差异，其目的是说明我们能否有证据拒绝接受零和假设（即试验中的变更不会产生影响）；另一个，**实际显著性** 在统计显著性检查之后，如果已经已经有统计显著性差异，我们想尝试提供更多的证据去证明试验中**变更可以实施**。这里的实际显著性差异就和 ${d_{min}}$ 值相关了，需要 ${CI}$ 值和 ${[-d_{min},d_{min}]}$ 进行比较。


The difference between experiment and control click-through rates is quite small (0.0116) but larger than the dmin score of 0.01. The margin of error is 0.005 which means that our 95% confidence interval for this data is 0.0064 ~ 0.016.

Given that the margin of error potentially puts us below the dmin score, we should run another experiment and think this change through some more before launching. I would recommend we hold off on the change until we have more data.

[Practical Significance; Standard Deviation Empirical/Analytical; Effect Size Test - DAND: A/B Testing - Discourse](https://discussions.udacity.com/t/practical-significance-standard-deviation-empirical-analytical-effect-size-test/163672)

# 符号检验及其双尾检验
符号检验的是说明试验组和对照组的数据是否有意义
The goal of a sign test is to make sure that a metric that isn't supposed to change really doesn't change. So for its purposes, it doesn't matter whether the metric goes up when it isn't supposed to, or down when it isn't supposed to. So yes, the hypothesis test will test for both positive and negative changes.
主要是检验变化是否发生没有

# 不变指标、引流单元、分析单元
* 引流单元：是试验中需要统计的单个对象，而且在试验中我们需要把分流对象从原总体中区分。引流的要求引流机制要能在试验中匹配到试验中的每个统计主体。

* 不变指标：分配到试验组和对照组中的对象，首先我们需要确认使用那些特征来说明变化以及这些特征在试验过程中表现是否能准确表现。而不变指标，就是我们在试验中选取的这样的特征，它能够确认试验组和对照组的容量是否满足相等，而且它不能受到变更的直接明显的影响。

	对用户 ID 假设为不变指标，是基于变更不会导致用户 ID 数量直接明显变化的要求。

* 分析单元：它只是在分析某些指标时用到的 **分母**。例如：计算点击率指标时，用点击量除以页面查看量，其中分母页面查看量，即是分析单元。因此在分析的时候确认作为分母的分析单元的变异性。
	原因：用分析方法计算差异时，我们会假设数据的分布，例如假设数据符合二项分布，并假设每次事件发生是独立的，
	
* 评估指标：它是评价试验或者变更效果的一个指标	
[设计 AB Test | Hexo](http://lilyalove.com/2017/08/04/AB-test-design/#%E8%AF%84%E4%BC%B0%E6%8C%87%E6%A0%87)
