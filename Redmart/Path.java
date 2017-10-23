package Redmart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krish on 10/23/17.
 */
public class Path {
    private int pathLength;
    private int pathDepth;
    private List<Spot> path;
    private boolean hasPath = false;

    public Path(int pathLength, int pathDepth, List<Spot> path, boolean hasPath) {
        this.path = new ArrayList<>();
        this.path.addAll(path);
        this.pathLength = pathLength;
        this.pathDepth = pathDepth;
        this.hasPath = hasPath;
    }

    public boolean hasPath() {
        return hasPath;
    }

    public List<Spot> getPath() {
        return path;
    }

    public int getPathLength() {
        return pathLength;
    }

    public int getPathDepth() {
        return pathDepth;
    }


}
