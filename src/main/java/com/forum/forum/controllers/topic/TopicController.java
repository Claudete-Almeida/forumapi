package com.forum.forum.controllers.topic;

import com.forum.forum.controllers.topic.dao.TopicListData;
import com.forum.forum.controllers.topic.dto.CreateTopicDTO;
import com.forum.forum.controllers.topic.dto.UpdateTopicDTO;
import com.forum.forum.core.entities.Topic;
import com.forum.forum.domain.service.TopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicController {

    @Autowired
    private TopicService service;

    @PostMapping
    public ResponseEntity createTopic (@RequestBody @Valid CreateTopicDTO dto) {
        try {
            this.service.createTopic(dto);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e)  {
            return new ResponseEntity("Falha ao tentar criar tópico!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topic> findTopic(@PathVariable Long id) {
        try {
            Topic topic = this.service.findTopicById(id);
            return new ResponseEntity(topic, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Tópico não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<Page<TopicListData>> listTopics(@PageableDefault(size = 10, sort = {"title"}) Pageable pagination) {
        Page<TopicListData> topicList = this.service.topicList(pagination);
        return new ResponseEntity(topicList, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateTopic(@RequestBody @Valid UpdateTopicDTO dto) {
        try {
            this.service.updateTopic(dto);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity("Tópico não encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTopic (@PathVariable Long id) {
        try {
            this.service.deleteTopic(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Tópico não encontrado", HttpStatus.NOT_FOUND);
        }
    }

}
