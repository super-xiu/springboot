配置文件

1. 在类路径下写Application.yml
2. 在Javabean中进行绑定
3. 导入对应的依赖，
4. 必须把对应的Javabean类加载到容器中，要不然能使用容器中的类



2. properties中配置

    	1. properties的语法person.last-name="张三" 
        	2. properties默认的是utf-8编码，可能会乱码，需要在idea中进行转码

   

   如何从两种配置文件中获取值：配置文件是springboot默认的配置文件，当springboot启动的时候就会默认的去添加对应的配置文件，所以需要知道springboot如何去到这两种配置文件中去渠道对应的值

   1. @Value()：相当于spring配置文件中的<bean>标签下的property属性，进行对应值的注入

   2. configurationproperties可以使用jsr303数据校验，单配validated进行使用，在对应的属性上添加对应的校验规则注解

   3. configurationproperties和@Value适用的情况

      如果有对应的Javabean与配置文件相对应，就是用@Configurationproperties,如果是单独的属性则使用的是@Values\

   springboot会默认加载application.yml或者是appication.porperties配置文件，但是如果想要对应的类其他配置文件进行类中属性的配置时，建议使用@PorpertiesSources进行引入用户指定的配置文件

   @importResource:导入spring的配置文件，添加在启动类的类上，因为springboot中不含spring的配置文件，所以如果需要添加spring的配置文件就需要使用该注解

   如果在springboot中想通过spring配置的方式进行生成对象

   1. 可以在主配置类中进行导入spring的配置文件
   2. 可以使用配置类，方法的返回值相当于属性的value,方法名相当于id,

   配置文件中的占位符：

   ​	

   springboot的多环境支持：profile

![](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119134917295.png)

