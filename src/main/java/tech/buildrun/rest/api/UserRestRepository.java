package tech.buildrun.rest.api;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import tech.buildrun.rest.entity.User;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(
    path = "users",
    collectionResourceRel = "users"
)
public interface UserRestRepository extends
        CrudRepository<User, UUID>,
        PagingAndSortingRepository<User, UUID> {

    List<User> findByName(@Param("name") String name);

    @Override
    @RestResource(exported = true)
    void deleteById(UUID uuid);
}
