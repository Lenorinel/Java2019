package spbt.hstore.storage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spbt.hstore.storage.Forms.PLUForm;
import spbt.hstore.storage.Forms.StoreForm;
import spbt.hstore.storage.dto.pluDto;
import spbt.hstore.storage.services.PLUservices;

import java.util.List;


@Controller
public class PLUController {

    @Autowired
    private PLUservices pluServices;

    @RequestMapping(value = "/StoreItems", method = RequestMethod.GET)
    public String getPluPage(Model model, @RequestParam("store") Long storeId){
        List<pluDto> items = pluServices.getPlusByStoreId(storeId);
        model.addAttribute("plus", items);
        model.addAttribute("storeId",storeId);
        return "plus";
    }

    @RequestMapping(value = "/StoreItems", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<pluDto> addPluToStore(@RequestParam("store") Long storeId,
                                      @RequestBody PLUForm form) {
        pluServices.add(storeId, form);
        return pluServices.getPlusByStoreId(storeId);
    }

}
