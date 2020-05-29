package com.yang.bootsourcelearn;

import org.springframework.beans.BeanUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BootSourceLearnApplication {

    /****
     *   SpringBoot 启动流程阅读记录.
     *   这里根据我之前看 Spring 源码的记录,这里的 ${@link BootSourceLearnApplication} 肯定也是当做为了 bean注入到Spring 容器中的.
     *
     *   先看构造方法中的初始化吧, 将 debug 中的断点打到构造函数上即可.
     *    Class<?>... primarySources  这个参数,就是我们传入进去的类名字. com.yang.bootsourcelearn.BootSourceLearnApplication.
     *    这里是有相应的判断处理,就是对应的逻辑值是不能为空的.  转化集合并且赋值给 primarySources(LinkedHashSet)
     *    {@link WebApplicationType} 中 deduceFromClasspath 方法来, 第一个判断是不满足条件的,跳过. 接着迭代 SERVLET_INDICATOR_CLASSES,
     *    我这里debug显示的是,都不满足,即跳过了. 最后返回了一个 WebApplicationType = SERVLET的.
     *    接下来会走到 getSpringFactoriesInstances 方法,也就是获取一些 xxxContextInitializer 和 LoggingListener
     *    org.springframework.boot.context.ConfigurationWarningsApplicationContextInitializer
     *    org.springframework.boot.context.ContextIdApplicationContextInitializer
     *    org.springframework.boot.context.config.DelegatingApplicationContextInitializer
     *    org.springframework.boot.rsocket.context.RSocketPortInfoApplicationContextInitializer
     *    org.springframework.boot.web.context.ServerPortInfoApplicationContextInitializer
     *    org.springframework.boot.autoconfigure.SharedMetadataReaderFactoryContextInitializer
     *    org.springframework.boot.autoconfigure.logging.ConditionEvaluationReportLoggingListener
     *    TODO 这里需要清楚的就是, ContextInitializer 在接下来的处理逻辑中是怎么走的.也就是说,这些东西对于接下来的SpringBoot启动流程或者Spring中是
     *    做一些什么处理 ?
     *    然后将上面获取的这些 赋值给集合 initializers.(上面还顺带着排序了的.)
     *    走完这里,SpringBoot的构造函数初始化算是走完了.
     *
     *    接下来就是走run方法,这个方法的重要程度都是不用说的. 并且这个方法是可以返回一个 ApplicationContext , 这个返回的 ApplicationContext是可以获取出
     *    任意的bean信息等的.
     *
     *    run 方法阅读 :
     *      最先可以看到 new 了一个 StopWatch, 这个东西的作用就是我们启动程序的耗时,也就是我们启动完毕了最后看到的耗时时间打印,就是使用这个类来进行统计的.
     *      对于这种方面感兴趣的,可以点进去看看是怎么实现的,然后是不是自己也可以按照这个源码跟着去写一个差不多的呢? 我想肯定是可以的.
     *      configureHeadlessProperty() 方法是里面是走的一些赋值操作方法.
     *      getRunListeners(args); 方法是获取了 SpringApplicationRunListeners listeners 对象, 最后是走到了 getSpringFactoriesInstances
     *      这个方法 org.springframework.boot.context.event.EventPublishingRunListener 获取出这个对象.
     *      listeners.starting(); 这个方法是对上面获取肚饿 Listener 调用 start 开始方法.
     *
     *      new ApplicationArguments / new出一个这个类,这里目前还不是很清楚这个类的详细作用是什么.
     *      prepareEnvironment(listeners, applicationArguments); 从这个方法的名字来看,还是可以具体看到其作用是:准备环境.
     *      listeners : SpringApplicationRunListeners 中有 listeners:EventPushishingRunListener. applicationArguments这个对应的值不是很清楚.
     *
     *      走进prepareEnvironment方法里面,getOrCreateEnvironment,可以很好的理解这个方法为 获取或者创建环境,肯定是先获取,如果是获取到没有的话,就会走创建的方法.
     *      这里是可以看到返回的是 StandardServletEnvironment类. configureEnvironment()这个方法就是对获取出来的Environment进行配置处理.
     *      listeners.environmentPrepared(environment);  为监听器准备环境.
     *      bindToSpringApplication(environment);  从字面理解来看,这里是给环境绑定到SpringApplication或者给SpringApplication绑定enviornment.
     *      整理来说这里给人的感觉就是对环境的准备和处理等类似的操作.
     *
     *      createApplicationContext();  这里可以很明显的感觉到的意思就是创建ApplicationContext.
     *      org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext
     *      这里是走到case:SERVLET 里面, 使用Class.forName(); 来创建一个 AnnotationConfigServletWebServerApplicationContext 对象.
     *      {@link BeanUtils} 走到BeanUtils中,instantiateClass方法, 这个方法的意思可以从字面上理解为初始化bean.
     *      可以看到这个方法中,先是对传入进来的class进行非null判断,然后判断是否是接口,如果是接口的话,就不给初始化,因为你是new不可一个接口的.后面就是
     *      调用一些反射的API等操作,来实例化出一个对象来.
     *
     *      getSpringFactoriesInstances() TODO 走漏了
     *      prepareContext() 准备Context,
     *
     *
     * @param args
     */
    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(BootSourceLearnApplication.class);
        ConfigurableApplicationContext applicationContext = application.run(args);

        // SpringApplication.run(BootSourceLearnApplication.class, args);


    }

}
