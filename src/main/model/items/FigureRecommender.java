
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FigureRecommender {
    // Remember a figure to recommend based on a specified figure purchased
    private Map<Figure, Set<Figure>> recommendations;

    public FigureRecommender() {
        recommendations = new HashMap<>();
    }

    // EFFECTS If a figure was not bought before, then create a new figure key
    //         and add the recommended figure toBuy to its set.
    //         If a figure was bought before, then a new figure key is not needed
    //         so just add the recommended figure toBuy to the set.
    public void addRecommendation(Figure bought, Figure toBuy) {
        Set<Figure> figureSet;
        if (!recommendations.containsKey(bought)) {
            // Need to create a set of figures for the value of the key in the map
            figureSet = new HashSet<Figure>();
            figureSet.add(toBuy);
            recommendations.put(bought, figureSet);
        } else {
            // The figure has recommendations for it,
            // add to the set.
            figureSet = recommendations.get(bought);
            figureSet.add(toBuy);
        }
    }

    public Set<Figure> recommended(Figure bought) {
        return recommendations.get(bought);
    }

    public String recommendedFigures(Figure bought) {
        Set<String> recommendedFigures = new HashSet<>();
        for (Figure f: recommended(bought)) {
            recommendedFigures.add(f.getName());
        }
        return ("Here is a list of recommended figures for "
                + bought.getName() + ": " + recommendedFigures);
    }

    public void print() {
        for (Map.Entry<Figure, Set<Figure>> s : recommendations.entrySet()) {
            Set<Figure> recommendedFigures = s.getValue();
            for (Figure f : recommendedFigures) {
                System.out.println(s.getKey().getName() + "-->" + f.getName());
            }
        }
    }
}