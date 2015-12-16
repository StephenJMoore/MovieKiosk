/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moviekiosk;
import java.util.*;
import java.io.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
//@author Stephen
public class Mailer {
    private String from = "stephenjmoore3@gmail.com";
    private String host = "smtp.gmail.com";
    private int port =465;
    private boolean login = true;
    private String username = "stephenjmoore3@gmail.com";
    private String password = "jak0Ablem42?";
    private Protocol protocol = Protocol.SMTPS;
    private boolean debug = true;
    
    public void mail(String toAddress, String subject, String body)
    {
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.ssl.enable", true);
        Authenticator authenticator = null;
        if(login)
        {
            props.put("mail.smtp.auth", true);
            authenticator = new Authenticator()
            {
                private PasswordAuthentication pa 
                        = new PasswordAuthentication(username, password);
                @Override
                public PasswordAuthentication getPasswordAuthentication()
                {
                    return pa;
                }
            };
        }
        
        Session s = Session.getInstance(props, authenticator);
        s.setDebug(debug);
        MimeMessage email = new MimeMessage(s);
        try{
            email.setFrom(new InternetAddress(from));
            email.setRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
            email.setSubject(subject);
            email.setSentDate(new Date());
            email.setText(body);
            Transport.send(email);
        } catch (MessagingException ex)
        {
            ex.printStackTrace();
        }
    }       
}
