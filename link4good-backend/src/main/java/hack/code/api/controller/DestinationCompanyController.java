package hack.code.api.controller;

import hack.code.store.DestinationCompanyEntity;
import hack.code.api.service.DestinationCompanyService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RequestMapping("api/v1/destination")
public class DestinationCompanyController {

    DestinationCompanyService destinationCompanyService;

    @PostMapping
    public DestinationCompanyEntity createDestinationCompany(@RequestBody DestinationCompanyEntity destinationCompany){

        return destinationCompanyService.createDestinationCompany(destinationCompany);
    }

    @GetMapping
    public List<DestinationCompanyEntity> getDestinationCompanyList(){
        return destinationCompanyService.getAllDestinationCompanies();
    }

    @GetMapping("/{destinationCompanyId}")
    public Optional<DestinationCompanyEntity> getDestinationCompanyById(@PathVariable(name = "destinationCompanyId") Long id){

        return destinationCompanyService.getDestinationCompanyById(id);
    }

    @PatchMapping("/{destinationCompanyId}")
    public DestinationCompanyEntity updateDestinationCompany(@PathVariable(name = "destinationCompanyId") Long id,
                                                             @RequestBody DestinationCompanyEntity destinationCompany){
        return destinationCompanyService.updateDestinationCompany(id, destinationCompany);
    }

    @DeleteMapping("/{destinationCompanyId}")
    public String deleteDestinationCompany(@PathVariable(name = "destinationCompanyId") Long id){
        return destinationCompanyService.deleteDestinationCompany(id);
    }

}
