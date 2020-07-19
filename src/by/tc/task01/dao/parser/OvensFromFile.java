package tc.task01.dao.parser;

import tc.task01.dao.exception.DaoException;
import tc.task01.entity.Appliance;
import tc.task01.entity.Oven;
import tc.task01.entity.criteria.Criteria;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OvensFromFile {
    private final FileParser parser = FileParser.getInstance();

    public Set<Appliance> getOvensByCriteria(Criteria criteria) throws DaoException {
        Set<Appliance> ovensByCriteria = new HashSet<>();
        List<String> infoFromFile = parser.getOneTypeAppliancesInfo("Oven");
        Set<Criteria.CriteriaNameAndValue> allCriteria = criteria.getCriteria();
        String searchCriteria;
        String paramValue;

        for (Criteria.CriteriaNameAndValue cr : allCriteria) {
            searchCriteria = cr.getCriteriaName();
            paramValue = cr.getCriteriaValue().toString();

            for (String param : infoFromFile) {

                String[] params = param.split(", ");

                if (searchCriteria.equalsIgnoreCase("POWER_CONSUMPTION") && params[0].split("=")[1].equalsIgnoreCase(paramValue)) {
                    ovensByCriteria.add(createOven(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase("WEIGHT") && params[1].split("=")[1].equalsIgnoreCase(paramValue)) {
                    ovensByCriteria.add(createOven(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase("CAPACITY") && params[2].split("=")[1].equalsIgnoreCase(paramValue)) {
                    ovensByCriteria.add(createOven(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase("DEPTH") && params[3].split("=")[1].equalsIgnoreCase(paramValue)) {
                    ovensByCriteria.add(createOven(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase("HEIGHT") && params[4].split("=")[1].equalsIgnoreCase(paramValue)) {
                    ovensByCriteria.add(createOven(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase("WIDTH") && params[5].split("=")[1].equalsIgnoreCase(paramValue)) {
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
