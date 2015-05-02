package jsr166e.cutoffs;

import jsr166e.ForkJoinTask;

public class MaxLevelMechanism implements CutoffMechanism {
	protected int c = CutoffMechanismFactory.parseParam("C", 8);
	@Override
	public boolean shouldFork(ForkJoinTask<?> t) {
		return t.depth < c;
	}
}