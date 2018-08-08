package com.sboot.test6;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutRabbitConfig {

    /**
     * 使用@Bean注解，对应的配置文件<bean id="messageA" class="xxx"/>，注入后bean的名称为messageA
     */
    @Bean
    public Queue messageA() {
        return new Queue("fanout.A");
    }

    @Bean
    public Queue messageB() {
        return new Queue("fanout.B");
    }

    @Bean
    public Queue messageC() {
        return new Queue("fanout.C");
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    /**
     * 通过@Bean注解，获得Binding实例
     *
     * @param messageA 将上面通过注解的messageA对象注入到参数中
     * @param fanoutExchange 将上面通过注解的fanoutExchange对象注入到参数中
     */
    @Bean
    public Binding bindingFanoutA(Queue messageA, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(messageA).to(fanoutExchange);
    }

    @Bean
    public Binding bindingFanoutB(Queue messageB, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(messageB).to(fanoutExchange);
    }

    @Bean
    public Binding bindingFanoutC(Queue messageC,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(messageC).to(fanoutExchange);
    }
}
