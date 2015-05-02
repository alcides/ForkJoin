package jsr166e.cutoffs;

import jsr166e.ForkJoinTask;

public class ATCMechanism extends MaxTasksMechanism {
	protected int d = CutoffMechanismFactory.parseParam("D", 10);
	@Override
	public boolean shouldFork(ForkJoinTask<?> t) {
		return super.shouldFork(t) && t.depth < d;
	}
}