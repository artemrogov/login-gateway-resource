package com.artemrogov.secure_login_gateway.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.util.UUID;

@Data
@RedisHash(value = "Profile")
@AllArgsConstructor
@NoArgsConstructor
public class Profile implements Serializable {

    @Id
    @Indexed
    private UUID guid;

    @Indexed
    private String login;

    @Indexed
    private String email;

    private String fullName;

    private boolean verify;

}
