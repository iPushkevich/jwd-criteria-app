package tc.task01.dao.parser;

import tc.task01.dao.exception.DaoException;
import tc.task01.entity.Appliance;
import tc.task01.entity.TabletPC;
import tc.task01.entity.criteria.Criteria;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TabletPCsFromFile {
    private final FileParser parser = FileParser.getInstance();

    public Set<Appliance> getTabletPCsByCriteria(Criteria criteria) throws DaoException {
        Set<Appliance> tabletPCsByCriteria = new HashSet<>();
        List<String> infoFromFile = parser.getOneTypeAppliancesInfo("TabletPC");
        Set<Criteria.CriteriaNameAndValue> allCriteria = criteria.getCriteria();
        String searchCriteria;
        String paramValue;

        for (Criteria.CriteriaNameAndValue cr : allCriteria) {
            searchCriteria = cr.getCriteriaName();
            paramValue = cr.getCriteriaValue().toString();

            for (String param : infoFromFile) {

                String[] params = param.split(", ");

                if (searchCriteria.equalsIgnoreCase("BATTERY_CAPACITY") && params[0].split("=")[1].equalsIgnoreCase(paramValue)) {
                    tabletPCsByCriteria.add(createTabletPC(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase("DISPLAY_INCHES") && params[1].split("=")[1].equalsIgnoreCase(paramValue)) {
                    tabletPCsByCriteria.add(createTabletPC(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase("MEMORY_ROM") && params[2].split("=")[1].equalsIgnoreCase(paramValue)) {
                    tabletPCsByCriteria.add(createTabletPC(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase("FLASH_MEMORY_CAPACITY") && params[3].split("=")[1].equalsIgnoreCase(paramValue)) {
                    tabletPCsByCriteria.add(createTabletPC(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase("COLOR") && params[4].split("=")[1].equalsIgnoreCase(paramValue)) {
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
