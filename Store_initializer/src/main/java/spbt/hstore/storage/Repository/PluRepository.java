package spbt.hstore.storage.Repository;

import spbt.hstore.storage.models.enums.ClothesType;
import spbt.hstore.storage.models.PLU;

import org.springframework.data.jpa.repository.JpaRepository;
import spbt.hstore.storage.models.enums.PLUSize;

import java.util.List;

public interface PluRepository extends JpaRepository<PLU, Long> {


    List<PLU> findAllByType(ClothesType type);
    List<PLU> findAllBySize(PLUSize size);
    List<PLU> findAllByStore_Id(Long id);

    void deleteById(Long id);


//    List<PLU> findByType(String type); // Как привязать Enum?
//    List<PLU> findBySize(String size);



}
