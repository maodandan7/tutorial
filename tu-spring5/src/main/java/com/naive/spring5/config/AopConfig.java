package com.naive.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * User zhongmeng-lizhaohong
 * Date 2021/5/28
 * Description:
 */
@Configuration
@ComponentScan(basePackages = {"com.naive.spring5.aop"})
@EnableAspectJAutoProxy
public class AopConfig {

}
