## XML设计的目的
1. 快速的数据传递——客户端和服务器端都是同样的传输协议
2. 能够快速的书写和读取数据
3. 文档是规范而有效
4. Human Readable
5. 可以被其他App广泛地应用

当前被广泛应用的数据传递和分析方面的工具，主要包括了XML和Json。

## 常用术语
1. entity：信息呈现的标志，具体解释见参考文档[在 XML 中添加实体](https://www.ibm.com/developerworks/cn/xml/x-entities/)
2. document：符合XML构造规则的数据对象
3. prolog：XML文档中首行中申明版本号和编码方式
4. tag：用于标记数据的标签——类似HMTL tag。一般情况下包括opening tag和closing tag
5. attribute：用于说明element的额外信息。需要注意在属性中的值，需要加引号。每个attribute需要对应的值
6. comment：提供笔记和临时性编辑的语句

***First and foremost, a valid XML document must be well-formed***

## 语法解析
对于大量数据的解析，推荐使用iterparse——不会将整个文件全部加载，可以减轻内存负担。该方法返回一个元祖，包括event和element

## XML解析
XML解析，一般都是当作ElementTree来看待，使用build-in的库可以完成相关解析。中文解析详情见[用 ElementTree 在 Python 中解析 XML — PyCoder's Weelky CN](https://pycoders-weekly-chinese.readthedocs.io/en/latest/issue6/processing-xml-in-python-with-element-tree.html#)

##举例

**prolog申明**
`<?xml version="1.0" encoding="ISO-8859-15">`

上段中version申明了版本号，encoding申明了文档编码类型；申明语句要求放在文档的最开头，包括了两部分即XML申明和DTD(Document Type Declaration——是包含了XML编码规则的一个文件，是类似于声明了语法规则。这个文件可以是一个外链)声明

下面文件包括了XML
声明和DTD外链声明

`<?xml version="1.0"?>`
`<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
 "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
`

**attribute属性**
`<opening tag element_attribute_name="value"></closing tag>`

**comment注释**<br>
`<!-- comment statement -->`

XML的注释语句的方法是和HTML相同的，可以多行注释。

##习题参考：

[1](https://classroom.udacity.com/nanodegrees/nd002/parts/0021345404/modules/316820862075461/lessons/5436095827/concepts/8755386140923)