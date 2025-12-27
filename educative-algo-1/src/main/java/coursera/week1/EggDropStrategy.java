package coursera.week1;



interface EggDropStrategyI {
    int findT(Building building);
}

public class EggDropStrategy implements  EggDropStrategyI {


    @Override
    public int findT(Building building) {
        return 0;
    }

    public int Version_Zero_OneEgg_LinearSearch(Building building) {

        for (int floor = 1; floor <= building.floors(); floor++) {
            if(building.drop(floor))
                return  floor;
        }
        return building.floors();
    }

    public int VersionOne_LogEggs_LogTosses(Building building){
        int lo = 1, hi = building.floors();
        while (lo <= hi){
            int mid  = lo +(hi-lo)/2;
            if(building.drop(mid)) hi = mid;
            else lo = mid +1;

        }
        return  lo;
    }

    // Increase floors in power of 2.
    public int VersionTwo_LogTEggs_DoubleLogTosses(Building building) {
        int bound = 1;
        while (bound < building.floors() && !building.drop(bound)){
            bound *= 2;
        }
        int lo = bound/2;
        int hi = Math.min(bound,building.floors());
        while ( lo < hi) {
            int mid  = lo +(hi-lo)/2;
            if(building.drop(mid)) hi = mid;
            else lo = mid +1;
        }
        return lo;
    }
}



