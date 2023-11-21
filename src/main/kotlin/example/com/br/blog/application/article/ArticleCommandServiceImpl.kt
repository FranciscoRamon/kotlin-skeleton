package example.com.br.blog.application.article

import example.com.br.blog.domain.Article
import example.com.br.blog.domain.repository.ArticleRepository

class ArticleCommandServiceImpl(
    val repository: ArticleRepository
): ArticleCommandService {
    override fun handler(command: CreateArticleCommand) {
        val article = Article.create(command.id, command.title, command.body)
        repository.save(article)
    }

    override fun handler(command: UpdateArticleCommand) {

    }


}