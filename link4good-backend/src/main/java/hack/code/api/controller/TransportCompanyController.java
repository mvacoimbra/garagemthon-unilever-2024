package hack.code.api.controller;

import hack.code.store.TransportCompanyEntity;
import hack.code.api.service.TransportCompanyService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequiredArgsConstructor
@RequestMapping("api/v1/transport")
public class TransportCompanyController {

    TransportCompanyService transportCompanyService;

    @PostMapping
    public TransportCompanyEntity createTransportCompany(@RequestBody TransportCompanyEntity transportCompany){

        return transportCompanyService.createTransportCompany(transportCompany);
    }

    @GetMapping
    public List<TransportCompanyEntity> getAllTransportCompaniesList(){

        return transportCompanyService.getAllTransportCompanies();
    }

    @GetMapping("/{transportCompanyId}")
    public Optional<TransportCompanyEntity> getTransportCompanyById(@PathVariable(name = "transportCompanyId") Long id){

        return transportCompanyService.getTransportCompanyById(id);
    }

    @PatchMapping("/{transportCompanyId}")
    public TransportCompanyEntity updateTransportCompany(@PathVariable(name = "transportCompanyId") Long id,
                                                         @RequestBody TransportCompanyEntity transportCompany){

        return transportCompanyService.updateTransportCompany(id, transportCompany);
    }


    @DeleteMapping("/{transportCompanyId}")
    public String deleteTransportCompany(@PathVariable(name = "transportCompanyId") Long id){

        return transportCompanyService.deleteTransportCompany(id);
    }
}
