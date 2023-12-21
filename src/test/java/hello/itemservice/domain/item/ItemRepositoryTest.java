package hello.itemservice.domain.item;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        Item item = new Item("itemA", 10000, 10);

        Item savedItem = itemRepository.save(item);

        Item findItem = itemRepository.findByID(item.getId());
        assertThat(findItem).isEqualTo(savedItem);
    }

    @Test
    void findAll() {
        Item item1 = new Item("item1", 10000, 10);
        Item item2 = new Item("item2", 20000, 20);
        itemRepository.save(item1);
        itemRepository.save(item2);

        List<Item> items = itemRepository.findAll();

        assertThat(items.size()).isEqualTo(2);
        assertThat(items).contains(item1, item2);
    }

    @Test
    void updateItem() {
        Item item = new Item("item1", 10000, 10);
        Item saveItem = itemRepository.save(item);
        Long itemId = saveItem.getId();

        Item updateParam = new Item("item2", 20000, 20);
        itemRepository.update(itemId, updateParam);

        Item findItem = itemRepository.findByID(itemId);
        assertThat(findItem.getItemName()).isEqualTo(updateParam.getItemName());
        assertThat(findItem.getPrice()).isEqualTo(updateParam.getPrice());
        assertThat(findItem.getQuantity()).isEqualTo(updateParam.getQuantity());
    }
}
