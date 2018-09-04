[TOC]

# 文件说明
该内容主要是针对答疑问题过程中找到的比较实用性的关于数据可视化部分

# Jupyter NoteBook 技巧
包括魔法命令，快捷键
 [[译]27 个Jupyter Notebook的小提示与技巧 - Focus on ML & DM](http://liuchengxu.org/pelican-blog/jupyter-notebook-tips.html)

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

# return 和 yield 语句说明
1. return 语句
`return` 语句可以在函数定义中，和类定义中。一般用法，函数中有值，返回值；如果没有值，那么将返回 `None` 值。一般情况下，在函数内遇见 `return` 语句会跳出函数表示函数运行完成；但是在遇到 `try-finally` 语句时，函数运行时在 `finally` 之后才算完成。下面的例子说明了 `finally` 语句是必须运行的：
	
	```{python}
	# python 3.x
	def test_return():
	    a = 1
	    try:
	        return a / 0
	    except:
	        print("something wrong")
	        return "return statement"
	    finally:
	        print("finally statement")
	
	print(test_return())
	# output        
	
	something wrong
	finally statement
	return statement
	```

2. yield 语句
`yield` 语句及表达式，被用于生成器函数的函数体中。主要被用于实现异步；另外可以将数据逐渐一部分传递出函数，这样达到产生可迭代对象的效果。但是需要注意 `yield` 语句运行完成后，函数内的后续语句不是受它控制，即相关语句还是会继续完成。视频 [python 的 yield 传递数值方式](https://www.bilibili.com/video/av23757923) 使用 `debug` 的方式，对 `yield` 进行了模拟，注意 `watch` 中的变量值变化以及语句运行时的跳转。


3. 参考
	1. [Simple statements](https://docs.python.org/3.6/reference/simple_stmts.html#the-return-statement)
	2. [Yield Expressions](https://docs.python.org/3.6/reference/expressions.html#yieldexpr)
	3. [协程 - 廖雪峰的官方网站](https://www.liaoxuefeng.com/wiki/001374738125095c955c1e6d8bb493182103fac9270762a000/0013868328689835ecd883d910145dfa8227b539725e5ed000)

# 具有数据值的字符串转换—— `eval` 使用
该方法是对那类将数据值、数据表达式以及其他数据类型数据被字符串包裹时，可以使用该方法进行数据转换。⚠️注意某些字符串转换会报错：对于某些 `Identifer` 如果没有使用另外的引号包裹可能报错——`eval("{'a':false}")`、`eval("{'b':null}")`等可能出现报 `NameError` 错误。解决方式时对相应的数据添加引号（强制变更为字符串）——`eval("{'a':'false'}")`、`eval("{'b':'null'}")`

# `Numpy` 数据类型的定制化

**思路：**

Numpy 的数据类型可以通过 dtype 进行定制化处理，它可以确定基础数据类型，数据大小，数据序列，以及数据的字段名。用法上如下：

```python
>>> dt = np.dtype('>i4')
>>> dt.byteorder
'>'
>>> dt.itemsize
4
>>> dt.name
'int32'
>>> dt.type is np.int32
True

# 上面的方法只是针对数据，进行了定制化数据类型。下面将定制化一个字段名，这样产生一个统一的数据字段名称
>>> dt = np.dtype([('age',np.int8)]) 
>>> a = np.array([(10,),(20,),(30,)], dtype = dt)
>>> print(a)
array([(10,), (20,), (30,)], dtype=[('age', 'i1')])

>>> a["age"]
array([10, 20, 30], dtype=int8)

# 下面是对定制了一个 student 的数据
>>> student = np.dtype([('name','S20'), ('age', 'i1'), ('marks', 'f4')]) 
>>> a = np.array([('abc', 21, 50),('xyz', 18, 75)], dtype = student) 
>>> a
array([(b'abc', 21, 50.), (b'xyz', 18, 75.)],
      dtype=[('name', 'S20'), ('age', 'i1'), ('marks', '<f4')])
>>> a["name"]
array([b'abc', b'xyz'], dtype='|S20')
```

**参考：**

1. [NumPy Data Types](https://www.tutorialspoint.com/numpy/numpy_data_types.htm)
2. [Data type objects (dtype)](https://docs.scipy.org/doc/numpy-1.13.0/reference/arrays.dtypes.html)

