package tc.task01.service.validation;

import tc.task01.entity.criteria.Criteria;
import tc.task01.service.validation.impl.LaptopValidator;

public class ValidatorFactory {
//	private static final ValidatorFactory INSTANCE = new ValidatorFactory();
//
//
//	private ValidatorFactory(){}

	public static boolean getValidator(Criteria criteria) {
		Validator validator;
		boolean isValid = false;

		if (criteria.getGroupSearchName().equals("Laptop")){
			 validator = new LaptopValidator();
			 isValid = validator.checkCriteria(criteria);
		}

		return isValid;
	}


//	public static ValidatorFactory getInstance() {
//		return INSTANCE;
//	}
}

//you may add your own new classes