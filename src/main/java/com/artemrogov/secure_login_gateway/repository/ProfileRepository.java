package com.artemrogov.secure_login_gateway.repository;

import com.artemrogov.secure_login_gateway.domain.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, UUID> {
}
