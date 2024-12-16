package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import java.util.List;
import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item) {
        //item은 jpa에 저장하기 전까지 id값이 없다.
        //id값이 없다는 것의 뜻은? => 완전히 새로 생성한 객체이다.
        if (item.getId()==null) {
            em.persist(item); //완전히 신규로 등록
        }else {
            em.merge(item); //이미 db에 등록된 것을 가져와서 update하는 것과 비슷하다.
        }
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class).getResultList();
        //단건 찾는 것은 find를 쓰면 되지만 여러 개를 찾는 것은 jpa를 작성해야 한다.
    }
}
