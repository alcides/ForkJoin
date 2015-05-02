package jsr166e.cutoffs;

import jsr166e.ForkJoinTask;

public class MaxTasksMechanism implements CutoffMechanism {
	protected int c = CutoffMechanismFactory.parseParam("C", 3);
	protected int processors = Runtime.getRuntime().availableProcessors();
	protected int limit = c * processors;
	@Override
	public boolean shouldFork(ForkJoinTask<?> t) {
		return ForkJoinTask.getPool().getQueuedTaskCount() < limit;
	}
}