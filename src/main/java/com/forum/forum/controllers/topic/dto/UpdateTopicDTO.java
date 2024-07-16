package com.forum.forum.controllers.topic.dto;

import jakarta.validation.constraints.NotNull;

public record UpdateTopicDTO (
        @NotNull
        Long id,

        String title,
        String description
) {}
