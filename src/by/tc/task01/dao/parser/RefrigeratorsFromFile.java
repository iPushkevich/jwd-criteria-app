package tc.task01.dao.parser;

import tc.task01.entity.Appliance;
import tc.task01.entity.Refrigerator;
import tc.task01.entity.criteria.Criteria;
import tc.task01.entity.criteria.SearchCriteria;

import java.util.*;

public class RefrigeratorsFromFile {
    private final FileParser parser = FileParser.getInstance();

    public Set<Appliance> getRefrigeratorsByCriteria(Criteria criteria) {
        Set<Appliance> refrigeratorsByCriteria = new HashSet<>();
        List<String> infoFromFile = parser.getOneTypeAppliancesInfo("Refrigerator");
        String searchCriteria;
        String paramValue;
        Map<String, Object> allCriteria = criteria.getCriteria();

        for (Map.Entry<String, Object> entry : allCriteria.entrySet()) {
            searchCriteria = entry.getKey();
            paramValue = entry.getValue().toString();

            for (String param : infoFromFile) {

                String[] params = param.split(", ");

                if (searchCriteria.equalsIgnoreCase(SearchCriteria.Refrigerator.POWER_CONSUMPTION.toString()) && params[0].split("=")[1].equals(paramValue)) {
                    refrigeratorsByCriteria.add(createRefrigerator(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase(SearchCriteria.Refrigerator.WEIGHT.toString()) && params[1].split("=")[1].equalsIgnoreCase(paramValue)) {
                    refrigeratorsByCriteria.add(createRefrigerator(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase(SearchCriteria.Refrigerator.FREEZER_CAPACITY.toString()) && params[2].split("=")[1].equals(paramValue)) {
                    refrigeratorsByCriteria.add(createRefrigerator(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase(SearchCriteria.Refrigerator.OVERALL_CAPACITY.toString()) && params[3].split("=")[1].equals(paramValue)) {
                    refrigeratorsByCriteria.add(createRefrigerator(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase(SearchCriteria.Refrigerator.HEIGHT.toString()) && params[4].split("=")[1].equals(paramValue)) {
                    refrigeratorsByCriteria.add(createRefrigerator(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase(SearchCriteria.Refrigerator.WIDTH.toString()) && params[5].split("=")[1].equals(paramValue)) {
                    refrigeratorsByCriteria.add(createRefrigerator(params));
                }
            }
        }

        return refrigeratorsByCriteria;
    }

    private Refrigerator createRefrigerator(String[] params) {
        Refrigerator refrigerator = new Refrigerator();
        refrigerator.setPowerConsumption(params[0].split("=")[1]);
        refrigerator.setWeight(params[1].split("=")[1]);
        refrigerator.setFreezerCapacity(params[2].split("=")[1]);
        refrigerator.setOverallCapacity(params[3].split("=")[1]);
        refrigerator.setHeight(params[4].split("=")[1]);
        refrigerator.setWidth(params[5].split("=")[1]);

        return refrigerator;
    }
}
