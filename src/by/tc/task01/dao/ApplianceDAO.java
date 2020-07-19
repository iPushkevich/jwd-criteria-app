package tc.task01.dao;

import tc.task01.dao.exception.DaoException;
import tc.task01.entity.Appliance;
import tc.task01.entity.criteria.Criteria;

import java.util.Set;

public interface ApplianceDAO {
    Set<Appliance> find(Criteria criteria) throws DaoException;
}
