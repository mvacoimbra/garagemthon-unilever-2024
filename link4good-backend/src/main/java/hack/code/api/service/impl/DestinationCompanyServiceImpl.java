package hack.code.api.service.impl;

import hack.code.store.DestinationCompanyEntity;
import hack.code.api.service.DestinationCompanyService;
import hack.code.store.repositury.DestinationCompanyEntityRepository;
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
public class DestinationCompanyServiceImpl implements DestinationCompanyService {

    DestinationCompanyEntityRepository destinationCompanyEntityRepository;

    @Override
    @Transactional
    public DestinationCompanyEntity createDestinationCompany(
            @RequestBody DestinationCompanyEntity destinationCompany) {

        DestinationCompanyEntity newDestinationCompany = DestinationCompanyEntity
                .builder()
                .name(destinationCompany.getName())
                .registrationInfo(destinationCompany.getRegistrationInfo())
                .build();

        destinationCompanyEntityRepository.saveAndFlush(newDestinationCompany);
        return newDestinationCompany;
    }

    @Override
    public List<DestinationCompanyEntity> getAllDestinationCompanies() {

        return destinationCompanyEntityRepository.findAll();
    }

    @Override
    public Optional<DestinationCompanyEntity> getDestinationCompanyById(
            @PathVariable(name = "destinationCompanyId") Long id) {

        Optional<DestinationCompanyEntity> company = destinationCompanyEntityRepository.findById(id);
        return company;
    }

    @Override
    @Transactional
    public DestinationCompanyEntity updateDestinationCompany(@PathVariable(name = "destinationCompanyId") Long id,
                                                             @RequestBody DestinationCompanyEntity destinationCompany) {

        DestinationCompanyEntity companyToBeUpdated = destinationCompanyEntityRepository.findById(id).orElseThrow();

        companyToBeUpdated.setName(destinationCompany.getName());
        companyToBeUpdated.setRegistrationInfo(destinationCompany.getRegistrationInfo());

        destinationCompanyEntityRepository.saveAndFlush(companyToBeUpdated);
        return companyToBeUpdated;
    }

    @Override
    @Transactional
    public String deleteDestinationCompany(@PathVariable(name = "destinationCompanyId") Long id) {
        DestinationCompanyEntity company = destinationCompanyEntityRepository.findById(id).orElseThrow();
        destinationCompanyEntityRepository.deleteById(id);

        return "Destination company was deleted";
    }
}
