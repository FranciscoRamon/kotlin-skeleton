package example.com.br.blog.application.article.command

import example.com.br.blog.domain.Article
import example.com.br.blog.domain.repository.ArticleRepository

class ArticleCommandHandlerImpl(
    private val repository: ArticleRepository
): ArticleCommandHandler {
    override fun handle(command: CreateArticleCommand) {
        val article = Article.create(command.id, command.title, command.body)
        repository.addArticle(article)
    }

    override fun handle(command: UpdateArticleCommand) {

    }


}