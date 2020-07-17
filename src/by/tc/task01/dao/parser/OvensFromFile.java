package tc.task01.dao.parser;

import tc.task01.entity.Appliance;
import tc.task01.entity.Oven;
import tc.task01.entity.criteria.Criteria;
import tc.task01.entity.criteria.SearchCriteria;

import java.util.*;

public class OvensFromFile {
    private final FileParser parser = FileParser.getInstance();

    public Set<Appliance> getOvensByCriteria(Criteria criteria) {
        Set<Appliance> ovensByCriteria = new HashSet<>();
        List<String> infoFromFile = parser.getOneTypeAppliancesInfo("Oven");
        String searchCriteria;
        String paramValue;
        Map<String, Object> allCriteria = criteria.getCriteria();

        for (Map.Entry<String, Object> entry : allCriteria.entrySet()) {
            searchCriteria = entry.getKey();
            paramValue = entry.getValue().toString();

            for (String param : infoFromFile) {

                String[] params = param.split(", ");

                if (searchCriteria.equalsIgnoreCase(SearchCriteria.Oven.POWER_CONSUMPTION.toString()) && params[0].split("=")[1].equals(paramValue)) {
                    ovensByCriteria.add(createOven(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase(SearchCriteria.Oven.WEIGHT.toString()) && params[1].split("=")[1].equalsIgnoreCase(paramValue)) {
                    ovensByCriteria.add(createOven(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase(SearchCriteria.Oven.CAPACITY.toString()) && params[2].split("=")[1].equals(paramValue)) {
                    ovensByCriteria.add(createOven(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase(SearchCriteria.Oven.DEPTH.toString()) && params[3].split("=")[1].equals(paramValue)) {
                    ovensByCriteria.add(createOven(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase(SearchCriteria.Oven.HEIGHT.toString()) && params[4].split("=")[1].equals(paramValue)) {
                    ovensByCriteria.add(createOven(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase(SearchCriteria.Oven.WIDTH.toString()) && params[5].split("=")[1].equals(paramValue)) {
                    ovensByCriteria.add(createOven(params));
                }
            }
        }

        return ovensByCriteria;
    }

    private Oven createOven(String[] params) {
        Oven oven = new Oven();
        oven.setPowerConsumption(params[0].split("=")[1]);
        oven.setWeight(params[1].split("=")[1]);
        oven.setCapacity(params[2].split("=")[1]);
        oven.setDepth(params[3].split("=")[1]);
        oven.setHeight(params[4].split("=")[1]);
        oven.setWidth(params[5].split("=")[1]);

        return oven;
    }
}
