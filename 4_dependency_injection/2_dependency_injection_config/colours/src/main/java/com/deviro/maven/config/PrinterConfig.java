package com.deviro.maven.config;

import com.deviro.maven.services.BluePrinter;
import com.deviro.maven.services.ColourPrinter;
import com.deviro.maven.services.GreenPrinter;
import com.deviro.maven.services.RedPrinter;
import com.deviro.maven.services.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 使用@注解手动注册成为Bean方法，返回值会作为Spring容器中的一个instance存储和管理

@Configuration // 里面的method都会被Spring扫描并执行
public class PrinterConfig {

  @Bean // 每个带Bean注解的method都会返回一个instance，交给Spring容器托管, 等待后续inject
  public BluePrinter bluePrinter() {
    return new EnglishBluePrinter();
  }

  @Bean
  public RedPrinter redPrinter() {
    return new SpanishRedPrinter();
  }

  @Bean
  public GreenPrinter greenPrinter() {
    return new SpanishGreenPrinter();
  }

  @Bean
  public ColourPrinter colourPrinter( // 组合型Bean，依赖前面3个Bean
      BluePrinter bluePrinter, RedPrinter redPrinter, GreenPrinter greenPrinter) {
    return new ColourPrinterImpl(redPrinter, bluePrinter, greenPrinter); // 告诉Spring，这个ColorPrinterImpl需要这3种Printer，请INJECT进来
  } // 然后instance化的ColourPrinterImpl就被构造出来
}
