package example.com.br.blog.application.article.command

interface ArticleCommandHandler {
    fun handle(command: CreateArticleCommand)
    fun handle(command: UpdateArticleCommand)

}