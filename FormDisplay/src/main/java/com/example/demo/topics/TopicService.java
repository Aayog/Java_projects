package com.example.demo.topics;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
//	private List<Topics> topics = new ArrayList<>(Arrays.asList(
//			new Topics("spring","Spring Framework","Spring Boot"),
//			new Topics("java","Java EE","Java Enterprise"),
//			new Topics("javascript","JavaScript","JavaScript Web interactiveness")
//			));
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topics> getAllTopics(){
		List<Topics> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics :: add);;
		return topics;
	}
	public Topics getTopicByID(int id) {
		return topicRepository.findById(id).get();
	}
	public void addTopic(Topics topic) {
		topicRepository.save(topic);
	}
	public void updateTopic(int id, Topics topic) {
		topicRepository.save(topic);
	}
	public void deleteTopic(int id) {
		topicRepository.deleteById(id);
	}
}
