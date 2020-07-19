package tc.task01.dao.parser;

import tc.task01.dao.exception.DaoException;
import tc.task01.entity.Appliance;
import tc.task01.entity.Laptop;
import tc.task01.entity.criteria.Criteria;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LaptopsFromFile {
    private final FileParser parser = FileParser.getInstance();

    public Set<Appliance> getLaptopsByCriteria(Criteria criteria) throws DaoException {
        Set<Appliance> laptopsByCriteria = new HashSet<>();
        List<String> infoFromFile = parser.getOneTypeAppliancesInfo("Laptop");
        Set<Criteria.CriteriaNameAndValue> allCriteria = criteria.getCriteria();
        String searchCriteria;
        String paramValue;

        for (Criteria.CriteriaNameAndValue cr : allCriteria) {
            searchCriteria = cr.getCriteriaName();
            paramValue = cr.getCriteriaValue().toString();

            for (String param : infoFromFile) {

                String[] params = param.split(", ");

                if (searchCriteria.equalsIgnoreCase("BATTERY_CAPACITY") && params[0].split("=")[1].equalsIgnoreCase(paramValue)) {
                    laptopsByCriteria.add(createLaptop(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase("OS") && params[1].split("=")[1].equalsIgnoreCase(paramValue)) {
                    laptopsByCriteria.add(createLaptop(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase("MEMORY_ROM") && params[2].split("=")[1].equalsIgnoreCase(paramValue)) {
                    laptopsByCriteria.add(createLaptop(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase("SYSTEM_MEMORY") && params[3].split("=")[1].equalsIgnoreCase(paramValue)) {
                    laptopsByCriteria.add(createLaptop(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase("CPU") && params[4].split("=")[1].equalsIgnoreCase(paramValue)) {
                    laptopsByCriteria.add(createLaptop(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase("DISPLAY_INCHES") && params[5].split("=")[1].equalsIgnoreCase(paramValue)) {
                    laptopsByCriteria.add(createLaptop(params));
                }
            }
        }

        return laptopsByCriteria;
    }

    private Laptop createLaptop(String[] params) {
        Laptop laptop = new Laptop();
        laptop.setBattery_capacity(params[0].split("=")[1]);
        laptop.setOS(params[1].split("=")[1]);
        laptop.setMemory_rom(params[2].split("=")[1]);
        laptop.setSystem_memory(params[3].split("=")[1]);
        laptop.setCPU(params[4].split("=")[1]);
        laptop.setDisplay_inches(params[5].split("=")[1]);

        return laptop;
    }
}

