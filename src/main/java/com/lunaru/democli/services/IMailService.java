package com.lunaru.democli.services;

import java.util.List;

public interface IMailService
{
    void sendMessage( List<String> to, String subject, String text );
}
