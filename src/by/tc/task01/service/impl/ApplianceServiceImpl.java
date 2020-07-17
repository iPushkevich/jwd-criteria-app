package tc.task01.service.impl;

import tc.task01.dao.ApplianceDAO;
import tc.task01.dao.DAOFactory;
import tc.task01.entity.Appliance;
import tc.task01.entity.criteria.Criteria;
import tc.task01.service.ApplianceService;
import tc.task01.service.validation.ValidatorFactory;

import java.util.Set;

public class ApplianceServiceImpl implements ApplianceService{

	@Override
	public Set<Appliance> find(Criteria criteria) {

		if (!ValidatorFactory.getValidator(criteria)) {
			return null;
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getAPPLIANCE_DAO();

		return applianceDAO.find(criteria);

	}

}
