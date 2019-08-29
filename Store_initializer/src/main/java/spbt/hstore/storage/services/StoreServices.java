package spbt.hstore.storage.services;

import spbt.hstore.storage.Forms.StoreForm;
import spbt.hstore.storage.dto.StoreDto;
import spbt.hstore.storage.models.Store;

import java.util.List;
import java.util.Optional;

public interface StoreServices {

    void addStore(StoreForm form);
    void deleteStore(Long id);
    void updateStore(Long id, StoreForm form);

    List<StoreDto> getAllStores();
    Optional<StoreDto> getStoreById(Long id);
}
