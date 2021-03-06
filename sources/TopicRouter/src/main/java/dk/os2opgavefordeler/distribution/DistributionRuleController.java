package dk.os2opgavefordeler.distribution;

import org.apache.deltaspike.jpa.api.transaction.Transactional;

import javax.enterprise.context.ApplicationScoped;

import javax.inject.Inject;

import javax.persistence.EntityManager;

import dk.os2opgavefordeler.distribution.dto.DistributionRuleFilterDTO;

import dk.os2opgavefordeler.employment.EmploymentRepository;
import dk.os2opgavefordeler.employment.OrgUnitRepository;

import dk.os2opgavefordeler.model.*;

@ApplicationScoped
@Transactional
public class DistributionRuleController {

    @Inject
    private DistributionRuleRepository ruleRepository;

    @Inject
    private OrgUnitRepository orgUnitRepository;

    @Inject
    private EmploymentRepository employmentRepository;

    @Inject
    private EntityManager entityManager;

    @Inject
    private DistributionRuleFilterFactory filterFactory;

	/**
	 * Creates a new distribution rule filter
	 *
	 * @param dto DTO object for the distribution rule filter
	 * @throws OrgUnitNotFoundException
	 * @throws RuleNotFoundException
	 */
    public void createFilter(DistributionRuleFilterDTO dto) throws
            OrgUnitNotFoundException,
            RuleNotFoundException {

        DistributionRule rule = ruleRepository.findBy(dto.distributionRuleId);

        if (rule == null) {
            throw new RuleNotFoundException("No such rule" + dto.distributionRuleId);
        }

        OrgUnit orgUnit = orgUnitRepository.findBy(dto.assignedOrgId);

        if (orgUnit == null) {
            throw new OrgUnitNotFoundException("Organizational unit not found");
        }

        rule.addFilter(filterFactory.fromDto(dto));

        ruleRepository.save(rule);
    }

	/**
	 * Updates the distribution rule filter with the specified filter ID
	 *
	 * @param ruleId ID for the distribution rule
	 * @param filterId ID for the distribution rule filter
	 * @param dto DTO object to use when updating the distribution rule filter
	 * @throws OrgUnitNotFoundException
	 * @throws RuleNotFoundException
	 */
    public void updateFilter(long ruleId, long filterId, DistributionRuleFilterDTO dto) throws
            OrgUnitNotFoundException,
            RuleNotFoundException {
        DistributionRule rule = ruleRepository.findBy(ruleId);

        if (rule == null) {
            throw new RuleNotFoundException("No such rule" + dto.distributionRuleId);
        }

        OrgUnit orgUnit = orgUnitRepository.findBy(dto.assignedOrgId);

        if (orgUnit == null) {
            throw new OrgUnitNotFoundException("Organizational unit not found");
        }

        DistributionRuleFilter filterById = rule.getFilterById(filterId);
        filterById.setName(dto.name);

        Employment e = employmentRepository.findBy(dto.assignedEmployeeId);

	    if (e != null) {
            filterById.setAssignedEmployee(e);
        }

        OrgUnit o = orgUnitRepository.findBy(dto.assignedOrgId);

	    if (o != null) {
            filterById.setAssignedOrg(o);
        }

        if (filterById instanceof CprDistributionRuleFilter) {
            CprDistributionRuleFilter f = (CprDistributionRuleFilter) filterById;
            f.setDays(dto.days);
            f.setMonths(dto.months);
        }
        else if (filterById instanceof TextDistributionRuleFilter) {
            TextDistributionRuleFilter f = (TextDistributionRuleFilter) filterById;
            f.setText(dto.text);
        }

        entityManager.merge(filterById);

    }

	/**
	 * Deletes the distribution rule filter with the specified distribution rule ID and filter ID
	 *
	 * @param distributionRuleId ID for the distribution rule
	 * @param filterId ID for the distribution rule filter
	 */
    public void deleteFilter(long distributionRuleId, long filterId) {
        DistributionRule rule = ruleRepository.findBy(distributionRuleId);

        DistributionRuleFilter filterById = rule.getFilterById(filterId);
        filterById.setDistributionRule(null);
        rule.removeFilter(filterById);

        entityManager.remove(filterById);
        ruleRepository.save(rule);
    }

    public class RuleNotFoundException extends Exception {
        public RuleNotFoundException(String msg) {
            super(msg);
        }

        public RuleNotFoundException(String msg, Throwable t) {
            super(msg, t);
        }
    }

    public class OrgUnitNotFoundException extends Exception {
        public OrgUnitNotFoundException(String msg) {
            super(msg);
        }

        public OrgUnitNotFoundException(String msg, Throwable t) {
            super(msg, t);
        }
    }

}
