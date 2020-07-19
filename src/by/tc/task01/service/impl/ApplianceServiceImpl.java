package tc.task01.service.impl;

import tc.task01.dao.ApplianceDAO;
import tc.task01.dao.DAOFactory;
import tc.task01.dao.exception.DaoException;
import tc.task01.entity.Appliance;
import tc.task01.entity.criteria.Criteria;
import tc.task01.service.ApplianceService;
import tc.task01.service.exception.CriteriaGroupSearchNameException;
import tc.task01.service.exception.ServiceException;
import tc.task01.service.validation.ValidatorFactory;

import java.util.Set;

public class ApplianceServiceImpl implements ApplianceService{

	@Override
	public Set<Appliance> find(Criteria criteria) throws ServiceException, CriteriaGroupSearchNameException {

		ValidatorFactory.getValidator(criteria);

		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getAPPLIANCE_DAO();

		try {
			return applianceDAO.find(criteria);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

}
