package com.lunaru.democli.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service( "MailService" )
public class MailService implements IMailService
{
    private static final Logger LOGGER= LoggerFactory.getLogger( MailService.class );
    private static final String NOREPLY_ADDRESS = "noreply@picocli.info";

    private final JavaMailSender _emailSender;

    public MailService( JavaMailSender emailSender ) {
        this._emailSender = emailSender;

    }

    @Override
    public void sendMessage( List<String> to, String subject, String body )
    {
        try
        {
            SimpleMailMessage message = new SimpleMailMessage(); // create message
            message.setFrom( NOREPLY_ADDRESS );                    // compose message
            for ( String recipient : to )
            {
                message.setTo(recipient);
            }
            message.setSubject( subject );
            message.setText( body );
            _emailSender.send( message );                           // send message

            LOGGER.info("Mail to {} sent! Subject: {}, Body: {}", to, subject, body);
        }
        catch (MailException e)
        {
            e.printStackTrace();
        }
    }
}
