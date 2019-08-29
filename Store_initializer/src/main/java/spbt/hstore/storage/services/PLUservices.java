package spbt.hstore.storage.services;

import spbt.hstore.storage.Forms.PLUForm;
import spbt.hstore.storage.dto.pluDto;
import spbt.hstore.storage.models.PLU;

import java.util.List;

public interface PLUservices {

    List<pluDto> getPlusByStoreId(Long storeId);

    List<pluDto> getAllPlus();

    void add(Long storeId, PLUForm plu);

    void add(PLUForm plu);

    void delete(Long id);

    void update(Long id, PLUForm form);

    void changeStatus(Long id);
}
