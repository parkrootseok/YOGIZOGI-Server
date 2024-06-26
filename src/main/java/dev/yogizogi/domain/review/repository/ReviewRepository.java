package dev.yogizogi.domain.review.repository;

import dev.yogizogi.domain.review.model.entity.Review;
import dev.yogizogi.domain.user.model.entity.User;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, UUID> {

    Optional<List<Review>> findAllByUser(User user);

}
