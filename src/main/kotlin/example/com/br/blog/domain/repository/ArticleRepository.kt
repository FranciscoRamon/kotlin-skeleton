package example.com.br.blog.domain.repository

import example.com.br.blog.domain.Article
import java.util.*

interface ArticleRepository {
    fun getAllArticles(limit: Int): List<Article>
    fun getArticleById(id: UUID): Article?
    fun addArticle(article: Article)
    fun updateArticle(article: Article)
    fun deleteArticle(id: UUID)
}