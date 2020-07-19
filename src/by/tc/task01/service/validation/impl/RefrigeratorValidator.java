package tc.task01.service.validation.impl;

import tc.task01.entity.criteria.Criteria;
import tc.task01.service.validation.Validator;

import java.util.Set;

public class RefrigeratorValidator implements Validator {

    public RefrigeratorValidator() {
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
                case "WEIGHT" -> isValid = checkWeightParam(criteriaValue);
                case "FREEZER_CAPACITY" -> isValid = checkFreezerCapacityParam(criteriaValue);
                case "OVERALL_CAPACITY" -> isValid = checkOverallCapacityParam(criteriaValue);
                case "HEIGHT" -> isValid = checkHeightParam(criteriaValue);
                case "WIDTH" -> isValid = checkWidthParam(criteriaValue);
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

        if (value < 30 || value > 300) {
            check = false;
        }

        return check;
    }

    private boolean checkWeightParam(Object param) {
        boolean check = true;
        int value = 0;


        if (param.getClass() != Integer.class) {
            check = false;
        }

        else {
            value = (int) param;
        }

        if (value < 3 || value > 35) {
            check = false;
        }

        return check;
    }

    private boolean checkFreezerCapacityParam(Object param) {
        boolean check = true;
        int value = 0;


        if (param.getClass() != Integer.class) {
            check = false;
        }

        else {
            value = (int) param;
        }

        if (value < 5 || value > 35) {
            check = false;
        }

        return check;
    }

    private boolean checkOverallCapacityParam(Object param) {
        boolean check = true;
        double value = 0;

        if

        (param.getClass() == Double.class) {
            value = (double) param;
        }

        else if (param.getClass() == Integer.class) {
            value = (int) param;
        }

        else {
            check = false;
        }

        if (value < 170.0 || value > 530.0) {
            check = false;
        }

        return check;
    }

    private boolean checkHeightParam(Object param) {
        boolean check = true;
        double value = 0;

        if (param.getClass() == Double.class) {
            value = (double) param;
        }

        else if (param.getClass() == Integer.class) {
            value = (int) param;
        }

        else {
            check = false;
        }

        if (value < 70.0 || value > 270.0) {
            check = false;
        }

        return check;
    }

    private boolean checkWidthParam(Object param) {
        boolean check = true;
        int value = 0;

        if (param.getClass() != Integer.class) {
            check = false;
        }

        else {
            value = (int) param;
        }

        if (value < 40 || value > 120) {
            check = false;
        }

        return check;
    }
}
