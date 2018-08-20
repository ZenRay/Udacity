**目录**

#### 

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

`Java` 程序可以小至一个类，但是通常一个程序有多个类组成。类可以相互调用其他类的方法，并更新字段使整个程序的逻辑组合到一起——因此程序需要进行恰当的逻辑组合和拆分。

但在如果需要调用方法，需要使用 `main` 方法来表示源头，其结构如下：

```java
public static void main(String [] args){
    // start program here
}
```

对上面的结构进行分析：

* `public` 表示在 `Java` 程序的任何位置度可以运行该方法，这里包括了可以 `private` 等用于申明可以调用的方式
* `static` 表示它不需要对象就能运行，因此计算机创建任何对象之前，会先从该方法开始。这里指出了是一个静态方法
* `void` 表示主方法不返回任何内容，只是在程序启动时就运行，运行完毕后程序终止，且没有返回任何方法
* `main` 该方法的名称
* `String [] args` 输入的参数。这里是一个字符串数组

`main` 方法表明了程序的起点，且该方法有且只能在程序中存在一个。它可以属于任何类，或者可以为该方法创建一个特定的类——这是最常见的使用方式。此外需要注意 `Java` 项目是包含若干个扩展名是 `.java` 文件的文件夹。

## 1.4 实践 `Java`

### 1.4.1 创建文件

