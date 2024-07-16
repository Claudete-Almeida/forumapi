package com.forum.forum.controllers.topic.dao;

import com.forum.forum.core.entities.Topic;

public record TopicListData(
        Long id,
        String title,
        String description
) {
        public TopicListData(Topic topic){
                this(topic.getId(), topic.getTitle(), topic.getDescription());
        }
}
