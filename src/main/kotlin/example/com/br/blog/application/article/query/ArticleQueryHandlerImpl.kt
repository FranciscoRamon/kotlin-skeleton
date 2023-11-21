package example.com.br.blog.application.article.query

import example.com.br.blog.application.article.query.dto.ArticleDto
import example.com.br.blog.domain.repository.ArticleRepository

class ArticleQueryHandlerImpl(private val articleRepository: ArticleRepository) :
    ArticleQueryHandler{

    override fun handle(query: GetAllArticlesQuery): List<ArticleDto> {
        val articles = articleRepository.getAllArticles(query.limit)
        return articles.map { article ->
            ArticleDto(article.id.toString(), article.title, article.body)
        }
    }
}
