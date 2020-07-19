package tc.task01.dao.parser;

import tc.task01.dao.exception.DaoException;
import tc.task01.entity.Appliance;
import tc.task01.entity.Refrigerator;
import tc.task01.entity.criteria.Criteria;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RefrigeratorsFromFile {
    private final FileParser parser = FileParser.getInstance();

    public Set<Appliance> getRefrigeratorsByCriteria(Criteria criteria) throws DaoException {
        Set<Appliance> refrigeratorsByCriteria = new HashSet<>();
        List<String> infoFromFile = parser.getOneTypeAppliancesInfo("Refrigerator");
        Set<Criteria.CriteriaNameAndValue> allCriteria = criteria.getCriteria();
        String searchCriteria;
        String paramValue;

        for (Criteria.CriteriaNameAndValue cr : allCriteria) {
            searchCriteria = cr.getCriteriaName();
            paramValue = cr.getCriteriaValue().toString();

            for (String param : infoFromFile) {

                String[] params = param.split(", ");

                if (searchCriteria.equalsIgnoreCase("POWER_CONSUMPTION") && params[0].split("=")[1].equalsIgnoreCase(paramValue)) {
                    refrigeratorsByCriteria.add(createRefrigerator(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase("WEIGHT") && params[1].split("=")[1].equalsIgnoreCase(paramValue)) {
                    refrigeratorsByCriteria.add(createRefrigerator(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase("FREEZER_CAPACITY") && params[2].split("=")[1].equalsIgnoreCase(paramValue)) {
                    refrigeratorsByCriteria.add(createRefrigerator(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase("OVERALL_CAPACITY") && params[3].split("=")[1].equalsIgnoreCase(paramValue)) {
                    refrigeratorsByCriteria.add(createRefrigerator(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase("HEIGHT") && params[4].split("=")[1].equalsIgnoreCase(paramValue)) {
                    refrigeratorsByCriteria.add(createRefrigerator(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase("WIDTH") && params[5].split("=")[1].equalsIgnoreCase(paramValue)) {
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
