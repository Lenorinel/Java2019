package store.Repository;

import store.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {
    //Для сортировки списка от большего count к меньшему
    //Или лучше NativeQuery написать?
    //@Query(nativeQuery = true, value="SELECT * from stores_tab st ORDER BY st.count DESC"

    List<Store> findAllByOrderByCount();//??
    List<Store> findAllByCountGreaterThan(Integer count);

    //нужно два поиска, первый для инфо меню + 1-2 дня - открытие MainPage
    // второй для отображения списка магазинов с  ближайшего завоза - открытие StorePage
    //@Query(nativeQuery = true, value="SELECT * from stores_tab st ORDER BY st.date DESC"
   // List<Store> findAllByArrivalDateIsBefore(Date date);
    List<Store> findAllByArrivalDaysBefore(String date);
}
