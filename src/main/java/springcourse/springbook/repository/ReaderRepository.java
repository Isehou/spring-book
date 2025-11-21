package springcourse.springbook.repository;

import lombok.Locked;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import springcourse.springbook.model.Reader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ReaderRepository {
    private final Map<Integer, Reader> readers = new HashMap<>();

    public Reader save(Reader reader) {
        return readers.put(reader.getId(), reader);
    }

    public List<Reader> findAll() {
        return new ArrayList<>(readers.values());
    }

    public Reader findById(int id) {
        return readers.get(id);
    }
}
