package com.amudhan.jpatest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import com.amudhan.jpatest.model.Image;
import com.amudhan.jpatest.model.Item;

@ContextConfiguration("classpath:configuration/applicationContext-test.xml")
public class ItemTest extends AbstractTransactionalTestNGSpringContextTests{
	
	@PersistenceContext
	private EntityManager entityManager;
	private static final Logger logger = LoggerFactory.getLogger(ItemTest.class);
	
	@Test
	@Transactional
	public void getItems(){
		Item item = new Item();
		item.setName(RandomStringUtils.randomAlphabetic(10));
		item.getImages().add(new Image(RandomStringUtils.randomAlphabetic(10), RandomStringUtils.randomAlphabetic(10)));
		entityManager.persist(item);
		entityManager.flush();
		Item persistedItem = entityManager.find(Item.class, item.getId());
		logger.info(persistedItem.getId()+" "+persistedItem.getName());
		for(Image persistedImage : persistedItem.getImages()){
			logger.info("Image name: "+persistedImage.getFileName()+" Image title: "+persistedImage.getTitle());
		}
	}
	
}
