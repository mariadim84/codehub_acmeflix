package com.acmeflix.acmeflixApplication.mapper;
import com.acmeflix.acmeflixApplication.base.BaseMapper;
import com.acmeflix.acmeflixApplication.domain.Program;
import com.acmeflix.acmeflixApplication.resource.ProgramResource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProgramMapper  extends BaseMapper<Program, ProgramResource> {

    }
