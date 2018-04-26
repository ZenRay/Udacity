**目录**

[toc]

## 1 使用 like 对 integer 类型查询

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

## 2 使用不同 JOIN 图解
[图解SQL的Join | | 酷 壳 - CoolShell](https://coolshell.cn/articles/3463.html)
