package repository;

import entity.UserPaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserPaymentStatusRepository extends JpaRepository<UserPaymentStatus,Long> {

    Optional<UserPaymentStatus> findByUserId(Long userId);
}
