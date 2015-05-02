package jsr166e.cutoffs;

import jsr166e.ForkJoinTask;

public class StackSizeMechanism implements CutoffMechanism {
	
	protected int c = CutoffMechanismFactory.parseParam("C", 10);
	@Override
	public boolean shouldFork(ForkJoinTask<?> t) {
		return Thread.currentThread().getStackTrace().length < c;
	}
}