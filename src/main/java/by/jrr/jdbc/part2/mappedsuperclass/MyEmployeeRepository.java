package by.jrr.jdbc.part2.mappedsuperclass;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyEmployeeRepository extends JpaRepository<MyEmployee, Long> {
}
