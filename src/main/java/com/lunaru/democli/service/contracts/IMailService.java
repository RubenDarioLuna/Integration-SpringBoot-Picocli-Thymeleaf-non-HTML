package com.lunaru.democli.service.contracts;

import com.lunaru.democli.common.entities.Mail;
import com.lunaru.democli.common.exceptions.SendMailException;

/**
 * *
 *
 * @author ruben
 * @version 1.0
 * @since 3/1/2021
 */
public interface IMailService
{
    void sendMessage( Mail mail ) throws SendMailException;
}
