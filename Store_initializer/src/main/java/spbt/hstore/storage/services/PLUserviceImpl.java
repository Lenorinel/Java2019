package spbt.hstore.storage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spbt.hstore.storage.Forms.PLUForm;
import spbt.hstore.storage.Repository.PluRepository;
import spbt.hstore.storage.dto.pluDto;
import spbt.hstore.storage.models.ClothesType;
import spbt.hstore.storage.models.PLU;
import spbt.hstore.storage.models.PLUSize;
import spbt.hstore.storage.models.Store;

import java.util.List;

import static spbt.hstore.storage.dto.pluDto.from;

@Service
public class PLUserviceImpl implements PLUservices {

    @Autowired
    private PluRepository pluRepository;


    @Transactional
    @Override
    public List<pluDto> getPlusByStoreId(Long storeId) {
        return from(pluRepository.findAllByStore_Id(storeId));
    }

    @Transactional
    @Override
    public void add(Long storeId, PLUForm plu) {
        PLU item = PLU.builder()
                .name(plu.getName())
                .type(ClothesType.valueOf(plu.getType()))
                .size(PLUSize.valueOf(plu.getSize()))
                .firstPrice(plu.getFirstprice())
                .sellPrice(plu.getSellprice())
                .status(true)
                .store(Store.builder().id(storeId).build())
                .build();
    }

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
    }
}
