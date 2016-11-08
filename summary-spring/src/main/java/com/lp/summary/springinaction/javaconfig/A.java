package com.lp.summary.springinaction.javaconfig;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by Administrator on 2016/11/3.
 */
public class A implements ConditionContext{

    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Environment env=conditionContext.getEnvironment();
        return env.containsProperty("c");
    }

    public BeanDefinitionRegistry getRegistry() {
        return null;
    }

    public ConfigurableListableBeanFactory getBeanFactory() {
        return null;
    }

    public Environment getEnvironment() {
        return null;
    }

    public ResourceLoader getResourceLoader() {
        return null;
    }

    public ClassLoader getClassLoader() {
        return null;
    }
}
