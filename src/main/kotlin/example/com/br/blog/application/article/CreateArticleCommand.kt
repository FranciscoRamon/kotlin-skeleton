package example.com.br.blog.application.article

data class CreateArticleCommand(
    val id: String,
    val title: String,
    val body: String
)