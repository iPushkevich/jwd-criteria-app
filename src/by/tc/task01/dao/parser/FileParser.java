package tc.task01.dao.parser;

import tc.task01.dao.exception.DaoException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileParser {
    private final List<String> oneTypeAppliancesInfo = new ArrayList<>();
    private final String PATH = "resources/appliances_db";

    private static final FileParser INSTANCE = new FileParser();

    private FileParser() {}

    public static FileParser getInstance() {
        return INSTANCE;
    }

    public List<String> getOneTypeAppliancesInfo(String applianceType) throws DaoException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(PATH))))  {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] criteriaInfo = line.split(" : ");

                if (criteriaInfo[0].equals(applianceType)) {
                    oneTypeAppliancesInfo.add(criteriaInfo[1].trim());
                }

            }

        } catch (Exception e) {
            throw new DaoException(e);
        }

        return oneTypeAppliancesInfo;
    }

}
