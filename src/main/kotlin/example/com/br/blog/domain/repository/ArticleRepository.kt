package example.com.br.blog.domain.repository

import example.com.br.blog.domain.Article

interface ArticleRepository {
    fun save(article: Article)
}