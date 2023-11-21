package example.com.br.blog.presenters.http

import example.com.br.blog.application.article.command.ArticleCommandHandler
import example.com.br.blog.application.article.command.CreateArticleCommand
import example.com.br.blog.application.article.query.ArticleQueryHandler
import example.com.br.blog.application.article.query.GetAllArticlesQuery
import example.com.br.blog.presenters.http.request.CreateArticleRequest
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import java.util.*

fun Route.blogRouters() {
    val commandHandler: ArticleCommandHandler by inject()
    val queryHandler: ArticleQueryHandler by inject()


    route("/articles") {

        get {
                try {
                    val query = GetAllArticlesQuery()
                    val articles = queryHandler.handle(query)
                    call.respond(articles)
                } catch (e: Exception) {
                    application.log.error("Erro ao obter artigos", e)
                    call.respondError(HttpStatusCode.InternalServerError, "Erro ao obter artigos")
                }
        }

        post {
            try {
                val request = call.receive<CreateArticleRequest>()
                val command = CreateArticleCommand(UUID.randomUUID().toString(), request.title, request.body)
                commandHandler.handle(command)

                application.log.info("Artigo criado com sucesso: ${command.id}")
                call.respond(HttpStatusCode.Created, "Artigo criado com sucesso")
            } catch (e: Exception) {
                application.log.error("Erro ao criar o artigo", e)
                call.respondError(HttpStatusCode.BadRequest, "Erro ao criar o artigo")
            }
        }
    }
}

suspend fun ApplicationCall.respondError(status: HttpStatusCode, message: String) {
    respond(status, mapOf("error" to message))
}
