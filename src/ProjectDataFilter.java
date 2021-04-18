import domain.ProjectData;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProjectDataFilter {
    /*The number of unique customerId for each contractId.

      The number of unique customerId for each geozone.

      The list of unique customerId for each geozone.

      The average buildduration for each geozone. "*/


    public static Predicate<ProjectData> byProjectCode = projectData -> projectData.getProjectCode().equalsIgnoreCase("ProjectEgg");

    public static <T> Predicate<T> distinctByProperty(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new HashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }


}
