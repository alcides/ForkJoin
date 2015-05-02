package jsr166e.cutoffs;

import jsr166e.ForkJoinTask;
import jsr166e.RecursiveAction;

public class MaxTasksInQueueMechanism implements CutoffMechanism {
	protected int c = CutoffMechanismFactory.parseParam("C", 3);
	@Override
	public boolean shouldFork(ForkJoinTask<?> t) {
		return RecursiveAction.getQueuedTaskCount() < c;
	}
}