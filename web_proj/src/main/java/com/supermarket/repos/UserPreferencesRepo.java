package com.supermarket.repos;

import com.supermarket.domain.UserPreferences;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPreferencesRepo extends JpaRepository<UserPreferences, Long> {
}
