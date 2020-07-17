package tc.task01.service.validation.impl;

import tc.task01.entity.criteria.Criteria;
import tc.task01.service.validation.Validator;

import java.util.*;

public class LaptopValidator implements Validator {

    public LaptopValidator() {
    }

    @Override
    public boolean checkCriteria(Criteria criteria) {
        Map<String, Object> params = criteria.getCriteria();
        boolean isValid = true;
        Set<String> os = getOS();

        for (Map.Entry<String, Object> entry : params.entrySet()){
            String criteriaName = entry.getKey();
            Object criteriaValue = entry.getValue();

            if (criteriaName.equals("BATTERY_CAPACITY")){
                isValid = checkBatteryCapacityParam(criteriaValue);
            }

            else if (criteriaName.equals("OS") && !os.contains(criteriaValue.toString())){
                isValid = checkOSParam(criteriaValue);
            }

            else if (criteriaName.equals("MEMORY_ROM") && ((int)criteriaValue<4000 || (int)criteriaValue>32000)){
                isValid = true;
            }

            else if (criteriaName.equals("SYSTEM_MEMORY") && ((int)criteriaValue<100 || (int)criteriaValue>5000)){
                isValid = true;
            }

            else if (criteriaName.equals("CPU") && ((double)criteriaValue<0.3 || (double)criteriaValue>10)){
                isValid = true;
            }

            else if (criteriaName.equals("DISPLAY_INCHES") && ((double)criteriaValue<10.0 || (double)criteriaValue>19)){
                isValid = true;
            }

            if (!isValid){
                System.out.println(criteriaValue + " wrong value for " + criteriaName );
            }

            isValid = true;

        }

        return isValid;
    }

    private Set<String> getOS(){
        Set<String> os = new HashSet<>();
        os.add("WINDOWS");
        os.add("LINUX");
        os.add("MAC");

        return os;
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
        String value = "";

        if (!(param.getClass() == String.class)){
            check = false;
        }

        else {
            value = param.toString();
        }

        if (!getOS().contains(value)){
            check = false;
        }

        return check;
    }
}
