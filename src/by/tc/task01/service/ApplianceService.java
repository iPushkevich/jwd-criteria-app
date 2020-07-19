package tc.task01.service;

import tc.task01.entity.Appliance;
import tc.task01.entity.criteria.Criteria;
import tc.task01.service.exception.CriteriaGroupSearchNameException;
import tc.task01.service.exception.ServiceException;

import java.util.Set;

public interface ApplianceService {
    Set<Appliance> find(Criteria criteria) throws ServiceException, CriteriaGroupSearchNameException;
}
