package example.com.br.blog.application.article.query

import example.com.br.blog.application.article.query.dto.ArticleDto
import example.com.br.blog.domain.Article

interface ArticleQueryHandler{
    fun handle(query: GetAllArticlesQuery): List<ArticleDto>
}
