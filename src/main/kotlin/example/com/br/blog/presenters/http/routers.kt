package example.com.br.blog.presenters.http

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import example.com.br.blog.application.article.ArticleCommandService
import example.com.br.blog.application.article.CreateArticleCommand
import example.com.br.blog.presenters.http.request.CreateArticleRequest
import java.util.*

fun Route.blogRouters() {

    val commandHandler: ArticleCommandService by inject()

    get {
        call.respond(":D")
    }

    post {
        val request  = call.receive<CreateArticleRequest>()
        val command = CreateArticleCommand(UUID.randomUUID().toString(),request.title,request.body)
        commandHandler.handler(command)
    }
}