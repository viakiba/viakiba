# SpringTest

> 结合TestNG使用SpringTest实现部分测试需求。

### notes

```
1) testng相对junit而言更加的繁琐一些。
2）Testng因为有xml文件，所以testng可以针对一组测试类共同测试，而junit只能一个类资源内部测试，比较耗时
3）Testng可以通过注解去区分执行方法的先后和依赖关系。而junit做不到
4）Testng如果有测试方法出错可以返回只执行错误的测试方法，junit需要全部重新执行
综上，testng比较适合更加完整大型的项目测试用例，而junit比较适合开发人员自己拿来测试方法比较方便。
```

### 参考

```
https://blog.csdn.net/u011138533/article/details/52174446
https://blog.csdn.net/taiyangdao/article/details/77096823
https://blog.csdn.net/douya43/article/details/73555843
https://segmentfault.com/a/1190000010854538
```