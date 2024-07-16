package com.forum.forum.controllers.topic.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateTopicDTO (

    @NotBlank
    String title,
    String description
) {}
