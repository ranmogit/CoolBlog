package cn.lxt.domain;

import cn.lxt.bean.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "myuser")
public interface UserRepository extends CrudRepository<User,Integer> {
    User findUserByName(String name);
}
