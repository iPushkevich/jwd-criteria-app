package tc.task01.service;

import tc.task01.entity.Appliance;
import tc.task01.entity.criteria.Criteria;

import java.util.Set;

public interface ApplianceService {

    Set<Appliance> find(Criteria criteria);

}
