package com.forum.forum.core.repositories;

import com.forum.forum.controllers.topic.dto.CreateTopicDTO;
import com.forum.forum.controllers.topic.dto.UpdateTopicDTO;
import com.forum.forum.core.entities.Topic;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface TopicMapper {

    Topic createTopicDtoToEntity(CreateTopicDTO dto);
    Topic updateTopicDtoToEntity(UpdateTopicDTO dto);
}
