package springcourse.springbook.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import springcourse.springbook.repository.BookRepository;
import springcourse.springbook.repository.ReaderRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReaderService {
    private final ReaderRepository repository;



}
