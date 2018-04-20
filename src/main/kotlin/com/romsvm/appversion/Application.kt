package com.romsvm.appversion

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication
class Application : SpringBootServletInitializer() {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<Application>(*args)
        }
    }

    override fun configure(builder: SpringApplicationBuilder): SpringApplicationBuilder {
        return builder.sources(Application::class.java)
    }
}