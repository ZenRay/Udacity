**目录**

[TOC]

课程是 `Udacity` 中 `Java OOP(ud283)` 的课程，课程的主题涉及到 `Java` 的高级知识：

* 面向对象编程，`Java` 的对象，含义及其使用方法
* 与用户互动（**User Interaction**），如何通过文本文件和用户输入建立与用户互动的程序
* `OOP` 概念，例如继承及其实际使用
* 存储一组对象的集合（**Collection**）

# 1. `OOP` 基础

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

## 1.5. 用户交互

### 1.5.1常用交互

交互的一个方面是需要用户输入信息，在 Java 中用户的输入需要使用 `Scanner` 类来完成。首先它需要在文件顶部调用 `import java.util.Scanner;` 语句——表示调用 `java.util` 库中的 `Scanner` 类。`Scanner` 允许程序读取来自特定输入的任何数据类型，需要先创建 scanner 对象，之后将 scanner 读取系统的输入。在该 scanner 对象中调用方法 `nextLine()` 将返回一个 String，其中包含用户在按下"enter”前输入的所有内容。例子如下

```python
import java.util.Scanner;

System.out.println("Enter your address");
// 实例化 Scanner
Scanner scanner = new Scanner(System.in);
String address = scanner.nexLine();		// 这里的申明变量类型，说明了 address 的数据类型；同时使用 scanner 不同方法来表示输入内容

System.out.println("You live at:" + address);

int grade = scanner.nextInt();		// 申明为整数型数据

if(grade > 90){
    System.out.println("wow! you did well!");
}else{
    System.out.println("Not bad, but you can do better next time!");
}
```

上面的方法是在终端输入数据，而 Java 可以通过文件的方式来交互——这类文件可能是纯文本编辑器、Excel 表格等。需要注意的是，`Scanner` 类传入的参数不是 System.in，而是 File 对象

```java
import java.io.File;
import java.utile.Scanner;

File file = new File("expenses.txt");
Scanner filescanner = new Scanner(file);

while (scanner.hasNextLine()){
    String scanner = scanner.nexLine();
}
```

### 1.5.2 错误和异常

常见的异常包括了 `Syntax Errors`， `RuntimeErrors`，`Bugs(Logic Errors)`:

1. `Syntax Erros`：包括是否符合语法；以及代码是否可以编译
2. `Runtime Errors`：程序崩溃；通常发生在程序运行中
3. `Bugs(Logic Erros)`：程序不符合预期结果

对于异常来说，可以通过 `throws` 语句来控制异常传递；另外可以使用 `try` 语句来控制和捕获异常

```java
voind main(String [] args) throws Exception {
    openFile();
}

// 下面是第二种方法
void openFile() throws Exception {
    File file = new File("somefile.txt");
}

try{
    openFIle ("somefile.txt");
} catch (FileNotFoundException e) {
    // handle the exception
    // or re-throw it
    System.out.println("File missing!");
    
    throw e;	// 这样抛出了异常
}

// 下面的语句可以捕获所有异常
try{
   openFile("somefile.txt");
   array[index]++;
} catch(Exception exception) {
   // Handle all the possible exceptions here
} 

// 下面使用多个捕获语句，这样可以进行不同的处理
try{
   openFile("somefile.txt");
   array[index]++;
} catch(FileNotFoundException exception) {
   // Handle all the possible file-not-found-related issues here
} catch(IndexOutOfBoundsException exception) {
   // Handle all the possible index-out-of-bounds-related issues here
} 
```

# 2. 继承

`OOP` 的核心以简单易懂的方式设计代码，同时更具有扩展性和更多特性。主要的特性：封装、多态性（`Polymorhism`)、继承(`Inheritance`)。其中继承能够让代码保持一致性和条理性。继承是通过将类扩展到其他类，并且构建在其上。

* 继承 继承能够将基本方法和属性传递给子类，这需要使用 `extends` 关键字

