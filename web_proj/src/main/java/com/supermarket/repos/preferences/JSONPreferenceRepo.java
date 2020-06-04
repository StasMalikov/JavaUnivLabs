package com.supermarket.repos.preferences;

import com.supermarket.domain.preferences.JSONPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JSONPreferenceRepo extends JpaRepository<JSONPreference, String> {
   Optional<JSONPreference> findById(String id);
}
