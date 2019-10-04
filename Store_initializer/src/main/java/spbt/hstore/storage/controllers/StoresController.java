package spbt.hstore.storage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spbt.hstore.storage.Forms.StoreForm;
import spbt.hstore.storage.dto.StoreDto;
import spbt.hstore.storage.security.details.UserDetailsImpl;
import spbt.hstore.storage.services.StoreServices;
import spbt.hstore.storage.utils.UserAuthenticationUtil;

import java.util.List;

@Controller
public class StoresController {
    @Autowired
    private StoreServices storeServices;

    @Autowired
    private UserAuthenticationUtil authenticationUtil;

    @GetMapping(value = "/stores")
    public String getStoresPage(Model model,

                                @AuthenticationPrincipal UserDetailsImpl user){
        List<StoreDto> stores = storeServices.getAllStores();
        model.addAttribute("stores",stores);
//        model.addAttribute("userId", userId); @RequestParam("id") Long userId,
        model.addAttribute("user", authenticationUtil.getUserByUserDetails(user));
        return "stores";
    }

    @PostMapping(value = "/stores")
    @ResponseBody
    public List<StoreDto> addStore(@RequestBody StoreForm form){ //@RequestParam("user") Long storeId,
        storeServices.addStore(form);
        return storeServices.getAllStores(); //Зачем?
    }

    @PostMapping(value ="/stores/delete")
    @ResponseBody
    public List<StoreDto> deleteStore(@RequestBody StoreForm form, @RequestParam("store") String storeId ){ //@RequestParam("user") Long storeId,
        Long id = Long.parseLong();
        storeServices.deleteStore(id);
        return storeServices.getAllStores(); //Зачем?
    }
}