* 多态 因为对父类的属性和方法继承，使得子类具有了其特性。此外子类本身方法的差异，而导致子类具有更多特性。使用方面，当声明子类变量时，可以使用父类的数据类型。但是要使用父类的实例对象时，需要通过申明父类类型方式来转型该变量，然后才能将其赋给子类的数据类型。下面是 Java 的类具有更多灵活性示例：

  ```java
  class Parent {
      // 这个是一个父类    
  }
  
  class Child1 extends Parent {
      // 这个是一个子类 1
  }
  
  class Child2 extends Parent {
      // 这个是一个子类 2
  }
  
  public class Method {
      // method
      // 其中属性传入进去的是一个 Parent 类对象作为参数
      boolean canAdd (Parent parent) {
          if(...){
              return false;
          } else {
              return true;
          }
      }
      
  }
  
  /* 
  * 在调用方面，可以直接使用 new 将子类实例化的同时申明新对象为该类；另外可以直接使用父类，
  * 而使用 new 来实例化子类。这在方法调用中非常有用，节省了因为多个子类中属性调用而出现差异
  */
  
  Child1 newChild1 = new Child1();
  Child2 newChild2 = new Child2();
  
  // 下面方法的意义同上
  Parent newChild1 = new Child1();
  Parent newChild2 = new Child2();
  
  // 最重要的作用是在使用 Method 时，传入的对象变量可以灵活使用
  Parent newChild1 = new Child1();
  method.canAdd(newChild1);		// 这里忽略了 Method 类的实例化
  ```

## 2.1 方法覆盖

当类扩展来自另一个类时，在父类中声明的所有 `public` 方法都将自动包含在子类中，而不需要任何操作。但是当在子类中重新申明父类中的 `public` 方法，重新定义它们的操作方式可以达到覆盖父类方法的目的。下面的示例中使用了覆盖的方式：

```java
// 这个是一个父类
class Piece{
   boolean isValidMove(Position newPosition){
      if(position.row>0 && position.column>0 
         && position.row<8 && position.column<8){
         return true;
      }
      else{
         return false;
      }
   }
}

// Rook 覆盖了父类中的方法，自定义了相关方法 isValidaMove
class Rook extends Piece{
   boolean isValidMove(Position newPosition){
      if(newPosition.column == this.position.column || newPosition.row == this.position.row){
         return true;
      }
      else{
         return false;
      }
   }
}

// 下面是 Bishop 的类，它也重新定义了 isValidMove 方法
```

### 2.1.1 阻止覆盖——`final`

能够覆盖任何方法可能比较危险。例如某人创建了一个具有特定方法的类，他们就认为该方法按照特定方式执行。

因此，如果想防止某些方法在子类中被覆盖，可以在方法声明前面加上前缀 `final` 关键字。`final` 方法依然能被子类访问（如果权限允许的话），但是不能被覆盖，因此可以保证任何 final 方法的行为将和父类的实现完全一样。具体的示例如下：

```Java
public class Room{
   private double width;
   private double height;
   public Room(double width, double height){
      this.width = width;
      this.height =height;
   }
   public final double getArea(){
      return width*height;
   }
}
```

现在如果另一个类扩展了 `Room`，无论是什么类型的房间，都不应该覆盖方法 `getArea`，因为面积的计算方式应该始终不变：

```Java
public class LivingRoom extends Room{
   // The constructor simply calls the parent's constructor using super()
   public LivingRoom(double width, double height){
        super(width,height);
    }
   // Not allowed to override getArea() here
}
```

但是因为该方法是 public 方法，因此子类也能访问它：

```Java
LivingRoom myLivingRoom = new LivingRoom(5,3);
double area = myLivingRoom.getArea();
System.out.println(area);

// 代码将能正常运行，输出将为预期的 15.0！
```

但是需要注意⚠️，在字段中使用 `final` 具有不一样的意义。`final` 关键字还可以用来描述字段。但是，和方法不一样，final 字段与继承毫无关系！`final` 字段就是一个常量！换句话说，变量只设置一次，再也不能改变！

`final` 字段的典型示例包括定义数学常量，例如 **PI**：

```Java
public class MathLib{
   public final double PI = 3.14;
}
```

这表示虽然字段是 `public` 字段，但是你不能在任何地方（该类里面或外面）更改 PI 的值。

```Java
public static void main(String [] args){
   MathLib mathlib = new MathLib();
   mathlib.PI = 0; // This is not allowed and will show a compiler error!
}
```

## 2.2 父类方法的重调用—— `super` 

在子类中使用方法覆盖后，不一定就是想抛弃父类的方法。如果需要在子类中重复调用父类方法，那么就需要使用 `super` 方法。使用该关键字可以可以在子类中，调用父类的该方法。例如上面的国际象棋中，如果在经过父类的检查之后已经返回 false，那么就不需要再进行检查了。另外还有一种方法，是在子类中的构造函数中使用 `super()` 以次来首先调用父类构造函数，并且可以在子类中添加更多的实现代码

