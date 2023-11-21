package example.com.br.plugins

import example.com.br.blog.infra.ExposedFeature
import io.ktor.server.application.*


fun Application.configureDatabases() {

    install(ExposedFeature) {
        init()
    }
}