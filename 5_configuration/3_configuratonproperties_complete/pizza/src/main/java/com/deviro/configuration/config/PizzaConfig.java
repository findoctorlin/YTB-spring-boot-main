package com.deviro.configuration.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration // 表示这是一个 Spring 配置类，会被注册为 Spring 容器中的一个 Bean。它告诉 Spring：这个类要参与容器管理
@ConfigurationProperties(prefix = "pizza") // 将 application.properties 或 application.yml 中以 pizza. 开头的属性，自动注入到这个类的字段中
@AllArgsConstructor // 生成带所有字段的构造器
@NoArgsConstructor // 生成无参构造器（必须要有，Spring 用它来创建 Bean）
@Data // 自动生成所有字段的 getter、setter、toString()、equals()、hashCode() 等
public class PizzaConfig {
    private String sauce;
    private String topping;
    private String crust;
}
