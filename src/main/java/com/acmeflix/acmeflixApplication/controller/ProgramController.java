package com.acmeflix.acmeflixApplication.controller;

import com.acmeflix.acmeflixApplication.base.BaseMapper;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
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

   /* @GetMapping(params = "serial")
    public ResponseEntity<ApiResponse<ProgramResource>> findByTitle(@RequestParam String title) {
        final ProgramResource programResource = getMapper().toResource(programService.findByTitle(title));
        return ResponseEntity.ok(ApiResponse.<ProgramResource>builder().data(programResource).build());
    }

    @GetMapping(params = "title", headers = {"filter", "api-v"})
    public ResponseEntity<ApiResponse<JsonNode>> findByTitleFiltered(@RequestParam String title,
                                                                      @RequestHeader(value = "filter", defaultValue = "rating") String filter,
                                                                      @RequestHeader(value = "api-v", defaultValue = "1") Integer apiVersion) {
        final ProgramResource programResource = getMapper().toResource(programService.findByTitle(title));

        // If you define API version 2, you get to select the fields excluded
        if (apiVersion == 2) {
            //@formatter:off

            // Get rid of spaces
            Set<String> filterFields = Arrays.stream(filter.split(","))
                    .map(String::trim)
                    .collect(Collectors.toSet());
            return ResponseEntity.ok(ApiResponse.<JsonNode>builder()
                    .data(filterProgramAndConvertToString(programResource, filterFields))
                    .build());
            //@formatter:on
        }

        // If you define API version 1 or nothing, you will get the fixed attribute excluded
        return ResponseEntity.ok(
                ApiResponse.<JsonNode>builder().data(filterProgramAndConvertToString(programResource, Set.of("rating")))
                        .build());
    }
*/
    private JsonNode filterProgramAndConvertToString(ProgramResource programResource, Set<String> excludedAttributes) {
        /*
         * Method that filters a given program and returns it based on what attributes we have chosen to exclude
         * This may be considered a way of dynamic filtering without setting a "global filter" in a program
         * configuration
         */
        SimpleFilterProvider simpleFilterProvider = new SimpleFilterProvider().setFailOnUnknownId(false);
        FilterProvider filters = simpleFilterProvider.addFilter("program_filter",
                SimpleBeanPropertyFilter.serializeAllExcept(
                        excludedAttributes));

        // Local object mapper that will convert our program to a string based on the given filter
        ObjectMapper mapper = new ObjectMapper();
        mapper.setFilterProvider(filters);
        // We can also add automatic filters such as not showing nulls etc.
        //mapper.serializationInclusion(JsonInclude.Include.NON_NULL)
        ObjectWriter writer = mapper.writer();
        final String filteredJsonAsString;
        try {
            // Converting to string to filter out attributes we have excluded
            filteredJsonAsString = writer.writeValueAsString(programResource);
            return mapper.readTree(filteredJsonAsString);
        } catch (JsonProcessingException e) {
            // Will be caught by the exception handler which handles generic exceptions
            throw new RuntimeException("Json processing has failed");
        }
    }
}
