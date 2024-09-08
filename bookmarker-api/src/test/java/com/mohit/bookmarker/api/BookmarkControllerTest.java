package com.mohit.bookmarker.api;

import com.mohit.bookmarker.domain.BookMark;
import com.mohit.bookmarker.domain.BookmarkRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:tc:postgresql:16-alpine:///demo"
})
public class BookmarkControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookmarkRepository repository;

    private List<BookMark> bookmarks;

    @BeforeEach
    void setUp() {
        repository.deleteAllInBatch();

        bookmarks = new ArrayList<>();

        bookmarks.add(new BookMark(null, "MohitLabs", "https://mohitlabs.in", Instant.now()));
        bookmarks.add(new BookMark(null, "SpringBlog", "https://spring.io/blog", Instant.now()));
        bookmarks.add(new BookMark(null, "Quarkus", "https://quarkus.io/", Instant.now()));
        bookmarks.add(new BookMark(null, "Micronaut", "https://micronaut.io/", Instant.now()));
        bookmarks.add(new BookMark(null, "JOOQ", "https://www.jooq.org/", Instant.now()));
        bookmarks.add(new BookMark(null, "VladMihalcea", "https://vladmihalcea.com", Instant.now()));
        bookmarks.add(new BookMark(null, "Thoughts On Java", "https://thorben-janssen.com/", Instant.now()));
        bookmarks.add(new BookMark(null, "DZone", "https://dzone.com/", Instant.now()));
        bookmarks.add(new BookMark(null, "DevOpsBookmarks", "http://www.devopsbookmarks.com/", Instant.now()));
        bookmarks.add(new BookMark(null, "Kubernetes docs", "https://kubernetes.io/docs/home/", Instant.now()));
        bookmarks.add(new BookMark(null, "Expressjs", "https://expressjs.com/", Instant.now()));
        bookmarks.add(new BookMark(null, "Marcobehler", "https://www.marcobehler.com", Instant.now()));
        bookmarks.add(new BookMark(null, "baeldung", "https://www.baeldung.com", Instant.now()));
        bookmarks.add(new BookMark(null, "devglan", "https://www.devglan.com", Instant.now()));
        bookmarks.add(new BookMark(null, "linuxize", "https://linuxize.com", Instant.now()));

        repository.saveAll(bookmarks);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 15, 2, 1, true, false, true, false",
            "2, 15, 2, 2, false, true, false, true"
    })
    void shouldGetBookmarks(int pageNo, int totalElements, int totalPages, int currentPage,
                            boolean isFirst, boolean isLast, boolean hasNext, boolean hasPrevious) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/bookmarks?page="+pageNo))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data").isArray())
                .andExpect(jsonPath("$.totalElements", equalTo(totalElements)))
                .andExpect(jsonPath("$.totalPages", equalTo(totalPages)))
                .andExpect(jsonPath("$.currentPage", equalTo(currentPage)))
                .andExpect(jsonPath("$.isFirst", equalTo(isFirst)))
                .andExpect(jsonPath("$.isLast", equalTo(isLast)))
                .andExpect(jsonPath("$.hasNext", equalTo(hasNext)))
                .andExpect(jsonPath("$.hasPrevious", equalTo(hasPrevious)));
    }

    @Test
    void shouldCreateBookmarkSuccessFully() throws Exception {
        mockMvc.perform(post("/api/bookmarks")
                .contentType("application/json")
                .content("{\"title\": \"SpringBoot\", \"url\": \"https://spring.io/projects/spring-boot\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.title", equalTo("SpringBoot")))
                .andExpect(jsonPath("$.url", equalTo("https://spring.io/projects/spring-boot")));
    }

    @Test
    void shouldFailToCreateBookmarkWhenUrlIsNotPresent() throws Exception {
        mockMvc.perform(
                        post("/api/bookmarks")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("""
                {
                    "title": "MohitLabs Blog"
                }
                """)
                )
                .andExpect(status().isBadRequest())
                .andExpect(header().string("Content-Type", is("application/problem+json")))
                .andExpect(jsonPath("$.type", is("https://zalando.github.io/problem/constraint-violation")))
                .andExpect(jsonPath("$.title", is("Constraint Violation")))
                .andExpect(jsonPath("$.status", is(400)))
                .andExpect(jsonPath("$.violations", hasSize(1)))
                .andExpect(jsonPath("$.violations[0].field", is("url")))
                .andExpect(jsonPath("$.violations[0].message", is("Url should not be empty")))
                .andReturn();
    }

}
