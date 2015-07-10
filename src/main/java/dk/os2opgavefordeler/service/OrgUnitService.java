package dk.os2opgavefordeler.service;

import dk.os2opgavefordeler.model.Employment;
import dk.os2opgavefordeler.model.OrgUnit;
import dk.os2opgavefordeler.model.presentation.OrgUnitPO;

import java.util.List;
import java.util.Optional;

public interface OrgUnitService {
	/**
	 * Persist an OrgUnit.
	 * @param orgUnit
	 * @return the input orgUnit, for possible ease of method chaining.
	 */
	OrgUnit createOrgUnit(OrgUnit orgUnit);

	/**
	 * Imports an organization tree.
	 * @param orgUnit
	 */
	void importOrganization(OrgUnit orgUnit);

	/**
	 * Looks up an orgUnit by id.
	 * @param id
	 * @return fetched orgUnit, or Optional.empty if not found.
	 */
	Optional<OrgUnit> getOrgUnit(int id);
	Optional<OrgUnit> getToplevelOrgUnit();
	List<OrgUnit> findByName(String name);

	List<OrgUnitPO> getToplevelOrgUnitPO();
	Optional<OrgUnitPO> getOrgUnitPO(int id);

	Optional<Employment> getEmployment(int id);
	Optional<Employment> getEmploymentByName(String name);
}