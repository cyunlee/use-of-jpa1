package jpabook.jpashop.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class ItemServiceTest {
    @Autowired private ItemService itemService;
    @Autowired private ItemRepository itemRepository;

    @Test
    void 상품_등록() throws Exception {
        //given
        Book book = new Book();
        book.setAuthor("이시윤");
        book.setIsbn("테스트");

        //when
        itemService.saveItem(book);

        //then
        assertEquals(book, itemRepository.findOne(book.getId()));
    }

}