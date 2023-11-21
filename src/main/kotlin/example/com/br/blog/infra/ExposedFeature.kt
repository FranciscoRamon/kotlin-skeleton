package example.com.br.blog.infra

import example.com.br.blog.infra.database.entity.ArticleTable
import io.ktor.server.application.*
import io.ktor.server.config.*
import io.ktor.util.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import org.slf4j.LoggerFactory

val logger = LoggerFactory.getLogger("ExposedFeature")


class ExposedModule(private val config: ApplicationConfig) {
    fun init() {

        logger.info("Initializing Exposed")

        Database.connect(
            url = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;",
            driver = "org.h2.Driver",
            user = "sa",
            password = ""
        )

        transaction {
            SchemaUtils.create(ArticleTable)
        }
    }
}

object ExposedFeature : BaseApplicationPlugin<Application, ExposedModule, ExposedModule> {
    override val key = AttributeKey<ExposedModule>("exposed")

    override fun install(pipeline: Application, configure: ExposedModule.() -> Unit): ExposedModule {
        val module = ExposedModule(pipeline.environment.config).apply(configure)
        pipeline.environment.monitor.subscribe(ApplicationStarted) {
            module.init()
        }
        return module
    }
}
