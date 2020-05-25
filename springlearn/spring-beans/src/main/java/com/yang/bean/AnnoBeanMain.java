package com.yang.bean;

import com.yang.bean.anno.YangServiceImpl;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.ResolvableType;

/**
 * @Author: Mu_Yi
 * @Date: 2020/5/25 23:00
 * @Version 1.0
 * @qq: 1411091515
 */

@ComponentScan("com.yang")
public class AnnoBeanMain {

    /***
     *  使用  AnnotationConfigApplicationContext 的 context 中的 getBean方法分析
     *  Debug模式走起来. YangServiceImpl yangService = context.getBean(YangServiceImpl.class);
     *  {@link AbstractApplicationContext}  走到这个类中的 getBean 方法,先判断这个BeanFactory是否是活跃的,
     *  如果不是活跃的话,就会抛出异常.
     *  {@link GenericApplicationContext}  这个类中是调用 getBeanFactory()方法,也就是从这儿获取到 BeanFactory的,
     *  {@link DefaultListableBeanFactory} 这个BeanFactory是上面返回回来的,所以同样也会走到这个类里面的getBean方法来.可以
     *  看到这个类中的getBean还是比较多的,这里方法重载使用到不错，哈哈哈哈.
     *  1. 显示检验你传入进来获取Bean的值不能为空null.
     *  2. {@link ResolvableType}   ResolvableType.forRawClass(requiredType),
     *  3. resolveBean 方法 :  调用 resolveNamedBean 来获取 NamedBeanHolder , 如果 NamedBeanHolder获取出来的值不是为null的话,就会直接调用
     *      return namedBean.getBeanInstance(); 并且进行返回. 如果返回来的是 Object(bean)是null的话,就是没有获取到.就会抛出下面的异常代码
     *      throw new NoSuchBeanDefinitionException(requiredType);  如果有值的话,就会进行一路的返回。
     *    resolveNamedBean() 方法讲解 :  先说方法走向 1: getBeanNamesForType(requiredType);  --->  2: etBeanNamesForType(ResolvableType type) --->
     *                         3:  getBeanNamesForType(ResolvableType type, boolean includeNonSingletons, boolean allowEagerInit) --->
     *                         4:  getBeanNamesForType(@Nullable Class<?> type, boolean includeNonSingletons, boolean allowEagerInit)  -->
     *                         5 : doGetBeanNamesForType(ResolvableType.forRawClass(type), includeNonSingletons, true);(目测这步就是真正的获取Bean对象啥的) TODO 以后完了了解补
     *                              这个方法里面其实对获取Bean还做了一层缓存的操作,如果是第一次来的话,cache里面肯定没有,那就走获取的逻辑,并且存放在cacha里面,下次来的
     *                              时候就直接从cacha里面获取即可.
     *                         6:  Step 5 中 String[] candidateNames = getBeanNamesForType(requiredType); 返回的 candidateNames ,后续会根据这个 candidateNames
     *                             的长度来走对应的逻辑.这里我们只有一个,所以就走了 length == 1 的逻辑代码,
     *                             return new NamedBeanHolder<>(beanName, (T) getBean(beanName, requiredType.toClass(), args));
     *                             跟着这个 new继续往里面跟,主要跟到 getBean里面来, {@link AbstractBeanFactory} 就会跟到这个类里面, doGetBean()方法,
     *                             这个里面就是获取bean的,.Object sharedInstance = getSingleton(beanName); 使用if + 锁来实现单例.  TODO 这个doGetBean是需要仔细看看的
     *                             然后走完这个 doGetBean就会返回一个 NamedBeanHolder. 也就是走5后面说的逻辑。这个时候,获取bean就已经结束了.
     *
     *
     *
     * */
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnoBeanMain.class);

        YangServiceImpl yangService = context.getBean(YangServiceImpl.class);
    }

}
