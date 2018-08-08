package com.sboot.test8.service.impl;

import com.sboot.test8.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailServiceImpl implements MailService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender javaMailSender;

    //发件人邮箱
    @Value("${mail.fromMail.addr}")
    private String from;

    /**
     * 发送普通文本邮箱
     */
    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);
        javaMailSender.send(simpleMailMessage);
        logger.info("邮件发送成功啦~");
    }

    /**
     * 发送一个带html邮箱
     */
    @Override
    public void sendHtmlEmail(String to, String subject, String content) {
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            //true表示创建一个multipart message
            MimeMessageHelper msgHelper = new MimeMessageHelper(message, true);
            msgHelper.setFrom(from);
            msgHelper.setTo(to);
            msgHelper.setSubject(subject);
            //true表示发送的邮件是html
            msgHelper.setText(content, true);
            javaMailSender.send(message);
            logger.info("html邮件发送成功");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送带附件的邮件
     */
    @Override
    public void sendAttachmentsMail(String to, String subject, String content, String filePath) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
            messageHelper.setFrom(from);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(content, true);

            FileSystemResource fileResource = new FileSystemResource(new File(filePath));
            String fileName = fileResource.getFilename();
            messageHelper.addAttachment(fileName, fileResource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送正文中有静态资源的邮件（图片）
     *
     * @param resPath  静态资源路径
     * @param resId
     */
    @Override
    public void sendInlineResourceEmail(String to, String subject, String content, String resPath, String resId) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            FileSystemResource res = new FileSystemResource(new File(resPath));
            helper.addInline(resId, res);

            javaMailSender.send(message);
            logger.info("嵌入静态资源的邮件已经发送。");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
