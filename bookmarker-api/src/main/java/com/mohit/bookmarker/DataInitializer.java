//package com.mohit.bookmarker;
//
//import com.mohit.bookmarker.domain.BookMark;
//import com.mohit.bookmarker.domain.BookmarkRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.time.Instant;
//
//@Component
//@RequiredArgsConstructor
//public class DataInitializer implements CommandLineRunner {
//    private final BookmarkRepository repository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        repository.save(new BookMark(null,"SpringLabs", "Spring Framework", Instant.now()));
//        repository.save(new BookMark(null,"MohitLabs", "Spring Boot", Instant.now()));
//        repository.save(new BookMark(null,"JavaLabs", "Java 8", Instant.now()));
//        repository.save(new BookMark(null, "KotlinLabs", "Kotlin", Instant.now()));
//        repository.save(new BookMark(null, "MicronautLabs", "Micronaut", Instant.now()));
//        repository.save(new BookMark(null, "QuarkusLabs", "Quarkus", Instant.now()));
//        repository.save(new BookMark(null, "DockerLabs", "Docker", Instant.now()));
//        repository.save(new BookMark(null, "KubernetesLabs", "Kubernetes", Instant.now()));
//        repository.save(new BookMark(null, "AWSLabs", "AWS", Instant.now()));
//        repository.save(new BookMark(null, "AzureLabs", "Azure", Instant.now()));
//        repository.save(new BookMark(null, "GCP", "Google Cloud Platform", Instant.now()));
//        repository.save(new BookMark(null, "JenkinsLabs", "Jenkins", Instant.now()));
//    }
//}
