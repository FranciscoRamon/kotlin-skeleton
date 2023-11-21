package example.com.br.blog.infra

import org.koin.dsl.module
import example.com.br.blog.application.article.ArticleCommandService
import example.com.br.blog.application.article.ArticleCommandServiceImpl
import example.com.br.blog.domain.repository.ArticleRepository
import example.com.br.blog.domain.repository.ArticleRepositoryImpl

val blogModule = module {
    single<ArticleRepository> { ArticleRepositoryImpl() }
    single<ArticleCommandService> { ArticleCommandServiceImpl(get()) }
}