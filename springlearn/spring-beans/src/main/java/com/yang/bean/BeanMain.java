package com.yang.bean;

import com.yang.bean.obj.BeanOne;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.AbstractPropertyResolver;
import org.springframework.util.PropertyPlaceholderHelper;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-5-24
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/


public class BeanMain {

    /*****
     * {@link ClassPathXmlApplicationContext}  先进入 ClassPathXmlApplicationContext的构造函数
     * 构造函数 :
     *  1 : super(parent);  parent ApplicationContext  ---> 最后调用到了 {@link AbstractApplicationContext}
     *      AbstractApplicationContext中做事情, this()初始化资源加载类. setParent(parent)中是可以看的,通过ClassPathXmlApplication
     *      调用上去的parent肯定是null,然后赋值给内部变量parent. 如果传递进来的null,不是null的话,就获取 Environment parentEnvironment =
     *      parent.getEnvironment();  如果是 ConfigurableEnvironment,就会调用merge方法来merge.
     *  2 : setConfigLocations()  先创建一个 StandardEnvironment, AbstractEnvironment 里面执行的 resolveRequiredPlaceholders 方法
     *      this.propertyResolver.resolveRequiredPlaceholders(text); 这行代码执行是在 {@link AbstractPropertyResolver}中
     *      最后是执行到了 {@link PropertyPlaceholderHelper} replacePlaceholders 方法
     *  3 ： 走到 refresh 方法里面,这个方法里面很多就是处理 Bean 的信息.
     *  走到这里的话,构造函数就基本走完了.
     *
     *  refresh 方法分析 {@link AbstractApplicationContext }
     *   1 ： prepareRefresh() 方法,  准备刷新, 这个里面可以看到先是对  closed /  active 进行值的设置,
     *      然后走到 {@link AbstractPropertyResolver} 中的validateRequiredProperties检验方法(里面debug进去,requiredPropertiess是没有值可以迭代的).
     *   2 : obtainFreshBeanFactory() 方法,  ---> 调用 refreshBeanFactory(); 和  getBeanFactory();
     *       refreshBeanFactory()  TODO 这个方法应该是刷新 beanFactory的方法,目前没具体找到具体的子类.
     *       getBeanFactory() {@link AbstractRefreshableApplicationContext} / {@link GenericApplicationContext} /
     *       {@link GenericApplicationContext} 在这些类中是可以找到的, 最后都是返回的是 DefaultListableBeanFactory.
     *   3 : prepareBeanFactory(beanFactory),这里的beanFactory是step2中返回来的, 給beanFactory中进行set一些属性的值, registery一些Dependency
     *      然后根据一些条件来进行调用对应的set方法,总之这里就是调用到一些赋值或者设置或者注册等方法.就是为 beanFactory准备环境.
     *   4 : postProcessBeanFactory() 方法,可能由于少设置了一些参数/还是什么东西,这个方法并没有走(因为方法里面没有代码).TODO case
     *   5 : invokeBeanFactoryPostProcessors(beanFactory) 方法, 这个方法很重要,里面走的逻辑还是很重要的.
     *
     *       PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(beanFactory, getBeanFactoryPostProcessors());
     *          PostProcessorRegistrationDelegate 的意思是 PostProcessor登记处代表,个人感觉这个有点类似于我们平常使用工具类的感觉.
     *          传入 beanFactory 和 BeanFactoryPostProcessor的集合
     *          beanFactory是 BeanDefinitionRegistry,这里大概猜测下,如果beanFactory是BDRegistry,所以BeanFactory也就是一个bean,而且Spring
     *          给其定义的是Registry.
     *
     *          迭代传入进来的beanFactoryPostProcessors集合, postProcessor如果是BeanDefinitionRegistryPostProcessor的话,强转下.
     *          然后走到 registryProcessor.postProcessBeanDefinitionRegistry(registry); TODO 这个具体要看子类是走的那段代码,目测是比较复杂的.
     *          然后给其添加到registryProcessors集合中来.否则的话,就会添加到regularPostProcessors集合中.
     *          5.1 接下里,先调用 实现 PriorityOrdered 的 BeanDefinitionRegistryPostProcessors,然后给添加到 currentRegistryProcessors 集合中.再给
     *          currentRegistryProcessors拍下寻,目测是根据Order,是有一个@Order注解控制初始化bean的先后顺序呢.在走 invokeBeanDefinitionRegistryPostProcessors
     *          方法,迭代每个currentRegistryProcessors中的元素,走到postProcessor.postProcessBeanDefinitionRegistry(registry);上面的todo有记录.
     *          5.2 然后接下来会调用,实现Ordered,并且该postProcessorName是在5.1中没有出现的,具体的做法是5.1中的过程是一样的.
     *          5.3 最后调用所有的BeanDefinitionRegistryPostProcessors,排除掉5.1和5.2中已经出现的,直到没有为止.
     *          5.4 最后调用  invokeBeanFactoryPostProcessors(registryProcessors, beanFactory);(这个registryProcessors是上面出现的所有的) 和
     *                      invokeBeanFactoryPostProcessors(regularPostProcessors, beanFactory)(这个是5.1中else存放的);
     *                      postProcessor.postProcessBeanFactory(beanFactory);是invokeBeanFactoryPostProcessors走的代码,会依次调用迭代的每个postProcessor
     *                      的postProcessBeanFactory方法,传入beanFactory进去.
     *          如果BeanFactory不是BeanDefinitionRegistry,就会直接走invokeBeanFactoryPostProcessors(beanFactoryPostProcessors, beanFactory);
     *         然后根据 BeanFactoryPostProcessor.class来获取bd名字(多个),如果在5.1,5.2中包含的的,就跳过不处理,
     *         如果是PriorityOrdered的话,就会存放 priorityOrderedPostProcessors 结合中
     *         如果是Ordered的话,就会存放在orderedPostProcessorNames集合中
     *         否则就会存放在nonOrderedPostProcessorNames集合中
     *         然后先调用 PriorityOrdered 集合中的元素,排序后也会走 invokeBeanFactoryPostProcessors(priorityOrderedPostProcessors, beanFactory);
     *         在调用 Ordered ,  invokeBeanFactoryPostProcessors(orderedPostProcessors, beanFactory);
     *         最后再调用 nonOrderedPostProcessorNames   invokeBeanFactoryPostProcessors(nonOrderedPostProcessorNames, beanFactory);
     *
     *         beanFactory.clearMetadataCache(); 方法, 走到 {@link DefaultListableBeanFactory} 中来, 再往下走 {@link AbstractBeanFactory} 到这个类中来,
     *         可以看出来是对一些集合(Map)中的元素进行clear清除方法.
     *
     *   6 : registerBeanPostProcessors(beanFactory);方法.
     *
     *
     *
     *
     *
     *
     *
     */

    public static void main(String[] args) {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("bean_one.xml");
        BeanOne beanOne = context.getBean("beanOne", BeanOne.class);
        System.out.println(beanOne.toString());

    }

}
