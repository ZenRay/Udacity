
[SQL规范化设计](http://www.bkent.net/Doc/simple5.htm)

[规范化－数据库设计原则](https://www.ibm.com/developerworks/cn/data/library/techarticles/dm-0605jiangt/index.html) 

## 规范化设计的主要内容
Rules for normalized tables
In a normalized database, the relationships among the tables match the relationships that are really there among the data.

1. Every row has the same number of columns. 
In practice, the database system won't let us literally have different numbers of columns in different rows. But if we have columns that are sometimes empty (null) and sometimes not, or if we stuff multiple values into a single field, we're bending this rule.
The example to keep in mind here is the diet table from the zoo database. Instead of trying to stuff multiple foods for a species into a single row about that species, we separate them out. This makes it much easier to do aggregations and comparisons.
2. There is a unique key and everything in a row says something about the key. 
The key may be one column or more than one. It may even be the whole row, as in the diet table. But we don't have duplicate rows in a table.
More importantly, if we are storing non-unique facts — such as people's names — we distinguish them using a unique identifier such as a serial number. This makes sure that we don't combine two people's grades or parking tickets just because they have the same name.
3. Facts that don't relate to the key belong in different tables. 
The example here was the items table, which had items, their locations, and the location's street addresses in it. The address isn't a fact about the item; it's a fact about the location. Moving it to a separate table saves space and reduces ambiguity, and we can always reconstitute the original table using ajoin.
4. Tables shouldn't imply relationships that don't exist. 
The example here was the job_skills table, where a single row listed one of a person's technology skills (like 'Linux') and one of their language skills (like 'French'). This made it look like their Linux knowledge was specific to French, or vice versa ... when that isn't the case in the real world. Normalizing this involved splitting the tech skills and job skills into separate tables.

## Sqlite 文件导入和导出
在 SQLite 中使用 CSV，SQLite 支持导入和导出 CSV 文件。

1. 将数据库中的数据导出为 CSV 文件


`sqlite> .mode csv /* 选择输出模式*／`

`sqlite> .output newFile.csv /*需要写入的文件名*／`

`sqlite> SELECT * FROM myTable; /*写入文件*/`

`sqlite> .exit`

2. 将 CSV 文件导入表中

`$ sqlite3 new.db   <--- 如果要将 csv 文件导入新数据库中，切记要先创建该数据库。`

`sqlite> CREATE TABLE myTable() <--- 构建您的模式！`

`sqlite> .mode csv /* 选择输入模式*/`

`sqlite> .import newFile.csv myTable /*输入内容*/`