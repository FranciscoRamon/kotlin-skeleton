package example.com.br.blog.infra.database.entity

import example.com.br.blog.domain.Article
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import java.util.*

object ArticleTable : UUIDTable("article") {
    val title = varchar("title", 255)
    val body = text("body")

}

class ArticleEntity(id: EntityID<UUID>) : Entity<UUID>(id) {
    companion object : EntityClass<UUID, ArticleEntity>(ArticleTable)

    var title by ArticleTable.title
    var body by ArticleTable.body

    fun toArticle(): Article {
        return Article(id.value, title, body)
    }
}