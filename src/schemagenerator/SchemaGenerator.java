package schemagenerator;

import javax.persistence.Persistence;

public class SchemaGenerator {
    public static void main(String[] args) {
        Persistence.generateSchema("ExamPrepExe2W4PU", null);
    }
}
