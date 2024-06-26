package dev.yogizogi.domain.review.repository;

import dev.yogizogi.domain.menu.model.entity.Menu;
import dev.yogizogi.domain.review.model.entity.MenuReview;
import dev.yogizogi.domain.review.model.entity.Review;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuReviewRepository extends JpaRepository<MenuReview, Long> {

    Optional<List<MenuReview>> findByMenu(Menu menu);

    Optional<List<MenuReview>> findAllByReview(Review review);

    Optional<MenuReview> findById(Long id);

}
