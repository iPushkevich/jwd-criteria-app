package tc.task01.service.validation.impl;

import tc.task01.entity.criteria.Criteria;
import tc.task01.service.validation.Validator;

import java.util.Set;

public class TabletPCValidator implements Validator {

    public TabletPCValidator() {
    }

    @Override
    public boolean checkCriteria(Criteria criteria) {
        Set<Criteria.CriteriaNameAndValue> allCriteria = criteria.getCriteria();
        boolean isValid = true;

        for (Criteria.CriteriaNameAndValue cr: allCriteria){
            String criteriaName = cr.getCriteriaName();
            Object criteriaValue = cr.getCriteriaValue();

            switch (criteriaName) {
                case "BATTERY_CAPACITY" -> isValid = checkBatteryCapacityParam(criteriaValue);
                case "DISPLAY_INCHES" -> isValid = checkDisplayInchesParam(criteriaValue);
                case "MEMORY_ROM" -> isValid = checkMemoryRomParam(criteriaValue);
                case "FLASH_MEMORY_CAPACITY" -> isValid = checkFlashMemoryCapacityParam(criteriaValue);
                case "COLOR" -> isValid = checkColorParam(criteriaValue);
            }

            if (!isValid){
                System.out.println(criteriaValue + " wrong value for " + criteriaName );
            }

            isValid = true;
        }

        return true;
    }


    private boolean checkBatteryCapacityParam(Object param){
        boolean check = true;
        int value = 0;

        if (param.getClass() == Integer.class){
            check = false;
        }

        else {
            value = (int) param;
        }

        if (value < 1 || value > 8){
            check = false;
        }

        return check;
    }

    private boolean checkDisplayInchesParam(Object param){
        boolean check = true;
        int value = 0;

        if (param.getClass() != Integer.class){
            check = false;
        }

        else {
            value = (int) param;
        }

        if (value < 7 || value > 25){
            check = false;
        }

        return check;
    }

    private boolean checkMemoryRomParam(Object param){
        boolean check = true;
        int value = 0;


        if (param.getClass() != Integer.class){
            check = false;
        }

        else {
            value = (int) param;
        }

        if (value < 4000 || value > 32000){
            check = false;
        }

        return check;
    }

    private boolean checkFlashMemoryCapacityParam(Object param){
        boolean check = true;
        int value = 0;


        if (param.getClass() != Integer.class){
            check = false;
        }

        else {
            value = (int) param;
        }

        if (value < 1 || value > 21){
            check = false;
        }

        return check;
    }

    private boolean checkColorParam(Object param){
        boolean check = true;

        if (!(param.getClass() == String.class)){
            check = false;
        }

        return check;
    }
}
