[toc]

# 文件说明
该内容主要是针对答疑问题过程中找到的比较实用性的关于数据可视化部分

# Jupyter NoteBook 技巧
1. [[译]27 个Jupyter Notebook的小提示与技巧 - Focus on ML & DM](http://liuchengxu.org/pelican-blog/jupyter-notebook-tips.html)

	魔法命令，快捷键

# Python 数据的移位求值
对于 Python 的移位求值来说，例如计算移动平均数等方式可以通过 pandas 的 rolling 方法来完成。

[pandas.DataFrame.rolling — pandas 0.22.0 documentation](https://pandas.pydata.org/pandas-docs/stable/generated/pandas.DataFrame.rolling.html)

[python | pandas | 移动窗口函数rolling - CSDN博客](https://blog.csdn.net/xxzhangx/article/details/76938053)

# Pandas 报 copy 和赋值的警告信息

在创建新的列和更改某些列的值时，`pandas`(版本号为 `0.22.0`)可能出现以下报错信息：

```{python}
# Python 3.6

SettingWithCopyException:
 	A value is trying to be set on a copy of a slice from a DataFrame.
 	Try using .loc[row_index,col_indexer] = value instead

```

产生该错误的原因：1）`pandas`	需要使用 `iloc` 的方法来避免因为直接使用 `df[["column1", "columns2"]]` 等方式造成的运算开销增大；2）上面这个错误可能连续报警，是因为在视图上进行调整数据。**解决方式：** 对使用了选择列的数据进行深度复制。代码参考如下：

```
# 创建和修改数据 其中 data 为原始数据
analysis_data = data[["attacker_size", "defender_size", "attacker_outcome"]].copy(deep=True)
analysis_data.loc[:,"attacker_outcome"] = \
    analysis_data.loc[:,"attacker_outcome"].apply(lambda x :1 if x=="win" else 0)
    
analysis_data.dropna(subset=["attacker_size", "defender_size"], inplace=True)
# 创建 intercept 值
analysis_data["intercept"] = np.repeat(1, len(analysis_data))
# 构建模型
model = Logit(analysis_data["attacker_outcome"], analysis_data[["attacker_size", "defender_size", "intercept"]])

# 生成报告
result = model.fit()
print(result.summary2())
```

关于计算开销增大原因参考——[Indexing and Selecting Data — pandas 0.22.0 documentation](http://pandas.pydata.org/pandas-docs/stable/indexing.html#indexing-view-versus-copy)
