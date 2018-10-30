/*
 * Copyright (c) 2012-2017 The ANTLR Project. All rights reserved.
 * Use of this file is governed by the BSD 3-clause license that
 * can be found in the LICENSE.txt file in the project root.
 */

package org.antlr.v4.runtime.atn;

import org.antlr.v4.runtime.dfa.DFAState;

import java.util.IdentityHashMap;
import java.util.UUID;

public abstract class ATNSimulator {
	/**
	 * @deprecated Use {@link ATNDeserializer#SERIALIZED_VERSION} instead.
	 */
	@Deprecated
	public static final int SERIALIZED_VERSION;
	static {
		SERIALIZED_VERSION = ATNDeserializer.SERIALIZED_VERSION;
	}

	/**
	 * This is the current serialized UUID.
	 * @deprecated Use {@link ATNDeserializer#checkCondition(boolean)} instead.
	 */
	@Deprecated
	public static final UUID SERIALIZED_UUID;
	static {
		SERIALIZED_UUID = ATNDeserializer.SERIALIZED_UUID;
	}

	/** Must distinguish between missing edge and edge we know leads nowhere */

	public static final DFAState ERROR;

	public final ATN atn;

	/** The context cache maps all PredictionContext objects that are equals()
	 *  to a single cached copy. This cache is shared across all contexts
	 *  in all ATNConfigs in all DFA states.  We rebuild each ATNConfigSet
	 *  to use only cached nodes/graphs in addDFAState(). We don't want to
	 *  fill this during closure() since there are lots of contexts that
	 *  pop up but are not used ever again. It also greatly slows down closure().
	 *
	 *  <p>This cache makes a huge difference in memory and a little bit in speed.
	 *  For the Java grammar on java.*, it dropped the memory requirements
	 *  at the end from 25M to 16M. We don't store any of the full context
	 *  graphs in the DFA because they are limited to local context only,
	 *  but apparently there's a lot of repetition there as well. We optimize
	 *  the config contexts before storing the config set in the DFA states
	 *  by literally rebuilding them with cached subgraphs only.</p>
	 *
	 *  <p>I tried a cache for use during closure operations, that was
	 *  whacked after each adaptivePredict(). It cost a little bit
	 *  more time I think and doesn't save on the overall footprint
	 *  so it's not worth the complexity.</p>
 	 */
	protected final PredictionContextCache sharedContextCache;

	static {
		ERROR = new DFAState(new ATNConfigSet());
		ERROR.stateNumber = Integer.MAX_VALUE;
	}

	public ATNSimulator(ATN atn,
						PredictionContextCache sharedContextCache)
	{
		this.atn = atn;
		this.sharedContextCache = sharedContextCache;
	}

	public abstract void reset();

	public PredictionContext getCachedContext(PredictionContext context) {
		if ( sharedContextCache==null ) return context;

		synchronized (sharedContextCache) {
			IdentityHashMap<PredictionContext, PredictionContext> visited =
				new IdentityHashMap<PredictionContext, PredictionContext>();
			return PredictionContext.getCachedContext(context,
													  sharedContextCache,
													  visited);
		}
	}

}
