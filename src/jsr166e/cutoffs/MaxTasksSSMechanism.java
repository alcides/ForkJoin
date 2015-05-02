package jsr166e.cutoffs;

import jsr166e.ForkJoinTask;

public class MaxTasksSSMechanism extends MaxTasksMechanism {
	protected int ss = CutoffMechanismFactory.parseParam("SS", 10);
	@Override
	public boolean shouldFork(ForkJoinTask<?> t) {
		if (Thread.currentThread().getStackTrace().length > ss) return false;
		return super.shouldFork(t);
	}
}