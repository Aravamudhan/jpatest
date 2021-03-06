package com.amudhan.jpatest.model.associations.onetomany.cascaderemove;

import java.math.BigDecimal;

import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import com.amudhan.jpatest.AbstractItemTest;

public class CascadeRemoveTest extends AbstractItemTest {
	private long persistedItemId;

	@Test(priority = 1)
	@Transactional
	@Commit
	public void oneToManyCascadePersistItemInsert(){
		Item item = new Item();
		item.setItemName("Random item name");
		item.getBids().add(new Bid(new BigDecimal(500), item));
		item.getBids().add(new Bid(new BigDecimal(400), item));
		item.getBids().add(new Bid(new BigDecimal(300), item));
		item.getBids().add(new Bid(new BigDecimal(200), item));
		entityManager.persist(item);
		persistedItemId = item.getId();
	}
	
	@Test(priority = 2)
	@Transactional
	@Commit
	public void oneToManyCascadePersistItemRemove(){
		Item item = entityManager.find(Item.class, persistedItemId);
		if(item != null){
			logger.info("Removing the item");
			/* The item#bids variable is marked for CascadeType.PERSIST and CascadeType.REMOVE. 
			 * This triggers persistence of bids, when the item is persisted and the removal when the item is removed.
			 * */
			/* The main disadvantage of this method is, all the bids are loaded first, then deleted one by one, instead of deletion by a single query.
			 * The reason for this is hibernate does not know whether any other record holds a bid as a foreign key.*/
			entityManager.remove(item);
		}
	}

}
