package dk.os2opgavefordeler.service;

import dk.os2opgavefordeler.model.Employment;
import dk.os2opgavefordeler.model.presentation.EmploymentPO;
import dk.os2opgavefordeler.model.search.EmploymentSearch;
import dk.os2opgavefordeler.model.search.SearchResult;

import java.util.List;
import java.util.Optional;

public interface EmploymentService {
	Optional<Employment> getEmployment(long id);
	Optional<EmploymentPO> getEmploymentPO(long id);
	List<Employment> findByEmail(String email);

	List<EmploymentPO> getManagedAsPO(long municipalityId, long employmentId);
	List<Employment> getAll(long municipalityId);
	List<EmploymentPO> getAllPO(long municipalityId, long employmentId);

	SearchResult<EmploymentPO> search(EmploymentSearch options);
}
