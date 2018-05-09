package com.dsinnovators.mailclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MailClientApplication

fun main(args: Array<String>) {
    runApplication<MailClientApplication>(*args)
}
