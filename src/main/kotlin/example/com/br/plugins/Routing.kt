package example.com.br.plugins

import io.ktor.server.application.*
import io.ktor.server.routing.*
import example.com.br.blog.presenters.http.blogRouters

fun Application.configureRouting() {
    routing {
        route("blog"){
            blogRouters()
        }
    }
}
