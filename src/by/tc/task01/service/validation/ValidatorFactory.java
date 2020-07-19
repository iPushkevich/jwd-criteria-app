package tc.task01.service.validation;

import tc.task01.entity.criteria.Criteria;
import tc.task01.service.exception.CriteriaGroupSearchNameException;
import tc.task01.service.validation.impl.*;

public class ValidatorFactory {

	public static boolean getValidator(Criteria criteria) throws CriteriaGroupSearchNameException {
		Validator validator = null;
		boolean isValid;

		switch (criteria.getGroupSearchName()) {
			case "Laptop" -> validator = new LaptopValidator();
			case "Oven" -> validator = new OvenValidator();
			case "Refrigerator" -> validator = new RefrigeratorValidator();
			case "VacuumCleaner" -> validator = new VacuumCleanerValidator();
			case "TabletPC" -> validator = new TabletPCValidator();
			case "Speakers" -> validator = new SpeakersValidator();
		}

		if (validator == null){
			throw new CriteriaGroupSearchNameException("Wrong criteria group search name");
		}

		isValid = validator.checkCriteria(criteria);

		return isValid;
	}
}
