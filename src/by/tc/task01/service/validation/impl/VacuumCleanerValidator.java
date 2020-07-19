package tc.task01.service.validation.impl;

import tc.task01.entity.criteria.Criteria;
import tc.task01.service.validation.Validator;

import java.util.Set;

public class VacuumCleanerValidator implements Validator {

    public VacuumCleanerValidator() {
    }

    @Override
    public boolean checkCriteria(Criteria criteria) {
        Set<Criteria.CriteriaNameAndValue> allCriteria = criteria.getCriteria();
        boolean isValid = true;

        for (Criteria.CriteriaNameAndValue cr: allCriteria){
            String criteriaName = cr.getCriteriaName();
            Object criteriaValue = cr.getCriteriaValue();

            switch (criteriaName) {
                case "POWER_CONSUMPTION" -> isValid = checkPowerConsumptionParam(criteriaValue);
                case "FILTER_TYPE" -> isValid = checkFilterTypeParam(criteriaValue);
                case "BAG_TYPE" -> isValid = checkBagTypeParam(criteriaValue);
                case "WAND_TYPE" -> isValid = checkWandTypeParam(criteriaValue);
                case "MOTOR_SPEED_REGULATION" -> isValid = checkMotorSpeedRegulationParam(criteriaValue);
                case "CLEANING_WIDTH" -> isValid = checkCleaningWidthParam(criteriaValue);
            }

            if (!isValid) {
                System.out.println(criteriaValue + " wrong value for " + criteriaName);
            }

            isValid = true;

        }

        return true;
    }


    private boolean checkPowerConsumptionParam(Object param) {
        boolean check = true;
        int value = 0;


        if (param.getClass() != Integer.class) {
            check = false;
        }

        else {
            value = (int) param;
        }

        if (value < 40 || value > 220) {
            check = false;
        }

        return check;
    }

    private boolean checkFilterTypeParam(Object param) {
        boolean check = true;

        if (!(param.getClass() == String.class)){
            check = false;
        }

        return check;
    }

    private boolean checkBagTypeParam(Object param) {
        boolean check = true;

        if (!(param.getClass() == String.class)){
            check = false;
        }

        return check;
    }

    private boolean checkWandTypeParam(Object param) {
        boolean check = true;

        if (!(param.getClass() == String.class)){
            check = false;
        }

        return check;
    }

    private boolean checkMotorSpeedRegulationParam(Object param) {
        boolean check = true;
        int value = 0;

        if (param.getClass() != Integer.class) {
            check = false;
        }

        else {
            value = (int) param;
        }

        if (value < 1700 || value > 5200) {
            check = false;
        }

        return check;
    }

    private boolean checkCleaningWidthParam(Object param) {
        boolean check = true;
        int value = 0;

        if (param.getClass() != Integer.class) {
            check = false;
        }

        else {
            value = (int) param;
        }

        if (value < 12 || value > 43) {
            check = false;
        }

        return check;
    }
}
