package spbt.hstore.storage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spbt.hstore.storage.Forms.StoreForm;
import spbt.hstore.storage.dto.StoreDto;
import spbt.hstore.storage.services.StoreServices;

import java.util.List;

@Controller
public class StoresController {
    @Autowired
    private StoreServices storeServices;

    @GetMapping(value = "/stores")
    public String getStoresPage(Model model){
        List<StoreDto> stores = storeServices.getAllStores();
        model.addAttribute("stores",stores);
        return "stores";
    }

    @PostMapping(value = "/stores")
    @ResponseBody
    public List<StoreDto> addStore(@RequestParam("store") Long storeId,
                                   @RequestBody StoreForm form){
        storeServices.addStore(form);
        return storeServices.getAllStores(); //Зачем?
    }
}
