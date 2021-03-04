package com.lunaru.democli.service.implementation;

import com.lunaru.democli.common.entities.Mail;
import com.lunaru.democli.common.exceptions.SendMailException;
import com.lunaru.democli.common.utilities.Properties;
import com.lunaru.democli.service.contracts.IMailService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * *
 *
 * @author ruben
 * @version 1.0
 * @since 3/1/2021
 */
@Service( "MailService" )
public class MailService extends BaseService implements IMailService
{
    //#region Static Attributes
    private static final Logger LOGGER = LoggerFactory.getLogger( MailService.class );
    private static final String NOREPLY_ADDRESS = "noreply@picocli.info";
    //#endregion

    //#region Privates Attributes
    private final JavaMailSender _emailSender;
    //#endregion

    //#region Constructors
    /**
     * Class constructor.
     */
    public MailService( JavaMailSender emailSender )
    {
        //Autowiring
        this._emailSender = emailSender;
    }
    //#endregion

    //#region Public Methods
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

            //_emailSender.send( message );
        }
        catch ( MailException | MessagingException e)
        {
            throw new SendMailException( Properties.getProperty( "error.mailNotSent" ), e );
        }
        catch ( Exception e )
        {
            throw new SendMailException( Properties.getProperty( "error.mailGeneral" ),e );
        }
    }
    //#endregion
}
