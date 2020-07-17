package tc.task01.dao;

import tc.task01.dao.impl.ApplianceDAOImpl;

public final class DAOFactory {
	private static final DAOFactory INSTANCE = new DAOFactory();

	private final ApplianceDAO APPLIANCE_DAO = new ApplianceDAOImpl();
	
	private DAOFactory() {}

	public ApplianceDAO getAPPLIANCE_DAO() {
		return APPLIANCE_DAO;
	}

	public static DAOFactory getInstance() {
		return INSTANCE;
	}
}
