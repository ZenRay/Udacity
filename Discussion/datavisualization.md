
[toc]

# 文件说明
该内容主要是针对答疑问题过程中找到的比较实用性的关于数据可视化部分

# 关于 JS 调试—— debugger 方式
[Chrome DevTools — JS调试 - 小前端 - SegmentFault 思否](https://segmentfault.com/a/1190000008396389)

# 严格模式下变量申明
[Javascript 严格模式详解 - 阮一峰的网络日志](http://www.ruanyifeng.com/blog/2013/01/javascript_strict_mode.html)

[严格模式 - JavaScript | MDN](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Strict_mode)

严格模式下，变量名使用需要注意申明，某些关键字使用需要注意

# 在 D3 中实现散点图 jitter 方法
[Discrete Scatterplot (D3.js) - bl.ocks.org](https://bl.ocks.org/duhaime/14c30df6b82d3f8094e5a51e5fff739a)

思路还是是利用 JS 中的 Math.random 方法

# dimple 中悬浮框
问题来源：[课程51-22 没有显示老师说的错误](http://discussions.youdaxue.com/t/51-22/57429/3)
dimple 的悬浮框是因为在调用 `addSeries` 等方法时会启用 `tooltip` 的相关方法。但是它本身可以通过相关方式进行定制化操作。具体原因可以参考：

1. [Tooltip Charts](http://dimplejs.org/advanced_examples_viewer.html?id=advanced_lollipop_with_hover)
2. [Create Data Visualizations in JavaScript using Dimple and D3 — SitePoint](https://www.sitepoint.com/create-data-visualizations-javascript-dimple-d3/)
3. [dimple.series · PMSI-AlignAlytics/dimple Wiki](https://github.com/PMSI-AlignAlytics/dimple/wiki/dimple.series#getTooltipText)
