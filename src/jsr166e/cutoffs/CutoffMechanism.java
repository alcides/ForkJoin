package jsr166e.cutoffs;

import jsr166e.ForkJoinTask;

public interface CutoffMechanism {
	public boolean shouldFork(ForkJoinTask<?> t);
}
