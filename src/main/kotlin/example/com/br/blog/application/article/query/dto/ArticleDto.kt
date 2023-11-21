package example.com.br.blog.application.article.query.dto

import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class ArticleDto(val id: String, val title: String, val body: String)