```java
// 下面重新修改了 Rock 的方法，启用了父类的检查方法
class Rock extends Piece{
   boolean isValidMove(Position newPosition){
      // First call the parent's method to check for the board bounds
      if(!super.isValidMove(position)){
         return false;
      }
      // If we passed the first test then check for the specific rock movement
      if(newPosition.column == this.column && newPosition.row == this.row){
         return true;
      }
      else{
         return false;
      }
   }
}

// 第二种方法是使用 super()
class Rock extends Piece{
   // default constructor
   public Rock(){
      super(); // this will call the parent's constructor
      this.name = "rock";
   }
}
```

**⚠️注意：**如果子类的构造函数没有使用关键字 super 明确调用父类的构造函数，Java 编译器将自动插入对父类的默认构造函数的调用。如果父类没有默认构造函数，则会出现编译错误。

## 2.3 多父类继承解决——接口

在很多情况下，扩展类都非常有帮助：

1. 扩展某个类的功能，不用对其作出任何更改。
2. 在该类的各个版本之间共用一些相同的代码。
3. 利用多态性将不同的类当做相同的类来处理。

但是，Java 存在一个重要的限制条件：类不能扩展多个类（即在 Java 中不允许出现多个继承）。因为如果父类有相似的方法，多个继承可能导致模棱两可的现象。如果你想深入了解这类情况，请参阅著名的[钻石问题](https://en.wikipedia.org/wiki/Multiple_inheritance#The_diamond_problem)示例。

Java 对多个继承问题的解决方案是**接口**——一个类可以被多个子类当作父类，但是一个子类不能继承多个父类。接口的重要作用在于定义了需要做什么，而不是怎么去做——即接口罗列了类中需要包含的方法，但不会包括代码去具体实现，而且接口不能直接实例化为对象。接口的目的就是被一个或者多个类执行。下图表示了两个接口对应了两个类——Vehicle 和 House：

![image-20180830005019568](https://ws2.sinaimg.cn/large/0069RVTdgy1fur20dond8j314j0myn5q.jpg)

下面的图，表示了使用两个接口来构建 Caravan 类：

![image-20180830005143049](https://ws4.sinaimg.cn/large/0069RVTdgy1fur21s97hvj314v0m3afz.jpg)

代码实现方式如下：

```java
public interface Movable {
    void move(int distance);
    boolean canMove();
}

public interface Habitable {
    boolean canFit(int inhabitants);
}

// 下面是调用上面两个接口
public class Caravan implements Habitable, Movable {
    void move(int distance) {
        location = location + distance;
    }
    boolean canFit(int inhabitants) {
        return max <= inhabitants;
    }
}
```

### 2.3.1 `comparable` 接口

[Comparable 接口](https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html) 是一个非常热门的 Java 接口。

该接口包含一个方法定义，叫做 `compareTo`，获取一个对象作为同一类型的输入参数，并比较这两个对象（"this”对象与输入参数对象）。该接口的主要目的是让任何类都有机会定义如何对比该类的两个对象。当进行排序或搜索该类型的对象时，这一接口非常实用。

例如有一个表示图书的类：

```Java
public class Book{
   int numberOfPages;
   String title;
   String author;
}
```

需要实现 Comparable 接口，以便根据以下条件对图书排序：

1. 如果一本图书的页数比其他图书的多，那么具有更多页数的图书排在前面。
2. 如果两本图书具有相同的页数，则按照书名字母顺序排序。
3. 如果两本图书具有相同的页数和相同的书名，则按照作者的字母顺序排序。

在开始编写代码之前，看看 compareTo 方法的工作原理—— `compareTo` 方法获取一个输入参数（即“指定对象”），然后该方法将“指定对象”与"this”对象进行比较。

根据官方文档的定义，在比较 2 个对象时，有 3 种可能的结果：

1. "This”对象被视为**小于**“指定对象”
2. "This”对象被视为**等于**“指定对象”
3. "This”对象被视为**大于**“指定对象”

对于每种情形，`compareTo` 方法应该返回：

1. 负整数（任何小于 0 的数字）
2. 零 (0)
3. 正整数（任何大于 0 的数字）

了解所有定义后，演示代码：

```Java
public class Book implements Comparable<Book>{
   public int compareTo(Book specifiedBook) {
      // First check if they have different page counts
      if(this.numberOfPages != specifiedBook.numberOfPages){
         // this will return a negative value if this < specified but will return a positive value if this > specified
         return this.numberOfPages - specifiedBook.numberOfPages;
      }
      // If page counts are identical then check if the titles are different
      if(!this.title.equals(specifiedBook.title){
         return this.title.compareTo(specifiedBook.title);
      }
      // If page titles are also identical then return the comparison of the authors
      return this.author.compareTo(specifiedBook.author);
    }
}
```

## 2.4 共享—— `static`

`static` 一般用于防止对象中字段因为域空间被回收，而导致相应的字段被销毁。当使用了该字段时也就“模拟”了共享该字段的方式，即使对象被销毁而该字段也不会被销毁。此外需要注意⚠️该字段可以被更新，而且引用了该字段的对象中相应的值也会更新。

```java
public class Person {
    public int count;
    
    public Person() {
        count ++;
    }
}

public class Main{
    public static void main(String [] args) {
        for (int i=0; i<100; i++){
            Person person = new person();
            System.out.println(person.count);
        }
    }
}

// 以上的代码并不会让 count 累计计数，因为每次循环都将对 person 实例化，而原 person 都将被销毁。需要进行相应的修改，使用 static 关键字

public class Person {
    public static int count;
    
    public Person() {
        count ++;
    }
}

public class Main{
    public static void main(String [] args) {
        for (int i=0; i<100; i++){
            Person person = new person();
            System.out.println(person.count);
        }
    }
}
```



关键字 `static` 也可以用来描述方法，表示能够从类中调用方法，而不是先创建一个对象，然后才能调用该方法。但是，`Static` 方法具有限制条件，因为它不能再访问对象中的非静态字段。

对将字段或方法声明 `Static` 时机：在大多数情况下，如果希望变量和方法属于某个对象，而不是整个类，因此在大多数情况下，不需要声明为 `Static`。但是，如果要创建一个提供某种功能的类，而不是拥有自己的状态，那么就非常适合将其大部分方法和字段声明为 `Static`。

例如，用来生成随机数字的 `Math` 类吗？该 `Math` 类是具有 `random()` 等大量 static 方法的类。因为没必要创建一个对象，叫做 `math1`，再创建一个对象，叫做 `math2`，所有 `Math` 都一样，因此我们可以直接使用该类本身来调用其方法，因此这时候就适合使用 static。

### 2.4.1 `static` 方法

和 `static` 字段一样，`static` 方法也属于类，而不属于对象。它最适合创建一个不需要访问对象中的任何字段的方法，换句话说，这种方法是独立函数。`static` 方法会接收输入参数，并仅根据这些输入值返回一个结果。不需要任何字段值使方法很容易附加到类定义中，而不是单个对象，因为它不关心任何字段的值。但是，static 方法依然能够访问 static 字段，因为 static 字段也属于类，在该类的所有对象之间共享。

以下是一个包含一些 `static` 方法的 `Calculator` 实现：

```Java
public class Calculator {

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

}
```

因为 `add` 和 `subtract` 都不需要特定于对象的值，它们可以如上所示地声明为 static，因此你可以使用类名称 `Calculator` 直接调用它们，根本不需要创建一个对象变量：

```Java
Calculator.add(5,10);
```

# 3. 集合

常用的数据结构为数组，数组在初始化时需要申明其具体个数，且之后不能进行变更，此外当数据出现变化时需要对数组重新调整。集合可以用于避免数组的缺陷，它提供了一个使用不同的类和接口来简化处理多个同类项的方式。例如 `ArrayList` 就是一个不用申明需要的数据项数量的集合——`ArrayList names = new ArrayList();` 这样就定义了一个变量名为 name 的 `ArrayList`，其还有具有一定的方法，例如 add。

## 3.1 List

Java 中的 `List` 是一个行为和数组非常相似的接口

- 它是一个有序集合（也称为序列）。
- 该接口的用户能够完全控制每个条目应该插到列表的哪个位置。
- 用户能够通过整数索引（列表中的位置）访问条目。
- 用户能够通过循环访问列表中的条目来搜索条目。

实际上，实现 `List` 接口的最常见类在内部使用了数组形式，叫做 `ArrayList`。`ArrayList` 是一个实现接口 `List` 的类。它是一个数组封装器，但是提供了非常强大的功能，使数组处理起来简单很多。`ArrayList` 类会在每次空间不足时，自动重新调整内部数组的大小，一切都是在后台发生的，不需要实现这些代码。ArrayList 的某些方法：

- **add(E element)：**将指定元素附加到该列表的末尾
- **add(int index, E element)：**将指定元素附加到该列表的指定索引处
- **get(int index)：**返回位于该列表中指定位置的元素
- **contains(Object o)：**如果该列表包含指定元素，则返回 true
- **remove(int index)：**删除该列表中指定位置的元素
- **size()：**返回该列表中的元素数量
- **clear()**: 删除整个列表

要了解完整的方法列表，请参阅[文档](https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html)。如果需要对列表元素进行访问，那么可以使用简单方式。for 语句中包含两部分，声明项目变量，后面是冒号`:`，然后是 ArrayList 变量（或任何集合类型）：

```java
// iterate via "New way to loop"
for (String item : list) {
   System.out.println(item);
}
```

还有一种循环访问集合的方式，但是更高级，只能在上述两种循环用起来太慢的特定情形下使用，例如 LinkedList，访问此[文档](https://www.tutorialspoint.com/java/java_using_iterator.htm)。

## 3.2 栈

栈集合代表的是后进先出 (LIFO, Last In First Out) 栈对象。意味着最后添加 (push) 的条目是先从栈中删除 (pop) 的条目。就像一堆碟子一样：最后放上去的碟子始终是第一个拿走的碟子。Stack 类包括以下 5 个方法：

- **push(E item)：**将条目添加到该栈的顶部。
- **pop()：**删除栈顶部的对象，并返回该对象。
- **peek()：**返回顶部的对象，但是不从栈中删除它。
- **empty()：**检查栈是否为空。
- **search(Object o)：**搜索栈中的对象，并返回其位置。

和 ArrayList 一样，Stack 也在内部使用数组来按顺序存储一切条目。适合使用栈的示例包括在开发电子邮件系统时：邮箱服务器收到新的电子邮件时，它应该将该邮件添加到邮件栈的顶部，这样用户就能查看最新的邮件！

以下是如何使用堆栈的简单示例：

```Java
Stack newsFeed = new Stack();
newsFeed.push("Morning news");
newsFeed.push("Afternoon news");
newsFeed.push("Evening news");
String breakingNews = (String) newsFeed.pop();
System.out.println(breakingNews);
```

注意⚠️为何要使用`(String)` 对 `pop()` 和 `peek()` 的返回类型进行转型？这是因为，这些方法实际上返回的是类型 `Object`，不是 `String`，因为它不负责插入的是什么，类型是什么！

## 3.3 队列

和栈不同，它是先进先出 (FIFO, First In Frist Out) 数据类型，第一个添加到队列中的元素是第一个被访问或删除的元素。Queue 只是一个接口，本身不是类，但是它为实现 Queue 接口的所有类定义了 2 个重要方法。

- **add(E element)：**将指定元素插入队列中
- **poll()：**检索并删除队列的头

有一种特殊的 Queue 类型，叫做 `Deque`，它是一种有两端的队列，表示你可以从 `Deque` 的任何一端（前端或末端）添加或删除元素。

除了上述两个队列方法之外，Deque 还提供了以下方法：

- **addFirst(E element)：**在此双队列的前端插入指定元素
- **addLast(E element)：**在此双队列的末端插入指定元素
- **pollFirst()：**检索并删除此队列的第一个元素
- **pollLast()：**检索并删除此队列的最后一个元素

Java 还提供了实现 Queue 接口的几个类，其中最热门的是 `LinkedList`

以下是如何创建和使用 LinkedList 对象的示例：

```Java
Queue orders = new LinkedList();
orders.add("Order1");
orders.add("Order2");
orders.add("Order3");
System.out.print(orders.poll());
System.out.print(orders.poll());
System.out.print(orders.poll());
```

## 3.4 泛型

简而言之，泛型使类能够在定义参数时接受它们，很像在方法声明中使用的参数。

为类定义类型参数使你能够重复利用相同的代码，并获得不同的输入。区别在于正式参数的输入是值，类型参数的输入是类型。

### 3.4.1 集合中的泛型

例如，ArrayLists 使用泛型使你能够指定要添加到该 ArrayList 中的元素的数据类型。

实现方式是在声明 ArrayList 变量时，在 `<>` 之间定义该数据类型：

```Java
ArrayList<String> listOfStrings = new ArrayList();
```

这就明确表示你想要创建字符串 ArrayList，因此编译器只允许向该 ArrayList 插入字符串，如果你插入其他类型的数据，将显示错误。

### 3.4.2 泛型不需要转型

还记得之前在使用堆栈等集合时，我们需要对 pop() 方法的返回值进行转型吗？

因为有了泛型，现在在声明堆栈、队列或任何集合时，可以指定数据类型了，因此不用对任何返回类型进行转型：

以下没有使用泛型的代码段需要转型：

```Java
List list = new ArrayList();
list.add("hello");
String s = (String) list.get(0);
```

在使用泛型重新编写是，代码不需要转型：

```Java
List<String> list = new ArrayList<String>();
list.add("hello");
String s = list.get(0);   // no cast
```

### 3.4.3 定义自己的泛型类型

最后，在定义类时，可以通过声明泛型参数来创建你自己的泛型类型。这节课将不介绍这方面的知识了，但是如果你想深入了解如何定义，请参阅[此处](https://docs.oracle.com/javase/tutorial/java/generics/types.html)的文档。

## 3.5 哈希表

了解 Java 中不同数据结构的原理将使你能够成为一名优秀的软件开发工程师。针对变量或集合使用正确的数据结构很重要的原因是**性能**。一个程序可以按照多种方式来实现，但是只有某些方式会顺利运行，并且速度够快，让用户愿意继续使用该程序。

例如：我们已经知道如何在字符串 ArrayList 中搜索特定的字符串，我们需要使用一个循环将该字符串与列表中的所有其他字符串进行对比*（即使使用 indexOf 方法，它在内部依然会使用循环来搜索你的条目）*。

当你在计算机上尝试时，可能觉得运行时间不长，但是如果该 ArrayList 包含数百万个条目（顺便提醒下，在 Java 中这是很常见的列表大小），那么寻找你要搜索的条目则需要很长的时间。

如果某个操作需要 10 秒以上才能完成，用户通常就会认为程序“不响应”！意味着如果搜索操作需要这么长的时间，就没有人会使用你的程序！

哈希表是在 Java 中引入的另一种集合类型，旨在加快 ArrayList 的搜索速度。从某种程度上来说，它只是另一种条目集合（String、Integer 或任何其他对象），但是它存储这些条目的方式很独特。哈希表允许你存储要添加的每个条目的键。该键对整个列表来说都必须是唯一的，很像普通的数组的索引，但是该键可以是任何类型的任何对象！目的在于能够在该集合中立即找到某个条目（无需循环访问列表中的所有条目），因此节省了宝贵的运行时时间。假设有一个叫做 `Book` 的类，其中包含了关于此类图书的所有详情：

```Java
public class Book{
   String title;
   String author;
   int numOfPages;
   int publishedYear;
   int edition;
   String ISBN;
}
```

如果你要创建一个 Library 类并模拟包含世界上存在的所有图书的书库（大约 1.3 亿），你可以轻松地创建一个 Books ArrayList，并填充所有的图书详情。

```Java
public class Library{
   ArrayList<Book> allBooks;
}
```

现在，要按照 ISBN（字符串）搜索图书，你需要创建一个循环来将要查找的图书的 ISBN 与每个图书的 ISBN 进行对比：

```Java
Book findBookByISBN(String isbn){
   for(Book book : library.allBooks){
      if(book.ISBN.equals(isbn)){
         return book;
      }
   }
}
```

一个更加优化的方案是使用哈希表，而不是 ArrayList。要使用哈希表，你需要在 Java 文件的顶部导入 HashMap：

```Java
import java.util.HashMap;
```

按照以下方式声明哈希表：

```Java
public class Library{
   HashMap<String, Book> allBooks;
}
```

以上声明表示我们要创建一个 `Book` 集合，键是 `String` 类型。要初始化该哈希表，使用默认的构造函数，如下所示：

```Java
allBooks = new HashMap<String, Book>();
```

然后，要将条目添加到哈希表中：

```Java
Book taleOfTwoCities = new Book();
allBooks.put("9781539687399", taleOfTwoCities);
```

要使用 ISBN 搜索图书：

```Java
Book findBookByISBN(String isbn){
   Book book = allBooks.get(isbn);
   return book;
}
```

上述代码将使用字符串键 (ISBN) 在有大约 1.3 亿图书的整个集合中立即找到你要的图书，并形成性能高效很多的 Java 程序。



