package hack.code.api.service;

import hack.code.store.DestinationCompanyEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface DestinationCompanyService {

    DestinationCompanyEntity createDestinationCompany(@RequestBody DestinationCompanyEntity destinationCompany);

    List<DestinationCompanyEntity> getAllDestinationCompanies();

    Optional<DestinationCompanyEntity> getDestinationCompanyById(@PathVariable(name = "destinationCompanyId") Long id);

    DestinationCompanyEntity updateDestinationCompany(@PathVariable(name = "destinationCompanyId") Long id,
                                                      @RequestBody DestinationCompanyEntity destinationCompany);

    String deleteDestinationCompany(@PathVariable(name = "destinationCompanyId") Long id);
}

