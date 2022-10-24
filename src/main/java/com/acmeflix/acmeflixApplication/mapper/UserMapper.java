package com.acmeflix.acmeflixApplication.mapper;
import com.acmeflix.acmeflixApplication.base.BaseMapper;
import com.acmeflix.acmeflixApplication.domain.User;
import com.acmeflix.acmeflixApplication.resource.UserResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper  extends BaseMapper<User, UserResource> {

}
