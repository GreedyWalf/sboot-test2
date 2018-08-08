package com.sboot.test8.service;

import org.springframework.stereotype.Service;

/**
 * 定义邮件发送相关接口
 */
public interface MailService {

    /**
     * 发送简单邮件
     *
     * @param to      收件人
     * @param subject 邮件主题
     * @param content 邮件内容
     */
    void sendSimpleMail(String to, String subject, String content);


    /**
     * 发送html内容邮件
     *
     * @param to      收件人
     * @param subject 邮件主题
     * @param content 邮件内容
     */
    void sendHtmlEmail(String to, String subject, String content);


    /**
     * 发送带附件的邮件
     *
     * @param to       收件人
     * @param subject  邮件主题
     * @param content  邮件内容
     * @param filePath 附件路径
     */
    void sendAttachmentsMail(String to, String subject, String content, String filePath);

    void sendInlineResourceEmail(String to, String subject, String content, String recPath, String recId);

}
