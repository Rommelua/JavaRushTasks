package com.javarush.task.task40.task4011;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class EMail {
    public static void main(String[] args) throws MessagingException {
        Properties props = new Properties();

        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host", "smtp.ukr.net");
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtp.sendpartial", "true");

        Session session = Session.getDefaultInstance(props);
        //создаем сообщение
        MimeMessage message = new MimeMessage(session);
        //устанавливаем тему письма
        message.setSubject("тестовое письмо!");
        //добавляем текст письма
        message.setText("Asta la vista, baby!");
        //указываем получателя
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("rommelua2@gmail.com"));
        //указываем дату отправления
        message.setSentDate(new Date());
        message.setFrom(new InternetAddress("rommel@ukr.net"));

        //логин и пароль gmail пользователя
        String userLogin = "rommel@ukr.net";
        String userPassword = "ALq5XM0reyAGoYgn";

        //авторизуемся на сервере:
        Transport transport = session.getTransport();
        transport.connect("smtp.ukr.net", 465, userLogin, userPassword);

        //отправляем сообщение:
        transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
    }
}
