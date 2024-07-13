package hack.code.api.service.impl;

import hack.code.store.TransportCompanyEntity;
import hack.code.api.service.TransportCompanyService;
import hack.code.store.repositury.TransportCompanyEntityRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class TransportCompanyServiceImpl implements TransportCompanyService {

    TransportCompanyEntityRepository transportCompanyEntityRepository;
    @Override
    @Transactional
    public TransportCompanyEntity createTransportCompany(@RequestBody TransportCompanyEntity transportCompany) {

        TransportCompanyEntity newTransportCompany = TransportCompanyEntity
                .builder()
                .name(transportCompany.getName())
                .someInfo(transportCompany.getSomeInfo())
                .build();

        transportCompanyEntityRepository.saveAndFlush(newTransportCompany);

        return newTransportCompany;
    }

    @Override
    public List<TransportCompanyEntity> getAllTransportCompanies() {

        return transportCompanyEntityRepository.findAll();
    }

    @Override
    public Optional<TransportCompanyEntity> getTransportCompanyById(@PathVariable(name = "transportCompanyId") Long id) {

        Optional<TransportCompanyEntity> company = transportCompanyEntityRepository.findById(id);
        return company;
    }

    @Override
    @Transactional
    public TransportCompanyEntity updateTransportCompany(@PathVariable(name = "transportCompanyId") Long id,
                                                         @RequestBody TransportCompanyEntity transportCompany) {

        TransportCompanyEntity companyToBeUpdated = transportCompanyEntityRepository.findById(id).orElseThrow();

        companyToBeUpdated.setName(transportCompany.getName());
        companyToBeUpdated.setSomeInfo(transportCompany.getSomeInfo());
        companyToBeUpdated.setDeliveryOrders(transportCompany.getDeliveryOrders());
        transportCompanyEntityRepository.saveAndFlush(companyToBeUpdated);
        return companyToBeUpdated;
    }

    @Override
    @Transactional
    public String deleteTransportCompany(@PathVariable(name = "transportCompanyId") Long id) {

        TransportCompanyEntity company = transportCompanyEntityRepository.findById(id).orElseThrow();
        transportCompanyEntityRepository.deleteById(id);

        return "Transport company was deleted";
    }
}
