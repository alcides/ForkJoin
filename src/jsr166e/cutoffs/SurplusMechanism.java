package jsr166e.cutoffs;

import jsr166e.ForkJoinPool;
import jsr166e.ForkJoinTask;

public class SurplusMechanism implements CutoffMechanism {
	protected int c = CutoffMechanismFactory.parseParam("C", 3);
	@Override
	public boolean shouldFork(ForkJoinTask<?> t) {
		return ForkJoinPool.getSurplusQueuedTaskCount() <= c;
	}
}