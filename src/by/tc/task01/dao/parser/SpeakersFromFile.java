package tc.task01.dao.parser;

import tc.task01.entity.Appliance;
import tc.task01.entity.Speakers;
import tc.task01.entity.criteria.Criteria;
import tc.task01.entity.criteria.SearchCriteria;

import java.util.*;

public class SpeakersFromFile {
    private final FileParser parser = FileParser.getInstance();

    public Set<Appliance> getSpeakersByCriteria(Criteria criteria) {
        Set<Appliance> speakersByCriteria = new HashSet<>();
        List<String> infoFromFile = parser.getOneTypeAppliancesInfo("Speakers");
        String searchCriteria;
        String paramValue;
        Map<String, Object> allCriteria = criteria.getCriteria();

        for (Map.Entry<String, Object> entry : allCriteria.entrySet()) {
            searchCriteria = entry.getKey();
            paramValue = entry.getValue().toString();

            for (String param : infoFromFile) {

                String[] params = param.split(", ");

                if (searchCriteria.equalsIgnoreCase(SearchCriteria.Speakers.POWER_CONSUMPTION.toString()) && params[0].split("=")[1].equals(paramValue)) {
                    speakersByCriteria.add(createSpeakers(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString()) && params[1].split("=")[1].equalsIgnoreCase(paramValue)) {
                    speakersByCriteria.add(createSpeakers(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase(SearchCriteria.Speakers.FREQUENCY_RANGE.toString()) && params[2].split("=")[1].equals(paramValue)) {
                    speakersByCriteria.add(createSpeakers(params));
                    continue;
                }

                if (searchCriteria.equalsIgnoreCase(SearchCriteria.Speakers.CORD_LENGTH.toString()) && params[3].split("=")[1].equals(paramValue)) {
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
