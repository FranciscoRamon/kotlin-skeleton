package example.com.br.blog.infra.database.repository

import example.com.br.blog.domain.Article
import example.com.br.blog.domain.repository.ArticleRepository
import example.com.br.blog.infra.database.entity.ArticleEntity
import example.com.br.blog.infra.database.entity.ArticleTable
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*

class ExplosedArticleRepository: ArticleRepository {
    override fun getAllArticles(limit: Int): List<Article> {
        return transaction {
            ArticleEntity.all().toList().map(ArticleEntity::toArticle)
        }
    }

    override fun getArticleById(id: UUID): Article? {
        return transaction {
            ArticleEntity.findById(EntityID(id, ArticleTable))?.toArticle()
        }
    }

    override fun addArticle(article: Article) {
        transaction {
            ArticleEntity.new(UUID.randomUUID()) {
                fromArticle(article)
            }
        }
    }

    override fun updateArticle(article: Article) {
        transaction {
            val articleEntity = ArticleEntity.findById(EntityID(article.id, ArticleTable))
            articleEntity?.apply {
                fromArticle(article)
            }
        }
    }

    override fun deleteArticle(id: UUID) {
        transaction {
            ArticleEntity.findById(EntityID(id, ArticleTable))?.delete()
        }
    }

    private fun ArticleEntity.toArticle(): Article {
        return Article(id.value, title, body)
    }

    private fun ArticleEntity.fromArticle(article: Article) {
        title = article.title
        body = article.body
    }

}