![image-20201119134936691](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119134936691.



激活指定的profile文件

1. 在主配置文件中使用spring.profile.active=环境名进行激活！
2. 以命令行的形式进行激活：

![image-20201119135202375](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119135202375.png)

![image-20201119135247330](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119135247330.png)

3. 将项目打包，在target目录中右键在浏览器中打开找到打好包的的位置，在该位置下使用cmd命令窗口进行命令行的形式启动项目（切换对应的环境）

   ![image-20201119135622483](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119135622483.png)

4 . 虚拟机参数：配置项目启动的vm option

![image-20201119135758390](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119135758390.



配置文件的加载位置：

就是springboot项目启动后，会如何加载对应的配置文件，其对应的顺序是什么？

springboot项目在启动后会默认加载四个地方的配置文件，并且会按照加载顺序去进行加载，如果配置文件中的内容有冲突的话，根据加载的优先级决定，先加载的优先级高，后加载的优先级低，发生冲突时优先采用优先级高的配置，如果四个位置的配置文件中含有不同的内容，那么springboot会将其进行互补，即把四个配置文件不同的地方进行互补冲突的地方柑橘优先级进行选取

比较类路径下和类路径下的config目录下配置文件的优先级：

![image-20201119140835612](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119140835612.png)

比较项目根目录下和项目根目录下的config文件的优先级：

![image-20201119140946098](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119140946098.png)

![image-20201119140959369](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119140959369.png)

配置的优先级：/config/* >/*>classpath/config/*>classpath/*



5. 还可以指定配置文件的位置，就是除了使用默认的四种位置的配置文件，还可以指定一个自定义的位置的配置文件

   ```xml
   spring.config.location=配置文件的路径
   ```

   

![image-20201119142035964](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119142035964.png)

![image-20201119142209550](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119142209550.png)

![image-20201119142351785](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119142351785.png)

![image-20201119142411905](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119142411905.png)  

命令行参数进行修改配置的方式：

![image-20201119142702935](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119142702935.png)

![image-20201119142821784](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119142821784.png)

优先加载带profile，再加载不带profile，遵循优先jar包向jar内进行寻找

打包只会打类路径下的文件，项目目录下的配置文件因为不符合maven的项目结构我不会被打包

命令行带多个参数使用空格进行区别，但是如果需要修改很多建议使用配置文件的方式进行修改

![image-20201119143458236](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119143458236.png)

springboot配置里的内容应该写啥？

1. 在官网中有记载

   ![image-20201119145623857](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119145623857.png)

自动配置原理（※）

![image-20201119152022836](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119152022836.png)

![image-20201119152441970](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119152441970.png)

根据当前不同的条件判断，决定这个类是否生效！

![image-20201119153409538](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119153409538.png)

![image-20201119154317955](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119154317955.png)

可以通过启用debug属性，让控制台打印自动配置报告

![image-20201119154513117](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119154513117.png)

![image-20201119154659316](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119154659316.png)



sprigboot的日志框架的选取

门面：SLF4J+实现：logback

如何在系统中使用该框架：在系统中尽量调用抽象层的方法而不是实现类的方法，这样可以提高框架的扩展性

1. 导入slf4j和logback的jar包

2. 使用 LoggerFactory进行获取Logger对象

   ```java
   import org.slf4j.Logger
   import org.slf4j.LoggerFactory
      
   public class HelloWorld{
       public static void main(String[] args){
           Logger logger = LoggerFactory.getLogger(HelloWorld.class);
       }
   }
   ```

   slf4j如何使用Loggerback框架，我们面向slf4j进行编码，而使用loggback进行实现slf4j，这样程序就可以调用对应的loggback框架了！

   ![image-20201119182629359](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119182629359.png)

程序如何使用loger4j进行日志的记录：

程序实现SLF4J接口，新建一个适配层，实现SLF4J的接口，和实现logger4的接口，在调用接口写日志的时候，调用logger4进行操作！

在实际开发中会遇到的问题：当我们在开发系统的时候，使用的是SLF4J日日志框，但是在系统中会调用其他框架，而框架中会自带其他日志框架，为了减少日志框架的配置，想要全部统一使用SLF4J框架，这如何进行实现？

就是使用适配包去替代原有框架的日志包，在适配包中含有原有框架包中的所有方法，但是在方法实现的时候调用的是SLF4J接口中的方法

主要需要排除框架中原有的日志jar包

![image-20201119183855468](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119183855468.png)

![image-20201119190009194](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119190009194.png)



![image-20201119190117191](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119190117191.png)

1. springboot底层也是使用SLF4J+Loggerback进行日志记录
2. springboot也把其他的日志都替换成了SLF4J

![image-20201119190749742](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119190749742.png)

需要引入框架的时候，需要移除原框架自带的日志框架

![image-20201119190944920](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119190944920.png)

![image-20201119191410885](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119191410885.png)

日志级别的作用：当项目上线时，有些低级别的日志信息不需要使用的时候，通过调整日志的级别可以自动屏蔽掉低级别的日志信息。

1. 日志的级别

   ![image-20201119191650462](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119191650462.png)

springboot默认使用的是info级别的日志，trace和debug不会输出，如何进行调整？

在springboot的配置文件中进行调整，info“root级别

![image-20201119191958331](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119191958331.png)

logging.path和logging。file会有冲突，两个都配置就显示longging.file中的配置，

项目一般使用logging.path，value是目录名，日志名使用springboot默认的

![image-20201119192319192](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119192319192.png)

![image-20201119192701843](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119192701843.png)

![image-20201119192721765](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119192721765.png)

如果不想使用springboot自带的日志框架，如何使用自定义的日志框架

1. 在项目的类路径下放入对应日志的配置文件

![image-20201119193921040](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119193921040.png)



![image-20201119194303862](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119194303862.png)

![image-20201119194451226](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201119194451226.png)

如果不改名字还使用会报错！



springboot-web

如何使用springboot开发一个web项目:

1. 使用启动器创建springboot项目，并且导入对应web所需要的组件
2. 导入对应的依赖

![image-20201208143530120](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201208143530120.png)

![image-20201208144840990](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201208144840990.png)





webjars，

什么是webjars?

就是一种可以以引入jar包的方式进行引入静态资源的技术！常用的前端框架，使用maven依赖的方式引入到项目

如何进行使用？（引入需要使用框架的依赖即可）

![image-20201208145625820](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201208145625820.png)

![image-20201208145730621](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201208145730621.png)

![image-20201208145848928](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201208145848928.png)

webjars：就是如果需要使用前端已经定义好的静态资源时，如jQuery，通过webjars进行对应静态资源的maven依赖引用，当访问localhost:8080/webjars/jquery/3.3.1/jquery.js就会去到对应的文件夹下寻找到对应的静态资源。

如果是想去查找自定义的静态资源应该怎么做？

根据自动配置中规定，当访问当前项目的任意资源时，springboot都会去以下几个目录下去寻找对应的资源文件，我们自己定义的静态资源文件只需要存放在以下目录下，当我们发送请求请求该项目的时候就会群一下目录下去寻找对应的资源文件

![image-20201208150954560](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201208150954560.png)

![image-20201208151145138](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201208151145138.png)

![image-20201208151205906](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201208151205906.png)



**自动配置中还有个欢迎页的自动配置**，**即首页的配置**

![image-20201208151333789](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201208151333789.png)

![image-20201208152045284](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201208152045284.png)

静态资源映射；springboot通过自动配置进行静态资源文件夹的映射，我们只需要按照springboot自动配置的映射规则进行存放静态资源就可以直接访问到对应的静态资源

如何自定义静态文件夹：在yml文件中进行配置,定义好了之后，静态资源就只能放在这个地方

```xml
spring.resources.static-localtions=静态文件夹的地址,地址2
```



**模板引擎**

1. 什么是模板引擎？有什么作用？

2. 如何使用模板引擎？

   ​	1. 引入对应的依赖

   ​	![image-20201208153758726](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201208153758726.png)

![image-20201208154252676](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201208154252676.png)

thymeleaf的语法规则：通过自动配置去看默认规则在进行语法学习

![image-20201208155618173](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201208155618173.png)

![image-20201208155624515](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201208155624515.png)

使用thymeleaf的好处：只需要我们把HTML页面放在classpath:/template下thymeleaf就可以自动渲染，就是说可以直接跳转到该页面。

在引入thymeleaf模板引擎的依赖后，当请求controller返回一个字符串，相当于springmvc的视图解析器，thymeleaf会自动去classpath:/template查找对应的页面

**thymeleaf的使用规则**

1. 可以去官网下载对应的使用教程。

   

![image-20201208160545301](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201208160545301.png)

![image-20201208160647659](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201208160647659.png)

**语法规则**

![image-20201208161020950](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201208161020950.png)

![image-20201208161710479](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201208161710479.png)

![image-20201208163148306](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201208163148306.png)

![image-20201208163502652](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201208163502652.png)

**springboot对springmvc的自动配置**

![image-20201209102146947](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201209102146947.png)

![image-20201209103902560](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201209103902560.png)

![image-20201209104044979](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201209104044979.png)

![image-20201209104246408](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201209104246408.png)

如何修改springboot的默认配置：

1. springboot启动时回去扫描容器中的组件，当发现有用户配置的组件优先使用用户配置的组件，如果没有，则使用默认配置的组件

2. 如果想额外增添一些主键的话：

   扩展springmvc：额外添加一些springmvc组件

   ![image-20201209105334254](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201209105334254.png)

   

![image-20201209105704380](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201209105704380.png)

![image-20201209105739843](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201209105739843.png)

既保留原有，又可以扩展（原因如下）

![image-20201209110224510](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201209110224510.png)

**springboot全面接管springmvc**

如果在配置类上添加注解@EnableWebMvc就相当于告诉springmvc去全面接管springmvc，此时springboot就不会自动的去配置springmvc所有有关springmvc的都需自己去配置。

![image-20201209111016794](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201209111016794.png)

![image-20201209111442204](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201209111442204.png)

导入为什么就会失效（上图）

**crud案例**





**springboot的持久层的交互**

![image-20201210104006787](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201210104006787.png)

![image-20201210105336296](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201210105336296.png)

![image-20201210105347768](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201210105347768.png)

![image-20201210105511248](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201210105511248.png)**自动配置原理**

![image-20201211100146115](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201211100146115.png)

**springboot如何进行表的自行创建**

**![image-20201211102659847](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201211102659847.png)**

![image-20201211103306188](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201211103306188.png)

建表语句会在我们启动时会自动创建一张表

![image-20201211103422644](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201211103422644.png)

整合数据源

![image-20201211103639249](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201211103639249.png)

引入对应的依赖

![image-20201211104656123](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201211104656123.png)

![image-20201211104756143](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201211104756143.png)

![image-20201211104919894](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201211104919894.png)

![image-20201211105004324](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201211105004324.png)

![image-20201211105140755](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201211105140755.png)

**springboot-mybatis**

![image-20201211105330196](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201211105330196.png)

![image-20201211140149763](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201211140149763.png)

![image-20201211140440963](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201211140440963.png)

![image-20201211140710836](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201211140710836.png)

![image-20201211140733328](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201211140733328.png)

自动成主键

![image-20201211140904823](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201211140904823.png)

![image-20201211140932087](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201211140932087.png)

自定义配置类

![image-20201211141315327](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201211141315327.png)

**批量扫描**

![image-20201211141612436](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201211141612436.png)

![image-20201211141641606](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201211141641606.png)

**整合JPA**

![image-20201211141743121](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201211141743121.png)

![image-20201211141751091](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201211141751091.png)

![image-20201211141830385](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20201211141830385.png)





**springbootweb - crud**

1. 如何使得springboot访问到首页？

![image-20210113140508037](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20210113140508037.png)

springboot的默认配置中，直接访问localhost:8080会去静态资源文件加下去找对应的index文件，比如public下的index.html会默认进行访问。前提是不接管springmvc

**我们如何自定义进行访问首页，而不使用springboot指定位置的首页？**

1. 方法一：使用一个空方法进行映射，使得请求映射到对应的页面

   ![image-20210113142116655](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20210113142116655.png)

2. 方法

![image-20210113191202287](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20210113191202287.png)

![image-20210113191445774](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20210113191445774.png)

**国际化**

![image-20210113192254083](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20210113192254083.png)

![image-20210113192938216](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20210113192938216.png)

![image-20210113193143579](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20210113193143579.png)

**全局设置**

![image-20210113193233855](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20210113193233855.png)

**点击实现国际化**（**自定义区域信息解析器**）

![image-20210113194222755](C:\Users\19586\AppData\Roaming\Typora\typora-user-images\image-20210113194222755.png)

