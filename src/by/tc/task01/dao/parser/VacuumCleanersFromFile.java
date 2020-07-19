package tc.task01.dao.parser;

import tc.task01.dao.exception.DaoException;
import tc.task01.entity.Appliance;
import tc.task01.entity.VacuumCleaner;
import tc.task01.entity.criteria.Criteria;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VacuumCleanersFromFile {
    private final FileParser parser = FileParser.getInstance();

    public Set<Appliance> getVacuumCleanersByCriteria(Criteria criteria) throws DaoException {
        Set<Appliance> vacuumCleanersByCriteria = new HashSet<>();
        List<String> infoFromFile = parser.getOneTypeAppliancesInfo("VacuumCleaner");
        Set<Criteria.CriteriaNameAndValue> allCriteria = criteria.getCriteria();
        String searchCriteria;
        String paramValue;

        for (Criteria.CriteriaNameAndValue cr : allCriteria) {
            searchCriteria = cr.getCriteriaName();
            paramValue = cr.getCriteriaValue().toString();

            for (String param : infoFromFile) {

                String[] params = param.split(", ");

                if (searchCriteria.equalsIgnoreCase("POWER_CONSUMPTION") && params[0].split("=")[1].equalsIgnoreCase(paramValue)) {
                    vacuumCleanersByCriteria.add(createVacuumCleaner(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase("FILTER_TYPE") && params[1].split("=")[1].equalsIgnoreCase(paramValue)) {
                    vacuumCleanersByCriteria.add(createVacuumCleaner(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase("BAG_TYPE") && params[2].split("=")[1].equalsIgnoreCase(paramValue)) {
                    vacuumCleanersByCriteria.add(createVacuumCleaner(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase("WAND_TYPE") && params[3].split("=")[1].equalsIgnoreCase(paramValue)) {
                    vacuumCleanersByCriteria.add(createVacuumCleaner(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase("MOTOR_SPEED_REGULATION") && params[4].split("=")[1].equalsIgnoreCase(paramValue)) {
                    vacuumCleanersByCriteria.add(createVacuumCleaner(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase("CLEANING_WIDTH") && params[5].split("=")[1].equalsIgnoreCase(paramValue)) {
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
