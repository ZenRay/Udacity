**目录**

[TOC]

针对 Git 和 GitHub 中的问题及其他相关总结

# 1. 部分文件 merge

场景，在某些情况下，可能只需要将部分文件 merge 到另一个 branch 上，这个时候使用 `git merge banch_name` 可能就不太合适了——因为该方法得到的结果是将所有文件都进行了 merge

解决方案：可以考虑使用 `git cherry-pick <commit id>` 的方法。首先需要确认需要合并的文件的 commit 哈希值是多少（可以通过 `git log` 查询），之后切换到文件被 merge 到的那个 branch 上。使用方式如下：

```git
git log 

commit a2739a3de8f876aa5669786f7f140ac8703565ed
Author: xxxx <xxxxx@gmail.com>
Date:   Sat Sep 1 11:34:28 2018 +0800

    report($img) update the final prediction
    
# 假设需要将上面这个图片文件 merge 到 report 分支上
git checkout report
git cherry-pick a2739a3
```



