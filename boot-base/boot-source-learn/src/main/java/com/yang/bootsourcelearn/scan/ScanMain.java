package com.yang.bootsourcelearn.scan;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Set;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-6-24
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class ScanMain {

    public static void main(String[] args) {

        /** false 不使用默認的fiter */
        ClassPathScanningCandidateComponentProvider c = new ClassPathScanningCandidateComponentProvider(false);

        c.addIncludeFilter(new AnnotationTypeFilter(GavinYang.class));

        Set<BeanDefinition> definitionSet = c.findCandidateComponents("com.yang.bootsourcelearn.scan");

        System.out.println(definitionSet);

    }

}
