package com.cisco.assignment.userservice.util;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.UUID;
import java.util.StringJoiner;

public class UserId {
    private UUID id;

    public UserId(UUID id) {
        this.id = id;
    }

    @JsonValue
    public UUID getId() {
        return id;
    }

    @JsonCreator
    public static UserId fromString(String id) {
        return new UserId(UUID.fromString(id));
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserId.class.getSimpleName() + "[", "]")
                .add(String.format("id=%s", id))
                .toString();
    }
}