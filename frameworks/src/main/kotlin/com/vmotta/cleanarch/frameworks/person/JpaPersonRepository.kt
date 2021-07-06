package com.vmotta.cleanarch.frameworks.person

import com.vmotta.cleanarch.entities.person.Person
import com.vmotta.cleanarch.entities.person.PersonRepository
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.UUID
import javax.inject.Singleton

@Repository
interface PersonRepositoryInterface : JpaRepository<Person, UUID>

@Singleton
class JpaPersonRepository(
    private val springPersonRepository: PersonRepositoryInterface
) : PersonRepository {
    override fun save(person: Person): Person {
        return springPersonRepository.save(person)
    }

    override fun update(person: Person): Person {
        return springPersonRepository.update(person)
    }

    override fun delete(person: Person) {
        return springPersonRepository.delete(person)
    }

    override fun findById(id: UUID): Person? {
        return springPersonRepository.findById(id).orElse(null)
    }

    override fun findAll(): List<Person> {
        return springPersonRepository.findAll()
    }
}