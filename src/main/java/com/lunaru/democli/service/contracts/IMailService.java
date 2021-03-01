package com.lunaru.democli.service.contracts;

import com.lunaru.democli.common.entities.Mail;
import com.lunaru.democli.common.exceptions.SendMailException;

public interface IMailService
{
    void sendMessage( Mail mail ) throws SendMailException;
}
