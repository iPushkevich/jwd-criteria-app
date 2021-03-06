package tc.task01.service.validation.impl;

import tc.task01.entity.criteria.Criteria;
import tc.task01.service.validation.Validator;

import java.util.Set;

public class LaptopValidator implements Validator {

    public LaptopValidator() {
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
                case "OS" -> isValid = checkOSParam(criteriaValue);
                case "MEMORY_ROM" -> isValid = checkMemoryRomParam(criteriaValue);
                case "SYSTEM_MEMORY" -> isValid = checkSystemMemoryParam(criteriaValue);
                case "CPU" -> isValid = checkCPUParam(criteriaValue);
                case "DISPLAY_INCHES" -> isValid = checkDisplayInchesParam(criteriaValue);
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
        double value = 0;

        if (param.getClass() == Double.class){
            value = (double) param;
        }

        else if (param.getClass() == Integer.class){
            value = (int) param;
        }

        else {
            check = false;
        }

        if (value < 1.0 || value > 5.5){
            check = false;
        }

        return check;
    }

    private boolean checkOSParam(Object param){
        boolean check = true;

        if (!(param.getClass() == String.class)){
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

    private boolean checkSystemMemoryParam(Object param){
        boolean check = true;
        int value = 0;


        if (param.getClass() != Integer.class){
            check = false;
        }

        else {
            value = (int) param;
        }

        if (value < 100 || value > 5000){
            check = false;
        }

        return check;
    }

    private boolean checkCPUParam(Object param){
        boolean check = true;
        double value = 0;


        if (param.getClass() != Double.class){
            check = false;
        }

        else {
            value = (double) param;
        }

        if (value < 0.3 || value > 10.0){
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
}
