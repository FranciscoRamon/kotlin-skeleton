package example.com.br.blog.application.article

interface ArticleCommandService {

    fun handler(command: CreateArticleCommand)
    fun handler(command: UpdateArticleCommand)

}