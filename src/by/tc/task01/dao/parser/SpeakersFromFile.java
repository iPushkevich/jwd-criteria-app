package tc.task01.dao.parser;

import tc.task01.dao.exception.DaoException;
import tc.task01.entity.Appliance;
import tc.task01.entity.Speakers;
import tc.task01.entity.criteria.Criteria;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpeakersFromFile {
    private final FileParser parser = FileParser.getInstance();

    public Set<Appliance> getSpeakersByCriteria(Criteria criteria) throws DaoException {
        Set<Appliance> speakersByCriteria = new HashSet<>();
        List<String> infoFromFile = parser.getOneTypeAppliancesInfo("Speakers");
        Set<Criteria.CriteriaNameAndValue> allCriteria = criteria.getCriteria();
        String searchCriteria;
        String paramValue;

        for (Criteria.CriteriaNameAndValue cr : allCriteria) {
            searchCriteria = cr.getCriteriaName();
            paramValue = cr.getCriteriaValue().toString();

            for (String param : infoFromFile) {

                String[] params = param.split(", ");

                if (searchCriteria.equalsIgnoreCase("POWER_CONSUMPTION") && params[0].split("=")[1].equalsIgnoreCase(paramValue)) {
                    speakersByCriteria.add(createSpeakers(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase("NUMBER_OF_SPEAKERS") && params[1].split("=")[1].equalsIgnoreCase(paramValue)) {
                    speakersByCriteria.add(createSpeakers(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase("FREQUENCY_RANGE") && params[2].split("=")[1].equalsIgnoreCase(paramValue)) {
                    speakersByCriteria.add(createSpeakers(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase("CORD_LENGTH") && params[3].split("=")[1].equalsIgnoreCase(paramValue)) {
                    speakersByCriteria.add(createSpeakers(params));
                }
            }
        }

        return speakersByCriteria;
    }

    private Speakers createSpeakers(String[] params) {
        Speakers speakers = new Speakers();
        speakers.setPowerConsumption(params[0].split("=")[1]);
        speakers.setNumberOfSpeakers(params[1].split("=")[1]);
        speakers.setFrequencyRange(params[2].split("=")[1]);
        speakers.setCordLength(params[3].split("=")[1]);

        return speakers;
    }
}
