package com.tunahan.market.repository.comment;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunahan.market.entities.comment.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{

}
