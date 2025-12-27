package coursera.week4;

import java.util.HashMap;
import java.util.Map;

/*
*
* Web tracking. Suppose that you are tracking
n web sites and
m users and you want to support the following API:

User visits a website.

How many times has a given user visited a given site?

What data structure or data structures would you use?


Map<User,Map<Website,Count>>
* */
public class WebTracker {

    private final Map<String,Map<String,Integer>> data  = new HashMap<>();


    public void recordVisit(String user,String website){
        data.computeIfAbsent(user,k -> new HashMap<>())
                .merge(website,1, Integer::sum);
    }

    // Query: how many times user visited site.
    public int getVisitCount(String user,String website){
        Map<String,Integer> userVisits = data.get(user);
        if(userVisits == null) return  0;
        return userVisits.getOrDefault(website,0);
    }
}
