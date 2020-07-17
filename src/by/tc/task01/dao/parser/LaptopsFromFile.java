package tc.task01.dao.parser;

import tc.task01.entity.Appliance;
import tc.task01.entity.Laptop;
import tc.task01.entity.criteria.Criteria;
import tc.task01.entity.criteria.SearchCriteria;

import java.util.*;

public class LaptopsFromFile {
    private final FileParser parser = FileParser.getInstance();

    public Set<Appliance> getLaptopsByCriteria(Criteria criteria) {
        Set<Appliance> laptopsByCriteria = new HashSet<>();
        List<String> infoFromFile = parser.getOneTypeAppliancesInfo("Laptop");
        String searchCriteria;
        String paramValue;
        Map<String, Object> allCriteria = criteria.getCriteria();

        for (Map.Entry<String, Object> entry : allCriteria.entrySet()) {
            searchCriteria = entry.getKey();
            paramValue = entry.getValue().toString();

            for (String param : infoFromFile) {

                String[] params = param.split(", ");

                if (searchCriteria.equalsIgnoreCase(SearchCriteria.Laptop.BATTERY_CAPACITY.toString()) && params[0].split("=")[1].equals(paramValue)) {
                    laptopsByCriteria.add(createLaptop(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase(SearchCriteria.Laptop.OS.toString()) && params[1].split("=")[1].equalsIgnoreCase(paramValue)) {
                    laptopsByCriteria.add(createLaptop(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase(SearchCriteria.Laptop.MEMORY_ROM.toString()) && params[2].split("=")[1].equals(paramValue)) {
                    laptopsByCriteria.add(createLaptop(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase(SearchCriteria.Laptop.SYSTEM_MEMORY.toString()) && params[3].split("=")[1].equals(paramValue)) {
                    laptopsByCriteria.add(createLaptop(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase(SearchCriteria.Laptop.CPU.toString()) && params[4].split("=")[1].equals(paramValue)) {
                    laptopsByCriteria.add(createLaptop(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase(SearchCriteria.Laptop.DISPLAY_INCHES.toString()) && params[5].split("=")[1].equals(paramValue)) {
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

