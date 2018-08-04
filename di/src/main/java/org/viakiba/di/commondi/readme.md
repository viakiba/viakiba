
### 解释

@Autowired
>按照类型（byType）装配依赖对象

>默认情况下它要求依赖对象必须存在，如果允许null值，可以设置它的required属性为false。

>如果我们想使用按照名称（byName）来装配，可以结合@Qualifier注解一起使用。

@Resource

>①如果同时指定了name和type，则从Spring上下文中找到唯一匹配的bean进行装配，找不到则抛出异常。

>②如果指定了name，则从上下文中查找名称（id）匹配的bean进行装配，找不到则抛出异常。

>③如果指定了type，则从上下文中找到类似匹配的唯一bean进行装配，找不到或是找到多个，都会抛出异常。

>④如果既没有指定name，又没有指定type，则自动按照byName方式进行装配；如果没有匹配，则回退为一个原始类型进行匹配，如果匹配则自动装配。

>@Resource的作用相当于@Autowired，只不过@Autowired按照byType自动注入。

setter注入

> 还是用了上述两个注解

构造函数注入

> 还是用了上述两个注解