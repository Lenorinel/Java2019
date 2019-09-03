package spbt.hstore.storage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spbt.hstore.storage.Forms.StoreForm;
import spbt.hstore.storage.Repository.StoreRepository;
import spbt.hstore.storage.dto.StoreDto;
import spbt.hstore.storage.models.DaysOfWeek;
import spbt.hstore.storage.models.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static spbt.hstore.storage.dto.StoreDto.from;

@Service
public class StoreServicesImpl implements StoreServices {

    @Autowired
    StoreRepository storeRepository;


    @Transactional
    @Override
    public void addStore(StoreForm form) {

        Store newStore = Store.builder()
                .name(form.getName())
                .address(form.getAddress())
                .arrivalDays(fromFormToDaysList(form))
                .workTime(form.getWorkTime())
                .comment(form.getComments())
                .count(0)
                .build();

        storeRepository.save(newStore);
    }

    private List<DaysOfWeek> fromFormToDaysList(StoreForm form){
        List<String> temp = form.getArrivalDays();
        List<DaysOfWeek> daysList = new ArrayList<>();

        for (String stringDay: temp
             ) {
//            DaysOfWeek tempDay = new DaysOfWeek(stringDay); не отрабатывает AllArgsConstruct
            daysList.add(new DaysOfWeek(stringDay));
        }
        return daysList;
    }

    @Transactional
    @Override
    public void deleteStore(Long id) {

        storeRepository.deleteById(id);

    }

    @Transactional
    @Override
    public void updateStore(Long id, StoreForm form) {
        Store storeForUpdate = storeRepository.getOne(id);

        storeForUpdate.setName(form.getName());
        storeForUpdate.setAddress(form.getAddress());
        storeForUpdate.setArrivalDays(fromFormToDaysList(form));
        storeForUpdate.setWorkTime(form.getWorkTime());
        storeForUpdate.setComment(form.getComments());

        storeRepository.save(storeForUpdate);
    }

    @Transactional
    @Override
    public List<StoreDto> getAllStores() {
        return from(storeRepository.findAll());
    }

    @Transactional
    @Override
    public Optional<StoreDto> getStoreById(Long id) {
        return Optional.of(from(storeRepository.findById(id).get()));
    }
}
