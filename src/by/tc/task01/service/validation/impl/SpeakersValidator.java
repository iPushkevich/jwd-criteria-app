package tc.task01.service.validation.impl;

import tc.task01.entity.criteria.Criteria;
import tc.task01.service.validation.Validator;

import java.util.Set;

public class SpeakersValidator implements Validator {

    public SpeakersValidator() {
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
                case "NUMBER_OF_SPEAKERS" -> isValid = checkNumberOfSpeakersParam(criteriaValue);
                case "FREQUENCY_RANGE" -> isValid = checkFrequencyRangeParam(criteriaValue);
                case "CORD_LENGTH" -> isValid = checkCordLengthParam(criteriaValue);
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

        if (value < 7 || value > 30) {
            check = false;
        }

        return check;
    }

    private boolean checkNumberOfSpeakersParam(Object param) {
        boolean check = true;
        int value = 0;


        if (param.getClass() != Integer.class) {
            check = false;
        }

        else {
            value = (int) param;
        }

        if (value < 2 || value > 8) {
            check = false;
        }

        return check;
    }

    private boolean checkFrequencyRangeParam(Object param) {
        boolean check = true;

        if (!(param.getClass() == String.class)){
            check = false;
        }

        return check;
    }

    private boolean checkCordLengthParam(Object param) {
        boolean check = true;
        int value = 0;


        if (param.getClass() != Integer.class) {
            check = false;
        }

        else {
            value = (int) param;
        }

        if (value < 1 || value > 9) {
            check = false;
        }

        return check;
    }
}
