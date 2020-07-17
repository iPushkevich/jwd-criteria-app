package tc.task01.dao.parser;

import tc.task01.entity.Appliance;
import tc.task01.entity.TabletPC;
import tc.task01.entity.criteria.Criteria;
import tc.task01.entity.criteria.SearchCriteria;

import java.util.*;

public class TabletPCsFromFile {
    private final FileParser parser = FileParser.getInstance();

    public Set<Appliance> getTabletPCsByCriteria(Criteria criteria) {
        Set<Appliance> tabletPCsByCriteria = new HashSet<>();
        List<String> infoFromFile = parser.getOneTypeAppliancesInfo("TabletPC");
        String searchCriteria;
        String paramValue;
        Map<String, Object> allCriteria = criteria.getCriteria();

        for (Map.Entry<String, Object> entry : allCriteria.entrySet()) {
            searchCriteria = entry.getKey();
            paramValue = entry.getValue().toString();

            for (String param : infoFromFile) {

                String[] params = param.split(", ");

                if (searchCriteria.equalsIgnoreCase(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString()) && params[0].split("=")[1].equals(paramValue)) {
                    tabletPCsByCriteria.add(createTabletPC(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase(SearchCriteria.TabletPC.DISPLAY_INCHES.toString()) && params[1].split("=")[1].equalsIgnoreCase(paramValue)) {
                    tabletPCsByCriteria.add(createTabletPC(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase(SearchCriteria.TabletPC.MEMORY_ROM.toString()) && params[2].split("=")[1].equals(paramValue)) {
                    tabletPCsByCriteria.add(createTabletPC(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString()) && params[3].split("=")[1].equals(paramValue)) {
                    tabletPCsByCriteria.add(createTabletPC(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase(SearchCriteria.TabletPC.COLOR.toString()) && params[4].split("=")[1].equals(paramValue)) {
                    tabletPCsByCriteria.add(createTabletPC(params));
                }
            }
        }

        return tabletPCsByCriteria;
    }

    private TabletPC createTabletPC(String[] params) {
        TabletPC tabletPC = new TabletPC();
        tabletPC.setBatteryCapacity(params[0].split("=")[1]);
        tabletPC.setDisplayInches(params[1].split("=")[1]);
        tabletPC.setMemoryRom(params[2].split("=")[1]);
        tabletPC.setFlashMemoryCapacity(params[3].split("=")[1]);
        tabletPC.setColor(params[4].split("=")[1]);

        return tabletPC;
    }
}
