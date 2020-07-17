package tc.task01.dao.parser;

import tc.task01.dao.ApplianceDAO;
import tc.task01.dao.DAOFactory;
import tc.task01.dao.impl.ApplianceDAOImpl;
import tc.task01.entity.Appliance;
import tc.task01.entity.criteria.SearchCriteria;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileParser {
    private final List<String> oneTypeAppliancesInfo = new ArrayList<>();
    private final String PATH = "resources/appliances_db";

    private static final FileParser instance = new FileParser();

    private FileParser() {}

    public static FileParser getInstance() {
        return instance;
    }

    public List<String> getOneTypeAppliancesInfo(String applianceType) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(PATH))))  {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] criteriaInfo = line.split(" : ");

                if (criteriaInfo[0].equals(applianceType)) {
                    oneTypeAppliancesInfo.add(criteriaInfo[1]);
                }

            }

        } catch (IOException e) {
            System.err.println(e);
        }

        return oneTypeAppliancesInfo;
    }

}
