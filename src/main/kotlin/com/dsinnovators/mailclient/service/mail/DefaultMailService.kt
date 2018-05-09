package com.dsinnovators.mailclient.service.mail

import com.dsinnovators.mailclient.model.Email
import org.springframework.stereotype.Service
import java.util.*
import javax.mail.Folder
import javax.mail.Session

@Service
class DefaultMailService : MailService {
    val emailAddress = "mail@gmmail.com"
    val password = "password"
    override fun getMail(startIndex: Int, endIndex: Int): List<Email> {
        try {
            val host = "pop.gmail.com"
            val properties = Properties()
            properties["mail.pop3.host"] = host
            properties["mail.pop3.port"] = "995"
            properties["mail.pop3.starttls.enable"] = "true"
            val emailSession = Session.getDefaultInstance(properties)
            //create the POP3 store object and connect with the pop server
            val store = emailSession.getStore("pop3s")
            store.connect(host, emailAddress, password)
            //create the folder object and open it
            val emailFolder = store.getFolder("INBOX")
            emailFolder.open(Folder.READ_ONLY)
            // retrieve the emailList from the folder in an array and print it
            val emailList = emailFolder.getMessages(1, 5).asSequence().map { Email(it.subject, "${it.from[0]}", it.sentDate) }.toList()
            //close the store and folder objects
            emailFolder.close(false)
            store.close()
            return emailList
        } catch (ex: Exception) {
            ex.printStackTrace()
            return emptyList()
        }
    }

}