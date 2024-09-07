package com.mohit.bookmarker.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookmarkRepository extends JpaRepository<BookMark, Long> {

    @Query("SELECT new com.mohit.bookmarker.domain.BookmarkDTO(b.id, b.title, b.url, b.createdAt) FROM BookMark b")
    Page<BookmarkDTO> findAllBookMarks(Pageable pageable);
}
