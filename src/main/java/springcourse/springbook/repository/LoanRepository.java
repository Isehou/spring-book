package springcourse.springbook.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import springcourse.springbook.model.Loan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
@Slf4j
public class LoanRepository {
    private final Map<Integer, Loan> loans = new HashMap<>();

    public Loan save(Loan loan) {
        return loans.put(loan.getId(), loan);
    }

    public Loan findById(int id) {
        return loans.get(id);
    }

    public List<Loan> findAll() {
        return new ArrayList<>(loans.values());
    }
}
