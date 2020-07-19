package tc.task01.service.validation.impl;

import tc.task01.entity.criteria.Criteria;
import tc.task01.service.validation.Validator;

import java.util.Set;

public class OvenValidator implements Validator {

    public OvenValidator() {
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
                case "CAPACITY" -> isValid = checkCapacityParam(criteriaValue);
                case "DEPTH" -> isValid = checkDepthParam(criteriaValue);
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

        if (value < 500 || value > 5000) {
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

        if (value < 5 || value > 25) {
            check = false;
        }

        return check;
    }

    private boolean checkCapacityParam(Object param) {
        boolean check = true;
        int value = 0;


        if (param.getClass() != Integer.class) {
            check = false;
        }

        else {
            value = (int) param;
        }

        if (value < 15 || value > 55) {
            check = false;
        }

        return check;
    }

    private boolean checkDepthParam(Object param) {
        boolean check = true;
        int value = 0;


        if (param.getClass() != Integer.class) {
            check = false;
        }

        else {
            value = (int) param;
        }

        if (value < 30 || value > 110) {
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

        if (value < 30.0 || value > 170.0) {
            check = false;
        }

        return check;
    }

    private boolean checkWidthParam(Object param) {
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

        if (value < 40.0 || value > 120.0) {
            check = false;
        }

        return check;
    }
}