1. 课程中使用 [Intellij 创建类](https://classroom.udacity.com/courses/ud283/lessons/008b74dd-d786-4d22-84e6-ace8ae102ba4/concepts/76b7b372-fcd2-4f73-9c48-7876b1fed029) ，1）运行 `IntelliJ`  创建新项目（`Create New Project`）；2）选择项目 `SDK` ，可以选择合适的 `Java JDK` 安装；3）定义文件名和文件位置；4）需要在 `src` 下创建 `Main` 类文件。

2. 在 `Main` 类文件中添加主方法，即在文件中输入相应的代码后，可以在 `IDE` 右上角点击运行按钮。如果不能正常运行，需要点击 `Edit Configurations` 进行配置，选择 `Application` 添加 `Main` 类文件到 `Main class` 选项中，确认后即配置完成

3. 创建第一个 `main` 方法：

   ```java
   public class Main {
       public static void main(String [] args){
           System.out.println("hello world!");
       }
   }
   ```

### 1.4.2 构造方法——`Constructors`

构造方法（**Constructors**） 它是一种特殊的方法，负责为该类创建和初始化对象

* 创建构造方法

  它和创建方法很相似，但是也有不同的地方：1）构造方法没有任何返回类型；2）构造方法的名称和类本身的名称一样

  但是它们可以像普通方法一样接受输入参数，并且可以创建多个构造方法并具有多个不同的输入参数。下面以 `Game` 的简单构造方法示例：

  ```java
  class Game{
      ...
      // Constructor
      Game(){
          // Initialization code goes here
      }
  }
  ```

* 默认构造方法

  默认构造方法根本没有任何输入参数，它是可选的。即说明如果没有创建默认构造方法， `Java` 将自动认为默认地已经有一个实际上不执行任何操作的默认构造方法。但如果类具有初始化然后才能使用的对象的字段，那么需要创建一个进行初始化的构造方法。

* 参数化构造方法

  当然构造方法可以接受输入参数，例如某些游戏开始时分数为正，即需要另外创建一个构造方法，该构造方法会接受整数型参数作为输入，并使用该参数初始化分数变量

  ```java
  class Game{
      int score;
      // Default constructor 默认构造方法
      Game(){
          score = 0;
      }
      // counstructer by starting score value 具有参数的构造方法
      Game(int startingScore){
          score = startingScore;
      }
  }
  ```

### 1.4.3 构造方法访问

与普通方法不同，不能使用 “.” 修饰符来调用构造方法。每次创建类类型的对象变量时，都会调用相应的构造方法。下面将说明调用方式：

* `new` 关键字

  创建特定类的对象，需要使用 `new` 关键字，紧跟其后时需要使用的构造方法。

  ```java
  // 使用默认构造方法创建一个 teris 的对象——这里初始化的分数值为 0
  Game tetris = new Game();
  
  // 创建一个使用其他初始分数初始化的游戏对象，这里使用参数化构造方法
  Game darts = new Game(50);
  ```

* `null` 关键字

  如果使用空对象（即未初始化对象），可以使用 `null` 来初始化对象。`null` 对象没有字段和方法，这种方法的作用，是表示该对象无效或者尚需设置

  ```java
  Game darts = null;
  ```

构造方法的多样性作用，是因为良好的习惯是始终包含一个默认构造方法，默认构造方法会将所有字段初始化为相应的典型值。 然后，可以添加额外的参数化构造方法，这样在处理不太常见的情形时，可以有更多的自定义余地。

正如之前提到的，可以不创建任何构造方法！类依然有效，依然能够使用相同的默认构造方法语法创建对象。就像创建了一个空的默认构造方法。

但是，当你创建了任何自己的构造方法后，就没有这种选择性了！这意味着，如果你创建了参数化构造方法，并且想要一个默认构造方法，则需要自己创建该构造方法。

### 1.4.4 自引用——`this` 使用

当需要对某个对象的方法或构造函数中引用该方法，可以使用 `this` 关键字。作用是表示当前对象的方法或者构造方法正在被调用，可以使用 `this` 在方法或构造函数中引用当前对象的字段。

* 字段引用

  使用关键字 `this` 常见的原因是字段名称，在方法或构造函数中参数的名称相同。下面的例子是用两种不同的方法来说明 `this` 的字段引用

  ```java
  // 方法一，直接使用变量名，未使用 this
  class Position {
     int row = 0;
     int column = 0;
  
      //constructor
     Position(int r, int c) {
        row = r;
        column = c;
     }
  }
  
  // 方法二，使用 this 来说明字段引用
  class Position {
     int row = 0;
     int column = 0;
  
      //constructor
     Position(int row, int column) {
        this.row = row;
        this.column = column;
     }
  }
  ```

  在第二段代码中，构造函数 `Position` 接收了参数 `row` 和 `column`，但是类 Position 也具有名称完全相同的两个字段。

  使用 `this.row` 而不是 `row` 表明我们现在引用的是名称为 `row` 的**字段**，而不是输入参数。

* 构造方法引用

  在相同的类中，可以使用 `this` 来调用其他构造方法，这种方式是显性构造方法引用。下面的示例中，类包括了多个构造方法，每个构造方法都初始化了部分或全部 `rectangle` 的成员变量，这样构造方法为成员变量提供了默认值，如果成员变量不是有参数提供了值。

  ```java
  
  public class Rectangle {
      private int x, y;
      private int width, height;
  // 这里是无参数的构造方法，创建了一个 1 x 1 且在0，0 位置上的长方形        
      public Rectangle() {
          this(0, 0, 1, 1);
      }
  // 这里是传入了 width 和 height 参数，且位置是在 0，0
      public Rectangle(int width, int height) {
          this(0, 0, width, height);
      }
      public Rectangle(int x, int y, int width, int height) {
          this.x = x;
          this.y = y;
          this.width = width;
          this.height = height;
      }
      ...
  }
  ```

  下面是练习中的示例：

  ```java
  class Contact{
     String name;
     String email;
     String phoneNumber;
  }
  // 创建一个默认构造函数，用于初始化这些字段
  class ContactsManager {
     // Fields:
     Contact [] myFriends;
     int friendsCount;
     // Constructor:
     ContactsManager(){
        this.friendsCount = 0;
        this.myFriends = new Contact[500];
     }
     // Methods:
     // 添加联系人 addContact 会接收 Contact 对象作为输入参数，并使用 friendsCount 值向数组中的该位置填充传入该方法的联系人
     void addContact(Contact contact){
        myFriends[friendsCount] = contact;
        friendsCount++;
     }
  
     Contact searchContact(String searchName){
        for(int i=0; i<friendsCount; i++){
           if(myFriends[i].name.equals(searchName)){
              return myFriends[i];
           }
        }
        return null;
     }
  }
  // 需要 main 方法，因此创建另一个叫做 Main 的类，用于存储该方法。这意味着一旦该程序运行了，主方法将启动，并创建 ContactManager 对象 myContactManager，从而能够被使用
  class Main {
     public static void main(String [] args){
        ContactManager myContactManager = new ContactManager();
     }
  }
  ```

  

### 1.4.5 访问修饰符

访问修饰符的方法可以用于避免程序错误。其中包括可以使用 `public` 和 `private` 修饰符：

1. `public` 修饰符：表示其他类也可以使用该字段或者该方法
2. `private` 修饰符：表示隐藏字段或者方法于该程序内

以上两种方法，表示了使用权限。

```java
public int score;	// 表示该字段是 public
private String password;	// 表示该字段为 private

public class Book{
    private String title;
    private String author;
    public boolean isBorrowed;
    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }
}
```

上面的类 Book 表示书籍作者和标题不可私有的，不可以变化，但是是否外借的状态可以为变化的值。但是实际上还是存在风险，如果需要检查是否为 true 或者 false 的状态时，出现将结果更改为 true 的错误！通过将该字段设置为 `private`，然后创建并返回此类隐藏字段的  `public` 方法，以及提供设置和更改其值的 `public` 方法。下面的方法，将 `isBorrowed` 字段设为 `private` 将阻止在代码的某个位置不小心更改其值，因为现在更改它的唯一方法是调用 `borrowBook()` 或 `returnBook()`，这样会明显的多。为了能够读取 `isBorrowed` 的值，创建一个叫做 `isBookBorrowed()` 的 getter 方法，该方法是 `public` 并返回 `isBorrowed` 的值

```java
public class Book{
   private String title;
   private String author;
   private boolean isBorrowed;
   public Book(String title, String author){
      this.title = title;
      this.author = author;
   }
   public void borrowBook(){
      isBorrowed = true;
   }
   public void returnBook(){
      isBorrowed = false;
   }
   public boolean isBookBorrowed(){
      return isBorrowed;
   }
}
```

方法中使用 `private` 和 `public` ，`private` 方法通常称之为 **helper 方法**，因为它们只能被相同的类看到和调用，它们通常是为了帮助整理代码并使代码看起来更简单易读。`public` 方法是类可以执行的实际操作，基本上是程序的剩余部分能够看到和调用的方法。

下面的例子中，类 Person 将它的两个字段都设成了 `private`，因为如果是 `public`，那么任何其他类都将能够更改此类敏感信息。将它们设为 `private` 意味着只有该类里面的方法和构造函数能够更改它！方法 `getId()` 也被设成了 `private`，这样其他类都不知道此人的社会保障号码。

但是，当我们在 `isSamePerson(Person p)` 方法中将此人与其他 person 对象对比时，依然能在内部使用该方法。这意味着任何其他类只能调用 `getUserName` 或 `isSamePerson`，看起来似乎类 Person 仅提供了这两个方法。

```java
class Person{
   private String userName;
   private String SSN;
   private String getId(){
      return SSN + "-" + userName;
   }
   public String getUserName(){
      return userName;
   }
   public boolean isSamePerson(Person p){
      if(p.getId().equals(this.getId()){
         return true;
      }
      else{
         return false;
      } 
   }
}
```

总结及其他建议：

- 始终尝试将所有字段声明为 **private**
- 创建一个将这些 `private` 字段当做输入的构造函数
- 创建一个***设置***每个 `private` 字段的 `public` 方法，这样你就知道何时更改了字段。这些方法叫做 **setter**
- 创建一个***返回***每个 `private` 字段的 `public` 方法，这样你就能够读取该字段，而不会不小心更改了它。这些方法叫做 **getter**
- 将所有类设为 **public**
- 将所有字段设为 **private**
- 将所有当做操作的方法设为 **public**
- 将所有当做辅助方法的方法设为 **private**