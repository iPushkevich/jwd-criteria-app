package tc.task01.service.validation;

import tc.task01.entity.criteria.Criteria;

public interface Validator {
    boolean checkCriteria(Criteria criteria);
}
