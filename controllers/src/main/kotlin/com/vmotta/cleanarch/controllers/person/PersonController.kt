package com.vmotta.cleanarch.controllers.person

import com.vmotta.cleanarch.usecases.person.CreatePersonInteractor
import com.vmotta.cleanarch.usecases.person.DeletePersonInteractor
import com.vmotta.cleanarch.usecases.person.FindAllPersonInteractor
import com.vmotta.cleanarch.usecases.person.FindPersonByIdInteractor
import com.vmotta.cleanarch.usecases.person.UpdatePersonInteractor
import com.vmotta.cleanarch.usecases.person.request.CreatePersonRequest
import com.vmotta.cleanarch.usecases.person.request.UpdatePersonRequest
import com.vmotta.cleanarch.usecases.person.response.PersonResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import io.micronaut.http.annotation.Put
import java.util.UUID

@Controller("/people")
class PersonController(
    private val createPersonInteractor: CreatePersonInteractor,
    private val updatePersonInteractor: UpdatePersonInteractor,
    private val deletePersonInteractor: DeletePersonInteractor,
    private val findAllPersonInteractor: FindAllPersonInteractor,
    private val findPersonByIdInteractor: FindPersonByIdInteractor
) {
    @Post("/")
    fun save(@Body request: CreatePersonRequest): PersonResponse {
        return createPersonInteractor.execute(request)
    }

    @Put("/")
    fun update(@Body request: UpdatePersonRequest): PersonResponse {
        return updatePersonInteractor.execute(request)
    }

    @Delete("/{id}")
    fun delete(@PathVariable("id") id: UUID) {
        return deletePersonInteractor.execute(id)
    }

    @Get("/")
    @Produces(MediaType.APPLICATION_JSON) // <3>
    fun findAll(): List<PersonResponse> {
        return findAllPersonInteractor.execute()
    }

    @Get("/{id}")
    fun findById(@PathVariable("id") id: UUID): PersonResponse {
        return findPersonByIdInteractor.execute(id)
    }
}