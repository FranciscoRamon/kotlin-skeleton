package example.com.br.blog.presenters.http.request

import kotlinx.serialization.Serializable
import org.valiktor.functions.hasSize
import org.valiktor.functions.isNotBlank
import org.valiktor.validate

@Serializable
data class CreateArticleRequest(
    val title: String,
    val body: String
){
    init {
        validate(this){
            validate(CreateArticleRequest::title).hasSize(min=3, max=100)
            validate(CreateArticleRequest::body).isNotBlank()
        }
    }
}
