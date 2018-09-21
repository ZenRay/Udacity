**目录**

[TOC]

# 1. HTML 中 meta 标签作用[^1]

- **meta标签是什么**

  META标签是HTML语言HEAD区的一个辅助性标签

- **meta标签是干什么用的**

  META标签用来描述一个HTML网页文档的属性，例如作者、日期和时间、网页描述、关键词、页面刷新等。它提供的信息虽然用户不可见，但却是文档的最基本的元数据

- **元数据又是什么东西**

  元数据(Metadata)是用来概括描述数据的一些基本数据。也就是描述数据的数据。形象的来解释一下：

  > 你今天在下班途中邂逅了一个美女，然后回到家之后你就迫不及待的想跟你的朋友炫耀一下。但是你不能只说你邂逅了一个美女，你得描述具体点啊，不然谁信啊？所以你得通过年龄（三十岁上下）、身高（个子高挑）、相貌（身材匀称，黑黑的眉毛，红红的脸蛋）、性格（活跃）来描述。这样你的朋友就可以通过这些信息来意淫一下啦。OK. 废话不多说，到底什么是metadata呢？

  这个例子中的”年龄”、”身高”、”相貌”、”性格”，就是元数据，因为它们是用来描述具体数据/信息的数据/信息。
  当然，这几个元数据用来刻画个人状况还不够精确。我们每个人从小到大，都填过《个人情况登记表》之类的东西吧，其中包括姓名、性别、民族、政治面貌、一寸照片、学历、职称等等……这一套元数据才算比较完备。

  **那么对于网页也来说，metadata就是通过一些字段信息来描述一下当前网页，以便浏览器和搜索引擎在访问到此网页的时候，可以通过这些描述信息来知道如何去解析此网页数据。**

- **meta标签的使用**

  - meta标签共有两个属性：`http-equiv`和`name`;不同的属性又有不同的*参数值*，这些不同的*参数值*就实现了不同的网页功能。

    1. **name属性**

       name属性主要用于描述网页，与之对应的属性值为content，content中的内容主要是便于搜索引擎机器人查找信息和分类信息用的。
       meta标签的name属性语法格式是：＜meta name=”参数” content=”具体的参数值”＞ 。其中name属性主要有以下几种参数:

       * Keywords(关键字)

         说明：keywords用来告诉搜索引擎你网页的关键字是什么。

         举例：`＜meta name ="keywords" content="science, education,culture,politics,ecnomics，relationships, entertaiment, human"＞`

       * description(网站内容描述)

         说明：description用来告诉搜索引擎你的网站主要内容。

         举例：`＜meta name="description" content="This page is about the meaning of science, education,culture."＞`

       * author(作者)

         说明：标注网页的作者

         举例：`＜meta name="author" content"root,root@21cn.com"＞`

    2. **http-equiv属性**

       http-equiv顾名思义，相当于http协议中文件头的作用，它可以向浏览器传回一些有用的信息，以帮助正确和精确地显示网页内容，与之对应的属性值为content，content中的内容其实就是各个参数的变量值。
       meat标签的http-equiv属性语法格式是：＜meta http-equiv=”参数” content=”参数变量值”＞ ；其中http-equiv属性主要有以下几种参数：

       * content-Type(显示字符集的设定)

         说明：设定页面使用的字符集。

         用法：`＜meta http-equiv="content-Type" content="text/html; charset=gb2312"＞`

       * Expires(期限)

         说明：可以用于设定网页的到期时间。一旦网页过期，必须到服务器上重新传输。

         用法：`＜meta http-equiv="expires" content="Fri, 12 Jan 2001 18:18:18 GMT"＞`
         注意：必须使用GMT的时间格式。

       * Pragma(cache模式)

         说明：禁止浏览器从本地计算机的缓存中访问页面内容。

         用法：`＜meta http-equiv="Pragma" content="no-cache"＞`
         注意：这样设定，访问者将无法脱机浏览。

       * Refresh(刷新)

         说明：自动刷新并指向新页面。

         用法：`＜meta http-equiv="Refresh" content="2; URL=http://www.root.net"＞`
         注意：其中的2是指停留2秒钟后自动刷新到URL网址。

       * Set-Cookie(cookie设定)

         说明：设置cookie, 如果网页过期，那么存盘的cookie将被删除。

         用法：`＜meta http-equiv="Set-Cookie" content="cookievalue=xxx; expires=Friday, 12-Jan-2001 18:18:18 GMT； path=/"＞`
         注意：必须使用GMT的时间格式。

       * Window-target(显示窗口的设定)

         说明：强制页面在当前窗口以独立页面显示。

         用法：`＜meta http-equiv="Window-target" content="_top"＞`
         注意：用来防止别人在框架里调用自己的页面。

- **meta标签对搜索引擎的作用**

  meta标签的一个很重要的功能就是设置关键字，来帮助你的主页被各大搜索引擎登录，提高网站的访问量。在这个功能中，最重要的就是对Keywords和description的设置。因为按照搜索引擎的工作原理,搜索引擎首先派出机器人自动检索页面中的keywords和decription，并将其加入到自己的数据库，然后再根据关键词的密度将网站排序。因此，我们必须设置好关键字，来提高页面的搜索点击率。下面我们来举一个例子供大家参考：

　`＜meta name="keywords" content="政治,经济, 科技,文化, 卫生, 情感，心灵，娱乐，生活，社会，企业，交通"＞`
　`＜meta name="description" content="政治,经济, 科技,文化, 卫生, 情感，心灵，娱乐，生活，社会，企业，交通"＞`

　设置好这些关键字后，搜索引擎将会自动把这些关键字添加到数据库中，并根据这些关键字的密度来进行合适的排序。



# $\rm A.$ 参考

[^1]: [html中meta标签的详解](http://zq210wl.github.io/2015/01/05/html-meta-tag/) 