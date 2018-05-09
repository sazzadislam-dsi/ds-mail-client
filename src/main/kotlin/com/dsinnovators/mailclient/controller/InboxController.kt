package com.dsinnovators.mailclient.controller

import com.dsinnovators.mailclient.service.mail.MailService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping


@Controller
class InboxController(private val mailService: MailService) {
    @RequestMapping("/inbox/{start_page}")
    fun home(@PathVariable start_page: Int,model: Model): String {
        model.addAttribute(
                "mailList", mailService.getMail(start_page, start_page + 5)
        )
        model.addAttribute("next", start_page + 6)
        var previousPage = 1
        if (start_page >= 6) {
            previousPage = start_page - 5
        }
        model.addAttribute("previous", previousPage)
        return "inbox"
    }
}