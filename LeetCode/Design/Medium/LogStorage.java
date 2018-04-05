class LogSystem {

	TreeMap<Long, Integer> log;

    public LogSystem() {
        log = new TreeMap<>();
    }
    
    public void put(int id, String timestamp) {
    	long key = getValue(timestamp.split(":"));
    	log.put(key, id);
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        int granularity = getGranularity(gra);
        String[] start = new String[6];        
        String[] givenStart = s.split(":");
        String[] end = new String[6];        
        String[] givenEnd = e.split(":");
        
        for (int i = 0; i <= granularity; i++) {
        	start[i] = givenStart[i];
        	end[i] = givenEnd[i];
        }

        for (int i = granularity + 1; i <= 5; i++) {
        	start[i] = getMin(i);
        	end[i] = getMax(i);
        }

        long startKey = getValue(start);
        long endKey = getValue(end);

        Map<Long, Integer> requiredLogMap = log.subMap(startKey, true, endKey, true);
        List<Integer> requiredLogs = new ArrayList<>();

        for (Map.Entry<Long, Integer> entry : requiredLogMap.entrySet()) {
        	requiredLogs.add(entry.getValue());
        }

        return requiredLogs;

    }

    public String getMax(int granularity) {
    	if (granularity == 1) {
    		return "12";
    	}
    	if (granularity == 2) {
    		return "31";
    	}
    	if (granularity == 3) {
    		return "23";
    	}
    	if (granularity == 4) {
    		return "59";
    	}
    	if (granularity == 5) {
    		return "59";
    	}
        return null;
    }

    public String getMin(int granularity) {
    	if (granularity == 1) {
    		return "01";
    	}
    	if (granularity == 2) {
    		return "01";
    	}
    	if (granularity == 3) {
    		return "00";
    	}
    	if (granularity == 4) {
    		return "00";
    	}
    	if (granularity == 5) {
    		return "00";
    	}
        return null;
    }


    public int getGranularity(String g) {
    	if (g.equals("Year")) {
    		return 0;
    	} else if (g.equals("Month")) {
    		return 1;
    	} else if (g.equals("Day")) {
    		return 2;
    	} else if (g.equals("Hour")) {
    		return 3;
    	} else if (g.equals("Minute")) {
    		return 4;
    	} else if (g.equals("Second")) {
    		return 5;
    	}
    	return -1;
    }

    public long getValue(String[] timeStamp) {
    	long value = 0l;    	
    	String str = "";
    	for (String tsElement : timeStamp) {
    		str = str + tsElement;
    	}
    	value = Long.parseLong(str);
        return value;
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */