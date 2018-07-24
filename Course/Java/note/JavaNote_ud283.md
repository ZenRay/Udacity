**目录**

[TOC]

课程是 `Udacity` 中 `Java OOP(ud283)` 的课程，课程的主题涉及到 `Java` 的高级知识：

* 面向对象编程，`Java` 的对象，含义及其使用方法
* 与用户互动（**User Interaction**），如何通过文本文件和用户输入建立与用户互动的程序
* `OOP` 概念，例如继承及其实际使用
* 存储一组对象的集合（**Collection**）

# 1. `OOP`——Object Oriented Programming

在 `Java` 中编写代码来解决实际问题，面向对象就是一种解决实际对象和编程对象相匹配的问题——对象存储描述其自身的数据（字段，即 **Field**，表达对象所具有的属性名称等——相当于 `Python` 类中的属性；方法，即 **Method**，表达对象可使用的特定方法——同 `Python` 类中的方法是具有同样的意义）。

在 `Java` 中变量的类型，可分为基本类型变量（**Basic Datatypes**，也叫做原始变量——**Primitive Variable**）可以创建整数，双精度等数据类型的变量；对象变量（**Object Variable**） 是可以自由设计的一种升级版数据类型。这种类型可以存储多个数据信息，例如 “Pokemon” 游戏中，动物对象可以存储名字、分类以及获胜次数等信息，另外还可以存储特定方法。但是需要注意⚠️，对象变量中数据需要使用原始变量，对象变量只是存储原始变量的“信息”。

使用对象的优势：1）对象是整合变量，使代码更有意义；2）更容易组织代码和理解代码；3）维护代码变得更容易；4）另外就是 `Java` 的运行依赖对象。



对象和类是两个不同的术语，虽然有些时候可以指代相同事物但两种具有不同的含义。类就像蓝图，定义了相应的结构即数据类型。对象是基于类创建的实际存在物体。

|          | 类                        | 对象                        |
| -------- | ------------------------- | --------------------------- |
| 是什么   | 类是一种数据类型          | 对象是一个变量类型          |
| 位置     | 可以具有独立的文件        | 分散到项目中的各个位置      |
| 使用原因 | 用于定义结构              | 用来实现一种逻辑            |
| 命名规范 | 双峰命名模式（CamelCase） | 单峰命名模式（camelCase）   |
| 示例     | County（类为国家）        | australia（命名特定的国家） |

以上中，对象和类之间的关系似 **变量** 和 **数据类型** 之间的关系——用 `Python` 的方式来看，可以看作实例化对象和对象之间的关系。

```java
// 下面的就是类
class Pokemon{
    // 字段，包括了 name，type，health
    String name;		// 需要注意 String 是一个类，而非原始类型，它是字符数组及其相应方法组成的类
    String type;
    int health;
    
    // 方法包括了 dodge，attack
    boolean dodge(){ 
    	return Math.random() > 0.5;
    }
    void attack(Pokemon enemy){
        if(!enemy.dodge()){
            enemy.health--;
        }
    }
}
```

在 `Java` 中一切皆是对象，包含的类只是将所有原始类型封装起来，并通过它们的方法提供额外的功能。下面是包括 `String` 类的其他类及其原始类型例子：

| 类          | 原始类型 |
| ----------- | -------- |
| `Integer`   | `int`    |
| `Long`      | `long`   |
| `Double`    | `double` |
| `Character` | `char`   |
| `String`    | `char[]` |

## 1.1 字段——`Field`

* 字段构成     对象的字段是构成对象的所有数据类型，也就是说其组成是有原始类型（例如整型、字符串等）以及对象构成。有时候使用 **属性** 或者 **成员变量** 来表示字段。

* 字段访问    访问字段可以使用 “.“ 进行访问，使用方式是 `object_name.field_name`。假设 `book` 对象具有如下字段：

  ```java
  String title;
  String author;
  int numberOfPages;
  ```

  如果需要访问其中的 `title` 字段，那么可以使用 `book.title` 方式来访问，当然也可以将字段赋值给其他变量 `String myBookTitle = book.title;` 。如果需要 **修改字段值**，可以使用 `book.numOfPages = 234;`。

## 1.2 方法——`Method`

方法是属于特定对象的函数，它可以使用或者修改数据。它的调用和创建，与函数相似。

* 调用方法		指使用方法，其调用方法和函数相同，但是需要使用 “.“。假设 `book` 对象中有 `setBookmark` 方法

  ```java
  void setBookmark(int pageNum);
  ```

  其调用的方法为 `book.setBookmark(12);`。

## 1.3 主方法——`Main` 

`Java` 程序可以