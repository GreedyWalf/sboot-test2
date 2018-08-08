package com.sboot.mail;

import com.sboot.test8.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;

/**
 * 测试springBoot支持的发送邮件功能；
 *  普通邮件、html邮件、带附件邮件、静态资源打开的邮件、使用邮件模版；
 *
 *  邮件发送不成功控制：
 *    1、接收到发送邮件请求，首先记录请求并且入库。
 *    2、调用邮件发送接口发送邮件，并且将发送结果记录入库。
 *    3、启动定时系统扫描时间段内，未发送成功并且重试次数小于3次的邮件，进行再次发送
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTest {

    private static final String to = "695830237@qq.com";

    @Resource
    private MailService mailService;

    //使用模版作为邮件内容，发送
    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testSend() {
        mailService.sendSimpleMail(to, "这个邮件没有主题", "我是邮件的正文内容，我是不是要说点什么~~");
    }

    @Test
    public void testSendHtml() {
        String content = "<b>我是加粗的内容</b>";
        mailService.sendHtmlEmail(to, "邮件主题", content);
    }

    @Test
    public void testSendAttachment() {
        String filePath = "/Users/qinyupeng/Desktop/图片/298548.jpg";
        String content = "<b>我是加粗的内容</b>";
        mailService.sendAttachmentsMail(to, "邮件主题", content, filePath);
    }

    @Test
    public void testSendInlineResource() {
        String rscId = "298548";
        String content = "<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "/Users/qinyupeng/Desktop/图片/298548.jpg";
        mailService.sendInlineResourceEmail(to, "主题：这是有图片的邮件", content, imgPath, rscId);
    }

    /**
     * 使用thymeleaf模版，发送邮件
     */
    @Test
    public void sendEmailUseTemplate() {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("id", "006");
        //加载模版文件（classpath:template/emailTemplate），并设置模版文件中的参数值
        String emailContent = templateEngine.process("/email/emailTemplate", context);

        mailService.sendHtmlEmail(to, "主题：这是模板邮件", emailContent);
    }
}