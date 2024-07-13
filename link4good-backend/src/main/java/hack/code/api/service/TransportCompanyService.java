package hack.code.api.service;

import hack.code.store.TransportCompanyEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface TransportCompanyService {

    TransportCompanyEntity createTransportCompany(@RequestBody TransportCompanyEntity transportCompany);

    List<TransportCompanyEntity> getAllTransportCompanies();

    Optional<TransportCompanyEntity> getTransportCompanyById(@PathVariable(name = "transportCompanyId") Long id);

    TransportCompanyEntity updateTransportCompany(@PathVariable(name = "transportCompanyId") Long id,
                                                  @RequestBody TransportCompanyEntity transportCompany);

    String deleteTransportCompany(@PathVariable(name = "transportCompanyId") Long id);
}
