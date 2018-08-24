**目录**

[TOC]

## 1 Java 基本语法规范

1. Java 是大小写敏感语言
2. 语句需要分号结尾
3. 变量使用前需要申明变量类型，同时在申明变量名称时，名称中间不能有空格

注意：在 Java 语法中，字符串可以和数值型数据进行加法运算，但是并不是真正的加法运算，而是通过对数值型数据进行了隐形转换。

## 2 Java 数据类型
* 数值性数据：Integer、Long 以及 Double。三者都可以使用正负号。在运算速度上，依次降低
* 字符型数据：String、Character(仅存储单个字符)。需要注意，双引号和单引号有不同的使用情况——双引号使用是对字符串数据类型时使用
* 逻辑型数据：Boolean

```{Java}
// Number
int maxInt = 2147483647;
long muchMore = 2147483647 * 10000000;

// string
String fullText = "(b) WWII ended 1945";
char anwser = 'b';

// Boolean
boolean fact = true;
```

## 3 Java 数据运算
在进行数据运算时，需要注意除法运算——有小数点的时候进行除法运算得到的结果才会有小数点，否则是整数数据。另外数据运算顺序符合一般规则

```{Java}
double div = 5 / 2; // output is 2
double accurate = 5 / 2.0; // output is 2.5
```
## 4 Java 数据类型转换
需要对数据类型转换，例如将 double 类型数据转换为 int（类似于取整），可以通过声明类型的方式来解决：

```
double current = 17;
double rate = 1.5;
double future = current * rate; // output is 25.5

int approx = (int) future; // output is 25
```

## 5 Java 控制流
* if 语句使用

    Java 的条件语句结构相同，只是语法结构上存在差异
    ```
    // 根据是否冷，判断输出语句。 isCold 为判断条件
    if(isCold){
        System.out.println("It's cold, wear a coat!");
    }
    ```
* else 语句使用

    ```{Java}
    boolean isLightGreen = false;

    if(isLightGreen){
        System.out.println("Drive");
    } else{
        System.out.println("stop");
    }
    ```

* else-if 语句使用

    ```{Java}
    boolean isLightGreen;
    boolean isLightYellow;

    if(isLightGreen){
        System.out.println("Drive");
    } else if(isLightYellow){
        System.out.println("Slow down");
    } else{
        System.out.println("Stop");
    }
    ```

* 条件控制中的 and 、 or 以及 not

    在使用多条件语句时，可以使用 `||` 表示 `or`，而用 `&&` 表示 `and`，同时可以使用 `!` 表示 `not`

* switch 语句使用

    switch 的作用时是判读变量，符合相应条件而进入相应的语句。需要注意在代码中 switch 只有一个括号；另外需要 break 来进行断句，以保证只执行了一个 case 的代码；默认 case 的设置，使用 default 关键字作为申明。具体示例如下：

    ```{Java}
    int passcode;
    String coffeeType;
    switch(passcode){
        case 555: coffeeType = "Espresso"; // 这里是 passcode 为555 时的赋值
            break;
        case 312: coffeeType = "Vanilla latte";
            break;
        case 629: coffeeType = "Drip coffee";
            break;
        default : coffeeType = "Unknown";
            break;
    }
    ```
    需要注意 case 和 default 语句的结构： `case|default (condition_value): do something;`，即需要对应的变量值或条件，之后需要一个冒号（":")

注意：Java 的变量作用域是根据大括号来确定的。例如下面的代码中，isLightGreen 和 carSpeed 的变量作用与是不同的：

```{Java}
// 下面的代码模块中，isLightGreen 相对来说是变量范围更大，而 carSpeed 就是局部变量——也就是说它的作用是在大括号内
boolean isLightGreen;

if(isLightGreen){
    double carSpeed = 100;
    System.out.println（"Drive!");
    System.out.println("Speed is:" + carSpeed);
}
```

## 6 Java 函数

Java 函数结构，函数头需要使用 `public` 或者 `private` 来声明；紧接之后是函数函数返回的数据类型，例如 `void` 为无返回值；之后是函数名，紧接着是形参以及大括号。

```{Java}
// 下面的代码中使用 public 声明函数，表示可以被调用，void 表示不需要返回数值，函数名为 chorus，并且没有形参
puplic void chorus() {
    System.out.println("The line is test");
}
```

关于函数数调用，和 Python 相同——即需函数名和形参，不同之处在需要添加分号。对于上述函数的调用：

```{Java}
chorus();
```

另外需要注意，形参需要类型声明，举例如下：

```{Java}
public void greeting(String location){
    System.out.println("hello, " + location);
}

// call function
greeting("world");
```

## 7 Java 注释
Java 有自己的代码注释规范，具体可以参考 [Java 文档注释 | 菜鸟教程](http://www.runoob.com/java/java-documentation.html) 和 [Oracle 的官方文档 How to Write Doc Comments for the Javadoc Tool](http://www.oracle.com/technetwork/java/javase/tech/index-137868.html)。主要的结构如下：

![](https://s3.cn-north-1.amazonaws.com.cn/u-img/3973cf52-6d5a-4bf2-b69d-556f5f9fbf37)

代码示例如下：

```
   /**
   * This method returns the square of num.
   * This is a multiline description. You can use
   * as many lines as you like.
   * @param num The value to be squared.
   * @return num squared.
   */
   
   public double square(double num) {
      return num * num;
   }
```
## 8 Java 循环
循环可用方法，while 的语法结构和 if 结构类似:

```{Java}
public int keepRolling() {
    int dice1 = rollDice();
    int dice2 = rollDice();
    int count = 1;

    while(!(dice1 == dice2)){
        dice1 = rollDice();
        dice2 = rollDice();
        count = count + 1;
    }
    return count;
}
```

使用 for 循环，

```{Java}
public void raiseAlarm(int numOfWarnings){
    for(int i = 1; i<= numOfWarnings; i++){
        System.out.println("Warning");
    }
}
```

注意，Java 中也可以使用 `break` 语句。
## Java 一些规范
1. Java 中一般是使用 lowerCamelCase 方式来进行变量命名，即首字母小写后面单词首字母大写。具体可以参考
[15条变量&方法命名的最佳实践](http://legendmohe.net/2014/04/15/%E8%AF%9115%E6%9D%A1%E5%8F%98%E9%87%8F%E6%96%B9%E6%B3%95%E5%91%BD%E5%90%8D%E7%9A%84%E6%9C%80%E4%BD%B3%E5%AE%9E%E8%B7%B5/) 以及 Google 推荐规范。

2. Java 关键字参考:[ oracle 的官方文档](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/_keywords.html) 以及 [菜鸟教程](http://www.runoob.com/java/java-basic-syntax.html)

3. Java 参考文档 [Java 8 文档](https://docs.oracle.com/javase/8/docs/api/java/lang/package-summary.html)