package com.supermarket.repos.preferences;

import com.supermarket.domain.preferences.CaloriesPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaloriesPreferenceRepo extends JpaRepository<CaloriesPreference, Long> {
}
