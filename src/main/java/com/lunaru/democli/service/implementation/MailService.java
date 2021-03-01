package com.lunaru.democli.service.implementation;

import com.lunaru.democli.common.entities.Mail;
import com.lunaru.democli.common.exceptions.SendMailException;
import com.lunaru.democli.service.contracts.IMailService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service( "MailService" )
public class MailService implements IMailService
{
    private static final Logger LOGGER= LoggerFactory.getLogger( MailService.class );
    private static final String NOREPLY_ADDRESS = "noreply@picocli.info";

    private final Environment _properties;
    private final JavaMailSender _emailSender;

    public MailService( JavaMailSender emailSender, Environment properties )
    {
        LOGGER.debug( "Entering Constructor MailService" );
        //Autowiring
        this._properties = properties;
        this._emailSender = emailSender;

        LOGGER.debug( "Levering Constructor MailService" );
    }

    @Override
    public void sendMessage( Mail mail ) throws SendMailException
    {
        try
        {
            MimeMessage message = _emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper( message, true);

            //set data
            helper.setFrom( NOREPLY_ADDRESS );
            helper.setTo( mail.getTo() );
            helper.setSubject( mail.getSubject() );
            helper.setText( mail.getBody() );
            if( mail.getFile() != null && mail.getFile().exists() )
                helper.addAttachment( mail.getFile().getName(), mail.getFile() );

            _emailSender.send( message );

            /*LOGGER.info( _properties.getProperty( "logger.mailSent" ), mail.getTo(), mail.getSubject(),
                         mail.getBody() );*/
        }
        catch ( MailException | MessagingException e)
        {
            //LOGGER.error( _properties.getProperty( "error.mailNotSent" ), e );
            throw new SendMailException( _properties.getProperty( "error.mailNotSent" ), e );
        }
        catch ( Exception e )
        {
            //LOGGER.error( _properties.getProperty( "error.general" ), e );
            throw new SendMailException( _properties.getProperty( "error.mailGeneral" ),e );
        }
    }
}
