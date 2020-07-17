package tc.task01.dao.impl;

import tc.task01.dao.ApplianceDAO;
import tc.task01.dao.parser.*;
import tc.task01.entity.Appliance;
import tc.task01.entity.criteria.Criteria;

import java.util.Set;

public class ApplianceDAOImpl implements ApplianceDAO {

    @Override
    public Set<Appliance> find(Criteria criteria) {

        String appType = criteria.getGroupSearchName();
        Set<Appliance> appliances = null;

        if (appType.equals("Laptop")){

            LaptopsFromFile laptops = new LaptopsFromFile();

            appliances = laptops.getLaptopsByCriteria(criteria);
        }

        if (appType.equals("Oven")){

            OvensFromFile ovens = new OvensFromFile();

            appliances = ovens.getOvensByCriteria(criteria);
        }

        if (appType.equals("Refrigerator")){

            RefrigeratorsFromFile refrigerators = new RefrigeratorsFromFile();

            appliances = refrigerators.getRefrigeratorsByCriteria(criteria);
        }

        if (appType.equals("VacuumCleaner")){

            VacuumCleanersFromFile cleaners = new VacuumCleanersFromFile();

            appliances = cleaners.getVacuumCleanersByCriteria(criteria);
        }

        if (appType.equals("TabletPC")){

            TabletPCsFromFile tabletPCsFromFile = new TabletPCsFromFile();

            appliances = tabletPCsFromFile.getTabletPCsByCriteria(criteria);
        }

        if (appType.equals("Speakers")){

            SpeakersFromFile speakers = new SpeakersFromFile();

            appliances = speakers.getSpeakersByCriteria(criteria);
        }

        return appliances;

    }
}

