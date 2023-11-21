package example.com.br.blog.domain

import java.util.*

data class Article(
    val id: UUID,
    val title: String,
    val body: String
) {
    companion object {
        fun create(id: String, title: String, body: String): Article {
            if(title.length > 100) throw BunessRulesException("title cannot contains more than 100 chars")
            return Article(UUID.fromString(id),title,body)
        }
    }


}