# LeetCodePlayGround
上leetcode刷题，没有合适的工具？运行testcase太麻烦? 

有了我的leetcode playground，模拟online judge的输入输出，随手写testcase，本地testcase和线上格式完全一样，不需要写任何一行测试代码。本地调试完毕以后，直接上线测试提交，极大提高刷题速度，让刷题成为乐趣 :)

这个项目目前只有Java版本 :)

原理如下：

1. 每个Solution创建一个package，在main函数里指定要运行的solution package名字。通过反射运行Solution。

2. 所有的Solution基于BaseSolution。第一个public函数就是主运行函数。（也可以通过覆盖invokeRunMethod()函数来自定义，一般不需要）

3. 每个Solution package下面放一个testcase.txt，把你能想到的testcase统统扔进来，格式和leetcode上的testcase完全一样。只要本地的testcase足够丰富，各种犄角旮旯都覆盖到，基本上上线提交都一次通过！

4. BaseSolution里有处理testcase的输入和输出，包括处理树和链表。目前能处理所有题目的数据结构。（我刚刷了不到50题，后面如果碰到新的数据结构，在BaseSolution里加就可以了。）
