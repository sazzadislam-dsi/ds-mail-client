package com.dsinnovators.mailclient.service.mail

import com.dsinnovators.mailclient.model.Email

interface MailService {
    fun getMail(startIndex: Int, endIndex: Int): List<Email>
}