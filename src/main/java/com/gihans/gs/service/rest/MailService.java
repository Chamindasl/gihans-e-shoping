/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gihans.gs.service.rest;

import com.gihans.gs.model.User;
import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *
 * @author echamam
 */
@Stateless
public class MailService {

    @Resource(name = "java:jboss/mail/gmail")
    private Session mailSession;

    @Asynchronous
    public void sendMail(final User user, final String path) {
        try {
            final Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
            cfg.setDirectoryForTemplateLoading(new File(path + "/WEB-INF/classes/com/gihans/gs/emails/"));
            final Template template = cfg.getTemplate("welcome.ftl");
            final MimeMessage m = new MimeMessage(mailSession);
            final InternetAddress[] to = new InternetAddress[]{
                new InternetAddress(user.getFirstName() + " " + user.getLastName() + "<" + user.getEmail() + ">")
            };
            m.setFrom("Gihans Textile <gihans.textile@gmail.com>");
            m.setRecipients(Message.RecipientType.TO, to);
            m.setSubject("[gshoping] Welcome to Gihans E Shoping (gshoping)");
            m.setSentDate(new java.util.Date());
            final Map<String, Object> params = new HashMap<>();
            params.put("displayName", user.getDisplayName());
            params.put("url", "http://www.gshopping.lk/rest/user/activate?uuid=" + user.getUuid());
            final StringWriter sw = new StringWriter();
            template.process(params, sw);
            m.setText(sw.toString(), "utf-8", "html");
            Transport.send(m);
        } catch (IOException | MessagingException | TemplateException ex) {
            Logger.getLogger(MailService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
