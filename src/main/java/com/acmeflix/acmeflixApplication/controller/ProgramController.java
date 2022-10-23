package com.acmeflix.acmeflixApplication.controller;

import com.acmeflix.acmeflixApplication.base.BaseMapper;
import com.acmeflix.acmeflixApplication.domain.Category;
import com.acmeflix.acmeflixApplication.domain.Program;
import com.acmeflix.acmeflixApplication.mapper.ProgramMapper;
import com.acmeflix.acmeflixApplication.resource.ProgramResource;
import com.acmeflix.acmeflixApplication.service.BaseService;
import com.acmeflix.acmeflixApplication.service.ProgramService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/programs")
public class ProgramController extends AbstractController<Program, ProgramResource> {
    private final ProgramService programService;
    private final ProgramMapper programMapper;

    @Override
    public BaseService<Program, Long> getBaseService() {
        return programService;
    }

    @Override
    public BaseMapper<Program, ProgramResource> getMapper() {
        return programMapper;
    }

    @GetMapping(params = "title")
    public ResponseEntity<ApiResponse<ProgramResource>> findByTitle(@RequestParam String title) {
        return ResponseEntity.ok(ApiResponse.<ProgramResource>builder().data(getMapper().toResource(
                programService.findByTitle(title))).build());
    }
    @GetMapping(params = "category")
    public ResponseEntity<ApiResponse<List<ProgramResource>>> findByCategory(@RequestParam String category) {
        return ResponseEntity.ok(ApiResponse.<List<ProgramResource>>builder().data(getMapper().toResources(
                programService.findByCategory(category))).build());
    }

}
