package example.com.br.plugins

import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin
import example.com.br.blog.infra.blogModule
import example.com.br.module

fun Application.configureKoin() {
    install(Koin) {
        modules(blogModule)
    }
}