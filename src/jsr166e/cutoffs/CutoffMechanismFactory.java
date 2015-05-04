package jsr166e.cutoffs;

import java.util.HashMap;
import java.util.Map;

public class CutoffMechanismFactory {
	static protected Map<String, CutoffMechanism> mapping;
	
	static {
		mapping = new HashMap<String, CutoffMechanism>();
		mapping.put("maxtasks", new MaxTasksMechanism());
		mapping.put("maxlevel", new MaxLevelMechanism());
		mapping.put("atc", new ATCMechanism());
		mapping.put("maxtasksinqueue", new MaxTasksInQueueMechanism());
		mapping.put("surplus", new SurplusMechanism());
		mapping.put("stacksize", new StackSizeMechanism());
		mapping.put("maxtasksss", new MaxTasksSSMechanism());
	}
	
	public static CutoffMechanism getMechanism() {
		if (System.getenv("CUTOFF") == null) return new SurplusMechanism();
		return mapping.get(System.getenv("CUTOFF"));
	}
	
	public static int parseParam(String n, int def) {
		String p = System.getenv(n);
		if (p == null) return def;
		else return Integer.parseInt(p);
	}
}
