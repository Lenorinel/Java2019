package spbt.hstore.storage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spbt.hstore.storage.Forms.PLUForm;
import spbt.hstore.storage.Repository.PluRepository;
import spbt.hstore.storage.Repository.StoreRepository;
import spbt.hstore.storage.dto.pluDto;
import spbt.hstore.storage.models.enums.ClothesType;
import spbt.hstore.storage.models.PLU;
import spbt.hstore.storage.models.enums.PLUSize;
import spbt.hstore.storage.models.Store;

import java.util.List;
import java.util.Optional;

import static spbt.hstore.storage.dto.pluDto.from;

@Service
public class PLUserviceImpl implements PLUservices {

    @Autowired
    private PluRepository pluRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Transactional
    @Override
    public List<pluDto> getPlusByStoreId(Long storeId) {
        return from(pluRepository.findAllByStore_Id(storeId));
    }

    @Transactional
    @Override
    public List<pluDto> getAllPlus() {
        return from(pluRepository.findAll());
    }

    @Transactional
    @Override
    public void add(Long storeId, PLUForm plu) {
        Store store = storeRepository.getOne(storeId);
        PLU item = PLU.builder()
                .name(plu.getName())
                .type(ClothesType.valueOf(plu.getType()))
                .size(PLUSize.valueOf(plu.getSize()))
                .firstPrice(plu.getFirstprice())
                .sellPrice(plu.getSellprice())
                .status(true)
                .store(Store.builder().id(storeId).build())
                .build();
        pluRepository.save(item);
        store.setCount(store.getCount()+1);
        storeRepository.save(store);
    }

    @Transactional
    @Override
    public void add(PLUForm plu) {
        PLU item = PLU.builder()
                .name(plu.getName())
                .type(ClothesType.valueOf(plu.getType()))
                .size(PLUSize.valueOf(plu.getSize()))
                .firstPrice(plu.getFirstprice())
                .sellPrice(plu.getSellprice())
                .status(true)
                .build();
        pluRepository.save(item);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        pluRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void update(Long id, PLUForm form) {

        PLU updatedPlu = pluRepository.getOne(id);


        updatedPlu.setName(form.getName());
        updatedPlu.setType(ClothesType.valueOf(form.getType()));
        updatedPlu.setSize(PLUSize.valueOf(form.getSize()));
        updatedPlu.setFirstPrice(form.getFirstprice());
        updatedPlu.setSellPrice(form.getSellprice());
        updatedPlu.setStore(updatedPlu.getStore());
        pluRepository.save(updatedPlu);

    }

    @Transactional
    @Override
    public void changeStatus(Long id) {

        PLU pluCandidate = pluRepository.getOne(id);

        if (pluCandidate.getStatus().equals(true)) {
            pluCandidate.setStatus(false);
            pluRepository.save(pluCandidate);
        } else if (pluCandidate.getStatus().equals(false)) {
            pluCandidate.setStatus(true);
            pluRepository.save(pluCandidate);
        }
    }


}
