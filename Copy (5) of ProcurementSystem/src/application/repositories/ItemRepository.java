package application.repositories;

import java.util.List;

import application.models.ItemCategory;

public interface ItemRepository {
	List<ItemCategory> getCategories();
}
