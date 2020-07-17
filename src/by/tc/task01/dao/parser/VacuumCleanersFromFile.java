package tc.task01.dao.parser;

import tc.task01.entity.Appliance;
import tc.task01.entity.VacuumCleaner;
import tc.task01.entity.criteria.Criteria;
import tc.task01.entity.criteria.SearchCriteria;

import java.util.*;

public class VacuumCleanersFromFile {
    private final FileParser parser = FileParser.getInstance();

    public Set<Appliance> getVacuumCleanersByCriteria(Criteria criteria) {
        Set<Appliance> vacuumCleanersByCriteria = new HashSet<>();
        List<String> infoFromFile = parser.getOneTypeAppliancesInfo("VacuumCleaner");
        String searchCriteria;
        String paramValue;
        Map<String, Object> allCriteria = criteria.getCriteria();

        for (Map.Entry<String, Object> entry : allCriteria.entrySet()) {
            searchCriteria = entry.getKey();
            paramValue = entry.getValue().toString();

            for (String param : infoFromFile) {

                String[] params = param.split(", ");

                if (searchCriteria.equalsIgnoreCase(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString()) && params[0].split("=")[1].equals(paramValue)) {
                    vacuumCleanersByCriteria.add(createVacuumCleaner(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString()) && params[1].split("=")[1].equalsIgnoreCase(paramValue)) {
                    vacuumCleanersByCriteria.add(createVacuumCleaner(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase(SearchCriteria.VacuumCleaner.BAG_TYPE.toString()) && params[2].split("=")[1].equals(paramValue)) {
                    vacuumCleanersByCriteria.add(createVacuumCleaner(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase(SearchCriteria.VacuumCleaner.WAND_TYPE.toString()) && params[3].split("=")[1].equals(paramValue)) {
                    vacuumCleanersByCriteria.add(createVacuumCleaner(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString()) && params[4].split("=")[1].equals(paramValue)) {
                    vacuumCleanersByCriteria.add(createVacuumCleaner(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString()) && params[5].split("=")[1].equals(paramValue)) {
                    vacuumCleanersByCriteria.add(createVacuumCleaner(params));
                }
            }
        }

        return vacuumCleanersByCriteria;
    }

    private VacuumCleaner createVacuumCleaner(String[] params) {
        VacuumCleaner cleaner = new VacuumCleaner();
        cleaner.setPowerConsumption(params[0].split("=")[1]);
        cleaner.setFilterType(params[1].split("=")[1]);
        cleaner.setBagType(params[2].split("=")[1]);
        cleaner.setWandType(params[3].split("=")[1]);
        cleaner.setMotorSpeedRegulation(params[4].split("=")[1]);
        cleaner.setCleaningWidth(params[5].split("=")[1]);

        return cleaner;
    }
}
