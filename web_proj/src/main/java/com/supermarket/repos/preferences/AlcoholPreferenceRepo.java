package com.supermarket.repos.preferences;

import com.supermarket.domain.preferences.AlcoholPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlcoholPreferenceRepo extends JpaRepository<AlcoholPreference, Long> {
}
