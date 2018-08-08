package com.sboot;

import com.sboot.test2.User;
import com.sboot.test2.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

//@EnableScheduling  //启动定时任务
@EnableConfigurationProperties({UserEntity.class, User.class}) //将属性文件配置到实体对象中
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * 输出springboot启动时加载的bean
     */
//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ac) {
//        return new CommandLineRunner() {
//            @Override
//            public void run(String... args) throws Exception {
//                System.out.println("--->>>springBoot启动时注入的bean：");
//                String[] beanDefinitionNames = ac.getBeanDefinitionNames();
//                for (String beanName : beanDefinitionNames) {
//                    System.out.println(beanName);
//                }
//            }
//        };
//    }
}
