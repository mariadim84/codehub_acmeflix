package com.acmeflix.acmeflixApplication.mapper;


import com.acmeflix.acmeflixApplication.base.BaseMapper;
import com.acmeflix.acmeflixApplication.domain.Account;
import com.acmeflix.acmeflixApplication.domain.Program;
import com.acmeflix.acmeflixApplication.resource.AccountResource;
import com.acmeflix.acmeflixApplication.resource.ProgramResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper  extends BaseMapper<Account, AccountResource> {

}
