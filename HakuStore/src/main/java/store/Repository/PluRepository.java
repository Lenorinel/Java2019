package store.Repository;

import store.models.PLU;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PluRepository extends JpaRepository<PLU, Long> {


    List<PLU> findAllByType(String type);
    List<PLU> findAllBySize(String type);


//    List<PLU> findByType(String type); // Как привязать Enum?
//    List<PLU> findBySize(String size);



}
