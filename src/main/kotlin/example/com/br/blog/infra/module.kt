package example.com.br.blog.infra

import example.com.br.blog.application.article.command.ArticleCommandHandler
import example.com.br.blog.application.article.command.ArticleCommandHandlerImpl
import example.com.br.blog.application.article.query.ArticleQueryHandler
import example.com.br.blog.application.article.query.ArticleQueryHandlerImpl
import example.com.br.blog.domain.repository.ArticleRepository
import example.com.br.blog.infra.database.repository.ExplosedArticleRepository
import org.koin.dsl.module

val blogModule = module {

    // repositories
    single<ArticleRepository> { ExplosedArticleRepository() }

    // command modules
    single<ArticleCommandHandler> { ArticleCommandHandlerImpl(get()) }

    // query modules
    single<ArticleQueryHandler> { ArticleQueryHandlerImpl(get()) }
}