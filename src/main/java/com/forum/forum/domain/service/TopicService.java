package com.forum.forum.domain.service;

import com.forum.forum.controllers.topic.dao.TopicListData;
import com.forum.forum.controllers.topic.dto.CreateTopicDTO;
import com.forum.forum.controllers.topic.dto.UpdateTopicDTO;
import com.forum.forum.core.entities.Topic;
import com.forum.forum.core.repositories.TopicMapper;
import com.forum.forum.core.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private TopicRepository repository;

    @Autowired(required=true)
    private TopicMapper topicMapper;

    public void createTopic(CreateTopicDTO dto) {
        this.repository.save(topicMapper.createTopicDtoToEntity(dto));
    }

    public Topic findTopicById (Long id){
        return this.repository.findById(id).orElseThrow();
    }

    public Page<TopicListData> topicList (Pageable pagination) {
        return this.repository.findAll(pagination).map(TopicListData::new);
    }

    public void updateTopic (UpdateTopicDTO dto) {
        Topic topic = this.topicMapper.updateTopicDtoToEntity(dto);
        this.repository.save(topic);

    }

    public void deleteTopic (Long id) {
        Topic topic = this.repository.findById(id).orElseThrow();
        this.repository.deleteById(topic.getId());
    }


}
