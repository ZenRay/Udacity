**目录**

[TOC]

## 1. 使用 like 对 integer 类型查询

该问题是基于这个[问题](https://discussions.youdaxue.com/t/like/56911)的思考,思路是需要对 integer 类型的数据需要转换为字符串,同理可以将日期类型强制转换为字符串.之后利用 like 的字符串比较方式来解决问题.**但是不推荐该方式,毕竟不同数据有不同处理方式**

解决思路:[sql - Like operator for integer - Stack Overflow](https://stackoverflow.com/questions/18462376/like-operator-for-integer)
不合适的解释:[Bad habits to kick : mis-handling date / range queries – SQLBlog / Aaron](https://sqlblog.org/2009/10/16/bad-habits-to-kick-mis-handling-date-range-queries)

```{SQL}
/*
* 目的是将 occurred_at 日期强制转换为字符串,并且使用 like 来筛选出 2016 年数据
*/
SELECT *
	FROM orders
WHERE CAST(occurred_at as varchar(10)) like '2016%';
```

## 2. 使用不同 JOIN 图解
[图解SQL的Join | | 酷 壳 - CoolShell](https://coolshell.cn/articles/3463.html)



## 3. 条件筛选与子查询

这个问题的思考来源于 [关于SQL HAVING语句的问题](https://discussions.youdaxue.com/t/sql-having/64626)。而解决该问题的最佳思路就是使用子查询，因为子查询语句不仅能够出现在 `FROM` 子句之后以表示数据来源，另外还可以在条件子句（例如 `WHERE` 和 `HAVING`）之后用于筛选特定的条件值。

```sql
SELECT DATE_TRUNC('month', occurred_at) months, SUM(total_amt_usd) ts
	FROM orders
	GROUP BY 1
HAVING DATE_TRUNC('month', occurred_at) = 
	(SELECT DATE_TRUNC('month', MIN(occurred_at)) 
		FROM orders)
```

其他的数据筛选举例：

```sql
SELECT name FROM bbc
	WHERE region='Europe' AND gdp/population >
		(SELECT gdp/population
			FROM bbc
		WHERE name='United Kingdom')
```

